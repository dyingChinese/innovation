package edu.wsyu.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wsyu.entity.dto.Courses;
import edu.wsyu.service.CoursesService;
import edu.wsyu.mapper.CoursesMapper;
import org.springframework.stereotype.Service;

/**
* @author chineseblack23
* @description 针对表【courses(课程表)】的数据库操作Service实现
* @createDate 2024-09-16 09:34:43
*/
@Service
public class CoursesServiceImpl extends ServiceImpl<CoursesMapper, Courses>
    implements CoursesService{

}




