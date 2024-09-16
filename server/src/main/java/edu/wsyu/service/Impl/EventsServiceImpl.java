package edu.wsyu.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wsyu.entity.dto.Events;
import edu.wsyu.service.EventsService;
import edu.wsyu.mapper.EventsMapper;
import org.springframework.stereotype.Service;

/**
* @author chineseblack23
* @description 针对表【events(事件表)】的数据库操作Service实现
* @createDate 2024-09-16 09:34:43
*/
@Service
public class EventsServiceImpl extends ServiceImpl<EventsMapper, Events>
    implements EventsService{

}




