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
 * 事件表
 *
 * @TableName events
 */
@TableName(value = "events")
@Data
public class Events implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "eid", type = IdType.AUTO)
    private Long eid;

    /**
     * 事件标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 事件描述
     */
    @TableField(value = "description")
    private String description;

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
     * 地点
     */
    @TableField(value = "location")
    private String location;

    /**
     * 是否全天事件
     */
    @TableField(value = "all_day")
    private Integer allDay;

    /**
     * 事件状态 0:未开始 1:进行中 2:已结束
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 创建者id（外键，可以是教师或管理员）
     */
    @TableField(value = "created_by")
    private Long createdBy;

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
    private LocalDateTime updateAt;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 6460824575419622059L;
}