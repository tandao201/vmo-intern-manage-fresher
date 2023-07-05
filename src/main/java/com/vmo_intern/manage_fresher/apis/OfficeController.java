package com.vmo_intern.manage_fresher.apis;

import com.vmo_intern.manage_fresher.models.dto_entities.OfficeEntityDto;
import com.vmo_intern.manage_fresher.models.entities.OfficeEntity;
import com.vmo_intern.manage_fresher.models.paging.PageInfo;
import com.vmo_intern.manage_fresher.models.paging.PagingEntity;
import com.vmo_intern.manage_fresher.models.result.Result;
import com.vmo_intern.manage_fresher.models.result.ResultGenerator;
import com.vmo_intern.manage_fresher.services.OfficeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/office")
@CrossOrigin("*")
public class OfficeController {
    @Autowired
    OfficeService officeService;

    private ModelMapper modelMapper = new ModelMapper();

    public OfficeController() {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
    }

    @GetMapping("")
    public Result getOffices(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Page<OfficeEntity> officeEntityPage = officeService.findAllPaging(page-1, pageSize, sortBy);
        PagingEntity pagingEntity;
        if (officeEntityPage != null) {
            pagingEntity = new PagingEntity(
                    officeEntityPage.getContent(),
                    new PageInfo(
                            page,
                            pageSize,
                            officeEntityPage.getTotalElements()
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
    public Result getOfficeById(@PathVariable("id") int id) {
        OfficeEntity officeEntity = officeService.findById(id);
        if (officeEntity == null) return ResultGenerator.genFailResult("Not found");
        return ResultGenerator.genSuccessResult(officeEntity);
    }

    @PostMapping("")
    public Result createOffice(@RequestBody OfficeEntityDto entityDto) {
        OfficeEntity entity = modelMapper.map(entityDto, OfficeEntity.class);
        OfficeEntity officeEntity = officeService.save(entity);
        if (officeEntity == null) return ResultGenerator.genFailResult("");
        return ResultGenerator.genSuccessResult(officeEntity);
    }

    @PutMapping("/{id}")
    public Result editOffice(@RequestBody OfficeEntityDto entityDto, @PathVariable("id") int id) {
        OfficeEntity entity = modelMapper.map(entityDto, OfficeEntity.class);
        entity.setId(id);
        int result = officeService.update(entity);
        if (result == 0) return ResultGenerator.genFailResult("");
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result deleteOffice(@PathVariable("id") int id) {
        int result = officeService.deleteById(id);
        if (result == 0) return ResultGenerator.genFailResult("");
        return ResultGenerator.genSuccessResult();
    }
}
