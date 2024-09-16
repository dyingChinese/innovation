package edu.wsyu.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 体检报告表
 * @TableName physical_examination_report
 */
@TableName(value ="physical_examination_report")
@Data
public class PhysicalExaminationReport implements Serializable {
    /**
     * 体检报告ID
     */
    @TableId(value = "report_id", type = IdType.AUTO)
    private Long reportId;

    /**
     * 受检者姓名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 性别 (M/F)
     */
    @TableField(value = "gender")
    private String gender;

    /**
     * 年龄
     */
    @TableField(value = "age")
    private Integer age;

    /**
     * 身份证号
     */
    @TableField(value = "id_card")
    private String idCard;

    /**
     * 联系电话
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 家庭住址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 工作单位
     */
    @TableField(value = "work_place")
    private String workPlace;

    /**
     * 体检日期
     */
    @TableField(value = "date")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate date;

    /**
     * 身高 (厘米)
     */
    @TableField(value = "height")
    private BigDecimal height;

    /**
     * 体重 (千克)
     */
    @TableField(value = "weight")
    private BigDecimal weight;

    /**
     * 收缩压
     */
    @TableField(value = "systolic_BP")
    private Integer systolicBP;

    /**
     * 舒张压
     */
    @TableField(value = "diastolic_BP")
    private Integer diastolicBP;

    /**
     * 心率
     */
    @TableField(value = "heart_rate")
    private Integer heartRate;

    /**
     * 体温 (摄氏度)
     */
    @TableField(value = "temperature")
    private BigDecimal temperature;

    /**
     * 白细胞计数 (WBC)
     */
    @TableField(value = "WBC")
    private Integer WBC;

    /**
     * 红细胞计数 (RBC)
     */
    @TableField(value = "RBC")
    private Integer RBC;

    /**
     * 血红蛋白 (HGB)
     */
    @TableField(value = "HGB")
    private BigDecimal HGB;

    /**
     * 血小板计数 (PLT)
     */
    @TableField(value = "PLT")
    private Integer PLT;

    /**
     * 血型 (ABO/Rh)
     */
    @TableField(value = "blood_type")
    private String bloodType;

    /**
     * 总胆固醇 (CHOL)
     */
    @TableField(value = "CHOL")
    private BigDecimal CHOL;

    /**
     * 甘油三酯 (TG)
     */
    @TableField(value = "TG")
    private BigDecimal TG;

    /**
     * 高密度脂蛋白胆固醇 (HDL-C)
     */
    @TableField(value = "HDL_C")
    private BigDecimal HDLC;

    /**
     * 低密度脂蛋白胆固醇 (LDL-C)
     */
    @TableField(value = "LDL_C")
    private BigDecimal LDLC;

    /**
     * 血糖 (GLU)
     */
    @TableField(value = "GLU")
    private BigDecimal GLU;

    /**
     * 肝功能 - 谷丙转氨酶 (ALT)
     */
    @TableField(value = "ALT")
    private BigDecimal ALT;

    /**
     * 肝功能 - 谷草转氨酶 (AST)
     */
    @TableField(value = "AST")
    private BigDecimal AST;

    /**
     * 肾功能 - 肌酐 (CREA)
     */
    @TableField(value = "CREA")
    private BigDecimal CREA;

    /**
     * 肾功能 - 尿素 (UREA)
     */
    @TableField(value = "UREA")
    private BigDecimal UREA;

    /**
     * 肾功能 - 血尿素氮 (BUN)
     */
    @TableField(value = "BUN")
    private BigDecimal BUN;

    /**
     * 尿蛋白
     */
    @TableField(value = "urine_protein")
    private String urineProtein;

    /**
     * 尿糖
     */
    @TableField(value = "urine_glucose")
    private String urineGlucose;

    /**
     * 尿酮体
     */
    @TableField(value = "urine_ketones")
    private String urineKetones;

    /**
     * 尿潜血
     */
    @TableField(value = "urine_occult_blood")
    private String urineOccultBlood;

    /**
     * 尿白细胞
     */
    @TableField(value = "urine_WBC")
    private String urineWBC;

    /**
     * 胸部X光
     */
    @TableField(value = "chest_x_ray")
    private String chestXRay;

    /**
     * B超 (肝、胆、胰、脾、肾等)
     */
    @TableField(value = "ultrasound")
    private String ultrasound;

    /**
     * 心电图 (ECG)
     */
    @TableField(value = "ECG")
    private String ECG;

    /**
     * 心脏检查
     */
    @TableField(value = "heart")
    private String heart;

    /**
     * 肺部检查
     */
    @TableField(value = "lung")
    private String lung;

    /**
     * 腹部检查
     */
    @TableField(value = "abdomen")
    private String abdomen;

    /**
     * 脑血管检查
     */
    @TableField(value = "cerebralVessels")
    private String cerebralVessels;

    /**
     * 皮肤检查
     */
    @TableField(value = "skin")
    private String skin;

    /**
     * 淋巴结检查
     */
    @TableField(value = "lymph_nodes")
    private String lymphNodes;

    /**
     * 肌肉骨骼检查
     */
    @TableField(value = "musculo_skeletal")
    private String musculoSkeletal;

    /**
     * 神经系统检查
     */
    @TableField(value = "nervous_system")
    private String nervousSystem;

    /**
     * 乳腺检查
     */
    @TableField(value = "breast")
    private String breast;

    /**
     * 宫颈涂片 (Pap smear)
     */
    @TableField(value = "pap_smear")
    private String papSmear;

    /**
     * 视力检查
     */
    @TableField(value = "vision")
    private String vision;

    /**
     * 结膜检查
     */
    @TableField(value = "conjunctiva")
    private String conjunctiva;

    /**
     * 角膜检查
     */
    @TableField(value = "cornea")
    private String cornea;

    /**
     * 瞳孔检查
     */
    @TableField(value = "pupil")
    private String pupil;

    /**
     * 晶状体检查
     */
    @TableField(value = "lens")
    private String lens;

    /**
     * 听力检查
     */
    @TableField(value = "hearing")
    private String hearing;

    /**
     * 鼻检查
     */
    @TableField(value = "nose")
    private String nose;

    /**
     * 喉检查
     */
    @TableField(value = "throat")
    private String throat;

    /**
     * 牙齿检查
     */
    @TableField(value = "teeth")
    private String teeth;

    /**
     * 口腔黏膜检查
     */
    @TableField(value = "oralMucosa")
    private String oralMucosa;

    /**
     * 体检结论
     */
    @TableField(value = "examinationConclusion")
    private String examinationConclusion;

    /**
     * 健康指导
     */
    @TableField(value = "healthGuidance")
    private String healthGuidance;

    /**
     * 医生建议
     */
    @TableField(value = "doctorsAdvice")
    private String doctorsAdvice;

    /**
     * 下次体检建议
     */
    @TableField(value = "nextExaminationRecommendation")
    private String nextExaminationRecommendation;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 9128638569298783818L;
}