package edu.wsyu.mapper;

import edu.wsyu.entity.dto.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author chineseblack23
* @description 针对表【users(用户表)】的数据库操作Mapper
* @createDate 2024-09-16 09:34:43
* @Entity edu.wsyu.entity.dto.Users
*/
@Mapper
public interface UsersMapper extends BaseMapper<Users> {

    List<Users> selectRolesByUID(@Param("uid") Long uid);

}




