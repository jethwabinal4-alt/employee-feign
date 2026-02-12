package com.binal.employeemanagementsystem.mapper;

import com.binal.employeemanagementsystem.dto.EmployeeDto;
import com.binal.employeemanagementsystem.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class EmployeeMapper {

    public Employee map(EmployeeDto employeeDto){
        return convertDtoToEntity(null,employeeDto);
    }

    public Employee convertDtoToEntity(Employee employee,EmployeeDto employeeDto){
        if(Objects.isNull(employee)){
            employee = new Employee();
        }
        employee.setName(employeeDto.getEmpName());
        employee.setSalary(employeeDto.getEmpSalary());
        employee.setCity(employeeDto.getEmpCity());
        return employee;
    }

    public EmployeeDto map(Employee employee){
        return convertEntityToDto(null,employee);
    }


    public EmployeeDto convertEntityToDto(EmployeeDto employeeDto,Employee employee){
        if(Objects.isNull(employeeDto)){
            employeeDto = new EmployeeDto();
        }
        employeeDto.setEmpName(employee.getName());
        employeeDto.setEmpSalary(employee.getSalary());
        employeeDto.setEmpCity(employee.getCity());
        return employeeDto;
    }

    public List<Employee> mapToEntity(List<EmployeeDto> employeeDtoList){
        List<Employee> employeeList = new ArrayList<>();
        for (EmployeeDto employeeDto:employeeDtoList){
            Employee employee= new Employee();
            employee.setId(employeeDto.getId());
            employee.setName(employeeDto.getEmpName());
            employee.setSalary(employeeDto.getEmpSalary());
            employee.setCity(employeeDto.getEmpCity());
            employeeList.add(employee);
        }
        return employeeList;
    }

    public List<EmployeeDto> mapToDto(List<Employee> employeeList){
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        for (Employee employee:employeeList){
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setId(employee.getId());
            employeeDto.setEmpName(employee.getName());
            employeeDto.setEmpCity(employee.getCity());
            employeeDto.setEmpSalary(employee.getSalary());
            employeeDtoList.add(employeeDto);
        }
        return employeeDtoList;
    }
}
