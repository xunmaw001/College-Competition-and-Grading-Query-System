<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="auto"
                >
            <el-row>
                <el-col :span="12"  v-if="sessionTable =='users'">
                    <el-form-item class="select" v-if="type!='info'"  label="竞赛" prop="jingsaiId">
                        <el-select v-model="ruleForm.jingsaiId" :disabled="ro.jingsaiId" filterable placeholder="请选择竞赛" @change="jingsaiChange">
                            <el-option
                                    v-for="(item,index) in jingsaiOptions"
                                    v-bind:key="item.id"
                                    :label="item.jingsaiName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='jingsai' ">
                    <el-form-item class="input" v-if="type!='info'"  label="竞赛名称" prop="jingsaiName">
                        <el-input v-model="jingsaiForm.jingsaiName"
                                  placeholder="竞赛名称" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="竞赛名称" prop="jingsaiName">
                            <el-input v-model="ruleForm.jingsaiName"
                                      placeholder="竞赛名称" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='jingsai' ">
                    <el-form-item class="input" v-if="type!='info'"  label="竞赛编号" prop="jingsaiUuidNumber">
                        <el-input v-model="jingsaiForm.jingsaiUuidNumber"
                                  placeholder="竞赛编号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="竞赛编号" prop="jingsaiUuidNumber">
                            <el-input v-model="ruleForm.jingsaiUuidNumber"
                                      placeholder="竞赛编号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='jingsai' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.jingsaiPhoto" label="竞赛照片" prop="jingsaiPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (jingsaiForm.jingsaiPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.jingsaiPhoto" label="竞赛照片" prop="jingsaiPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.jingsaiPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='jingsai' ">
                    <el-form-item class="input" v-if="type!='info'"  label="竞赛类型" prop="jingsaiValue">
                        <el-input v-model="jingsaiForm.jingsaiValue"
                                  placeholder="竞赛类型" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="竞赛类型" prop="jingsaiValue">
                            <el-input v-model="ruleForm.jingsaiValue"
                                      placeholder="竞赛类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='jingsai' ">
                    <el-form-item class="input" v-if="type!='info'"  label="竞赛热度" prop="jingsaiClicknum">
                        <el-input v-model="jingsaiForm.jingsaiClicknum"
                                  placeholder="竞赛热度" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="竞赛热度" prop="jingsaiClicknum">
                            <el-input v-model="ruleForm.jingsaiClicknum"
                                      placeholder="竞赛热度" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='jingsai' ">
                    <el-form-item class="input" v-if="type!='info'"  label="报名截止时间" prop="baomingjiezhiTime">
                        <el-input v-model="jingsaiForm.baomingjiezhiTime"
                                  placeholder="报名截止时间" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="报名截止时间" prop="baomingjiezhiTime">
                            <el-input v-model="ruleForm.baomingjiezhiTime"
                                      placeholder="报名截止时间" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable =='users'">
                    <el-form-item class="select" v-if="type!='info'"  label="学生" prop="yonghuId">
                        <el-select v-model="ruleForm.yonghuId" :disabled="ro.yonghuId" filterable placeholder="请选择学生" @change="yonghuChange">
                            <el-option
                                    v-for="(item,index) in yonghuOptions"
                                    v-bind:key="item.id"
                                    :label="item.yonghuName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="学生姓名" prop="yonghuName">
                        <el-input v-model="yonghuForm.yonghuName"
                                  placeholder="学生姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="学生姓名" prop="yonghuName">
                            <el-input v-model="ruleForm.yonghuName"
                                      placeholder="学生姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="学生手机号" prop="yonghuPhone">
                        <el-input v-model="yonghuForm.yonghuPhone"
                                  placeholder="学生手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="学生手机号" prop="yonghuPhone">
                            <el-input v-model="ruleForm.yonghuPhone"
                                      placeholder="学生手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="学生身份证号" prop="yonghuIdNumber">
                        <el-input v-model="yonghuForm.yonghuIdNumber"
                                  placeholder="学生身份证号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="学生身份证号" prop="yonghuIdNumber">
                            <el-input v-model="ruleForm.yonghuIdNumber"
                                      placeholder="学生身份证号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='yonghu' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.yonghuPhoto" label="学生头像" prop="yonghuPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (yonghuForm.yonghuPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.yonghuPhoto" label="学生头像" prop="yonghuPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.yonghuPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="学生邮箱" prop="yonghuEmail">
                        <el-input v-model="yonghuForm.yonghuEmail"
                                  placeholder="学生邮箱" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="学生邮箱" prop="yonghuEmail">
                            <el-input v-model="ruleForm.yonghuEmail"
                                      placeholder="学生邮箱" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable =='users'">
                    <el-form-item class="select" v-if="type!='info'"  label="指导老师" prop="zhidaolaoshiId">
                        <el-select v-model="ruleForm.zhidaolaoshiId" :disabled="ro.zhidaolaoshiId" filterable placeholder="请选择指导老师" @change="zhidaolaoshiChange">
                            <el-option
                                    v-for="(item,index) in zhidaolaoshiOptions"
                                    v-bind:key="item.id"
                                    :label="item.zhidaolaoshiName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='zhidaolaoshi' ">
                    <el-form-item class="input" v-if="type!='info'"  label="指导老师姓名" prop="zhidaolaoshiName">
                        <el-input v-model="zhidaolaoshiForm.zhidaolaoshiName"
                                  placeholder="指导老师姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="指导老师姓名" prop="zhidaolaoshiName">
                            <el-input v-model="ruleForm.zhidaolaoshiName"
                                      placeholder="指导老师姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='zhidaolaoshi' ">
                    <el-form-item class="input" v-if="type!='info'"  label="指导老师手机号" prop="zhidaolaoshiPhone">
                        <el-input v-model="zhidaolaoshiForm.zhidaolaoshiPhone"
                                  placeholder="指导老师手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="指导老师手机号" prop="zhidaolaoshiPhone">
                            <el-input v-model="ruleForm.zhidaolaoshiPhone"
                                      placeholder="指导老师手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='zhidaolaoshi' ">
                    <el-form-item class="input" v-if="type!='info'"  label="指导老师身份证号" prop="zhidaolaoshiIdNumber">
                        <el-input v-model="zhidaolaoshiForm.zhidaolaoshiIdNumber"
                                  placeholder="指导老师身份证号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="指导老师身份证号" prop="zhidaolaoshiIdNumber">
                            <el-input v-model="ruleForm.zhidaolaoshiIdNumber"
                                      placeholder="指导老师身份证号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='zhidaolaoshi' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.zhidaolaoshiPhoto" label="指导老师头像" prop="zhidaolaoshiPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (zhidaolaoshiForm.zhidaolaoshiPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.zhidaolaoshiPhoto" label="指导老师头像" prop="zhidaolaoshiPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.zhidaolaoshiPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='zhidaolaoshi' ">
                    <el-form-item class="input" v-if="type!='info'"  label="指导老师邮箱" prop="zhidaolaoshiEmail">
                        <el-input v-model="zhidaolaoshiForm.zhidaolaoshiEmail"
                                  placeholder="指导老师邮箱" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="指导老师邮箱" prop="zhidaolaoshiEmail">
                            <el-input v-model="ruleForm.zhidaolaoshiEmail"
                                      placeholder="指导老师邮箱" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="报名编号" prop="jingsaiYuyueUuidNumber">
                       <el-input v-model="ruleForm.jingsaiYuyueUuidNumber"
                                 placeholder="报名编号" clearable  :readonly="ro.jingsaiYuyueUuidNumber"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="报名编号" prop="jingsaiYuyueUuidNumber">
                           <el-input v-model="ruleForm.jingsaiYuyueUuidNumber"
                                     placeholder="报名编号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
            <input id="jingsaiId" name="jingsaiId" type="hidden">
            <input id="yonghuId" name="yonghuId" type="hidden">
            <input id="zhidaolaoshiId" name="zhidaolaoshiId" type="hidden">
                <el-col :span="12">
                    <el-form-item class="upload" v-if="type!='info' &&  sessionTable=='users'" label="竞赛作品" prop="jingsaiYuyueFile">
                        <file-upload
                                tip="点击上传竞赛作品"
                                action="file/upload"
                                :limit="3"
                                :multiple="true"
                                :fileUrls="ruleForm.jingsaiYuyueFile?$base.url+ruleForm.jingsaiYuyueFile:''"
                                @change="jingsaiYuyueFileUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item label="竞赛作品" prop="jingsaiYuyueFile">
                            <a type="text" style="text-decoration:none" class="el-button" :href="$base.url+ruleForm.jingsaiYuyueFile"  >竞赛作品下载</a>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'&& sessionTable=='users1111'"  label="竞赛状态" prop="jingsaiYuyueTypes">
                        <el-select v-model="ruleForm.jingsaiYuyueTypes" :disabled="ro.jingsaiYuyueTypes" placeholder="请选择竞赛状态">
                            <el-option
                                v-for="(item,index) in jingsaiYuyueTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="竞赛状态" prop="jingsaiYuyueValue">
                        <el-input v-model="ruleForm.jingsaiYuyueValue"
                            placeholder="竞赛状态" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
            <el-col :span="12" v-if="type=='info'">
                <div>
                    <el-form-item v-if="ruleForm.jingsaiYuyueYesnoTypes" label="报名状态" prop="jingsaiYuyueYesnoTypes">
                        <el-input v-model="ruleForm.jingsaiYuyueYesnoValue" placeholder="报名状态" readonly></el-input>
                    </el-form-item>
                </div>
            </el-col>
            <el-col :span="12" v-if="type=='info'">
                <div>
                    <el-form-item v-if="ruleForm.jingsaiYuyueYesnoText" label="审核回复" prop="jingsaiYuyueYesnoText">
                        <span v-html="ruleForm.jingsaiYuyueYesnoText"></span>
                    </el-form-item>
                </div>
            </el-col>
            <el-col :span="12" v-if="type=='info'">
                <div>
                    <el-form-item v-if="ruleForm.jingsaiYuyueShenheTime" label="审核时间" prop="jingsaiYuyueShenheTime">
                        <span v-html="ruleForm.jingsaiYuyueShenheTime"></span>
                    </el-form-item>
                </div>
            </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="几等奖" prop="jingsaiYuyueJidengjiangTypes">
                        <el-select v-model="ruleForm.jingsaiYuyueJidengjiangTypes" :disabled="ro.jingsaiYuyueJidengjiangTypes" placeholder="请选择几等奖">
                            <el-option
                                v-for="(item,index) in jingsaiYuyueJidengjiangTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="几等奖" prop="jingsaiYuyueJidengjiangValue">
                        <el-input v-model="ruleForm.jingsaiYuyueJidengjiangValue"
                            placeholder="几等奖" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="得分" prop="jingsaiYuyueDafen">
                       <el-input v-model="ruleForm.jingsaiYuyueDafen"
                                 placeholder="得分" clearable  :readonly="ro.jingsaiYuyueDafen"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="得分" prop="jingsaiYuyueDafen">
                           <el-input v-model="ruleForm.jingsaiYuyueDafen"
                                     placeholder="得分" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info'"  label="评审意见" prop="jingsaiYuyuePingshenText">
                        <el-input type="textarea"  :readonly="ro.jingsaiYuyuePingshenText" v-model="ruleForm.jingsaiYuyuePingshenText" placeholder="评审意见"></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.jingsaiYuyuePingshenText" label="评审意见" prop="jingsaiYuyuePingshenText">
                            <span v-html="ruleForm.jingsaiYuyuePingshenText"></span>
                        </el-form-item>
                    </div>
                </el-col>
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    import utilsJs, {getYearFormat,getMonthFormat,getDateFormat,getDatetimeFormat} from "../../../utils/utils.js";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                userId:"",//当前登录人的id
                jingsaiForm: {},
                yonghuForm: {},
                zhidaolaoshiForm: {},
                ro:{
                    jingsaiYuyueUuidNumber: false,
                    jingsaiId: false,
                    yonghuId: false,
                    zhidaolaoshiId: false,
                    insertTime: false,
                    jingsaiYuyueFile: false,
                    jingsaiYuyueTypes: false,
                    jingsaiYuyueYesnoTypes: false,
                    jingsaiYuyueYesnoText: false,
                    jingsaiYuyueShenheTime: false,
                    jingsaiYuyueJidengjiangTypes: false,
                    jingsaiYuyueDafen: false,
                    jingsaiYuyuePingshenText: false,
                },
                ruleForm: {
                    jingsaiYuyueUuidNumber: new Date().getTime(),
                    jingsaiId: '',
                    yonghuId: '',
                    zhidaolaoshiId: '',
                    insertTime: '',
                    jingsaiYuyueFile: '',
                    jingsaiYuyueTypes: '',
                    jingsaiYuyueYesnoTypes: '',
                    jingsaiYuyueYesnoText: '',
                    jingsaiYuyueShenheTime: '',
                    jingsaiYuyueJidengjiangTypes: '',
                    jingsaiYuyueDafen: '',
                    jingsaiYuyuePingshenText: '',
                },
                jingsaiYuyueTypesOptions : [],
                jingsaiYuyueYesnoTypesOptions : [],
                jingsaiYuyueJidengjiangTypesOptions : [],
                jingsaiOptions : [],
                yonghuOptions : [],
                zhidaolaoshiOptions : [],
                rules: {
                   jingsaiYuyueUuidNumber: [
                              { required: true, message: '报名编号不能为空', trigger: 'blur' },
                          ],
                   jingsaiId: [
                              { required: true, message: '竞赛不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   yonghuId: [
                              { required: true, message: '用户不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   zhidaolaoshiId: [
                              { required: true, message: '指导老师不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   insertTime: [
                              { required: true, message: '竞赛报名时间不能为空', trigger: 'blur' },
                          ],
                   jingsaiYuyueFile: [
                              { required: true, message: '竞赛作品不能为空', trigger: 'blur' },
                          ],
                   jingsaiYuyueTypes: [
                              { required: true, message: '竞赛状态不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   jingsaiYuyueYesnoTypes: [
                              { required: true, message: '报名状态不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   jingsaiYuyueYesnoText: [
                              { required: true, message: '审核回复不能为空', trigger: 'blur' },
                          ],
                   jingsaiYuyueShenheTime: [
                              { required: true, message: '审核时间不能为空', trigger: 'blur' },
                          ],
                   jingsaiYuyueJidengjiangTypes: [
                              { required: true, message: '几等奖不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   jingsaiYuyueDafen: [
                              { required: true, message: '得分不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]{0,6}(\.[0-9]{1,2})?$/,
                                  message: '只允许输入整数6位,小数2位的数字',
                                  trigger: 'blur'
                              }
                          ],
                   jingsaiYuyuePingshenText: [
                              { required: true, message: '评审意见不能为空', trigger: 'blur' },
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");


            if (this.role != "管理员"){
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=jingsai_yuyue_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.jingsaiYuyueTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=jingsai_yuyue_yesno_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.jingsaiYuyueYesnoTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=jingsai_yuyue_jidengjiang_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.jingsaiYuyueJidengjiangTypesOptions = data.data.list;
                    }
                });

         this.$http({
             url: `jingsai/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.jingsaiOptions = data.data.list;
            }
         });
         this.$http({
             url: `yonghu/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.yonghuOptions = data.data.list;
            }
         });
         this.$http({
             url: `zhidaolaoshi/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.zhidaolaoshiOptions = data.data.list;
            }
         });

        },
        mounted() {
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'){
                    this.info(id);
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            jingsaiChange(id){
                this.$http({
                    url: `jingsai/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.jingsaiForm = data.data;
                    }
                });
            },
            yonghuChange(id){
                this.$http({
                    url: `yonghu/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.yonghuForm = data.data;
                    }
                });
            },
            zhidaolaoshiChange(id){
                this.$http({
                    url: `zhidaolaoshi/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.zhidaolaoshiForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `jingsaiYuyue/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.jingsaiChange(data.data.jingsaiId)
                        _this.yonghuChange(data.data.yonghuId)
                        _this.zhidaolaoshiChange(data.data.zhidaolaoshiId)
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.$http({
                            url:`jingsaiYuyue/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                        this.parent.showFlag = true;
                                        this.parent.addOrUpdateFlag = false;
                                        this.parent.jingsaiYuyueCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.jingsaiYuyueCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片
            jingsaiYuyueFileUploadChange(fileUrls){
                this.ruleForm.jingsaiYuyueFile = fileUrls;
                this.addEditUploadStyleChange()
            },

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
  height: 500px;

  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
	background-color: transparent;
}
.btn .el-button {
  padding: 0;
}</style>

