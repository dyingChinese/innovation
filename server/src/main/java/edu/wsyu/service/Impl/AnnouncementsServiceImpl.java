package edu.wsyu.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wsyu.entity.dto.Announcements;
import edu.wsyu.service.AnnouncementsService;
import edu.wsyu.mapper.AnnouncementsMapper;
import org.springframework.stereotype.Service;

/**
* @author chineseblack23
* @description 针对表【announcements(公告表)】的数据库操作Service实现
* @createDate 2024-09-16 09:34:43
*/
@Service
public class AnnouncementsServiceImpl extends ServiceImpl<AnnouncementsMapper, Announcements>
    implements AnnouncementsService{

}




