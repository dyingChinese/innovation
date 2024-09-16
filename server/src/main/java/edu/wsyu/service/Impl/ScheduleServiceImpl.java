package edu.wsyu.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wsyu.entity.dto.Schedule;
import edu.wsyu.service.ScheduleService;
import edu.wsyu.mapper.ScheduleMapper;
import org.springframework.stereotype.Service;

/**
* @author chineseblack23
* @description 针对表【schedule(课程表)】的数据库操作Service实现
* @createDate 2024-09-16 09:34:43
*/
@Service
public class ScheduleServiceImpl extends ServiceImpl<ScheduleMapper, Schedule>
    implements ScheduleService{

}




