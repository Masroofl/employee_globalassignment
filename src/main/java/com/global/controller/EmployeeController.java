package com.global.controller;

import com.global.entity.Employee;
import com.global.exception.EmployeeNotFoundException;
import com.global.payload.EmployeeDTO;
import com.global.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/employees")
    public String addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        employee.setId(UUID.randomUUID().toString());
        employee.setReportsTo(UUID.randomUUID().toString());
        employeeRepository.save(employee);
        return "Employee added successfully with id: "+employee.getId();
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    //pagination
    @GetMapping("/info")
    public Page<EmployeeDTO> getAllEmployees(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) int size,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "sortOrder",defaultValue = "asc",required = false) String sortOrder) {

        Sort orders = sortOrder.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        PageRequest pageRequest = PageRequest.of(pageNo, size, orders);
        

        Page<Employee> employeePage = employeeRepository.findAll(pageRequest);
        List<Employee> content = employeePage.getContent();
        List<EmployeeDTO> employeeDTOs = content.stream().map(empl -> modelMapper.map(empl, EmployeeDTO.class)).
                collect(Collectors.toList());
        return new PageImpl<>(employeeDTOs, employeePage.getPageable(), employeePage.getTotalElements());
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable String id) {
        employeeRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public EmployeeDTO updateEmployee(@PathVariable String id, @RequestBody EmployeeDTO employeeDTO) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + id));

        modelMapper.map(employeeDTO, existingEmployee);
        existingEmployee.setId(id);
        Employee employee = employeeRepository.save(existingEmployee);
        return modelMapper.map(employee,EmployeeDTO.class);
    }
}

