package edu.wsyu.mapper;

import edu.wsyu.entity.dto.Events;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author chineseblack23
* @description 针对表【events(事件表)】的数据库操作Mapper
* @createDate 2024-09-16 09:34:43
* @Entity edu.wsyu.entity.dto.Events
 */
@Mapper
public interface EventsMapper extends BaseMapper<Events> {

}




