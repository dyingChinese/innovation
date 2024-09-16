package edu.wsyu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Mapper;

import edu.wsyu.entity.vo.User;


/**
 * @author chineseblack23
 * @description 针对表【user】的数据库操作Service
 * @createDate 2024-04-19 15:49:59
 */
@Mapper
public interface UserService extends IService<User> {
    User findUser(QueryWrapper<User> queryWrapper);


}