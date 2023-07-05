package com.vmo_intern.manage_fresher.apis;

import com.vmo_intern.manage_fresher.models.entities.UserEntity;
import com.vmo_intern.manage_fresher.models.result.Result;
import com.vmo_intern.manage_fresher.models.result.ResultGenerator;
import com.vmo_intern.manage_fresher.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public Result getUser() {
        return ResultGenerator.genSuccessResult(userService.findAll());
    }

    @GetMapping("/{id}")
    public Result getExampleById(@PathVariable("id") int id) {
        UserEntity userEntity = userService.findById(id);
        if (userEntity == null)  return ResultGenerator.genFailResult("Not found");
        return ResultGenerator.genSuccessResult(userEntity);
    }

    @PostMapping("")
    public Result createExample(@RequestBody UserEntity entity) {
        UserEntity userEntity = userService.save(entity);
        if (userEntity == null)  return ResultGenerator.genFailResult("");
        return ResultGenerator.genSuccessResult(userEntity);
    }

    @PutMapping("/{id}")
    public Result editExample(@RequestBody UserEntity entity, @PathVariable("id") int id) {
        entity.setId(id);
        int result = userService.update(entity);
        if ( result == 0) return ResultGenerator.genFailResult("");
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result deleteExample( @PathVariable("id") int id) {
        int result = userService.deleteById(id);
        if ( result == 0) return ResultGenerator.genFailResult("");
        return ResultGenerator.genSuccessResult();
    }
}
