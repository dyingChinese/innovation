package edu.wsyu.entity.vo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.wsyu.entity.dto.Role;
import edu.wsyu.entity.dto.Users;
import edu.wsyu.mapper.RoleMapper;
import edu.wsyu.service.RoleService;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * @TableName user
 */
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends Users implements UserDetails, Serializable {


    @Serial
    private static final long serialVersionUID = -6204823218194972456L;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.getRolesList() == null) {
//            this.setRolesList(roleMapper.selectList(new QueryWrapper<Role>().eq("user_id", this.getUid())));
            this.setRolesList(new ArrayList<>());
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : this.getRolesList()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }


    // 基于Users实例的构造函数
    public User(Users users) {
        // 这里我们假设Users类有一个无参构造函数或者有相应的getter方法
        // 我们使用Users实例的字段来初始化User实例的字段
        super(users.getUid(), users.getUsername(), users.getName(), users.getPassword(), users.getIdCard(), users.getEmail(), users.getAvatar(), users.getAddress(), users.getDescText(), users.getLocked(), users.getEnable(), users.getCreateAt(), users.getUpdateAt(), users.getRolesList());
    }
}
