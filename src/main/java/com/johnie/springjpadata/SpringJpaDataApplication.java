package com.johnie.springjpadata;

import com.johnie.springjpadata.repository.BaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(
        repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class,
        repositoryBaseClass = BaseRepositoryImpl.class)
public class SpringJpaDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaDataApplication.class, args);
    }

}
