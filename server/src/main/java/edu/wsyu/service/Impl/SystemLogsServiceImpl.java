package edu.wsyu.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wsyu.entity.dto.SystemLogs;
import edu.wsyu.service.SystemLogsService;
import edu.wsyu.mapper.SystemLogsMapper;
import org.springframework.stereotype.Service;

/**
* @author chineseblack23
* @description 针对表【system_logs(系统日志表)】的数据库操作Service实现
* @createDate 2024-09-16 09:34:43
*/
@Service
public class SystemLogsServiceImpl extends ServiceImpl<SystemLogsMapper, SystemLogs>
    implements SystemLogsService{

}




