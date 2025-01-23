package com.entity.model;

import com.entity.JiaowuchuguanliyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 教务处管理员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiaowuchuguanliyuanModel implements Serializable {
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
     * 教务处管理员姓名
     */
    private String jiaowuchuguanliyuanName;


    /**
     * 教务处管理员手机号
     */
    private String jiaowuchuguanliyuanPhone;


    /**
     * 教务处管理员身份证号
     */
    private String jiaowuchuguanliyuanIdNumber;


    /**
     * 教务处管理员头像
     */
    private String jiaowuchuguanliyuanPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 教务处管理员邮箱
     */
    private String jiaowuchuguanliyuanEmail;


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

    }
