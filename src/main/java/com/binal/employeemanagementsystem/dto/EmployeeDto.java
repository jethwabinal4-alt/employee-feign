package com.binal.employeemanagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY )
    private Integer id;

    private String empName;

    private String empSalary;

    private String empCity;
}
