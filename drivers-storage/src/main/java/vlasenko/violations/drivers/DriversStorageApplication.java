package vlasenko.violations.drivers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@ComponentScan("vlasenko.violations.drivers")
@EnableJpaRepositories("vlasenko.violations.drivers.repository")
@EnableSwagger2
public class DriversStorageApplication {
    public static void main(String[] args) {
        SpringApplication.run(DriversStorageApplication.class, args);
    }

    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("drivers")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/drivers.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Drivers storage API")
                .description("Drivers storage REST API documentation")
                .version("2.0")
                .build();
    }
}
