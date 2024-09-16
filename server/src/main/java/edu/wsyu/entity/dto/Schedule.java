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
 * 课程表
 * @TableName schedule
 */
@TableName(value ="schedule")
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
    private Date startTime;

    /**
     * 结束时间
     */
    @TableField(value = "end_time")
    private Date endTime;

    /**
     * 教室
     */
    @TableField(value = "classroom")
    private String classroom;

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
    private static final long serialVersionUID = -4933671027711343274L;
}