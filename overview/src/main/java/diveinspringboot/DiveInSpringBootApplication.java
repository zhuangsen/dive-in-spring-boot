package diveinspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ServletComponentScan(basePackages = "com.zs.diveinspringboot.web.servlet")
public class DiveInSpringBootApplication {

    public static void main(String[] args) {
//	    new SpringApplicationBuilder(DiveInSpringBootApplication.class)
//                .web(WebApplicationType.NONE)
//                .properties("abc=sds")
//                .run(args);
        SpringApplication.run(DiveInSpringBootApplication.class, args);
    }
}
