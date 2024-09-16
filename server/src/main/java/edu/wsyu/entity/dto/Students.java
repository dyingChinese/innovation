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
 * 学生表
 * @TableName students
 */
@TableName(value ="students")
@Data
public class Students implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "sid", type = IdType.AUTO)
    private Long sid;

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
     * 班级id
     */
    @TableField(value = "cid")
    private Long cid;

    /**
     * 入学日期
     */
    @TableField(value = "admission_date")
    private Date admissionDate;

    /**
     * 学生状态 0:在读 1:休学 2:退学 3:毕业 4:其他
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
    private static final long serialVersionUID = 2207931180775353201L;
}