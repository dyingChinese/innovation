package edu.wsyu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wsyu.entity.dto.Document;
import edu.wsyu.service.DocumentService;
import edu.wsyu.mapper.DocumentMapper;
import org.springframework.stereotype.Service;

/**
* @author chineseblack23
* @description 针对表【document(文件信息)】的数据库操作Service实现
* @createDate 2024-09-16 09:34:43
*/
@Service
public class DocumentServiceImpl extends ServiceImpl<DocumentMapper, Document>
    implements DocumentService{

}




