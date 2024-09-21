package edu.wsyu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.wsyu.entity.dto.Users;
import edu.wsyu.entity.vo.User;
import edu.wsyu.service.UsersService;
import edu.wsyu.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/save")
    public Result<Users> save(User user) {
        usersService.save(user);
        return Result.succeed(user);
    }


    //查询
    @GetMapping("/get")
    public Result<List<Users>> save(@RequestParam Long currentPage, @RequestParam Long pageSize) {
        return Result.succeed(usersService.page(new Page<>(currentPage, pageSize)).getRecords());
    }

    @GetMapping("/get/{uid}")
    public Result<Users> get(@PathVariable Long uid) {
        return Result.succeed(usersService.getById(uid));
    }

    @GetMapping("/get/{username}")
    public Result<Users> get(@PathVariable String username) {
        return Result.succeed(usersService.getOne(new QueryWrapper<Users>().eq("username", username)));
    }

    //删除
    @DeleteMapping("/delete/{uid}")
    public Result<Boolean> delete(@PathVariable Long uid) {
        return Result.succeed(usersService.removeById(uid));
    }


    // 修改
    @PutMapping("/update/{uid}")
    public Result<Users> update(User user, @PathVariable Long uid) {
        usersService.updateById(user);
        return Result.succeed(user);
    }
}
