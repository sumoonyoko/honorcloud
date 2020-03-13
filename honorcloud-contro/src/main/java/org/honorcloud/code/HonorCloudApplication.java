package org.honorcloud.code;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sumoon
 * @date 2020/03/08
 *
 */
@Slf4j
@MapperScan(basePackages = "org.honorcloud.code.dao")
@ComponentScan("org.honorcloud.code")
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class HonorCloudApplication{
    public static void main( String[] args ){
    	SpringApplication application = new SpringApplication(HonorCloudApplication.class);
    	/*
         * Banner.Mode.OFF:关闭;
         * Banner.Mode.CONSOLE:控制台输出，默认方式;
         * Banner.Mode.LOG:日志输出方式;
         */
    	application.setBannerMode(Banner.Mode.OFF); 
        SpringApplication.run(HonorCloudApplication.class, args);
        log.info("HonorCloudApplication 系统启动成功！！！");
    }
}
