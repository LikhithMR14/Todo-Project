package com.ivoyant.springboot_todo.service;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TodoServiceTests {

    @Autowired
    TodoService todoService;

    @BeforeAll
    public static void beforeTestExecution() {
        System.out.println("Before the execution of test");
    }

    @Disabled
    @Test
    public void testAdd() {
        assertEquals(4,2+2);
    }

    @Test
    public void testFindAll() {
        assertNotNull(todoService.getAllTodos());
    }

    @Disabled
    @Test
    public void testdeleteTodo() {
        assertTrue(todoService.deleteTodo(352L));
    }

    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,3,5",
            "2,6,9"
    })
    public void testParameterizedAdd(int a,int b,int sum) {
        assertEquals(sum,a+b);
    }

    @AfterAll
    public static void afterTestExecution() {
        System.out.println("After the execution of test");
    }
}
