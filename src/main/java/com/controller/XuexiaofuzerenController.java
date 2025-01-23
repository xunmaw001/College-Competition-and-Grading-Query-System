
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
 * 学院负责人
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xuexiaofuzeren")
public class XuexiaofuzerenController {
    private static final Logger logger = LoggerFactory.getLogger(XuexiaofuzerenController.class);

    private static final String TABLE_NAME = "xuexiaofuzeren";

    @Autowired
    private XuexiaofuzerenService xuexiaofuzerenService;


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
    private JingsaiYuyueService jingsaiYuyueService;//竞赛报名
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
        PageUtils page = xuexiaofuzerenService.queryPage(params);

        //字典表数据转换
        List<XuexiaofuzerenView> list =(List<XuexiaofuzerenView>)page.getList();
        for(XuexiaofuzerenView c:list){
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
        XuexiaofuzerenEntity xuexiaofuzeren = xuexiaofuzerenService.selectById(id);
        if(xuexiaofuzeren !=null){
            //entity转view
            XuexiaofuzerenView view = new XuexiaofuzerenView();
            BeanUtils.copyProperties( xuexiaofuzeren , view );//把实体数据重构到view中
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
    public R save(@RequestBody XuexiaofuzerenEntity xuexiaofuzeren, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xuexiaofuzeren:{}",this.getClass().getName(),xuexiaofuzeren.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<XuexiaofuzerenEntity> queryWrapper = new EntityWrapper<XuexiaofuzerenEntity>()
            .eq("username", xuexiaofuzeren.getUsername())
            .or()
            .eq("xuexiaofuzeren_phone", xuexiaofuzeren.getXuexiaofuzerenPhone())
            .or()
            .eq("xuexiaofuzeren_id_number", xuexiaofuzeren.getXuexiaofuzerenIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuexiaofuzerenEntity xuexiaofuzerenEntity = xuexiaofuzerenService.selectOne(queryWrapper);
        if(xuexiaofuzerenEntity==null){
            xuexiaofuzeren.setCreateTime(new Date());
            xuexiaofuzeren.setPassword("123456");
            xuexiaofuzerenService.insert(xuexiaofuzeren);
            return R.ok();
        }else {
            return R.error(511,"账户或者学院负责人手机号或者学院负责人身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XuexiaofuzerenEntity xuexiaofuzeren, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xuexiaofuzeren:{}",this.getClass().getName(),xuexiaofuzeren.toString());
        XuexiaofuzerenEntity oldXuexiaofuzerenEntity = xuexiaofuzerenService.selectById(xuexiaofuzeren.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(xuexiaofuzeren.getXuexiaofuzerenPhoto()) || "null".equals(xuexiaofuzeren.getXuexiaofuzerenPhoto())){
                xuexiaofuzeren.setXuexiaofuzerenPhoto(null);
        }

            xuexiaofuzerenService.updateById(xuexiaofuzeren);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XuexiaofuzerenEntity> oldXuexiaofuzerenList =xuexiaofuzerenService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        xuexiaofuzerenService.deleteBatchIds(Arrays.asList(ids));

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
            List<XuexiaofuzerenEntity> xuexiaofuzerenList = new ArrayList<>();//上传的东西
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
                            XuexiaofuzerenEntity xuexiaofuzerenEntity = new XuexiaofuzerenEntity();
//                            xuexiaofuzerenEntity.setUsername(data.get(0));                    //账户 要改的
//                            //xuexiaofuzerenEntity.setPassword("123456");//密码
//                            xuexiaofuzerenEntity.setXuexiaofuzerenName(data.get(0));                    //学院负责人姓名 要改的
//                            xuexiaofuzerenEntity.setXuexiaofuzerenPhone(data.get(0));                    //学院负责人手机号 要改的
//                            xuexiaofuzerenEntity.setXuexiaofuzerenIdNumber(data.get(0));                    //学院负责人身份证号 要改的
//                            xuexiaofuzerenEntity.setXuexiaofuzerenPhoto("");//详情和图片
//                            xuexiaofuzerenEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            xuexiaofuzerenEntity.setXuexiaofuzerenEmail(data.get(0));                    //学院负责人邮箱 要改的
//                            xuexiaofuzerenEntity.setCreateTime(date);//时间
                            xuexiaofuzerenList.add(xuexiaofuzerenEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //学院负责人手机号
                                if(seachFields.containsKey("xuexiaofuzerenPhone")){
                                    List<String> xuexiaofuzerenPhone = seachFields.get("xuexiaofuzerenPhone");
                                    xuexiaofuzerenPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> xuexiaofuzerenPhone = new ArrayList<>();
                                    xuexiaofuzerenPhone.add(data.get(0));//要改的
                                    seachFields.put("xuexiaofuzerenPhone",xuexiaofuzerenPhone);
                                }
                                //学院负责人身份证号
                                if(seachFields.containsKey("xuexiaofuzerenIdNumber")){
                                    List<String> xuexiaofuzerenIdNumber = seachFields.get("xuexiaofuzerenIdNumber");
                                    xuexiaofuzerenIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xuexiaofuzerenIdNumber = new ArrayList<>();
                                    xuexiaofuzerenIdNumber.add(data.get(0));//要改的
                                    seachFields.put("xuexiaofuzerenIdNumber",xuexiaofuzerenIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<XuexiaofuzerenEntity> xuexiaofuzerenEntities_username = xuexiaofuzerenService.selectList(new EntityWrapper<XuexiaofuzerenEntity>().in("username", seachFields.get("username")));
                        if(xuexiaofuzerenEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XuexiaofuzerenEntity s:xuexiaofuzerenEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //学院负责人手机号
                        List<XuexiaofuzerenEntity> xuexiaofuzerenEntities_xuexiaofuzerenPhone = xuexiaofuzerenService.selectList(new EntityWrapper<XuexiaofuzerenEntity>().in("xuexiaofuzeren_phone", seachFields.get("xuexiaofuzerenPhone")));
                        if(xuexiaofuzerenEntities_xuexiaofuzerenPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XuexiaofuzerenEntity s:xuexiaofuzerenEntities_xuexiaofuzerenPhone){
                                repeatFields.add(s.getXuexiaofuzerenPhone());
                            }
                            return R.error(511,"数据库的该表中的 [学院负责人手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //学院负责人身份证号
                        List<XuexiaofuzerenEntity> xuexiaofuzerenEntities_xuexiaofuzerenIdNumber = xuexiaofuzerenService.selectList(new EntityWrapper<XuexiaofuzerenEntity>().in("xuexiaofuzeren_id_number", seachFields.get("xuexiaofuzerenIdNumber")));
                        if(xuexiaofuzerenEntities_xuexiaofuzerenIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XuexiaofuzerenEntity s:xuexiaofuzerenEntities_xuexiaofuzerenIdNumber){
                                repeatFields.add(s.getXuexiaofuzerenIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [学院负责人身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xuexiaofuzerenService.insertBatch(xuexiaofuzerenList);
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
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        XuexiaofuzerenEntity xuexiaofuzeren = xuexiaofuzerenService.selectOne(new EntityWrapper<XuexiaofuzerenEntity>().eq("username", username));
        if(xuexiaofuzeren==null || !xuexiaofuzeren.getPassword().equals(password))
            return R.error("账号或密码不正确");
        String token = tokenService.generateToken(xuexiaofuzeren.getId(),username, "xuexiaofuzeren", "学院负责人");
        R r = R.ok();
        r.put("token", token);
        r.put("role","学院负责人");
        r.put("username",xuexiaofuzeren.getXuexiaofuzerenName());
        r.put("tableName","xuexiaofuzeren");
        r.put("userId",xuexiaofuzeren.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody XuexiaofuzerenEntity xuexiaofuzeren, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<XuexiaofuzerenEntity> queryWrapper = new EntityWrapper<XuexiaofuzerenEntity>()
            .eq("username", xuexiaofuzeren.getUsername())
            .or()
            .eq("xuexiaofuzeren_phone", xuexiaofuzeren.getXuexiaofuzerenPhone())
            .or()
            .eq("xuexiaofuzeren_id_number", xuexiaofuzeren.getXuexiaofuzerenIdNumber())
            ;
        XuexiaofuzerenEntity xuexiaofuzerenEntity = xuexiaofuzerenService.selectOne(queryWrapper);
        if(xuexiaofuzerenEntity != null)
            return R.error("账户或者学院负责人手机号或者学院负责人身份证号已经被使用");
        xuexiaofuzeren.setCreateTime(new Date());
        xuexiaofuzerenService.insert(xuexiaofuzeren);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        XuexiaofuzerenEntity xuexiaofuzeren = xuexiaofuzerenService.selectById(id);
        xuexiaofuzeren.setPassword("123456");
        xuexiaofuzerenService.updateById(xuexiaofuzeren);
        return R.ok();
    }

	/**
	 * 修改密码
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        XuexiaofuzerenEntity xuexiaofuzeren = xuexiaofuzerenService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("新密码不能为空") ;
		}
		if(!oldPassword.equals(xuexiaofuzeren.getPassword())){
			return R.error("原密码输入错误");
		}
		if(newPassword.equals(xuexiaofuzeren.getPassword())){
			return R.error("新密码不能和原密码一致") ;
		}
        xuexiaofuzeren.setPassword(newPassword);
		xuexiaofuzerenService.updateById(xuexiaofuzeren);
		return R.ok();
	}



    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        XuexiaofuzerenEntity xuexiaofuzeren = xuexiaofuzerenService.selectOne(new EntityWrapper<XuexiaofuzerenEntity>().eq("username", username));
        if(xuexiaofuzeren!=null){
            xuexiaofuzeren.setPassword("123456");
            xuexiaofuzerenService.updateById(xuexiaofuzeren);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrXuexiaofuzeren(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        XuexiaofuzerenEntity xuexiaofuzeren = xuexiaofuzerenService.selectById(id);
        if(xuexiaofuzeren !=null){
            //entity转view
            XuexiaofuzerenView view = new XuexiaofuzerenView();
            BeanUtils.copyProperties( xuexiaofuzeren , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = xuexiaofuzerenService.queryPage(params);

        //字典表数据转换
        List<XuexiaofuzerenView> list =(List<XuexiaofuzerenView>)page.getList();
        for(XuexiaofuzerenView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XuexiaofuzerenEntity xuexiaofuzeren = xuexiaofuzerenService.selectById(id);
            if(xuexiaofuzeren !=null){


                //entity转view
                XuexiaofuzerenView view = new XuexiaofuzerenView();
                BeanUtils.copyProperties( xuexiaofuzeren , view );//把实体数据重构到view中

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
    public R add(@RequestBody XuexiaofuzerenEntity xuexiaofuzeren, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xuexiaofuzeren:{}",this.getClass().getName(),xuexiaofuzeren.toString());
        Wrapper<XuexiaofuzerenEntity> queryWrapper = new EntityWrapper<XuexiaofuzerenEntity>()
            .eq("username", xuexiaofuzeren.getUsername())
            .or()
            .eq("xuexiaofuzeren_phone", xuexiaofuzeren.getXuexiaofuzerenPhone())
            .or()
            .eq("xuexiaofuzeren_id_number", xuexiaofuzeren.getXuexiaofuzerenIdNumber())
//            .notIn("xuexiaofuzeren_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuexiaofuzerenEntity xuexiaofuzerenEntity = xuexiaofuzerenService.selectOne(queryWrapper);
        if(xuexiaofuzerenEntity==null){
            xuexiaofuzeren.setCreateTime(new Date());
        xuexiaofuzeren.setPassword("123456");
        xuexiaofuzerenService.insert(xuexiaofuzeren);

            return R.ok();
        }else {
            return R.error(511,"账户或者学院负责人手机号或者学院负责人身份证号已经被使用");
        }
    }

}

