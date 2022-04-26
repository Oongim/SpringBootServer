package com.server.ToyProject.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.server.ToyProject.model.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @Controller 와 ResponseBody를 모두 포함하는 어노테이션
public class HelloController {

    private static final String template = "Hello, %s!"; // final은 바꾸지 않겠다는 뜻 const랑 같은 듯
    private final AtomicLong counter = new AtomicLong(); // Atomic은 진짜 아토믹 가장 적은 비용으로 스레드 처리 할 수 있는듯
    /*
     * AtomicInteger는 int 자료형을 갖고 있는 wrapping 클래스입니다. AtomicInteger 클래스는 멀티쓰레드 환경에서
     * 동시성을 보장합니다.
     * 
     * 자바에서 동시성 문제를 해결하는데 3가지 방법이 있습니다.
     * 
     * "volatile" 은 Thread1에서 쓰고, Thread2에서 읽는 경우만 동시성을 보장합니다. 두개의 쓰레드에서 쓴다면 문제가 될 수
     * 있습니다.
     * "synchronized"를 쓰면 안전하게 동시성을 보장할 수 있습니다. 하지만 비용이 가장 큽니다.
     * Atomic 클래스는 CAS(compare-and-swap)를 이용하여 동시성을 보장합니다. 여러 쓰레드에서 데이터를 write해도 문제가
     * 없습니다.
     * AtomicInteger는 synchronized 보다 적은 비용으로 동시성을 보장할 수 있습니다.
     */

    @GetMapping("/hello")
    public Hello hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Hello(counter.incrementAndGet(), String.format(template, name));
    }

}