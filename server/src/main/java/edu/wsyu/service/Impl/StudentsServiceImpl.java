package edu.wsyu.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wsyu.entity.dto.Students;
import edu.wsyu.service.StudentsService;
import edu.wsyu.mapper.StudentsMapper;
import org.springframework.stereotype.Service;

/**
* @author chineseblack23
* @description 针对表【students(学生表)】的数据库操作Service实现
* @createDate 2024-09-16 09:34:43
*/
@Service
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper, Students>
    implements StudentsService{

}




