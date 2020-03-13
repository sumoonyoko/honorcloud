package org.honorcloud.code.controller.base;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class DefaultController  extends WebMvcConfigurationSupport {
	
	
	 /**
     * 添加主页方法
     *
     * @param registry 主页注册器
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        System.out.println("设置了主页");
        //设置主页
        registry.addViewController("/").setViewName("forward:/index");
        //设置优先级
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        //将主页注册器添加到视图控制器中
        super.addViewControllers(registry);
    }
}
