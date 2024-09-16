package edu.wsyu.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wsyu.entity.dto.Users;
import edu.wsyu.entity.vo.User;
import edu.wsyu.mapper.UsersMapper;
import edu.wsyu.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author chineseblack23
 * @description 针对表【users(用户表)】的数据库操作Service实现
 * @createDate 2024-09-16 09:34:43
 */
@Service
public class UserServiceImpl extends ServiceImpl<UsersMapper, Users> implements UserService {
    private final UsersMapper userMapper;

    public UserServiceImpl(UsersMapper usersMapper) {
        this.userMapper = usersMapper;
    }

    @Override
    public IPage<User> selectPageWithFuzzySearch(Integer currentPage, Integer pageSize, String searchKey) {
        return null;
    }

    @Override
    public IPage<User> selectUserList(Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public User findUserByUID(Long uid) {
        Users findUser = userMapper.findUserByUID(uid);
        return new User(findUser);
    }

    @Override
    public User findUser(QueryWrapper<User> username) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
