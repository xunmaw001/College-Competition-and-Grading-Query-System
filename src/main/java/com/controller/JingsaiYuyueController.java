
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 竞赛报名
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jingsaiYuyue")
public class JingsaiYuyueController {
    private static final Logger logger = LoggerFactory.getLogger(JingsaiYuyueController.class);

    private static final String TABLE_NAME = "jingsaiYuyue";

    @Autowired
    private JingsaiYuyueService jingsaiYuyueService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private JiaowuchuguanliyuanService jiaowuchuguanliyuanService;//教务处管理员
    @Autowired
    private JingsaiService jingsaiService;//竞赛
    @Autowired
    private JingsaiCollectionService jingsaiCollectionService;//竞赛收藏
    @Autowired
    private JingsaiLiuyanService jingsaiLiuyanService;//竞赛留言
    @Autowired
    private XuexiaofuzerenService xuexiaofuzerenService;//学院负责人
    @Autowired
    private YonghuService yonghuService;//学生
    @Autowired
    private ZhidaolaoshiService zhidaolaoshiService;//指导老师
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("教务处管理员".equals(role))
            params.put("jiaowuchuguanliyuanId",request.getSession().getAttribute("userId"));
        else if("学院负责人".equals(role))
            params.put("xuexiaofuzerenId",request.getSession().getAttribute("userId"));
        else if("指导老师".equals(role))
            params.put("zhidaolaoshiId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = jingsaiYuyueService.queryPage(params);

        //字典表数据转换
        List<JingsaiYuyueView> list =(List<JingsaiYuyueView>)page.getList();
        for(JingsaiYuyueView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JingsaiYuyueEntity jingsaiYuyue = jingsaiYuyueService.selectById(id);
        if(jingsaiYuyue !=null){
            //entity转view
            JingsaiYuyueView view = new JingsaiYuyueView();
            BeanUtils.copyProperties( jingsaiYuyue , view );//把实体数据重构到view中
            //级联表 竞赛
            //级联表
            JingsaiEntity jingsai = jingsaiService.selectById(jingsaiYuyue.getJingsaiId());
            if(jingsai != null){
            BeanUtils.copyProperties( jingsai , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "zhidaolaoshiId"
, "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setJingsaiId(jingsai.getId());
            }
            //级联表 学生
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(jingsaiYuyue.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "zhidaolaoshiId"
, "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 指导老师
            //级联表
            ZhidaolaoshiEntity zhidaolaoshi = zhidaolaoshiService.selectById(jingsaiYuyue.getZhidaolaoshiId());
            if(zhidaolaoshi != null){
            BeanUtils.copyProperties( zhidaolaoshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "zhidaolaoshiId"
, "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setZhidaolaoshiId(zhidaolaoshi.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JingsaiYuyueEntity jingsaiYuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jingsaiYuyue:{}",this.getClass().getName(),jingsaiYuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("指导老师".equals(role))
            jingsaiYuyue.setZhidaolaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("学生".equals(role))
            jingsaiYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JingsaiYuyueEntity> queryWrapper = new EntityWrapper<JingsaiYuyueEntity>()
            .eq("jingsai_id", jingsaiYuyue.getJingsaiId())
            .eq("yonghu_id", jingsaiYuyue.getYonghuId())
            .eq("zhidaolaoshi_id", jingsaiYuyue.getZhidaolaoshiId())
            .eq("jingsai_yuyue_types", jingsaiYuyue.getJingsaiYuyueTypes())
            .in("jingsai_yuyue_yesno_types", new Integer[]{1,2})
            .eq("jingsai_yuyue_jidengjiang_types", jingsaiYuyue.getJingsaiYuyueJidengjiangTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JingsaiYuyueEntity jingsaiYuyueEntity = jingsaiYuyueService.selectOne(queryWrapper);
        if(jingsaiYuyueEntity==null){
            jingsaiYuyue.setInsertTime(new Date());
            jingsaiYuyue.setJingsaiYuyueYesnoTypes(1);
            jingsaiYuyue.setCreateTime(new Date());
            jingsaiYuyueService.insert(jingsaiYuyue);
            return R.ok();
        }else {
            if(jingsaiYuyueEntity.getJingsaiYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(jingsaiYuyueEntity.getJingsaiYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JingsaiYuyueEntity jingsaiYuyue, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jingsaiYuyue:{}",this.getClass().getName(),jingsaiYuyue.toString());
        JingsaiYuyueEntity oldJingsaiYuyueEntity = jingsaiYuyueService.selectById(jingsaiYuyue.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if(!"学生".equals(role)){
            jingsaiYuyue.setJingsaiYuyueTypes(107);
        }
        if("".equals(jingsaiYuyue.getJingsaiYuyueFile()) || "null".equals(jingsaiYuyue.getJingsaiYuyueFile())){
                jingsaiYuyue.setJingsaiYuyueFile(null);
        }

            jingsaiYuyueService.updateById(jingsaiYuyue);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody JingsaiYuyueEntity jingsaiYuyueEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,jingsaiYuyueEntity:{}",this.getClass().getName(),jingsaiYuyueEntity.toString());

        JingsaiYuyueEntity oldJingsaiYuyue = jingsaiYuyueService.selectById(jingsaiYuyueEntity.getId());//查询原先数据

        if(jingsaiYuyueEntity.getJingsaiYuyueYesnoTypes() == 2){//通过
            jingsaiYuyueEntity.setJingsaiYuyueTypes(103);
        }else if(jingsaiYuyueEntity.getJingsaiYuyueYesnoTypes() == 3){//拒绝
            jingsaiYuyueEntity.setJingsaiYuyueTypes(106);
        }
        jingsaiYuyueEntity.setJingsaiYuyueShenheTime(new Date());//审核时间
        jingsaiYuyueService.updateById(jingsaiYuyueEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JingsaiYuyueEntity> oldJingsaiYuyueList =jingsaiYuyueService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jingsaiYuyueService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<JingsaiYuyueEntity> jingsaiYuyueList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            JingsaiYuyueEntity jingsaiYuyueEntity = new JingsaiYuyueEntity();
//                            jingsaiYuyueEntity.setJingsaiYuyueUuidNumber(data.get(0));                    //报名编号 要改的
//                            jingsaiYuyueEntity.setJingsaiId(Integer.valueOf(data.get(0)));   //竞赛 要改的
//                            jingsaiYuyueEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            jingsaiYuyueEntity.setZhidaolaoshiId(Integer.valueOf(data.get(0)));   //指导老师 要改的
//                            jingsaiYuyueEntity.setInsertTime(date);//时间
//                            jingsaiYuyueEntity.setJingsaiYuyueFile(data.get(0));                    //竞赛作品 要改的
//                            jingsaiYuyueEntity.setJingsaiYuyueTypes(Integer.valueOf(data.get(0)));   //竞赛状态 要改的
//                            jingsaiYuyueEntity.setJingsaiYuyueYesnoTypes(Integer.valueOf(data.get(0)));   //报名状态 要改的
//                            jingsaiYuyueEntity.setJingsaiYuyueYesnoText(data.get(0));                    //审核回复 要改的
//                            jingsaiYuyueEntity.setJingsaiYuyueShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            jingsaiYuyueEntity.setJingsaiYuyueJidengjiangTypes(Integer.valueOf(data.get(0)));   //几等奖 要改的
//                            jingsaiYuyueEntity.setJingsaiYuyueDafen(data.get(0));                    //得分 要改的
//                            jingsaiYuyueEntity.setJingsaiYuyuePingshenText(data.get(0));                    //评审意见 要改的
//                            jingsaiYuyueEntity.setCreateTime(date);//时间
                            jingsaiYuyueList.add(jingsaiYuyueEntity);


                            //把要查询是否重复的字段放入map中
                                //报名编号
                                if(seachFields.containsKey("jingsaiYuyueUuidNumber")){
                                    List<String> jingsaiYuyueUuidNumber = seachFields.get("jingsaiYuyueUuidNumber");
                                    jingsaiYuyueUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jingsaiYuyueUuidNumber = new ArrayList<>();
                                    jingsaiYuyueUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jingsaiYuyueUuidNumber",jingsaiYuyueUuidNumber);
                                }
                        }

                        //查询是否重复
                         //报名编号
                        List<JingsaiYuyueEntity> jingsaiYuyueEntities_jingsaiYuyueUuidNumber = jingsaiYuyueService.selectList(new EntityWrapper<JingsaiYuyueEntity>().in("jingsai_yuyue_uuid_number", seachFields.get("jingsaiYuyueUuidNumber")));
                        if(jingsaiYuyueEntities_jingsaiYuyueUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JingsaiYuyueEntity s:jingsaiYuyueEntities_jingsaiYuyueUuidNumber){
                                repeatFields.add(s.getJingsaiYuyueUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [报名编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jingsaiYuyueService.insertBatch(jingsaiYuyueList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = jingsaiYuyueService.queryPage(params);

        //字典表数据转换
        List<JingsaiYuyueView> list =(List<JingsaiYuyueView>)page.getList();
        for(JingsaiYuyueView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JingsaiYuyueEntity jingsaiYuyue = jingsaiYuyueService.selectById(id);
            if(jingsaiYuyue !=null){


                //entity转view
                JingsaiYuyueView view = new JingsaiYuyueView();
                BeanUtils.copyProperties( jingsaiYuyue , view );//把实体数据重构到view中

                //级联表
                    JingsaiEntity jingsai = jingsaiService.selectById(jingsaiYuyue.getJingsaiId());
                if(jingsai != null){
                    BeanUtils.copyProperties( jingsai , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJingsaiId(jingsai.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(jingsaiYuyue.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    ZhidaolaoshiEntity zhidaolaoshi = zhidaolaoshiService.selectById(jingsaiYuyue.getZhidaolaoshiId());
                if(zhidaolaoshi != null){
                    BeanUtils.copyProperties( zhidaolaoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setZhidaolaoshiId(zhidaolaoshi.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody JingsaiYuyueEntity jingsaiYuyue, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jingsaiYuyue:{}",this.getClass().getName(),jingsaiYuyue.toString());
        Wrapper<JingsaiYuyueEntity> queryWrapper = new EntityWrapper<JingsaiYuyueEntity>()
            .eq("jingsai_id", jingsaiYuyue.getJingsaiId())
            .eq("yonghu_id", jingsaiYuyue.getYonghuId())
            .notIn("jingsai_yuyue_types", new Integer[]{102,106})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JingsaiYuyueEntity jingsaiYuyueEntity = jingsaiYuyueService.selectOne(queryWrapper);
        if(jingsaiYuyueEntity==null){
            jingsaiYuyue.setJingsaiYuyueUuidNumber(String.valueOf(new Date().getTime()));
            jingsaiYuyue.setJingsaiYuyueTypes(101);
            jingsaiYuyue.setInsertTime(new Date());
            jingsaiYuyue.setJingsaiYuyueYesnoTypes(1);
            jingsaiYuyue.setCreateTime(new Date());
        jingsaiYuyueService.insert(jingsaiYuyue);

            return R.ok();
        }else {
            return R.error(511,"已经报过名了,不能重复报名");
        }
    }

    /**
    * 取消报名
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            JingsaiYuyueEntity jingsaiYuyue = jingsaiYuyueService.selectById(id);//当前表service
            Integer jingsaiId = jingsaiYuyue.getJingsaiId();
            if(jingsaiId == null)
                return R.error(511,"查不到该竞赛");
            JingsaiEntity jingsaiEntity = jingsaiService.selectById(jingsaiId);
            if(jingsaiEntity == null)
                return R.error(511,"查不到该竞赛");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            jingsaiYuyue.setJingsaiYuyueYesnoTypes(null);
            jingsaiYuyue.setJingsaiYuyueTypes(102);//设置订单状态为已取消报名
            jingsaiYuyueService.updateAllColumnById(jingsaiYuyue);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            jingsaiService.updateById(jingsaiEntity);//更新订单中竞赛的信息

            return R.ok();
    }

//    /**
//     * 同意报名
//     */
//    @RequestMapping("/deliver")
//    public R deliver(Integer id  , HttpServletRequest request){
//        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
//        JingsaiYuyueEntity  jingsaiYuyueEntity = jingsaiYuyueService.selectById(id);
//        jingsaiYuyueEntity.setJingsaiYuyueTypes(103);//设置订单状态为已同意报名
//        jingsaiYuyueService.updateById( jingsaiYuyueEntity);
//
//        return R.ok();
//    }


//    /**
//     * 上传报名作品
//     */
//    @RequestMapping("/receiving")
//    public R receiving(Integer id , HttpServletRequest request){
//        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
//        JingsaiYuyueEntity  jingsaiYuyueEntity = jingsaiYuyueService.selectById(id);
//        jingsaiYuyueEntity.setJingsaiYuyueTypes(104);//设置订单状态为上传报名作品
//        jingsaiYuyueService.updateById( jingsaiYuyueEntity);
//        return R.ok();
//    }

}

