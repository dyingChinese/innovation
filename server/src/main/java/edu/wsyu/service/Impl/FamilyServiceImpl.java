package edu.wsyu.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wsyu.entity.dto.Family;
import edu.wsyu.service.FamilyService;
import edu.wsyu.mapper.FamilyMapper;
import org.springframework.stereotype.Service;

/**
* @author chineseblack23
* @description 针对表【family(家庭表)】的数据库操作Service实现
* @createDate 2024-09-16 09:34:43
*/
@Service
public class FamilyServiceImpl extends ServiceImpl<FamilyMapper, Family>
    implements FamilyService{

}




