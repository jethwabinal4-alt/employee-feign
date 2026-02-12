package com.binal.employeemanagementsystem.controller;

import com.binal.employeemanagementsystem.dto.EmployeeDto;
import com.binal.employeemanagementsystem.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/addEmpList")
    public ResponseEntity<List<EmployeeDto>> addEmpList(@RequestBody List<EmployeeDto> employeeDtoList){
        log.info("[EmployeeController] [addEmpList] adding employee list");
        List<EmployeeDto> employeeDtoList1 = employeeService.addEmpList(employeeDtoList);
        return new ResponseEntity<>(employeeDtoList1, HttpStatus.CREATED);
    }

    @PostMapping("/addSingleEmp")
    public ResponseEntity<EmployeeDto> addSingleEmp(@RequestBody EmployeeDto employeeDto){
        log.info("[EmployeeController] [addSingleEmp] adding employee");
        EmployeeDto employeeDto1 = employeeService.addEmployee(employeeDto);
        return new ResponseEntity<>(employeeDto1,HttpStatus.CREATED);
    }

    @GetMapping("/get-emp/{id}")
    public ResponseEntity<EmployeeDto> getEmpById(@PathVariable Integer id){
        log.info("[EmployeeController] [getEmpByID] getting employee");
        EmployeeDto empById = employeeService.getEmpById(id);
        return new ResponseEntity<>(empById,HttpStatus.OK);
    }

    @PutMapping("/update-emp/{id}")
    public ResponseEntity<EmployeeDto> updateEmp(@PathVariable Integer id,@RequestBody EmployeeDto employeeDto){
        log.info("[EmployeeController] [updateEmp] updating employee");
        EmployeeDto employeeDto1 = employeeService.updateEmp(id, employeeDto);
        return new ResponseEntity<>(employeeDto1,HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        log.info("[EmployeeController] [deleteById] deleting one employee");
        employeeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete-emp")
    public ResponseEntity<?> deleteAllEmp(){
        log.info("[EmployeeController] [deleteAllEmp] delete  all employee");
        employeeService.deleteEmp();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
