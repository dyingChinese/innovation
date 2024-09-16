package edu.wsyu.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wsyu.entity.dto.Role;
import edu.wsyu.service.RoleService;
import edu.wsyu.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author chineseblack23
* @description 针对表【role(角色表)】的数据库操作Service实现
* @createDate 2024-09-16 09:34:43
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




