package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 竞赛
 *
 * @author 
 * @email
 */
@TableName("jingsai")
public class JingsaiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JingsaiEntity() {

	}

	public JingsaiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 竞赛名称
     */
    @ColumnInfo(comment="竞赛名称",type="varchar(200)")
    @TableField(value = "jingsai_name")

    private String jingsaiName;


    /**
     * 竞赛编号
     */
    @ColumnInfo(comment="竞赛编号",type="varchar(200)")
    @TableField(value = "jingsai_uuid_number")

    private String jingsaiUuidNumber;


    /**
     * 竞赛照片
     */
    @ColumnInfo(comment="竞赛照片",type="varchar(200)")
    @TableField(value = "jingsai_photo")

    private String jingsaiPhoto;


    /**
     * 竞赛类型
     */
    @ColumnInfo(comment="竞赛类型",type="int(11)")
    @TableField(value = "jingsai_types")

    private Integer jingsaiTypes;


    /**
     * 竞赛热度
     */
    @ColumnInfo(comment="竞赛热度",type="int(11)")
    @TableField(value = "jingsai_clicknum")

    private Integer jingsaiClicknum;


    /**
     * 报名截止时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="报名截止时间",type="timestamp")
    @TableField(value = "baomingjiezhi_time")

    private Date baomingjiezhiTime;


    /**
     * 竞赛内容
     */
    @ColumnInfo(comment="竞赛内容",type="text")
    @TableField(value = "jingsai_content")

    private String jingsaiContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：竞赛名称
	 */
    public String getJingsaiName() {
        return jingsaiName;
    }
    /**
	 * 设置：竞赛名称
	 */

    public void setJingsaiName(String jingsaiName) {
        this.jingsaiName = jingsaiName;
    }
    /**
	 * 获取：竞赛编号
	 */
    public String getJingsaiUuidNumber() {
        return jingsaiUuidNumber;
    }
    /**
	 * 设置：竞赛编号
	 */

    public void setJingsaiUuidNumber(String jingsaiUuidNumber) {
        this.jingsaiUuidNumber = jingsaiUuidNumber;
    }
    /**
	 * 获取：竞赛照片
	 */
    public String getJingsaiPhoto() {
        return jingsaiPhoto;
    }
    /**
	 * 设置：竞赛照片
	 */

    public void setJingsaiPhoto(String jingsaiPhoto) {
        this.jingsaiPhoto = jingsaiPhoto;
    }
    /**
	 * 获取：竞赛类型
	 */
    public Integer getJingsaiTypes() {
        return jingsaiTypes;
    }
    /**
	 * 设置：竞赛类型
	 */

    public void setJingsaiTypes(Integer jingsaiTypes) {
        this.jingsaiTypes = jingsaiTypes;
    }
    /**
	 * 获取：竞赛热度
	 */
    public Integer getJingsaiClicknum() {
        return jingsaiClicknum;
    }
    /**
	 * 设置：竞赛热度
	 */

    public void setJingsaiClicknum(Integer jingsaiClicknum) {
        this.jingsaiClicknum = jingsaiClicknum;
    }
    /**
	 * 获取：报名截止时间
	 */
    public Date getBaomingjiezhiTime() {
        return baomingjiezhiTime;
    }
    /**
	 * 设置：报名截止时间
	 */

    public void setBaomingjiezhiTime(Date baomingjiezhiTime) {
        this.baomingjiezhiTime = baomingjiezhiTime;
    }
    /**
	 * 获取：竞赛内容
	 */
    public String getJingsaiContent() {
        return jingsaiContent;
    }
    /**
	 * 设置：竞赛内容
	 */

    public void setJingsaiContent(String jingsaiContent) {
        this.jingsaiContent = jingsaiContent;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jingsai{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", jingsaiName=" + jingsaiName +
            ", jingsaiUuidNumber=" + jingsaiUuidNumber +
            ", jingsaiPhoto=" + jingsaiPhoto +
            ", jingsaiTypes=" + jingsaiTypes +
            ", jingsaiClicknum=" + jingsaiClicknum +
            ", baomingjiezhiTime=" + DateUtil.convertString(baomingjiezhiTime,"yyyy-MM-dd") +
            ", jingsaiContent=" + jingsaiContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
