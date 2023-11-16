package top.zhengru.financetrain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan(basePackages = "top.zhengru.financetrain.mapper")
@EnableCaching
public class FinanceTrainApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanceTrainApplication.class, args);
    }

}
