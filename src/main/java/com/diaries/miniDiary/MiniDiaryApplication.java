package com.diaries.miniDiary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.diaries.miniDiary.repository", "com.diaries.miniDiary.controller", "com.diaries.miniDiary.service"})
@EntityScan({"com.diaries.miniDiary.model"})
@EnableJpaRepositories(basePackages = {"com.diaries.miniDiary.repository"})
public class MiniDiaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniDiaryApplication.class, args);
	}

}
