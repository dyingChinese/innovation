package edu.wsyu.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wsyu.entity.dto.Grades;
import edu.wsyu.service.GradesService;
import edu.wsyu.mapper.GradesMapper;
import org.springframework.stereotype.Service;

/**
* @author chineseblack23
* @description 针对表【grades(成绩表)】的数据库操作Service实现
* @createDate 2024-09-16 09:34:43
*/
@Service
public class GradesServiceImpl extends ServiceImpl<GradesMapper, Grades>
    implements GradesService{

}




