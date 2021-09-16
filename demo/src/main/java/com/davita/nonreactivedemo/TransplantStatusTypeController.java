package com.davita.nonreactivedemo;

import com.davita.nonreactivedemo.dao.TransplantStatusTypeRepository;
import com.davita.nonreactivedemo.model.TransplantStatusType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("transplant-status-types")
@Slf4j
public class TransplantStatusTypeController {

    private TransplantStatusTypeRepository transplantStatusTypesRepository;

    public TransplantStatusTypeController(TransplantStatusTypeRepository transplantStatusTypesRepository) {
        this.transplantStatusTypesRepository = transplantStatusTypesRepository;
    }

    @GetMapping("{id}")
    public TransplantStatusType get(@PathVariable("id") String id) {

        return transplantStatusTypesRepository
                .findById(id).get();
    }

    @GetMapping
    public List<TransplantStatusType> getTypes() {
        return transplantStatusTypesRepository.activeTypesNotUnspecified();
    }

//    @GetMapping("count")
//    public Mono<ResponseEntity<Long>> count() {
//
//        return transplantStatusTypesRepository
//                .count()
//                .map(ResponseEntity::ok)
//                .defaultIfEmpty(ResponseEntity.notFound().build());
//    }
}

