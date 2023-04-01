package com.os.course.service;

import com.os.course.model.dto.CompanyDto;

import java.util.List;

public interface CompanyService {
    CompanyDto create(CompanyDto companyDto);

    List<CompanyDto> findAll();
}
