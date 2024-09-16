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
 * 班级表
 * @TableName myclass
 */
@TableName(value ="myclass")
@Data
public class Myclass implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "cid", type = IdType.AUTO)
    private Long cid;

    /**
     * 班级名称
     */
    @TableField(value = "class_name")
    private String className;

    /**
     * 班级代码(如一班,二班)
     */
    @TableField(value = "class_code")
    private String classCode;

    /**
     * 年级
     */
    @TableField(value = "grade")
    private String grade;

    /**
     * 专业
     */
    @TableField(value = "major")
    private String major;

    /**
     * 班级人数
     */
    @TableField(value = "class_size")
    private Integer classSize;

    /**
     * 教师id
     */
    @TableField(value = "tid")
    private Long tid;

    /**
     * 班级描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 学校id
     */
    @TableField(value = "school_id")
    private Long schoolId;

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
    private static final long serialVersionUID = -7569791320530707626L;
}