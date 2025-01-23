<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="auto"
    >  
     <el-row>
                    <el-col :span="12">
           <el-form-item v-if="flag=='jiaowuchuguanliyuan'"  label='教务处管理员姓名' prop="jiaowuchuguanliyuanName">
               <el-input v-model="ruleForm.jiaowuchuguanliyuanName"  placeholder='教务处管理员姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='jiaowuchuguanliyuan'"  label='教务处管理员手机号' prop="jiaowuchuguanliyuanPhone">
               <el-input v-model="ruleForm.jiaowuchuguanliyuanPhone"  placeholder='教务处管理员手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='jiaowuchuguanliyuan'"  label='教务处管理员身份证号' prop="jiaowuchuguanliyuanIdNumber">
               <el-input v-model="ruleForm.jiaowuchuguanliyuanIdNumber"  placeholder='教务处管理员身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='jiaowuchuguanliyuan'" label='教务处管理员头像' prop="jiaowuchuguanliyuanPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.jiaowuchuguanliyuanPhoto?$base.url+ruleForm.jiaowuchuguanliyuanPhoto:''"
                         @change="jiaowuchuguanliyuanPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='jiaowuchuguanliyuan'"  label='教务处管理员邮箱' prop="jiaowuchuguanliyuanEmail">
               <el-input v-model="ruleForm.jiaowuchuguanliyuanEmail"  placeholder='教务处管理员邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='xuexiaofuzeren'"  label='学院负责人姓名' prop="xuexiaofuzerenName">
               <el-input v-model="ruleForm.xuexiaofuzerenName"  placeholder='学院负责人姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='xuexiaofuzeren'"  label='学院负责人手机号' prop="xuexiaofuzerenPhone">
               <el-input v-model="ruleForm.xuexiaofuzerenPhone"  placeholder='学院负责人手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='xuexiaofuzeren'"  label='学院负责人身份证号' prop="xuexiaofuzerenIdNumber">
               <el-input v-model="ruleForm.xuexiaofuzerenIdNumber"  placeholder='学院负责人身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='xuexiaofuzeren'" label='学院负责人头像' prop="xuexiaofuzerenPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.xuexiaofuzerenPhoto?$base.url+ruleForm.xuexiaofuzerenPhoto:''"
                         @change="xuexiaofuzerenPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='xuexiaofuzeren'"  label='学院负责人邮箱' prop="xuexiaofuzerenEmail">
               <el-input v-model="ruleForm.xuexiaofuzerenEmail"  placeholder='学院负责人邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='学生姓名' prop="yonghuName">
               <el-input v-model="ruleForm.yonghuName"  placeholder='学生姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='学生手机号' prop="yonghuPhone">
               <el-input v-model="ruleForm.yonghuPhone"  placeholder='学生手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='学生身份证号' prop="yonghuIdNumber">
               <el-input v-model="ruleForm.yonghuIdNumber"  placeholder='学生身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='yonghu'" label='学生头像' prop="yonghuPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.yonghuPhoto?$base.url+ruleForm.yonghuPhoto:''"
                         @change="yonghuPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='学生邮箱' prop="yonghuEmail">
               <el-input v-model="ruleForm.yonghuEmail"  placeholder='学生邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='zhidaolaoshi'"  label='指导老师姓名' prop="zhidaolaoshiName">
               <el-input v-model="ruleForm.zhidaolaoshiName"  placeholder='指导老师姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='zhidaolaoshi'"  label='指导老师手机号' prop="zhidaolaoshiPhone">
               <el-input v-model="ruleForm.zhidaolaoshiPhone"  placeholder='指导老师手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='zhidaolaoshi'"  label='指导老师身份证号' prop="zhidaolaoshiIdNumber">
               <el-input v-model="ruleForm.zhidaolaoshiIdNumber"  placeholder='指导老师身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='zhidaolaoshi'" label='指导老师头像' prop="zhidaolaoshiPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.zhidaolaoshiPhoto?$base.url+ruleForm.zhidaolaoshiPhoto:''"
                         @change="zhidaolaoshiPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='zhidaolaoshi'"  label='指导老师邮箱' prop="zhidaolaoshiEmail">
               <el-input v-model="ruleForm.zhidaolaoshiEmail"  placeholder='指导老师邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-form-item v-if="flag=='users'" label="用户名" prop="username">
             <el-input v-model="ruleForm.username"
                       placeholder="用户名"></el-input>
         </el-form-item>
         <el-col :span="12">
             <el-form-item v-if="flag!='users' &&( 1==2|| flag=='yonghu'
|| flag=='jiaowuchuguanliyuan'
|| flag=='xuexiaofuzeren'
|| flag=='zhidaolaoshi')"  label="性别" prop="sexTypes">
                 <el-select v-model="ruleForm.sexTypes" placeholder="请选择性别">
                     <el-option
                             v-for="(item,index) in sexTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="24">
             <el-form-item>
                 <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
             </el-form-item>
         </el-col>
     </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
        ruleForm: {},
        flag: '',
        usersFlag: false,
        // sexTypesOptions : [],
// 注册表 学生
    // 注册的类型字段 学生
        // 性别
        sexTypesOptions : [],
// 注册表 教务处管理员
    // 注册的类型字段 教务处管理员
        // 性别
        sexTypesOptions : [],
// 注册表 学院负责人
    // 注册的类型字段 学院负责人
        // 性别
        sexTypesOptions : [],
// 注册表 指导老师
    // 注册的类型字段 指导老师
        // 性别
        sexTypesOptions : [],
    };
  },
  mounted() {
    //获取当前登录用户的信息
    var table = this.$storage.get("sessionTable");
    this.sessionTable = this.$storage.get("sessionTable");
    this.role = this.$storage.get("role");
    if (this.role != "管理员"){
    }

    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
// 注册表 学生
// 注册表 教务处管理员
// 注册表 学院负责人
// 注册表 指导老师
      } else {
        this.$message.error(data.msg);
      }
    });

// 注册表 学生 的级联表
// 注册表 教务处管理员 的级联表
// 注册表 学院负责人 的级联表
// 注册表 指导老师 的级联表

      this.$http({
          url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=sex_types`,
          method: "get"
      }).then(({ data }) => {
          if (data && data.code === 0) {
              this.sexTypesOptions = data.data.list;
          } else {
              this.$message.error(data.msg);
          }
      });
  },
  methods: {
    chongzhi() {
      this.$router.replace({ path: "/pay" });
    },
    tixian() {
      let _this=this;
      this.$confirm(`确定要提现么?`, "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
      }).then(() => {
          _this.ruleForm.newMoney=0;
          _this.$http({
              url: `${this.$storage.get("sessionTable")}/update`,
              method: "post",
              data: this.ruleForm
          }).then(({ data }) => {
              if (data && data.code === 0) {
                  _this.$message({message: "提现成功",type: "success",duration: 1500,onClose: () => {}});
              } else {this.$message.error(data.msg);}
          });
      });
    },
    jiaowuchuguanliyuanPhotoUploadChange(fileUrls) {
        this.ruleForm.jiaowuchuguanliyuanPhoto = fileUrls;
    },
    xuexiaofuzerenPhotoUploadChange(fileUrls) {
        this.ruleForm.xuexiaofuzerenPhoto = fileUrls;
    },
    yonghuPhotoUploadChange(fileUrls) {
        this.ruleForm.yonghuPhoto = fileUrls;
    },
    zhidaolaoshiPhotoUploadChange(fileUrls) {
        this.ruleForm.zhidaolaoshiPhoto = fileUrls;
    },


    onUpdateHandler() {
                         if((!this.ruleForm.jiaowuchuguanliyuanName)&& 'jiaowuchuguanliyuan'==this.flag){
                             this.$message.error('教务处管理员姓名不能为空');
                             return
                         }

                             if( 'jiaowuchuguanliyuan' ==this.flag && this.ruleForm.jiaowuchuguanliyuanPhone&&(!isMobile(this.ruleForm.jiaowuchuguanliyuanPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.jiaowuchuguanliyuanIdNumber)&& 'jiaowuchuguanliyuan'==this.flag){
                             this.$message.error('教务处管理员身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.jiaowuchuguanliyuanPhoto)&& 'jiaowuchuguanliyuan'==this.flag){
                             this.$message.error('教务处管理员头像不能为空');
                             return
                         }

                             if( 'jiaowuchuguanliyuan' ==this.flag && this.ruleForm.jiaowuchuguanliyuanEmail&&(!isEmail(this.ruleForm.jiaowuchuguanliyuanEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.xuexiaofuzerenName)&& 'xuexiaofuzeren'==this.flag){
                             this.$message.error('学院负责人姓名不能为空');
                             return
                         }

                             if( 'xuexiaofuzeren' ==this.flag && this.ruleForm.xuexiaofuzerenPhone&&(!isMobile(this.ruleForm.xuexiaofuzerenPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.xuexiaofuzerenIdNumber)&& 'xuexiaofuzeren'==this.flag){
                             this.$message.error('学院负责人身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.xuexiaofuzerenPhoto)&& 'xuexiaofuzeren'==this.flag){
                             this.$message.error('学院负责人头像不能为空');
                             return
                         }

                             if( 'xuexiaofuzeren' ==this.flag && this.ruleForm.xuexiaofuzerenEmail&&(!isEmail(this.ruleForm.xuexiaofuzerenEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.yonghuName)&& 'yonghu'==this.flag){
                             this.$message.error('学生姓名不能为空');
                             return
                         }

                             if( 'yonghu' ==this.flag && this.ruleForm.yonghuPhone&&(!isMobile(this.ruleForm.yonghuPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.yonghuIdNumber)&& 'yonghu'==this.flag){
                             this.$message.error('学生身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.yonghuPhoto)&& 'yonghu'==this.flag){
                             this.$message.error('学生头像不能为空');
                             return
                         }

                             if( 'yonghu' ==this.flag && this.ruleForm.yonghuEmail&&(!isEmail(this.ruleForm.yonghuEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.zhidaolaoshiName)&& 'zhidaolaoshi'==this.flag){
                             this.$message.error('指导老师姓名不能为空');
                             return
                         }

                             if( 'zhidaolaoshi' ==this.flag && this.ruleForm.zhidaolaoshiPhone&&(!isMobile(this.ruleForm.zhidaolaoshiPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.zhidaolaoshiIdNumber)&& 'zhidaolaoshi'==this.flag){
                             this.$message.error('指导老师身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.zhidaolaoshiPhoto)&& 'zhidaolaoshi'==this.flag){
                             this.$message.error('指导老师头像不能为空');
                             return
                         }

                             if( 'zhidaolaoshi' ==this.flag && this.ruleForm.zhidaolaoshiEmail&&(!isEmail(this.ruleForm.zhidaolaoshiEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
        if((!this.ruleForm.sexTypes) && (1==2|| this.flag=='yonghu'
|| this.flag=='jiaowuchuguanliyuan'
|| this.flag=='xuexiaofuzeren'
|| this.flag=='zhidaolaoshi')){
            this.$message.error('性别不能为空');
            return
        }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
        this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
