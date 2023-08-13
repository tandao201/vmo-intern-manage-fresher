package com.vmo_intern.manage_fresher.apis;

import com.vmo_intern.manage_fresher.models.entities.ExampleEntity;
import com.vmo_intern.manage_fresher.models.result.Result;
import com.vmo_intern.manage_fresher.models.result.ResultGenerator;
import com.vmo_intern.manage_fresher.services.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/example")
@CrossOrigin("*")
public class ExampleController {

    @Autowired
    private ExampleService exampleService;

    @GetMapping("")
    public Result getExample() {
        return ResultGenerator.genSuccessResult(exampleService.findAll());
    }

    @GetMapping("/{id}")
    public Result getExampleById(@PathVariable("id") int id) {
        ExampleEntity exampleEntity = exampleService.findById(id);
        if (exampleEntity == null)  return ResultGenerator.genFailResult("Not found entity");
        return ResultGenerator.genSuccessResult(exampleEntity);
    }

    @PostMapping("")
    public Result createExample(@RequestBody ExampleEntity entity) {
        ExampleEntity exampleEntity = exampleService.save(entity);
        if (exampleEntity == null)  return ResultGenerator.genFailResult("");
        return ResultGenerator.genSuccessResult(exampleEntity);
    }

    @PutMapping("/{id}")
    public Result editExample(@RequestBody ExampleEntity entity, @PathVariable("id") int id) {
        entity.setId(id);
        int result = exampleService.update(entity);
        if ( result == 0) return ResultGenerator.genFailResult("");
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result deleteExample( @PathVariable("id") int id) {
        int result = exampleService.deleteById(id);
        if ( result == 0) return ResultGenerator.genFailResult("");
        return ResultGenerator.genSuccessResult();
    }
}
