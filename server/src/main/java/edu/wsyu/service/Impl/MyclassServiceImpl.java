package edu.wsyu.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wsyu.entity.dto.Myclass;
import edu.wsyu.service.MyclassService;
import edu.wsyu.mapper.MyclassMapper;
import org.springframework.stereotype.Service;

/**
* @author chineseblack23
* @description 针对表【myclass(班级表)】的数据库操作Service实现
* @createDate 2024-09-16 09:34:43
*/
@Service
public class MyclassServiceImpl extends ServiceImpl<MyclassMapper, Myclass>
    implements MyclassService{

}




