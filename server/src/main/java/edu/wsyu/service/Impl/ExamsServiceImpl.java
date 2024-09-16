package edu.wsyu.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wsyu.entity.dto.Exams;
import edu.wsyu.service.ExamsService;
import edu.wsyu.mapper.ExamsMapper;
import org.springframework.stereotype.Service;

/**
* @author chineseblack23
* @description 针对表【exams(考试表)】的数据库操作Service实现
* @createDate 2024-09-16 09:34:43
*/
@Service
public class ExamsServiceImpl extends ServiceImpl<ExamsMapper, Exams>
    implements ExamsService{

}




