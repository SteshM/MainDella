package com.SteshM.MainDella;

import com.SteshM.MainDella.repo.ProfileRepo;
import com.SteshM.MainDella.repo.UsersRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
//@ComponentScan(basePackages = {"com.SteshM.MainDella.services"})
@EnableJpaRepositories(basePackageClasses = {UsersRepo.class, ProfileRepo.class})
@AutoConfiguration
public class MainDellaApplication {
	public static void main(String[] args) {
		SpringApplication.run(MainDellaApplication.class, args);
	}
}
