package com.server.ToyProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing //Spring Data JPA 에서 JPA 를 사용하기 위해서는 SpringBoot 설정 클래스에 @EnableJpaAuditing 을 적어줘야한다.
@SpringBootApplication		//Configuration, EnableAutoConfiguration, ComponentScan 포함 그래서 root에 있어야 여기부터 스캔 시작 https://congsong.tistory.com/13
public class ToyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToyProjectApplication.class, args);
	}

}
