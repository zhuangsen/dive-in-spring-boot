package com.zs.web.controller;

import com.zs.web.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

/**
 * User {@link RestController}
 */
//@RestController
@Controller
public class PropertiesRestController {
    @PostMapping(value = "/add/props",
            //过滤媒体类型
            consumes = "text/properties;charset=UTF-8")
    public Properties addProperties(//@RequestBody
                                                Properties properties) {
        return properties;
    }
}
