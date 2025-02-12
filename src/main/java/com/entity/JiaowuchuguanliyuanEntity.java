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
 * 教务处管理员
 *
 * @author 
 * @email
 */
@TableName("jiaowuchuguanliyuan")
public class JiaowuchuguanliyuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiaowuchuguanliyuanEntity() {

	}

	public JiaowuchuguanliyuanEntity(T t) {
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
     * 教务处管理员姓名
     */
    @ColumnInfo(comment="教务处管理员姓名",type="varchar(200)")
    @TableField(value = "jiaowuchuguanliyuan_name")

    private String jiaowuchuguanliyuanName;


    /**
     * 教务处管理员手机号
     */
    @ColumnInfo(comment="教务处管理员手机号",type="varchar(200)")
    @TableField(value = "jiaowuchuguanliyuan_phone")

    private String jiaowuchuguanliyuanPhone;


    /**
     * 教务处管理员身份证号
     */
    @ColumnInfo(comment="教务处管理员身份证号",type="varchar(200)")
    @TableField(value = "jiaowuchuguanliyuan_id_number")

    private String jiaowuchuguanliyuanIdNumber;


    /**
     * 教务处管理员头像
     */
    @ColumnInfo(comment="教务处管理员头像",type="varchar(200)")
    @TableField(value = "jiaowuchuguanliyuan_photo")

    private String jiaowuchuguanliyuanPhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 教务处管理员邮箱
     */
    @ColumnInfo(comment="教务处管理员邮箱",type="varchar(200)")
    @TableField(value = "jiaowuchuguanliyuan_email")

    private String jiaowuchuguanliyuanEmail;


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
	 * 获取：教务处管理员姓名
	 */
    public String getJiaowuchuguanliyuanName() {
        return jiaowuchuguanliyuanName;
    }
    /**
	 * 设置：教务处管理员姓名
	 */

    public void setJiaowuchuguanliyuanName(String jiaowuchuguanliyuanName) {
        this.jiaowuchuguanliyuanName = jiaowuchuguanliyuanName;
    }
    /**
	 * 获取：教务处管理员手机号
	 */
    public String getJiaowuchuguanliyuanPhone() {
        return jiaowuchuguanliyuanPhone;
    }
    /**
	 * 设置：教务处管理员手机号
	 */

    public void setJiaowuchuguanliyuanPhone(String jiaowuchuguanliyuanPhone) {
        this.jiaowuchuguanliyuanPhone = jiaowuchuguanliyuanPhone;
    }
    /**
	 * 获取：教务处管理员身份证号
	 */
    public String getJiaowuchuguanliyuanIdNumber() {
        return jiaowuchuguanliyuanIdNumber;
    }
    /**
	 * 设置：教务处管理员身份证号
	 */

    public void setJiaowuchuguanliyuanIdNumber(String jiaowuchuguanliyuanIdNumber) {
        this.jiaowuchuguanliyuanIdNumber = jiaowuchuguanliyuanIdNumber;
    }
    /**
	 * 获取：教务处管理员头像
	 */
    public String getJiaowuchuguanliyuanPhoto() {
        return jiaowuchuguanliyuanPhoto;
    }
    /**
	 * 设置：教务处管理员头像
	 */

    public void setJiaowuchuguanliyuanPhoto(String jiaowuchuguanliyuanPhoto) {
        this.jiaowuchuguanliyuanPhoto = jiaowuchuguanliyuanPhoto;
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
	 * 获取：教务处管理员邮箱
	 */
    public String getJiaowuchuguanliyuanEmail() {
        return jiaowuchuguanliyuanEmail;
    }
    /**
	 * 设置：教务处管理员邮箱
	 */

    public void setJiaowuchuguanliyuanEmail(String jiaowuchuguanliyuanEmail) {
        this.jiaowuchuguanliyuanEmail = jiaowuchuguanliyuanEmail;
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
        return "Jiaowuchuguanliyuan{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", jiaowuchuguanliyuanName=" + jiaowuchuguanliyuanName +
            ", jiaowuchuguanliyuanPhone=" + jiaowuchuguanliyuanPhone +
            ", jiaowuchuguanliyuanIdNumber=" + jiaowuchuguanliyuanIdNumber +
            ", jiaowuchuguanliyuanPhoto=" + jiaowuchuguanliyuanPhoto +
            ", sexTypes=" + sexTypes +
            ", jiaowuchuguanliyuanEmail=" + jiaowuchuguanliyuanEmail +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
