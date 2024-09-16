package edu.wsyu.service;

import edu.wsyu.entity.dto.Users;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Mapper;

/**
* @author chineseblack23
* @description 针对表【users(用户表)】的数据库操作Service
* @createDate 2024-09-16 09:34:43
*/
@Mapper
public interface UsersService extends IService<Users> {

}
