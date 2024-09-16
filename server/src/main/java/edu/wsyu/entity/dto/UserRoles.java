package edu.wsyu.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName user_roles
 */
@TableName(value ="user_roles")
@Data
public class UserRoles implements Serializable {
    /**
     * 外键用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 外键角色id
     */
    @TableField(value = "role_id")
    private Long roleId;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = -2706503363002251432L;
}