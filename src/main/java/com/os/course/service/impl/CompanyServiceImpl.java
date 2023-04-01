package com.os.course.service.impl;

import com.os.course.model.dto.CompanyDto;
import com.os.course.model.entity.Company;
import com.os.course.persistence.repository.CompanyRepository;
import com.os.course.persistence.repository.EmployeeRepository;
import com.os.course.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public CompanyServiceImpl(CompanyRepository companyRepository, EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.companyRepository = companyRepository;
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public CompanyDto create(CompanyDto companyDto) {
        Company company = modelMapper.map(companyDto, Company.class);
        companyRepository.save(company);
        int id = company.getId();
        company.getEmployees().forEach(employee -> employee.getCompany().setId(id));
        employeeRepository.saveAll(company.getEmployees());
        return modelMapper.map(company, CompanyDto.class);
    }

    @Override
    public List<CompanyDto> findAll() {
        List<Company> companyDtos = companyRepository.findAll();
        return companyDtos.stream()
                .map(company -> modelMapper.map(company, CompanyDto.class))
                .collect(Collectors.toList());
    }
}
