import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import gonggao from '@/views/modules/gonggao/list'
    import jiaowuchuguanliyuan from '@/views/modules/jiaowuchuguanliyuan/list'
    import jingsai from '@/views/modules/jingsai/list'
    import jingsaiCollection from '@/views/modules/jingsaiCollection/list'
    import jingsaiLiuyan from '@/views/modules/jingsaiLiuyan/list'
    import jingsaiYuyue from '@/views/modules/jingsaiYuyue/list'
    import xuexiaofuzeren from '@/views/modules/xuexiaofuzeren/list'
    import yonghu from '@/views/modules/yonghu/list'
    import zhidaolaoshi from '@/views/modules/zhidaolaoshi/list'
    import config from '@/views/modules/config/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionaryJingsai from '@/views/modules/dictionaryJingsai/list'
    import dictionaryJingsaiCollection from '@/views/modules/dictionaryJingsaiCollection/list'
    import dictionaryJingsaiYuyue from '@/views/modules/dictionaryJingsaiYuyue/list'
    import dictionaryJingsaiYuyueJidengjiang from '@/views/modules/dictionaryJingsaiYuyueJidengjiang/list'
    import dictionaryJingsaiYuyueYesno from '@/views/modules/dictionaryJingsaiYuyueYesno/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }, {
        path: '/huanyuan',
        name: '数据还原',
        component: huanyuan
    }, {
        path: '/beifen',
        name: '数据备份',
        component: beifen
    }, {
        path: '/users',
        name: '管理信息',
        component: users
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionaryJingsai',
        name: '竞赛类型',
        component: dictionaryJingsai
    }
    ,{
        path: '/dictionaryJingsaiCollection',
        name: '收藏表类型',
        component: dictionaryJingsaiCollection
    }
    ,{
        path: '/dictionaryJingsaiYuyue',
        name: '竞赛状态',
        component: dictionaryJingsaiYuyue
    }
    ,{
        path: '/dictionaryJingsaiYuyueJidengjiang',
        name: '几等奖',
        component: dictionaryJingsaiYuyueJidengjiang
    }
    ,{
        path: '/dictionaryJingsaiYuyueYesno',
        name: '报名状态',
        component: dictionaryJingsaiYuyueYesno
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/gonggao',
        name: '公告',
        component: gonggao
      }
    ,{
        path: '/jiaowuchuguanliyuan',
        name: '教务处管理员',
        component: jiaowuchuguanliyuan
      }
    ,{
        path: '/jingsai',
        name: '竞赛',
        component: jingsai
      }
    ,{
        path: '/jingsaiCollection',
        name: '竞赛收藏',
        component: jingsaiCollection
      }
    ,{
        path: '/jingsaiLiuyan',
        name: '竞赛留言',
        component: jingsaiLiuyan
      }
    ,{
        path: '/jingsaiYuyue',
        name: '竞赛报名',
        component: jingsaiYuyue
      }
    ,{
        path: '/xuexiaofuzeren',
        name: '学院负责人',
        component: xuexiaofuzeren
      }
    ,{
        path: '/yonghu',
        name: '学生',
        component: yonghu
      }
    ,{
        path: '/zhidaolaoshi',
        name: '指导老师',
        component: zhidaolaoshi
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
