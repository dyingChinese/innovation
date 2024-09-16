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
 * 社团成员表
 * @TableName club_members
 */
@TableName(value ="club_members")
@Data
public class ClubMembers implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "cmid", type = IdType.AUTO)
    private Long cmid;

    /**
     * 社团id
     */
    @TableField(value = "clid")
    private Long clid;

    /**
     * 学生id
     */
    @TableField(value = "sid")
    private Long sid;

    /**
     * 职位|角色
     */
    @TableField(value = "role")
    private String role;

    /**
     * 状态 0:正常 1:已退出
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 加入日期
     */
    @TableField(value = "join_date")
    private Date joinDate;

    /**
     * 退出日期
     */
    @TableField(value = "end_date")
    private Date endDate;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1388349323903078696L;
}