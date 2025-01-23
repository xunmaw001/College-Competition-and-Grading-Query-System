package com.entity.vo;

import com.entity.ZhidaolaoshiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 指导老师
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhidaolaoshi")
public class ZhidaolaoshiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 指导老师姓名
     */

    @TableField(value = "zhidaolaoshi_name")
    private String zhidaolaoshiName;


    /**
     * 指导老师手机号
     */

    @TableField(value = "zhidaolaoshi_phone")
    private String zhidaolaoshiPhone;


    /**
     * 指导老师身份证号
     */

    @TableField(value = "zhidaolaoshi_id_number")
    private String zhidaolaoshiIdNumber;


    /**
     * 指导老师头像
     */

    @TableField(value = "zhidaolaoshi_photo")
    private String zhidaolaoshiPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 指导老师邮箱
     */

    @TableField(value = "zhidaolaoshi_email")
    private String zhidaolaoshiEmail;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：指导老师姓名
	 */
    public String getZhidaolaoshiName() {
        return zhidaolaoshiName;
    }


    /**
	 * 获取：指导老师姓名
	 */

    public void setZhidaolaoshiName(String zhidaolaoshiName) {
        this.zhidaolaoshiName = zhidaolaoshiName;
    }
    /**
	 * 设置：指导老师手机号
	 */
    public String getZhidaolaoshiPhone() {
        return zhidaolaoshiPhone;
    }


    /**
	 * 获取：指导老师手机号
	 */

    public void setZhidaolaoshiPhone(String zhidaolaoshiPhone) {
        this.zhidaolaoshiPhone = zhidaolaoshiPhone;
    }
    /**
	 * 设置：指导老师身份证号
	 */
    public String getZhidaolaoshiIdNumber() {
        return zhidaolaoshiIdNumber;
    }


    /**
	 * 获取：指导老师身份证号
	 */

    public void setZhidaolaoshiIdNumber(String zhidaolaoshiIdNumber) {
        this.zhidaolaoshiIdNumber = zhidaolaoshiIdNumber;
    }
    /**
	 * 设置：指导老师头像
	 */
    public String getZhidaolaoshiPhoto() {
        return zhidaolaoshiPhoto;
    }


    /**
	 * 获取：指导老师头像
	 */

    public void setZhidaolaoshiPhoto(String zhidaolaoshiPhoto) {
        this.zhidaolaoshiPhoto = zhidaolaoshiPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：指导老师邮箱
	 */
    public String getZhidaolaoshiEmail() {
        return zhidaolaoshiEmail;
    }


    /**
	 * 获取：指导老师邮箱
	 */

    public void setZhidaolaoshiEmail(String zhidaolaoshiEmail) {
        this.zhidaolaoshiEmail = zhidaolaoshiEmail;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
