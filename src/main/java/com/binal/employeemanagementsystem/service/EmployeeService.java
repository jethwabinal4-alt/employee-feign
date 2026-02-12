package com.binal.employeemanagementsystem.service;

import com.binal.employeemanagementsystem.dto.EmployeeDto;
import com.binal.employeemanagementsystem.entity.Employee;
import com.binal.employeemanagementsystem.mapper.EmployeeMapper;
import com.binal.employeemanagementsystem.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    public List<EmployeeDto> addEmpList(List<EmployeeDto> employeeDtoList){
        log.info("[EmployeeService] [addEmpList] adding employee list");
        List<Employee> employeeList = employeeMapper.mapToEntity(employeeDtoList);

        List<Employee> employeeList1 = employeeRepository.saveAll(employeeList);

        return employeeMapper.mapToDto(employeeList1);
    }

    public EmployeeDto addEmployee(EmployeeDto employeeDto){
        log.info("[EmployeeService] [addList] adding employee");
        Employee employee = employeeMapper.map(employeeDto);

        Employee employee1= employeeRepository.save(employee);

        return employeeMapper.map(employee1);
    }

    public EmployeeDto getEmpById(Integer id){
        log.info("[EmployeeService] [getList] get employee");
        Optional<Employee> byId = employeeRepository.findById(id);
        if (byId.isEmpty()){
            throw new RuntimeException("Employee with this id does not exist");
        }
        Employee employee = byId.get();
        return employeeMapper.map(employee);
    }

    public EmployeeDto updateEmp(Integer id,EmployeeDto employeeDto){
        log.info("[EmployeeService] [updateEmp] update employee");
        Optional<Employee> byId = employeeRepository.findById(id);
        if (byId.isEmpty()){
            throw new RuntimeException("Employee with this id does not exist");
        }
        Employee employee = byId.get();
        Employee employee1 = employeeMapper.convertDtoToEntity(employee,employeeDto);
        Employee employee2 = employeeRepository.save(employee1);
        return employeeMapper.convertEntityToDto(employeeDto,employee2);
    }

    public void deleteById(Integer id){
        log.info("[EmployeeService] [deleteById] delete employee");
        employeeRepository.deleteById(id);
    }

    public void deleteEmp(){
        log.info("[EmployeeService] [deleteById] deleting all employee");
        employeeRepository.deleteAll();
    }
}
