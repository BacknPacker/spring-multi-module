package dev.be.moduleapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    @Async("defaultTaskExecutor")
    public void sendMail(){
        System.out.println("[EmailService.sendMail] :: " + Thread.currentThread().getName());
    }

    @Async("messagingTaskExecutor")
    public void sendMailWithCustomThreadPool(){
        System.out.println("[EmailService.sendMailWithCustomThreadPool] :: " + Thread.currentThread().getName());
    }
}
