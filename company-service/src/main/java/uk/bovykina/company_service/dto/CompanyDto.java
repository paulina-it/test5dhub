package uk.bovykina.company_service.dto;

import lombok.Data;

import java.util.List;

@Data
public class CompanyDto {
    private Long id;
    private String name;
    private Double budget;
    private List<Long> employeeIds;
}