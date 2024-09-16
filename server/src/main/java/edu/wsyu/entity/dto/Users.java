package edu.wsyu.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import mybatis.mate.annotation.FieldSensitive;
import mybatis.mate.strategy.SensitiveType;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户表
 *
 * @TableName users
 */
@TableName(value = "users")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Users implements Serializable {


    /**
     * 主键id
     */
    @TableId(value = "uid", type = IdType.AUTO)
    private Long uid;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 姓名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 密码
     */
    @TableField(value = "password")
    @FieldSensitive(SensitiveType.password)
    private String password;

    /**
     * 身份证号
     */
    @TableField(value = "id_card")
    @FieldSensitive(SensitiveType.idCard)
    private String idCard;

    /**
     * 电子邮件
     */
    @TableField(value = "email")
    @FieldSensitive(SensitiveType.email)
    private String email;


    /**
     * 默认头像
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 地址
     */
    @TableField(value = "address")
    @FieldSensitive(SensitiveType.address)
    private String address;

    /**
     * 个人描述
     */
    @TableField(value = "desc_text")
    private String descText;

    /**
     * 是否封禁
     */
    @TableField(value = "locked")
    private Boolean locked;

    /**
     * 是否启用
     */
    @TableField(value = "enable")
    @JsonIgnore
    private Boolean enable;

    /**
     * 创建时间
     */
    @TableField(value = "create_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createAt;

    /**
     * 更新时间
     */
    @TableField(value = "update_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonIgnore
    private LocalDateTime updateAt;

    /**
     * 角色
     */
    @TableField(exist = false, typeHandler = JacksonTypeHandler.class)
    private List<Role> rolesList;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 2057830635288482988L;
}