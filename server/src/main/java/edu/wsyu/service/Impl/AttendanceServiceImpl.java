package edu.wsyu.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wsyu.entity.dto.Attendance;
import edu.wsyu.service.AttendanceService;
import edu.wsyu.mapper.AttendanceMapper;
import org.springframework.stereotype.Service;

/**
* @author chineseblack23
* @description 针对表【attendance(考勤表)】的数据库操作Service实现
* @createDate 2024-09-16 09:34:43
*/
@Service
public class AttendanceServiceImpl extends ServiceImpl<AttendanceMapper, Attendance>
    implements AttendanceService{

}




