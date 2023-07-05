package com.vmo_intern.manage_fresher.apis;

import com.vmo_intern.manage_fresher.models.dto_entities.UserEntityDto;
import com.vmo_intern.manage_fresher.models.entities.UserEntity;
import com.vmo_intern.manage_fresher.models.paging.PageInfo;
import com.vmo_intern.manage_fresher.models.paging.PagingEntity;
import com.vmo_intern.manage_fresher.models.result.Result;
import com.vmo_intern.manage_fresher.models.result.ResultGenerator;
import com.vmo_intern.manage_fresher.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;

    private ModelMapper modelMapper = new ModelMapper();

    public UserController() {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
    }

    @GetMapping("")
    public Result getUser(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Page<UserEntity> usersPage = userService.findAllPaging(page-1, pageSize, sortBy);
        PagingEntity pagingEntity;
        if (usersPage != null) {
            pagingEntity = new PagingEntity(
                    usersPage.getContent(),
                    new PageInfo(
                            page,
                            pageSize,
                            usersPage.getTotalElements()
                    )
            );
        } else {
            pagingEntity = new PagingEntity(
                    new ArrayList<>(),
                    new PageInfo(
                            page,
                            pageSize,
                            0
                    )
            );
        }
        return ResultGenerator.genSuccessResult(pagingEntity);
    }

    @GetMapping("/{id}")
    public Result getExampleById(@PathVariable("id") int id) {
        UserEntity userEntity = userService.findById(id);
        if (userEntity == null) return ResultGenerator.genFailResult("Not found");
        return ResultGenerator.genSuccessResult(userEntity);
    }

    @PostMapping("")
    public Result createExample(@RequestBody UserEntityDto entityDto) {
        UserEntity entity = modelMapper.map(entityDto, UserEntity.class);
        UserEntity userEntity = userService.save(entity);
        if (userEntity == null) return ResultGenerator.genFailResult("");
        return ResultGenerator.genSuccessResult(userEntity);
    }

    @PutMapping("/{id}")
    public Result editExample(@RequestBody UserEntityDto entityDto, @PathVariable("id") int id) {
        UserEntity entity = modelMapper.map(entityDto, UserEntity.class);
        entity.setId(id);
        int result = userService.update(entity);
        if (result == 0) return ResultGenerator.genFailResult("");
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result deleteExample(@PathVariable("id") int id) {
        int result = userService.deleteById(id);
        if (result == 0) return ResultGenerator.genFailResult("");
        return ResultGenerator.genSuccessResult();
    }
}
