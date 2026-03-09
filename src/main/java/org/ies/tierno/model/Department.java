package org.ies.tierno.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@Log4j
public class Department {
    private String name;
    private List<Employees> employees;

    public void showInfo() {
        log.info("Nombre: " + name + " " + "Empleados");
        for (Employees employees1 : employees) {
            employees1.showInfo();
        }
    }

}
