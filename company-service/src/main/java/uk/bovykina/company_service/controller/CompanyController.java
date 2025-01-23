package uk.bovykina.company_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.bovykina.company_service.dto.CompanyDto;
import uk.bovykina.company_service.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
@Tag(name = "Company API", description = "Company management endpoints")
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping
    @Operation(summary = "Get all companies")
    public ResponseEntity<List<CompanyDto>> getAllCompanies() {
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get company by ID")
    public ResponseEntity<CompanyDto> getCompanyById(@PathVariable Long id) {
        return ResponseEntity.ok(companyService.getCompanyById(id));
    }

    @GetMapping("/name/{name}")
    @Operation(summary = "Get company by name")
    public ResponseEntity<CompanyDto> getCompanyByName(@PathVariable String name) {
        return ResponseEntity.ok(companyService.getCompanyByName(name));
    }

    @PostMapping
    @Operation(summary = "Create a new company")
    public ResponseEntity<CompanyDto> createCompany(@RequestBody CompanyDto companyDto) {
        return ResponseEntity.ok(companyService.createCompany(companyDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete company by ID")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }
}