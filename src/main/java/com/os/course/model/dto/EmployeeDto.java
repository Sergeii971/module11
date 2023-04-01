package com.os.course.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmployeeDto {
    private int id;
    private String name;
    private String email;
    private LocalDateTime dateOfBirth;
}
