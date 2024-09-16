package edu.wsyu.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 违纪表
 * @TableName disciplinary
 */
@TableName(value ="disciplinary")
@Data
public class Disciplinary implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "did", type = IdType.AUTO)
    private Long did;

    /**
     * 学生id|违纪学生id|如果存在
     */
    @TableField(value = "sid")
    private Long sid;

    /**
     * 班级id | 违纪班级id|如果存在
     */
    @TableField(value = "cid")
    private Long cid;

    /**
     * 教师id | 违纪教师id|如果存在
     */
    @TableField(value = "tid")
    private Long tid;

    /**
     * 违纪原因
     */
    @TableField(value = "reason")
    private String reason;

    /**
     * 处罚措施
     */
    @TableField(value = "punishment")
    private String punishment;

    /**
     * 创建时间
     */
    @TableField(value = "create_at")
    private Date createAt;

    /**
     * 更新时间
     */
    @TableField(value = "update_at")
    private Date updateAt;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = -2951437475401505802L;
}