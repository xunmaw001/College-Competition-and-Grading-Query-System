package com.entity.vo;

import com.entity.XuexiaofuzerenEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 学院负责人
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xuexiaofuzeren")
public class XuexiaofuzerenVO implements Serializable {
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
     * 学院负责人姓名
     */

    @TableField(value = "xuexiaofuzeren_name")
    private String xuexiaofuzerenName;


    /**
     * 学院负责人手机号
     */

    @TableField(value = "xuexiaofuzeren_phone")
    private String xuexiaofuzerenPhone;


    /**
     * 学院负责人身份证号
     */

    @TableField(value = "xuexiaofuzeren_id_number")
    private String xuexiaofuzerenIdNumber;


    /**
     * 学院负责人头像
     */

    @TableField(value = "xuexiaofuzeren_photo")
    private String xuexiaofuzerenPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 学院负责人邮箱
     */

    @TableField(value = "xuexiaofuzeren_email")
    private String xuexiaofuzerenEmail;


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
	 * 设置：学院负责人姓名
	 */
    public String getXuexiaofuzerenName() {
        return xuexiaofuzerenName;
    }


    /**
	 * 获取：学院负责人姓名
	 */

    public void setXuexiaofuzerenName(String xuexiaofuzerenName) {
        this.xuexiaofuzerenName = xuexiaofuzerenName;
    }
    /**
	 * 设置：学院负责人手机号
	 */
    public String getXuexiaofuzerenPhone() {
        return xuexiaofuzerenPhone;
    }


    /**
	 * 获取：学院负责人手机号
	 */

    public void setXuexiaofuzerenPhone(String xuexiaofuzerenPhone) {
        this.xuexiaofuzerenPhone = xuexiaofuzerenPhone;
    }
    /**
	 * 设置：学院负责人身份证号
	 */
    public String getXuexiaofuzerenIdNumber() {
        return xuexiaofuzerenIdNumber;
    }


    /**
	 * 获取：学院负责人身份证号
	 */

    public void setXuexiaofuzerenIdNumber(String xuexiaofuzerenIdNumber) {
        this.xuexiaofuzerenIdNumber = xuexiaofuzerenIdNumber;
    }
    /**
	 * 设置：学院负责人头像
	 */
    public String getXuexiaofuzerenPhoto() {
        return xuexiaofuzerenPhoto;
    }


    /**
	 * 获取：学院负责人头像
	 */

    public void setXuexiaofuzerenPhoto(String xuexiaofuzerenPhoto) {
        this.xuexiaofuzerenPhoto = xuexiaofuzerenPhoto;
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
	 * 设置：学院负责人邮箱
	 */
    public String getXuexiaofuzerenEmail() {
        return xuexiaofuzerenEmail;
    }


    /**
	 * 获取：学院负责人邮箱
	 */

    public void setXuexiaofuzerenEmail(String xuexiaofuzerenEmail) {
        this.xuexiaofuzerenEmail = xuexiaofuzerenEmail;
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
