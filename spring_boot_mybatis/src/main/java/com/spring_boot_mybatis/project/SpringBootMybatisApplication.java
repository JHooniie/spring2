package com.spring_boot_mybatis.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.spring_boot_mybatis.project.dao.IProductDAO;

// 추가하는 DAO, Service, Controller 마다 모두 추가해 주어야 한다.

@SpringBootApplication
@ComponentScan(basePackages= {"com.spring_boot_mybatis.project"})
//@ComponentScan(basePackageClasses=ProductController.class)
//@ComponentScan(basePackageClasses=ProductService.class)
@MapperScan(basePackageClasses=IProductDAO.class)
public class SpringBootMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisApplication.class, args);
	}

}
