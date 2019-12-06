package com.masglobalconsulting.handsOnTest.rest.web;

import com.masglobalconsulting.handsOnTest.dto.EmployeeDTO;
import com.masglobalconsulting.handsOnTest.exceptions.NotFoundException;
import com.masglobalconsulting.handsOnTest.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDTO> getAll() {
        try {
            return employeeService.getAll()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.error("Error {}", e.getMessage());
            return Collections.emptyList();
        }
    }

    @GetMapping("/{id}")
    public EmployeeDTO employeeDTO(@PathVariable("id") Integer id) {
      try {
          return employeeService.findById(id)
                  .orElseThrow((() -> new NotFoundException()));
      } catch (IOException e) {
          log.error("Error {}", e.getMessage());
      }
      return null;
    }
}
