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
 * 社团表
 * @TableName clubs
 */
@TableName(value ="clubs")
@Data
public class Clubs implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "clid", type = IdType.AUTO)
    private Long clid;

    /**
     * 社团名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 指导老师id
     */
    @TableField(value = "supervisor_id")
    private Long supervisorId;

    /**
     * 社团描述
     */
    @TableField(value = "description")
    private String description;

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
    private static final long serialVersionUID = -2160092313200150104L;
}