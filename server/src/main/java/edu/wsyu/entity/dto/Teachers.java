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
 * 教师表
 * @TableName teachers
 */
@TableName(value ="teachers")
@Data
public class Teachers implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "tid", type = IdType.AUTO)
    private Long tid;

    /**
     * 性别
     */
    @TableField(value = "gender")
    private Integer gender;

    /**
     * 年龄
     */
    @TableField(value = "age")
    private Integer age;

    /**
     * 职称
     */
    @TableField(value = "title")
    private String title;

    /**
     * 部门
     */
    @TableField(value = "department")
    private String department;

    /**
     * 入职日期
     */
    @TableField(value = "hire_date")
    private Date hireDate;

    /**
     * 教师状态 0:在职 1:离职 2:退休 3:其他
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 用户id
     */
    @TableField(value = "uid")
    private Long uid;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 8382737207066769837L;
}