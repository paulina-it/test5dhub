package uk.bovykina.company_service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "companies")
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "budget", nullable = false)
    private Double budget;

    @ElementCollection
    @CollectionTable(name = "company_employees", joinColumns = @JoinColumn(name = "company_id"))
    @Column(name = "employee_id")
    private List<Long> employeeIds; // Хранит ID пользователей из User Service
}