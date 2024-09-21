package edu.wsyu.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wsyu.entity.dto.Role;
import edu.wsyu.entity.dto.Users;
import edu.wsyu.entity.vo.User;
import edu.wsyu.mapper.UsersMapper;
import edu.wsyu.service.UserService;
import edu.wsyu.util.SQLUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chineseblack23
 * @description 针对表【users(用户表)】的数据库操作Service实现
 * @createDate 2024-09-16 09:34:43
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UsersMapper, Users> implements UserService {
    private final UsersMapper userMapper;
    private final SQLUtils sqlUtils;

    public UserServiceImpl(UsersMapper usersMapper, SQLUtils sqlUtils) {
        this.userMapper = usersMapper;
        this.sqlUtils = sqlUtils;
    }

    @Override
    public IPage<User> selectPageWithFuzzySearch(Integer currentPage, Integer pageSize, String searchKey) {
        Page<Users> pages = new Page<>(currentPage, pageSize);
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        if (searchKey == null || searchKey.isEmpty()) {
            return this.selectPageUserList(currentPage, pageSize);
        }
        searchKey = searchKey.trim();
        if (searchKey.matches("[0-9]+")) {
            queryWrapper.or().eq("uid", Long.parseLong(searchKey));
        }
        if (searchKey.matches("[0-9]+")) {
            queryWrapper.or().eq("phone", searchKey);
        }
        if (searchKey.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")) {
            queryWrapper.or().eq("email", searchKey);
        }
        if (searchKey.matches("^[0-9]{17}[0-9X]$")) {
            queryWrapper.or().eq("id_card", searchKey);
        }

        sqlUtils.fillFieldByFuzzy(searchKey, queryWrapper, Users.class, "username", "name", "address", "desc_text");

        IPage<Users> page = userMapper.selectPage(pages, queryWrapper);
        return this.convertToUser(page);
    }

    @Override
    public IPage<User> selectPageUserList(Integer currentPage, Integer pageSize) {
        Page<Users> pages = new Page<>(currentPage, pageSize);
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        IPage<Users> page = userMapper.selectPage(pages, queryWrapper);
        return this.convertToUser(page);
    }

    @Override
    public User findUserByUID(Long uid) {
        Users findUser = userMapper.findUserByUID(uid);
        return this.convertToUser(findUser);
    }

    @Override
    public User findUser(QueryWrapper<User> queryWrapper) {
        User one = this.convertToUser(userMapper.selectOne(this.convertToUsersALLEq(queryWrapper)));
        System.out.println(one);
        return one;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        User user = (User) userMapper.selectOne(wrapper);
        if (user == null) {
            log.error("访问失败: username = {} 不存在", username);
            throw new UsernameNotFoundException(username + "用户不存在");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.isEnabled(),
                user.isAccountNonExpired(),
                user.isCredentialsNonExpired(),
                user.isAccountNonLocked(),
                getAuthorities(user)
        );
    }

    private User convertToUser(Users user) {
        if (user instanceof User) {
            return (User) user;
        }
        return new User(user);
    }

    private IPage<User> convertToUser(IPage<Users> page) {
        Page<User> userPage = new Page<>(page.getCurrent(), page.getSize());
        // 将 Users 的 IPage 转换为 User 的 IPage
        List<User> userList = page.getRecords().stream()
                .map(user -> (User) user) // 这里假设 Users 的实例可以被安全地强制转换为 User
                .collect(Collectors.toList());
        userPage.setRecords(userList);
        userPage.setTotal(page.getTotal()); // 复制总数
        userPage.setSize(page.getSize()); // 复制页大小
        userPage.setCurrent(page.getCurrent()); // 复制当前页码
        return userPage;
    }

    private QueryWrapper<Users> convertToUsersALLEq(QueryWrapper<User> userQueryWrapper) {
        Map<String, Object> paramNameValuePairs = userQueryWrapper.getParamNameValuePairs();
        // 创建一个新的 QueryWrapper<Users> 实例
        QueryWrapper<Users> usersQueryWrapper = new QueryWrapper<>();
        // 复制条件（这取决于你如何设置条件，以下是一个简单的例子）
        paramNameValuePairs.forEach(usersQueryWrapper::eq);
        return usersQueryWrapper;
    }

    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : user.getRolesList()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }
}
