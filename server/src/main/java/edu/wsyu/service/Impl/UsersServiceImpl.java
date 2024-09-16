package edu.wsyu.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wsyu.entity.dto.Users;
import edu.wsyu.service.UsersService;
import edu.wsyu.mapper.UsersMapper;
import org.springframework.stereotype.Service;

/**
* @author chineseblack23
* @description 针对表【users(用户表)】的数据库操作Service实现
* @createDate 2024-09-16 09:34:43
*/
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
    implements UsersService{

}




