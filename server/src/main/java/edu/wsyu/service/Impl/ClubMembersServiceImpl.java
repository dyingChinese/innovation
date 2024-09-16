package edu.wsyu.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wsyu.entity.dto.ClubMembers;
import edu.wsyu.service.ClubMembersService;
import edu.wsyu.mapper.ClubMembersMapper;
import org.springframework.stereotype.Service;

/**
* @author chineseblack23
* @description 针对表【club_members(社团成员表)】的数据库操作Service实现
* @createDate 2024-09-16 09:34:43
*/
@Service
public class ClubMembersServiceImpl extends ServiceImpl<ClubMembersMapper, ClubMembers>
    implements ClubMembersService{

}




