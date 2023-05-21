package dev.be.moduleapi.service;

import dev.be.moduleapi.exception.CustomException;
import dev.be.moduleapi.feign.client.DemoFeignClient;
import dev.be.moduleapi.feign.common.dto.BaseResponseInfo;
import dev.be.modulecommon.domain.Member;
import dev.be.modulecommon.enums.CodeEnum;
import dev.be.modulecommon.repositories.MemberRepository;
import dev.be.modulecommon.service.CommonDemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {

    @Value("${profile-name}") private String name;
    private final MemberRepository memberRepository;
    private final DemoFeignClient demoFeignClient;

    public String save(){
        System.out.println("name = " + name);
        memberRepository.save(Member.builder().name(Thread.currentThread().getName()).build());
        return "save";
    }

    public String find(){
        int size = memberRepository.findAll().size();
        System.out.println("size = " + size);
        return "find";
    }

    public String exception(){
        throw new CustomException(CodeEnum.UNKNOWN_ERROR);
    }

    public BaseResponseInfo get(){
        ResponseEntity<BaseResponseInfo> response = demoFeignClient.callGet("CustomHeader", "CustomName", 100L);

        System.out.println("response.getBody().getName() = " + response.getBody().getName());
        System.out.println("response.getBody().getAge() = " + response.getBody().getAge());
        System.out.println("response.getBody().getHeader() = " + response.getBody().getHeader());

        return response.getBody();
    }
}
