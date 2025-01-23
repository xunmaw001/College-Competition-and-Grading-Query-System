
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
 * 教务处管理员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiaowuchuguanliyuan")
public class JiaowuchuguanliyuanController {
    private static final Logger logger = LoggerFactory.getLogger(JiaowuchuguanliyuanController.class);

    private static final String TABLE_NAME = "jiaowuchuguanliyuan";

    @Autowired
    private JiaowuchuguanliyuanService jiaowuchuguanliyuanService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private JingsaiService jingsaiService;//竞赛
    @Autowired
    private JingsaiCollectionService jingsaiCollectionService;//竞赛收藏
    @Autowired
    private JingsaiLiuyanService jingsaiLiuyanService;//竞赛留言
    @Autowired
    private JingsaiYuyueService jingsaiYuyueService;//竞赛报名
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
        PageUtils page = jiaowuchuguanliyuanService.queryPage(params);

        //字典表数据转换
        List<JiaowuchuguanliyuanView> list =(List<JiaowuchuguanliyuanView>)page.getList();
        for(JiaowuchuguanliyuanView c:list){
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
        JiaowuchuguanliyuanEntity jiaowuchuguanliyuan = jiaowuchuguanliyuanService.selectById(id);
        if(jiaowuchuguanliyuan !=null){
            //entity转view
            JiaowuchuguanliyuanView view = new JiaowuchuguanliyuanView();
            BeanUtils.copyProperties( jiaowuchuguanliyuan , view );//把实体数据重构到view中
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
    public R save(@RequestBody JiaowuchuguanliyuanEntity jiaowuchuguanliyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiaowuchuguanliyuan:{}",this.getClass().getName(),jiaowuchuguanliyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<JiaowuchuguanliyuanEntity> queryWrapper = new EntityWrapper<JiaowuchuguanliyuanEntity>()
            .eq("username", jiaowuchuguanliyuan.getUsername())
            .or()
            .eq("jiaowuchuguanliyuan_phone", jiaowuchuguanliyuan.getJiaowuchuguanliyuanPhone())
            .or()
            .eq("jiaowuchuguanliyuan_id_number", jiaowuchuguanliyuan.getJiaowuchuguanliyuanIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaowuchuguanliyuanEntity jiaowuchuguanliyuanEntity = jiaowuchuguanliyuanService.selectOne(queryWrapper);
        if(jiaowuchuguanliyuanEntity==null){
            jiaowuchuguanliyuan.setCreateTime(new Date());
            jiaowuchuguanliyuan.setPassword("123456");
            jiaowuchuguanliyuanService.insert(jiaowuchuguanliyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者教务处管理员手机号或者教务处管理员身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiaowuchuguanliyuanEntity jiaowuchuguanliyuan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jiaowuchuguanliyuan:{}",this.getClass().getName(),jiaowuchuguanliyuan.toString());
        JiaowuchuguanliyuanEntity oldJiaowuchuguanliyuanEntity = jiaowuchuguanliyuanService.selectById(jiaowuchuguanliyuan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(jiaowuchuguanliyuan.getJiaowuchuguanliyuanPhoto()) || "null".equals(jiaowuchuguanliyuan.getJiaowuchuguanliyuanPhoto())){
                jiaowuchuguanliyuan.setJiaowuchuguanliyuanPhoto(null);
        }

            jiaowuchuguanliyuanService.updateById(jiaowuchuguanliyuan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JiaowuchuguanliyuanEntity> oldJiaowuchuguanliyuanList =jiaowuchuguanliyuanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jiaowuchuguanliyuanService.deleteBatchIds(Arrays.asList(ids));

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
            List<JiaowuchuguanliyuanEntity> jiaowuchuguanliyuanList = new ArrayList<>();//上传的东西
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
                            JiaowuchuguanliyuanEntity jiaowuchuguanliyuanEntity = new JiaowuchuguanliyuanEntity();
//                            jiaowuchuguanliyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            //jiaowuchuguanliyuanEntity.setPassword("123456");//密码
//                            jiaowuchuguanliyuanEntity.setJiaowuchuguanliyuanName(data.get(0));                    //教务处管理员姓名 要改的
//                            jiaowuchuguanliyuanEntity.setJiaowuchuguanliyuanPhone(data.get(0));                    //教务处管理员手机号 要改的
//                            jiaowuchuguanliyuanEntity.setJiaowuchuguanliyuanIdNumber(data.get(0));                    //教务处管理员身份证号 要改的
//                            jiaowuchuguanliyuanEntity.setJiaowuchuguanliyuanPhoto("");//详情和图片
//                            jiaowuchuguanliyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            jiaowuchuguanliyuanEntity.setJiaowuchuguanliyuanEmail(data.get(0));                    //教务处管理员邮箱 要改的
//                            jiaowuchuguanliyuanEntity.setCreateTime(date);//时间
                            jiaowuchuguanliyuanList.add(jiaowuchuguanliyuanEntity);


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
                                //教务处管理员手机号
                                if(seachFields.containsKey("jiaowuchuguanliyuanPhone")){
                                    List<String> jiaowuchuguanliyuanPhone = seachFields.get("jiaowuchuguanliyuanPhone");
                                    jiaowuchuguanliyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> jiaowuchuguanliyuanPhone = new ArrayList<>();
                                    jiaowuchuguanliyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("jiaowuchuguanliyuanPhone",jiaowuchuguanliyuanPhone);
                                }
                                //教务处管理员身份证号
                                if(seachFields.containsKey("jiaowuchuguanliyuanIdNumber")){
                                    List<String> jiaowuchuguanliyuanIdNumber = seachFields.get("jiaowuchuguanliyuanIdNumber");
                                    jiaowuchuguanliyuanIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jiaowuchuguanliyuanIdNumber = new ArrayList<>();
                                    jiaowuchuguanliyuanIdNumber.add(data.get(0));//要改的
                                    seachFields.put("jiaowuchuguanliyuanIdNumber",jiaowuchuguanliyuanIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<JiaowuchuguanliyuanEntity> jiaowuchuguanliyuanEntities_username = jiaowuchuguanliyuanService.selectList(new EntityWrapper<JiaowuchuguanliyuanEntity>().in("username", seachFields.get("username")));
                        if(jiaowuchuguanliyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiaowuchuguanliyuanEntity s:jiaowuchuguanliyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //教务处管理员手机号
                        List<JiaowuchuguanliyuanEntity> jiaowuchuguanliyuanEntities_jiaowuchuguanliyuanPhone = jiaowuchuguanliyuanService.selectList(new EntityWrapper<JiaowuchuguanliyuanEntity>().in("jiaowuchuguanliyuan_phone", seachFields.get("jiaowuchuguanliyuanPhone")));
                        if(jiaowuchuguanliyuanEntities_jiaowuchuguanliyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiaowuchuguanliyuanEntity s:jiaowuchuguanliyuanEntities_jiaowuchuguanliyuanPhone){
                                repeatFields.add(s.getJiaowuchuguanliyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [教务处管理员手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //教务处管理员身份证号
                        List<JiaowuchuguanliyuanEntity> jiaowuchuguanliyuanEntities_jiaowuchuguanliyuanIdNumber = jiaowuchuguanliyuanService.selectList(new EntityWrapper<JiaowuchuguanliyuanEntity>().in("jiaowuchuguanliyuan_id_number", seachFields.get("jiaowuchuguanliyuanIdNumber")));
                        if(jiaowuchuguanliyuanEntities_jiaowuchuguanliyuanIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiaowuchuguanliyuanEntity s:jiaowuchuguanliyuanEntities_jiaowuchuguanliyuanIdNumber){
                                repeatFields.add(s.getJiaowuchuguanliyuanIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [教务处管理员身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jiaowuchuguanliyuanService.insertBatch(jiaowuchuguanliyuanList);
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
        JiaowuchuguanliyuanEntity jiaowuchuguanliyuan = jiaowuchuguanliyuanService.selectOne(new EntityWrapper<JiaowuchuguanliyuanEntity>().eq("username", username));
        if(jiaowuchuguanliyuan==null || !jiaowuchuguanliyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        String token = tokenService.generateToken(jiaowuchuguanliyuan.getId(),username, "jiaowuchuguanliyuan", "教务处管理员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","教务处管理员");
        r.put("username",jiaowuchuguanliyuan.getJiaowuchuguanliyuanName());
        r.put("tableName","jiaowuchuguanliyuan");
        r.put("userId",jiaowuchuguanliyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody JiaowuchuguanliyuanEntity jiaowuchuguanliyuan, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<JiaowuchuguanliyuanEntity> queryWrapper = new EntityWrapper<JiaowuchuguanliyuanEntity>()
            .eq("username", jiaowuchuguanliyuan.getUsername())
            .or()
            .eq("jiaowuchuguanliyuan_phone", jiaowuchuguanliyuan.getJiaowuchuguanliyuanPhone())
            .or()
            .eq("jiaowuchuguanliyuan_id_number", jiaowuchuguanliyuan.getJiaowuchuguanliyuanIdNumber())
            ;
        JiaowuchuguanliyuanEntity jiaowuchuguanliyuanEntity = jiaowuchuguanliyuanService.selectOne(queryWrapper);
        if(jiaowuchuguanliyuanEntity != null)
            return R.error("账户或者教务处管理员手机号或者教务处管理员身份证号已经被使用");
        jiaowuchuguanliyuan.setCreateTime(new Date());
        jiaowuchuguanliyuanService.insert(jiaowuchuguanliyuan);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        JiaowuchuguanliyuanEntity jiaowuchuguanliyuan = jiaowuchuguanliyuanService.selectById(id);
        jiaowuchuguanliyuan.setPassword("123456");
        jiaowuchuguanliyuanService.updateById(jiaowuchuguanliyuan);
        return R.ok();
    }

	/**
	 * 修改密码
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        JiaowuchuguanliyuanEntity jiaowuchuguanliyuan = jiaowuchuguanliyuanService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("新密码不能为空") ;
		}
		if(!oldPassword.equals(jiaowuchuguanliyuan.getPassword())){
			return R.error("原密码输入错误");
		}
		if(newPassword.equals(jiaowuchuguanliyuan.getPassword())){
			return R.error("新密码不能和原密码一致") ;
		}
        jiaowuchuguanliyuan.setPassword(newPassword);
		jiaowuchuguanliyuanService.updateById(jiaowuchuguanliyuan);
		return R.ok();
	}



    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        JiaowuchuguanliyuanEntity jiaowuchuguanliyuan = jiaowuchuguanliyuanService.selectOne(new EntityWrapper<JiaowuchuguanliyuanEntity>().eq("username", username));
        if(jiaowuchuguanliyuan!=null){
            jiaowuchuguanliyuan.setPassword("123456");
            jiaowuchuguanliyuanService.updateById(jiaowuchuguanliyuan);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrJiaowuchuguanliyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        JiaowuchuguanliyuanEntity jiaowuchuguanliyuan = jiaowuchuguanliyuanService.selectById(id);
        if(jiaowuchuguanliyuan !=null){
            //entity转view
            JiaowuchuguanliyuanView view = new JiaowuchuguanliyuanView();
            BeanUtils.copyProperties( jiaowuchuguanliyuan , view );//把实体数据重构到view中

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
        PageUtils page = jiaowuchuguanliyuanService.queryPage(params);

        //字典表数据转换
        List<JiaowuchuguanliyuanView> list =(List<JiaowuchuguanliyuanView>)page.getList();
        for(JiaowuchuguanliyuanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiaowuchuguanliyuanEntity jiaowuchuguanliyuan = jiaowuchuguanliyuanService.selectById(id);
            if(jiaowuchuguanliyuan !=null){


                //entity转view
                JiaowuchuguanliyuanView view = new JiaowuchuguanliyuanView();
                BeanUtils.copyProperties( jiaowuchuguanliyuan , view );//把实体数据重构到view中

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
    public R add(@RequestBody JiaowuchuguanliyuanEntity jiaowuchuguanliyuan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jiaowuchuguanliyuan:{}",this.getClass().getName(),jiaowuchuguanliyuan.toString());
        Wrapper<JiaowuchuguanliyuanEntity> queryWrapper = new EntityWrapper<JiaowuchuguanliyuanEntity>()
            .eq("username", jiaowuchuguanliyuan.getUsername())
            .or()
            .eq("jiaowuchuguanliyuan_phone", jiaowuchuguanliyuan.getJiaowuchuguanliyuanPhone())
            .or()
            .eq("jiaowuchuguanliyuan_id_number", jiaowuchuguanliyuan.getJiaowuchuguanliyuanIdNumber())
//            .notIn("jiaowuchuguanliyuan_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaowuchuguanliyuanEntity jiaowuchuguanliyuanEntity = jiaowuchuguanliyuanService.selectOne(queryWrapper);
        if(jiaowuchuguanliyuanEntity==null){
            jiaowuchuguanliyuan.setCreateTime(new Date());
        jiaowuchuguanliyuan.setPassword("123456");
        jiaowuchuguanliyuanService.insert(jiaowuchuguanliyuan);

            return R.ok();
        }else {
            return R.error(511,"账户或者教务处管理员手机号或者教务处管理员身份证号已经被使用");
        }
    }

}

