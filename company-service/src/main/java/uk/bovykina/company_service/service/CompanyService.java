package uk.bovykina.company_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.bovykina.company_service.dto.CompanyDto;
import uk.bovykina.company_service.exception.CompanyNotFoundException;
import uk.bovykina.company_service.mapper.CompanyMapper;
import uk.bovykina.company_service.model.Company;
import uk.bovykina.company_service.repository.CompanyRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public List<CompanyDto> getAllCompanies() {
        return companyRepository.findAll().stream()
                .map(companyMapper::toDto)
                .collect(Collectors.toList());
    }

    public CompanyDto getCompanyById(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException("Company not found with id: " + id));
        return companyMapper.toDto(company);
    }

    public CompanyDto getCompanyByName(String name) {
        Company company = companyRepository.findByName(name)
                .orElseThrow(() -> new CompanyNotFoundException("Company not found with name: " + name));
        return companyMapper.toDto(company);
    }

    public CompanyDto createCompany(CompanyDto companyDto) {
        Company company = companyMapper.toEntity(companyDto);
        company = companyRepository.save(company);
        return companyMapper.toDto(company);
    }

    public void deleteCompany(Long id) {
        if (!companyRepository.existsById(id)) {
            throw new CompanyNotFoundException("Company not found with id: " + id);
        }
        companyRepository.deleteById(id);
    }
}