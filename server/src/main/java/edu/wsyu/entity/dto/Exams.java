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
 * 考试表
 * @TableName exams
 */
@TableName(value ="exams")
@Data
public class Exams implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "eid", type = IdType.AUTO)
    private Long eid;

    /**
     * 课程id
     */
    @TableField(value = "crid")
    private Long crid;

    /**
     * 班级id
     */
    @TableField(value = "cid")
    private Long cid;

    /**
     * 考试标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 考试描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 开始时间
     */
    @TableField(value = "start_time")
    private Date startTime;

    /**
     * 结束时间
     */
    @TableField(value = "end_time")
    private Date endTime;

    /**
     * 考试时长（分钟）
     */
    @TableField(value = "duration")
    private Integer duration;

    /**
     * 考试状态 0:未开始 1:进行中 2:已结束 3:已发布 4:已撤回 5:已删除 6:已过期 7:草稿 8:审核中
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 创建者id（外键，可以是教师或管理员）
     */
    @TableField(value = "created_by")
    private Long createdBy;

    /**
     * 教室
     */
    @TableField(value = "classroom")
    private String classroom;

    /**
     * 监考人id
     */
    @TableField(value = "invigilator_id")
    private Long invigilatorId;

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
    private static final long serialVersionUID = 636627866602104885L;
}