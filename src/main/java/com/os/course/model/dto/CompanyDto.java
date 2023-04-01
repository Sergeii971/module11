package com.os.course.model.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CompanyDto {
    private int id;
    private String name;

    private List<EmployeeDto> employees = new ArrayList<>();
}
