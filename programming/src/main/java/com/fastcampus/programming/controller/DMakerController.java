package com.fastcampus.programming.controller;
import com.fastcampus.programming.dto.*;
import com.fastcampus.programming.entity.Developer;
import com.fastcampus.programming.service.DMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController /* @Controller + @ResponseBody */
@Slf4j
@RequiredArgsConstructor
public class DMakerController {

    private final DMakerService dMakerService;

    @GetMapping("/developers")
    public List<DeveloperDto> getAllDevelopers() {
        log.info("GET /developers HTTP/1.1");

        return dMakerService.getAllDevelopers();
    }
    @GetMapping("/developers/{memberId}")
    public DeveloperDetailDto getAllDeveloperDetail(@PathVariable String memberId){
        log.info("GET /developers HTTP/1.1");

        return dMakerService.getDeveloperDetail(memberId);
    }

    @PostMapping("/create-developer")
    public CreateDeveloper.Response createDevelopers(
            @Valid @RequestBody CreateDeveloper.Request request) {

        log.info("request : {}", request);

        return dMakerService.createDeveloper(request);
    }

}
