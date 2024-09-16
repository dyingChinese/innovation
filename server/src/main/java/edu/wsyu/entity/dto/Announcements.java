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
 * 公告表
 *
 * @TableName announcements
 */
@TableName(value = "announcements")
@Data
public class Announcements implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "aid", type = IdType.AUTO)
    private Long aid;

    /**
     * 公告标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 公告内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 公告状态 0:未发布 1:已发布 2:已撤回 3:已删除 4:已过期 5:草稿 6:置顶 7:审核中
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateAt;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = -5389701271118863911L;
}