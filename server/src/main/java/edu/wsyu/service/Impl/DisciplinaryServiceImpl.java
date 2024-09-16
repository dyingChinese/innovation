package edu.wsyu.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wsyu.entity.dto.Disciplinary;
import edu.wsyu.service.DisciplinaryService;
import edu.wsyu.mapper.DisciplinaryMapper;
import org.springframework.stereotype.Service;

/**
* @author chineseblack23
* @description 针对表【disciplinary(违纪表)】的数据库操作Service实现
* @createDate 2024-09-16 09:34:43
*/
@Service
public class DisciplinaryServiceImpl extends ServiceImpl<DisciplinaryMapper, Disciplinary>
    implements DisciplinaryService{

}




