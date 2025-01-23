package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JingsaiYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 竞赛报名
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jingsai_yuyue")
public class JingsaiYuyueView extends JingsaiYuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 竞赛状态的值
	*/
	@ColumnInfo(comment="竞赛状态的字典表值",type="varchar(200)")
	private String jingsaiYuyueValue;
	/**
	* 报名状态的值
	*/
	@ColumnInfo(comment="报名状态的字典表值",type="varchar(200)")
	private String jingsaiYuyueYesnoValue;
	/**
	* 几等奖的值
	*/
	@ColumnInfo(comment="几等奖的字典表值",type="varchar(200)")
	private String jingsaiYuyueJidengjiangValue;

	//级联表 竞赛
					 
		/**
		* 竞赛 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer jingsaiYonghuId;
		/**
		* 竞赛名称
		*/

		@ColumnInfo(comment="竞赛名称",type="varchar(200)")
		private String jingsaiName;
		/**
		* 竞赛编号
		*/

		@ColumnInfo(comment="竞赛编号",type="varchar(200)")
		private String jingsaiUuidNumber;
		/**
		* 竞赛照片
		*/

		@ColumnInfo(comment="竞赛照片",type="varchar(200)")
		private String jingsaiPhoto;
		/**
		* 竞赛类型
		*/
		@ColumnInfo(comment="竞赛类型",type="int(11)")
		private Integer jingsaiTypes;
			/**
			* 竞赛类型的值
			*/
			@ColumnInfo(comment="竞赛类型的字典表值",type="varchar(200)")
			private String jingsaiValue;
		/**
		* 竞赛热度
		*/

		@ColumnInfo(comment="竞赛热度",type="int(11)")
		private Integer jingsaiClicknum;
		/**
		* 报名截止时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="报名截止时间",type="timestamp")
		private Date baomingjiezhiTime;
		/**
		* 竞赛内容
		*/

		@ColumnInfo(comment="竞赛内容",type="text")
		private String jingsaiContent;
	//级联表 学生
		/**
		* 学生姓名
		*/

		@ColumnInfo(comment="学生姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 学生手机号
		*/

		@ColumnInfo(comment="学生手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 学生身份证号
		*/

		@ColumnInfo(comment="学生身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 学生头像
		*/

		@ColumnInfo(comment="学生头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 学生邮箱
		*/

		@ColumnInfo(comment="学生邮箱",type="varchar(200)")
		private String yonghuEmail;
	//级联表 指导老师
		/**
		* 指导老师姓名
		*/

		@ColumnInfo(comment="指导老师姓名",type="varchar(200)")
		private String zhidaolaoshiName;
		/**
		* 指导老师手机号
		*/

		@ColumnInfo(comment="指导老师手机号",type="varchar(200)")
		private String zhidaolaoshiPhone;
		/**
		* 指导老师身份证号
		*/

		@ColumnInfo(comment="指导老师身份证号",type="varchar(200)")
		private String zhidaolaoshiIdNumber;
		/**
		* 指导老师头像
		*/

		@ColumnInfo(comment="指导老师头像",type="varchar(200)")
		private String zhidaolaoshiPhoto;
		/**
		* 指导老师邮箱
		*/

		@ColumnInfo(comment="指导老师邮箱",type="varchar(200)")
		private String zhidaolaoshiEmail;

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;


	public JingsaiYuyueView() {

	}

	public JingsaiYuyueView(JingsaiYuyueEntity jingsaiYuyueEntity) {
		try {
			BeanUtils.copyProperties(this, jingsaiYuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 竞赛状态的值
	*/
	public String getJingsaiYuyueValue() {
		return jingsaiYuyueValue;
	}
	/**
	* 设置： 竞赛状态的值
	*/
	public void setJingsaiYuyueValue(String jingsaiYuyueValue) {
		this.jingsaiYuyueValue = jingsaiYuyueValue;
	}
	//当前表的
	/**
	* 获取： 报名状态的值
	*/
	public String getJingsaiYuyueYesnoValue() {
		return jingsaiYuyueYesnoValue;
	}
	/**
	* 设置： 报名状态的值
	*/
	public void setJingsaiYuyueYesnoValue(String jingsaiYuyueYesnoValue) {
		this.jingsaiYuyueYesnoValue = jingsaiYuyueYesnoValue;
	}
	//当前表的
	/**
	* 获取： 几等奖的值
	*/
	public String getJingsaiYuyueJidengjiangValue() {
		return jingsaiYuyueJidengjiangValue;
	}
	/**
	* 设置： 几等奖的值
	*/
	public void setJingsaiYuyueJidengjiangValue(String jingsaiYuyueJidengjiangValue) {
		this.jingsaiYuyueJidengjiangValue = jingsaiYuyueJidengjiangValue;
	}


	//级联表的get和set 竞赛
		/**
		* 获取：竞赛 的 用户
		*/
		public Integer getJingsaiYonghuId() {
			return jingsaiYonghuId;
		}
		/**
		* 设置：竞赛 的 用户
		*/
		public void setJingsaiYonghuId(Integer jingsaiYonghuId) {
			this.jingsaiYonghuId = jingsaiYonghuId;
		}

		/**
		* 获取： 竞赛名称
		*/
		public String getJingsaiName() {
			return jingsaiName;
		}
		/**
		* 设置： 竞赛名称
		*/
		public void setJingsaiName(String jingsaiName) {
			this.jingsaiName = jingsaiName;
		}

		/**
		* 获取： 竞赛编号
		*/
		public String getJingsaiUuidNumber() {
			return jingsaiUuidNumber;
		}
		/**
		* 设置： 竞赛编号
		*/
		public void setJingsaiUuidNumber(String jingsaiUuidNumber) {
			this.jingsaiUuidNumber = jingsaiUuidNumber;
		}

		/**
		* 获取： 竞赛照片
		*/
		public String getJingsaiPhoto() {
			return jingsaiPhoto;
		}
		/**
		* 设置： 竞赛照片
		*/
		public void setJingsaiPhoto(String jingsaiPhoto) {
			this.jingsaiPhoto = jingsaiPhoto;
		}
		/**
		* 获取： 竞赛类型
		*/
		public Integer getJingsaiTypes() {
			return jingsaiTypes;
		}
		/**
		* 设置： 竞赛类型
		*/
		public void setJingsaiTypes(Integer jingsaiTypes) {
			this.jingsaiTypes = jingsaiTypes;
		}


			/**
			* 获取： 竞赛类型的值
			*/
			public String getJingsaiValue() {
				return jingsaiValue;
			}
			/**
			* 设置： 竞赛类型的值
			*/
			public void setJingsaiValue(String jingsaiValue) {
				this.jingsaiValue = jingsaiValue;
			}

		/**
		* 获取： 竞赛热度
		*/
		public Integer getJingsaiClicknum() {
			return jingsaiClicknum;
		}
		/**
		* 设置： 竞赛热度
		*/
		public void setJingsaiClicknum(Integer jingsaiClicknum) {
			this.jingsaiClicknum = jingsaiClicknum;
		}

		/**
		* 获取： 报名截止时间
		*/
		public Date getBaomingjiezhiTime() {
			return baomingjiezhiTime;
		}
		/**
		* 设置： 报名截止时间
		*/
		public void setBaomingjiezhiTime(Date baomingjiezhiTime) {
			this.baomingjiezhiTime = baomingjiezhiTime;
		}

		/**
		* 获取： 竞赛内容
		*/
		public String getJingsaiContent() {
			return jingsaiContent;
		}
		/**
		* 设置： 竞赛内容
		*/
		public void setJingsaiContent(String jingsaiContent) {
			this.jingsaiContent = jingsaiContent;
		}
	//级联表的get和set 学生

		/**
		* 获取： 学生姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 学生姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 学生手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 学生手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 学生身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 学生身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 学生头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 学生头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 学生邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 学生邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}
	//级联表的get和set 指导老师

		/**
		* 获取： 指导老师姓名
		*/
		public String getZhidaolaoshiName() {
			return zhidaolaoshiName;
		}
		/**
		* 设置： 指导老师姓名
		*/
		public void setZhidaolaoshiName(String zhidaolaoshiName) {
			this.zhidaolaoshiName = zhidaolaoshiName;
		}

		/**
		* 获取： 指导老师手机号
		*/
		public String getZhidaolaoshiPhone() {
			return zhidaolaoshiPhone;
		}
		/**
		* 设置： 指导老师手机号
		*/
		public void setZhidaolaoshiPhone(String zhidaolaoshiPhone) {
			this.zhidaolaoshiPhone = zhidaolaoshiPhone;
		}

		/**
		* 获取： 指导老师身份证号
		*/
		public String getZhidaolaoshiIdNumber() {
			return zhidaolaoshiIdNumber;
		}
		/**
		* 设置： 指导老师身份证号
		*/
		public void setZhidaolaoshiIdNumber(String zhidaolaoshiIdNumber) {
			this.zhidaolaoshiIdNumber = zhidaolaoshiIdNumber;
		}

		/**
		* 获取： 指导老师头像
		*/
		public String getZhidaolaoshiPhoto() {
			return zhidaolaoshiPhoto;
		}
		/**
		* 设置： 指导老师头像
		*/
		public void setZhidaolaoshiPhoto(String zhidaolaoshiPhoto) {
			this.zhidaolaoshiPhoto = zhidaolaoshiPhoto;
		}

		/**
		* 获取： 指导老师邮箱
		*/
		public String getZhidaolaoshiEmail() {
			return zhidaolaoshiEmail;
		}
		/**
		* 设置： 指导老师邮箱
		*/
		public void setZhidaolaoshiEmail(String zhidaolaoshiEmail) {
			this.zhidaolaoshiEmail = zhidaolaoshiEmail;
		}

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}

	@Override
	public String toString() {
		return "JingsaiYuyueView{" +
			", jingsaiYuyueValue=" + jingsaiYuyueValue +
			", jingsaiYuyueYesnoValue=" + jingsaiYuyueYesnoValue +
			", jingsaiYuyueJidengjiangValue=" + jingsaiYuyueJidengjiangValue +
			", jingsaiName=" + jingsaiName +
			", jingsaiUuidNumber=" + jingsaiUuidNumber +
			", jingsaiPhoto=" + jingsaiPhoto +
			", jingsaiClicknum=" + jingsaiClicknum +
			", baomingjiezhiTime=" + DateUtil.convertString(baomingjiezhiTime,"yyyy-MM-dd") +
			", jingsaiContent=" + jingsaiContent +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", zhidaolaoshiName=" + zhidaolaoshiName +
			", zhidaolaoshiPhone=" + zhidaolaoshiPhone +
			", zhidaolaoshiIdNumber=" + zhidaolaoshiIdNumber +
			", zhidaolaoshiPhoto=" + zhidaolaoshiPhoto +
			", zhidaolaoshiEmail=" + zhidaolaoshiEmail +
			"} " + super.toString();
	}
}
