package com.entity.vo;

import com.entity.JiaowuchuguanliyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 教务处管理员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiaowuchuguanliyuan")
public class JiaowuchuguanliyuanVO implements Serializable {
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
     * 教务处管理员姓名
     */

    @TableField(value = "jiaowuchuguanliyuan_name")
    private String jiaowuchuguanliyuanName;


    /**
     * 教务处管理员手机号
     */

    @TableField(value = "jiaowuchuguanliyuan_phone")
    private String jiaowuchuguanliyuanPhone;


    /**
     * 教务处管理员身份证号
     */

    @TableField(value = "jiaowuchuguanliyuan_id_number")
    private String jiaowuchuguanliyuanIdNumber;


    /**
     * 教务处管理员头像
     */

    @TableField(value = "jiaowuchuguanliyuan_photo")
    private String jiaowuchuguanliyuanPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 教务处管理员邮箱
     */

    @TableField(value = "jiaowuchuguanliyuan_email")
    private String jiaowuchuguanliyuanEmail;


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
	 * 设置：教务处管理员姓名
	 */
    public String getJiaowuchuguanliyuanName() {
        return jiaowuchuguanliyuanName;
    }


    /**
	 * 获取：教务处管理员姓名
	 */

    public void setJiaowuchuguanliyuanName(String jiaowuchuguanliyuanName) {
        this.jiaowuchuguanliyuanName = jiaowuchuguanliyuanName;
    }
    /**
	 * 设置：教务处管理员手机号
	 */
    public String getJiaowuchuguanliyuanPhone() {
        return jiaowuchuguanliyuanPhone;
    }


    /**
	 * 获取：教务处管理员手机号
	 */

    public void setJiaowuchuguanliyuanPhone(String jiaowuchuguanliyuanPhone) {
        this.jiaowuchuguanliyuanPhone = jiaowuchuguanliyuanPhone;
    }
    /**
	 * 设置：教务处管理员身份证号
	 */
    public String getJiaowuchuguanliyuanIdNumber() {
        return jiaowuchuguanliyuanIdNumber;
    }


    /**
	 * 获取：教务处管理员身份证号
	 */

    public void setJiaowuchuguanliyuanIdNumber(String jiaowuchuguanliyuanIdNumber) {
        this.jiaowuchuguanliyuanIdNumber = jiaowuchuguanliyuanIdNumber;
    }
    /**
	 * 设置：教务处管理员头像
	 */
    public String getJiaowuchuguanliyuanPhoto() {
        return jiaowuchuguanliyuanPhoto;
    }


    /**
	 * 获取：教务处管理员头像
	 */

    public void setJiaowuchuguanliyuanPhoto(String jiaowuchuguanliyuanPhoto) {
        this.jiaowuchuguanliyuanPhoto = jiaowuchuguanliyuanPhoto;
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
	 * 设置：教务处管理员邮箱
	 */
    public String getJiaowuchuguanliyuanEmail() {
        return jiaowuchuguanliyuanEmail;
    }


    /**
	 * 获取：教务处管理员邮箱
	 */

    public void setJiaowuchuguanliyuanEmail(String jiaowuchuguanliyuanEmail) {
        this.jiaowuchuguanliyuanEmail = jiaowuchuguanliyuanEmail;
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
