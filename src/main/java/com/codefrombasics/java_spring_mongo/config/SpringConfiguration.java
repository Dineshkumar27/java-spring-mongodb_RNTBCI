package com.codefrombasics.java_spring_mongo.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
public class SpringConfiguration{

   private ApplicationContext applicationContext;

    public SpringConfiguration(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void init(){
       MappingMongoConverter mappingMongoConverter=
               applicationContext.getBean(MappingMongoConverter.class);
       mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
   }

}