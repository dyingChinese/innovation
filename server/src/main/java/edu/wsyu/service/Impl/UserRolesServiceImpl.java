package edu.wsyu.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wsyu.entity.dto.UserRoles;
import edu.wsyu.service.UserRolesService;
import edu.wsyu.mapper.UserRolesMapper;
import org.springframework.stereotype.Service;

/**
* @author chineseblack23
* @description 针对表【user_roles】的数据库操作Service实现
* @createDate 2024-09-16 09:34:43
*/
@Service
public class UserRolesServiceImpl extends ServiceImpl<UserRolesMapper, UserRoles>
    implements UserRolesService{

}




