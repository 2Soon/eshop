package org.xianghao.eshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.xianghao.eshop.config.DruidDBConfig;

@SpringBootApplication
// 使用@Import就可以将其他的配置管理类导入进来
@Import(DruidDBConfig.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
