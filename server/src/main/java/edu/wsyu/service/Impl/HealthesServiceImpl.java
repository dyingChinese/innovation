package edu.wsyu.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wsyu.entity.dto.Healthes;
import edu.wsyu.service.HealthesService;
import edu.wsyu.mapper.HealthesMapper;
import org.springframework.stereotype.Service;

/**
* @author chineseblack23
* @description 针对表【healthes(健康表)】的数据库操作Service实现
* @createDate 2024-09-16 09:34:43
*/
@Service
public class HealthesServiceImpl extends ServiceImpl<HealthesMapper, Healthes>
    implements HealthesService{

}




