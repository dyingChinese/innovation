package edu.wsyu.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wsyu.entity.dto.Clubs;
import edu.wsyu.service.ClubsService;
import edu.wsyu.mapper.ClubsMapper;
import org.springframework.stereotype.Service;

/**
* @author chineseblack23
* @description 针对表【clubs(社团表)】的数据库操作Service实现
* @createDate 2024-09-16 09:34:43
*/
@Service
public class ClubsServiceImpl extends ServiceImpl<ClubsMapper, Clubs>
    implements ClubsService{

}




