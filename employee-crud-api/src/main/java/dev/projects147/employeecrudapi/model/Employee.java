package dev.projects147.employeecrudapi.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee {

    private String id;
    private String name;
    private String email;
    private String department;

}
