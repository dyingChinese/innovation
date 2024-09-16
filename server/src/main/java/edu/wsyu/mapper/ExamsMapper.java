package edu.wsyu.mapper;

import edu.wsyu.entity.dto.Exams;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author chineseblack23
* @description 针对表【exams(考试表)】的数据库操作Mapper
* @createDate 2024-09-16 09:34:43
* @Entity edu.wsyu.entity.dto.Exams
 */
@Mapper
public interface ExamsMapper extends BaseMapper<Exams> {

}




