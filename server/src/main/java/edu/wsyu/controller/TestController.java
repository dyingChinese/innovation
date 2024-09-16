package edu.wsyu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.wsyu.entity.dto.Users;
import edu.wsyu.service.UsersService;
import edu.wsyu.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class TestController {
    private final UsersService usersService;

    public TestController(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping("/test")
    public Result<Users> test() {
        Users uid = usersService.getOne(new QueryWrapper<Users>().eq("uid", 1L));
        System.out.println(uid);
        System.out.println("test");
        return Result.succeed(uid);
    }
}
