package com.ivoyant.springboot_todo.exceptions;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
public class ExceptionObject {

    private int statusCode;

    private String message;

}
