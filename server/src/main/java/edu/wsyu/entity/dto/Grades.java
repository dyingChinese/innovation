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
 * 成绩表
 * @TableName grades
 */
@TableName(value ="grades")
@Data
public class Grades implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "gid", type = IdType.AUTO)
    private Long gid;

    /**
     * 学生id
     */
    @TableField(value = "sid")
    private Long sid;

    /**
     * 课程id
     */
    @TableField(value = "crid")
    private Long crid;

    /**
     * 成绩
     */
    @TableField(value = "grade")
    private Double grade;

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
    private static final long serialVersionUID = -2985274867446456581L;
}