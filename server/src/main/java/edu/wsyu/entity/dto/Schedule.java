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
 * 课程表
 *
 * @TableName schedule
 */
@TableName(value = "schedule")
@Data
public class Schedule implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "scdid", type = IdType.AUTO)
    private Long scdid;

    /**
     * 班级id
     */
    @TableField(value = "cid")
    private Long cid;

    /**
     * 教师id
     */
    @TableField(value = "tid")
    private Long tid;

    /**
     * 课程id
     */
    @TableField(value = "crid")
    private Long crid;

    /**
     * 星期几
     */
    @TableField(value = "day_of_week")
    private Integer dayOfWeek;

    /**
     * 开始时间
     */
    @TableField(value = "start_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @TableField(value = "end_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime endTime;

    /**
     * 教室
     */
    @TableField(value = "classroom")
    private String classroom;

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
    private static final long serialVersionUID = -4933671027711343274L;
}