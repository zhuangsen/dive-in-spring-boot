package com.zs.diveinspringboot.repository;

import com.zs.diveinspringboot.annotation.FirstLevelRepository;
import org.springframework.stereotype.Component;

@FirstLevelRepository(value = "myFirstLevelRepository")
//@Component(value = "myFirstLevelRepository")
public class MyFirstLevelRepository {
}
