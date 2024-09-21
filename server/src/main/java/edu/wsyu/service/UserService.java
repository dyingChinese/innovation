package edu.wsyu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import edu.wsyu.entity.dto.Users;
import org.apache.ibatis.annotations.Mapper;

import edu.wsyu.entity.vo.User;


/**
 * @author chineseblack23
 * @description 针对表【user】的数据库操作Service
 * @createDate 2024-04-19 15:49:59
 */
@Mapper
public interface UserService extends UsersService {

    /**
     * 根据用户名查询用户信息
     *
     * @param currentPage 当前页
     * @param pageSize    每页显示条数
     * @param searchKey   查询关键字
     * @return 用户信息
     */
    IPage<User> selectPageWithFuzzySearch(Integer currentPage, Integer pageSize, String searchKey);

    /**
     * 查询用户列表
     *
     * @param pageNum  当前页
     * @param pageSize 每页显示条数
     * @return 用户列表
     */
    IPage<User> selectUserList(Integer pageNum, Integer pageSize);

    /**
     * 根据用户ID查询用户信息
     *
     * @param uid 用户ID
     * @return 用户信息
     */
    User findUserByUID(Long uid);

    User findUser(QueryWrapper<User> username);
}