package edu.wsyu.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 家庭表
 * @TableName family
 */
@TableName(value ="family")
@Data
public class Family implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "fid", type = IdType.AUTO)
    private Long fid;

    /**
     * 学生id
     */
    @TableField(value = "sid")
    private Long sid;

    /**
     * 家长姓名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 家长电话
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 与学生关系
     */
    @TableField(value = "relationship")
    private String relationship;

    /**
     * 家长邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 家庭住址
     */
    @TableField(value = "address")
    private String address;

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
    private LocalDateTime updateAt;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = -7230616045682083068L;
}