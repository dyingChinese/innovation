package edu.wsyu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import edu.wsyu.entity.dto.Users;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author chineseblack23
 * @description 针对表【users(用户表)】的数据库操作Service
 * @createDate 2024-09-16 09:34:43
 */
@Mapper
public interface UsersService extends IService<Users>, UserDetailsService {


    /**
     * 根据用户ID查询用户信息
     *
     * @param uid 用户ID
     * @return 用户信息
     */
    Users findUserByUID(Long uid);

}
