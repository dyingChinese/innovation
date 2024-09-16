package edu.wsyu.mapper;

import edu.wsyu.entity.dto.Students;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author chineseblack23
* @description 针对表【students(学生表)】的数据库操作Mapper
* @createDate 2024-09-16 09:34:43
* @Entity edu.wsyu.entity.dto.Students
 */
@Mapper
public interface StudentsMapper extends BaseMapper<Students> {

}




