package org.ies.tierno.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;

import java.util.List;

@Data
@AllArgsConstructor
@Log4j
public class Department {
    private String name;
    private List<Employee> employees;

    public void showInfo() {
        log.info("Departamento: " + name + " " + "Empleados");
        for (Employee employees1 : employees) {
            employees1.showInfo();
        }
    }

}
