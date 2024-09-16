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
 * 健康表
 * @TableName healthes
 */
@TableName(value ="healthes")
@Data
public class Healthes implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "hid", type = IdType.AUTO)
    private Long hid;

    /**
     * 用户id
     */
    @TableField(value = "uid")
    private Long uid;

    /**
     * 体检报告id
     */
    @TableField(value = "report_id")
    private Long reportId;

    /**
     * 体温
     */
    @TableField(value = "temperature")
    private Double temperature;

    /**
     * 症状
     */
    @TableField(value = "symptom")
    private String symptom;

    /**
     * 身高
     */
    @TableField(value = "height")
    private Double height;

    /**
     * 体重
     */
    @TableField(value = "weight")
    private Double weight;

    /**
     * 血压
     */
    @TableField(value = "blood_pressure")
    private String bloodPressure;

    /**
     * 日期
     */
    @TableField(value = "date")
    private Date date;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 状态 0:正常 1:异常
     */
    @TableField(value = "status")
    private Integer status;

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
    private static final long serialVersionUID = 6361501264121540474L;
}