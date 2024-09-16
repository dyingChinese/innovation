package edu.wsyu.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 考勤表
 *
 * @TableName attendance
 */
@TableName(value = "attendance")
@Data
public class Attendance implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "aid", type = IdType.AUTO)
    private Long aid;

    /**
     * 学生id
     */
    @TableField(value = "sid")
    private Long sid;

    /**
     * 班级id
     */
    @TableField(value = "cid")
    private Long cid;

    /**
     * 考勤日期
     */
    @TableField(value = "attendance_date")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate attendanceDate;

    /**
     * 考勤状态 0:正常 1:迟到 2:早退 3:旷课 4:请假
     */
    @TableField(value = "attendance_status")
    private Integer attendanceStatus;

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
    private static final long serialVersionUID = 2181402111086733735L;
}