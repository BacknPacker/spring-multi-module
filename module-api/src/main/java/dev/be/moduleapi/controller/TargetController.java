package dev.be.moduleapi.controller;

import dev.be.moduleapi.feign.common.dto.BaseResponseInfo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/target_server")
public class TargetController {

    @GetMapping("/get")
    public BaseResponseInfo demoGet(@RequestHeader("CustomHeaderName") String customHeader,
                                    @RequestParam("name") String name,
                                    @RequestParam("age") Long age){

        return BaseResponseInfo
                .builder()
                .header(customHeader)
                .name(name)
                .age(age)
                .build();
    }}
