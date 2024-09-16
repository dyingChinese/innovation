package edu.wsyu.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wsyu.entity.dto.Teachers;
import edu.wsyu.service.TeachersService;
import edu.wsyu.mapper.TeachersMapper;
import org.springframework.stereotype.Service;

/**
* @author chineseblack23
* @description 针对表【teachers(教师表)】的数据库操作Service实现
* @createDate 2024-09-16 09:34:43
*/
@Service
public class TeachersServiceImpl extends ServiceImpl<TeachersMapper, Teachers>
    implements TeachersService{

}




