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
 * 学院负责人
 *
 * @author 
 * @email
 */
@TableName("xuexiaofuzeren")
public class XuexiaofuzerenEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XuexiaofuzerenEntity() {

	}

	public XuexiaofuzerenEntity(T t) {
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
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 学院负责人姓名
     */
    @ColumnInfo(comment="学院负责人姓名",type="varchar(200)")
    @TableField(value = "xuexiaofuzeren_name")

    private String xuexiaofuzerenName;


    /**
     * 学院负责人手机号
     */
    @ColumnInfo(comment="学院负责人手机号",type="varchar(200)")
    @TableField(value = "xuexiaofuzeren_phone")

    private String xuexiaofuzerenPhone;


    /**
     * 学院负责人身份证号
     */
    @ColumnInfo(comment="学院负责人身份证号",type="varchar(200)")
    @TableField(value = "xuexiaofuzeren_id_number")

    private String xuexiaofuzerenIdNumber;


    /**
     * 学院负责人头像
     */
    @ColumnInfo(comment="学院负责人头像",type="varchar(200)")
    @TableField(value = "xuexiaofuzeren_photo")

    private String xuexiaofuzerenPhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 学院负责人邮箱
     */
    @ColumnInfo(comment="学院负责人邮箱",type="varchar(200)")
    @TableField(value = "xuexiaofuzeren_email")

    private String xuexiaofuzerenEmail;


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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 设置：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 设置：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：学院负责人姓名
	 */
    public String getXuexiaofuzerenName() {
        return xuexiaofuzerenName;
    }
    /**
	 * 设置：学院负责人姓名
	 */

    public void setXuexiaofuzerenName(String xuexiaofuzerenName) {
        this.xuexiaofuzerenName = xuexiaofuzerenName;
    }
    /**
	 * 获取：学院负责人手机号
	 */
    public String getXuexiaofuzerenPhone() {
        return xuexiaofuzerenPhone;
    }
    /**
	 * 设置：学院负责人手机号
	 */

    public void setXuexiaofuzerenPhone(String xuexiaofuzerenPhone) {
        this.xuexiaofuzerenPhone = xuexiaofuzerenPhone;
    }
    /**
	 * 获取：学院负责人身份证号
	 */
    public String getXuexiaofuzerenIdNumber() {
        return xuexiaofuzerenIdNumber;
    }
    /**
	 * 设置：学院负责人身份证号
	 */

    public void setXuexiaofuzerenIdNumber(String xuexiaofuzerenIdNumber) {
        this.xuexiaofuzerenIdNumber = xuexiaofuzerenIdNumber;
    }
    /**
	 * 获取：学院负责人头像
	 */
    public String getXuexiaofuzerenPhoto() {
        return xuexiaofuzerenPhoto;
    }
    /**
	 * 设置：学院负责人头像
	 */

    public void setXuexiaofuzerenPhoto(String xuexiaofuzerenPhoto) {
        this.xuexiaofuzerenPhoto = xuexiaofuzerenPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 设置：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：学院负责人邮箱
	 */
    public String getXuexiaofuzerenEmail() {
        return xuexiaofuzerenEmail;
    }
    /**
	 * 设置：学院负责人邮箱
	 */

    public void setXuexiaofuzerenEmail(String xuexiaofuzerenEmail) {
        this.xuexiaofuzerenEmail = xuexiaofuzerenEmail;
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
        return "Xuexiaofuzeren{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", xuexiaofuzerenName=" + xuexiaofuzerenName +
            ", xuexiaofuzerenPhone=" + xuexiaofuzerenPhone +
            ", xuexiaofuzerenIdNumber=" + xuexiaofuzerenIdNumber +
            ", xuexiaofuzerenPhoto=" + xuexiaofuzerenPhoto +
            ", sexTypes=" + sexTypes +
            ", xuexiaofuzerenEmail=" + xuexiaofuzerenEmail +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
