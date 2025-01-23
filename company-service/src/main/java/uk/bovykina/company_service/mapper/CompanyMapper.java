package uk.bovykina.company_service.mapper;

import org.mapstruct.Mapper;
import uk.bovykina.company_service.dto.CompanyDto;
import uk.bovykina.company_service.model.Company;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyDto toDto(Company company);
    Company toEntity(CompanyDto companyDto);
}
