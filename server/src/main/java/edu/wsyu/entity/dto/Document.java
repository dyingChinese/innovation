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
 * 文件信息
 * @TableName document
 */
@TableName(value ="document")
@Data
public class Document implements Serializable {
    /**
     * 文件id
     */
    @TableId(value = "did", type = IdType.AUTO)
    private Long did;

    /**
     * 用户id|上传者id
     */
    @TableField(value = "uid")
    private Long uid;

    /**
     * 班级id (如果和班级有关)
     */
    @TableField(value = "cid")
    private Long cid;

    /**
     * 教师id (如果和教师有关)
     */
    @TableField(value = "tid")
    private Long tid;

    /**
     * 课程id (如果和课程有关)
     */
    @TableField(value = "crid")
    private Long crid;

    /**
     * 原始文件名
     */
    @TableField(value = "file_name")
    private String fileName;

    /**
     * 文件路径
     */
    @TableField(value = "file_path")
    private String filePath;

    /**
     * 文件类型
     */
    @TableField(value = "file_type")
    private String fileType;

    /**
     * 文件描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 文件大小(单位字节)
     */
    @TableField(value = "file_size")
    private Long fileSize;

    /**
     * 文件状态 0:正常 1:删除 2:禁用
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(value = "create_at")
    private Date createAt;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = -2063504869555824864L;
}