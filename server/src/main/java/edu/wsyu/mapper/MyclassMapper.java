package edu.wsyu.mapper;

import edu.wsyu.entity.dto.Myclass;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author chineseblack23
* @description 针对表【myclass(班级表)】的数据库操作Mapper
* @createDate 2024-09-16 09:34:43
* @Entity edu.wsyu.entity.dto.Myclass
 */
@Mapper
public interface MyclassMapper extends BaseMapper<Myclass> {

}




