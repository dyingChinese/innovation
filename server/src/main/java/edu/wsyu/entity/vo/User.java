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


    private List<Role> roles;

    @Serial
    private static final long serialVersionUID = -6204823218194972456L;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.roles == null) {
//            roleMapper.().forEach(role -> {
//                if (role.getUserId().equals(this.getId())) {
//                    roles.add(role);
//                }
//            }                                          );
//            this.roles = roleMapper.selectList(new QueryWrapper<Role>().eq("user_id", this.getUid()));
        } ;
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : this.roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

}
