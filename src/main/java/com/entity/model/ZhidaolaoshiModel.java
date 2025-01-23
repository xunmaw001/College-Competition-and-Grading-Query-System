package com.entity.model;

import com.entity.ZhidaolaoshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 指导老师
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhidaolaoshiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 指导老师姓名
     */
    private String zhidaolaoshiName;


    /**
     * 指导老师手机号
     */
    private String zhidaolaoshiPhone;


    /**
     * 指导老师身份证号
     */
    private String zhidaolaoshiIdNumber;


    /**
     * 指导老师头像
     */
    private String zhidaolaoshiPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 指导老师邮箱
     */
    private String zhidaolaoshiEmail;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：指导老师姓名
	 */
    public String getZhidaolaoshiName() {
        return zhidaolaoshiName;
    }


    /**
	 * 设置：指导老师姓名
	 */
    public void setZhidaolaoshiName(String zhidaolaoshiName) {
        this.zhidaolaoshiName = zhidaolaoshiName;
    }
    /**
	 * 获取：指导老师手机号
	 */
    public String getZhidaolaoshiPhone() {
        return zhidaolaoshiPhone;
    }


    /**
	 * 设置：指导老师手机号
	 */
    public void setZhidaolaoshiPhone(String zhidaolaoshiPhone) {
        this.zhidaolaoshiPhone = zhidaolaoshiPhone;
    }
    /**
	 * 获取：指导老师身份证号
	 */
    public String getZhidaolaoshiIdNumber() {
        return zhidaolaoshiIdNumber;
    }


    /**
	 * 设置：指导老师身份证号
	 */
    public void setZhidaolaoshiIdNumber(String zhidaolaoshiIdNumber) {
        this.zhidaolaoshiIdNumber = zhidaolaoshiIdNumber;
    }
    /**
	 * 获取：指导老师头像
	 */
    public String getZhidaolaoshiPhoto() {
        return zhidaolaoshiPhoto;
    }


    /**
	 * 设置：指导老师头像
	 */
    public void setZhidaolaoshiPhoto(String zhidaolaoshiPhoto) {
        this.zhidaolaoshiPhoto = zhidaolaoshiPhoto;
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
	 * 获取：指导老师邮箱
	 */
    public String getZhidaolaoshiEmail() {
        return zhidaolaoshiEmail;
    }


    /**
	 * 设置：指导老师邮箱
	 */
    public void setZhidaolaoshiEmail(String zhidaolaoshiEmail) {
        this.zhidaolaoshiEmail = zhidaolaoshiEmail;
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

    }
