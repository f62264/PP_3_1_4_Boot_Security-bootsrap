package ru.kata.spring.boot_security.demo.configs;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/user").setViewName("user");
    }

    //Этот код добавляет контроллер представлений для URL-адреса "/user",
    // который будет отображать представление с именем "user". Таким образом,
    // при переходе по URL-адресу "/user" будет отображаться страница с содержимым из файла "user.html"
}
