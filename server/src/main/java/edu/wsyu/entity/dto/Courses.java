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
 * @TableName courses
 */
@TableName(value ="courses")
@Data
public class Courses implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "crid", type = IdType.AUTO)
    private Long crid;

    /**
     * 课程名称
     */
    @TableField(value = "course_name")
    private String courseName;

    /**
     * 课程代码
     */
    @TableField(value = "course_code")
    private String courseCode;

    /**
     * 学分
     */
    @TableField(value = "credit")
    private Integer credit;

    /**
     * 课程描述
     */
    @TableField(value = "description")
    private String description;

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
    private static final long serialVersionUID = 101916940657622697L;
}