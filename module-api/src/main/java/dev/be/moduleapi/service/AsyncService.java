package dev.be.moduleapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AsyncService {

    private final EmailService emailService;

    /**
     * 비동기 O
     * 비동기로 동작할 수 있게 Sub Thread 에 위임해준다.
     * Spring 이 관리하는 Bean 을 사용해야된다.
     */
    public void asyncCall_1(){
        System.out.println("[asyncCall_1] :: " + Thread.currentThread().getName());
        emailService.sendMail();
        emailService.sendMailWithCustomThreadPool();
    }

    /**
     * 비동기 X
     */
    public void asyncCall_2(){
        System.out.println("[asyncCall_2] :: " + Thread.currentThread().getName());
        EmailService emailService1 = new EmailService();
        emailService1.sendMail();
        emailService1.sendMailWithCustomThreadPool();
    }

    /**
     * 비동기 X
     */
    public void asyncCall_3(){
        System.out.println("[asyncCall_3] :: " + Thread.currentThread().getName());
        this.sendMail();
    }

    @Async
    public void sendMail(){
        System.out.println("[AsyncService.sendMail] :: " + Thread.currentThread().getName());
    }
}
