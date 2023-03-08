package dev.projects147.employeecrudapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "EMPLOYEE_DETAILS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeEntity {

    @Id
    private String id;
    private String name;
    private String email;
    private String department;
}
