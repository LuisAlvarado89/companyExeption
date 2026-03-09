package org.ies.tierno.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;

import java.util.Map;

@Log4j
@Data
@AllArgsConstructor
public class Company {
    private String name;
    private String cif;
    private Map<String, Department> departmentByName;

    public void showInfo() {
        log.info("Nombre: " + name + " " + "Departamentos");
        for (Department department1:departmentByName.values()){
            department1.showInfo();
        }

    }


}
