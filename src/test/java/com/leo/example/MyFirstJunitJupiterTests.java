package com.leo.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

@DisplayName("我的第一个测试")
@Tag("add test")
public class MyFirstJunitJupiterTests {
    private final Calculator calculator = new Calculator();
    @Test
    @DisplayName("加法测试")
    public void addition(){
        Assert.assertEquals(2, calculator.add(1, 1));
    }
}
