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
 * 系统日志表
 * @TableName system_logs
 */
@TableName(value ="system_logs")
@Data
public class SystemLogs implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "lid", type = IdType.AUTO)
    private Long lid;

    /**
     * 用户id
     */
    @TableField(value = "uid")
    private Long uid;

    /**
     * ip地址
     */
    @TableField(value = "ip")
    private String ip;

    /**
     * 模块
     */
    @TableField(value = "module")
    private String module;

    /**
     * 操作
     */
    @TableField(value = "action")
    private String action;

    /**
     * 内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 状态 0:失败 1:成功
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 操作时间
     */
    @TableField(value = "create_at")
    private Date createAt;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 6562021603020196018L;
}