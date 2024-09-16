package edu.wsyu;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.wsyu.entity.dto.Users;
import edu.wsyu.service.Impl.UsersServiceImpl;
import edu.wsyu.service.UsersService;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScans(value = {@MapperScan("edu.wsyu.mapper")})
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

}
