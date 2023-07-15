package com.vmo_intern.manage_fresher.apis;

import com.vmo_intern.manage_fresher.exceptions_handler.exceptions.ResourceNotFoundException;
import com.vmo_intern.manage_fresher.models.dto_entities.UserEntityDto;
import com.vmo_intern.manage_fresher.models.entities.ScoreEntity;
import com.vmo_intern.manage_fresher.models.entities.UserEntity;
import com.vmo_intern.manage_fresher.models.entities.UserProgrammingLanguageEntity;
import com.vmo_intern.manage_fresher.models.paging.PageInfo;
import com.vmo_intern.manage_fresher.models.paging.PagingEntity;
import com.vmo_intern.manage_fresher.models.result.Result;
import com.vmo_intern.manage_fresher.models.result.ResultGenerator;
import com.vmo_intern.manage_fresher.services.ScoreService;
import com.vmo_intern.manage_fresher.services.UserProgrammingLanguageService;
import com.vmo_intern.manage_fresher.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserProgrammingLanguageService userProgrammingLanguageService;
    @Autowired
    ScoreService scoreService;

    private ModelMapper modelMapper = new ModelMapper();

    public UserController() {
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
    }

    @GetMapping("")
    public Result getUsers(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "") String email,
            @RequestParam(defaultValue = "-1") Integer languageId,
            @RequestParam(defaultValue = "-1") Integer officeId,
            @RequestParam(defaultValue = "-1") Double scoreFrom,
            @RequestParam(defaultValue = "-1") Double scoreTo
    ) {
        Map<String , Object> queryParam = new HashMap<>();
        queryParam.put("page", page-1);
        queryParam.put("pageSize", pageSize);
        queryParam.put("sortBy", sortBy);
        queryParam.put("email", email);
        queryParam.put("languageId", languageId);
        queryParam.put("officeId", officeId);
        queryParam.put("scoreFrom", scoreFrom);
        queryParam.put("scoreTo", scoreTo);

        Page<UserEntity> usersPage = userService.findAllPagingAndSearch(queryParam);
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
    public Result getUserById(@PathVariable("id") int id) {
        UserEntity userEntity = userService.findById(id);
        if (userEntity == null) throw new ResourceNotFoundException("Not found");
        return ResultGenerator.genSuccessResult(userEntity);
    }

    @PostMapping("")
    public Result createUser(@RequestBody UserEntityDto entityDto) {
        UserEntity entity = modelMapper.map(entityDto, UserEntity.class);
        UserEntity userEntity = userService.save(entity);

        // save programming language
        List<UserProgrammingLanguageEntity> userLanguages = entityDto.getProgrammingLanguageIds().stream().map(
                idLanguage -> new UserProgrammingLanguageEntity(userEntity.getId(), idLanguage)
        ).toList();
        userProgrammingLanguageService.save(userLanguages);
        UserEntity userEntityTmp = userService.findById(userEntity.getId());
        if (userEntityTmp == null) return ResultGenerator.genFailResult("");
        return ResultGenerator.genSuccessResult(userEntityTmp);
    }

    @PutMapping("/{id}")
    public Result editUser(@RequestBody UserEntityDto entityDto, @PathVariable("id") int id) {
        UserEntity entity = modelMapper.map(entityDto, UserEntity.class);
        entity.setId(id);

        List<UserProgrammingLanguageEntity> userLanguages = entityDto.getProgrammingLanguageIds().stream().map(
                idLanguage -> new UserProgrammingLanguageEntity(id, idLanguage)
        ).toList();

        List<ScoreEntity> scoreEntities =
                IntStream.range(0, entityDto.getScores().size())
                        .mapToObj(i -> new ScoreEntity(id, i + 1, String.format("Bài test %S", i + 1), entityDto.getScores().get(i)))
                        .collect(toList());

        int result = userService.update(entity);
        scoreService.save(scoreEntities); // save score
        userProgrammingLanguageService.save(userLanguages); // save programming language
        if (result == 0) return ResultGenerator.genFailResult("");
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable("id") int id) {
        int result = userService.deleteById(id);
        if (result == 0) return ResultGenerator.genFailResult("");
        return ResultGenerator.genSuccessResult();
    }
}
