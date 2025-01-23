package com.entity.model;

import com.entity.XuexiaofuzerenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 学院负责人
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XuexiaofuzerenModel implements Serializable {
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
     * 学院负责人姓名
     */
    private String xuexiaofuzerenName;


    /**
     * 学院负责人手机号
     */
    private String xuexiaofuzerenPhone;


    /**
     * 学院负责人身份证号
     */
    private String xuexiaofuzerenIdNumber;


    /**
     * 学院负责人头像
     */
    private String xuexiaofuzerenPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 学院负责人邮箱
     */
    private String xuexiaofuzerenEmail;


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

    }
