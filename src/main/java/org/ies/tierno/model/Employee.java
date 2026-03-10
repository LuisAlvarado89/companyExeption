package org.ies.tierno.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@Log4j
@Data
public class Employee {
    private String nif;
    private String name;
    private String surname;
    private String role;

    public void showInfo() {
        log.info(surname + ", " + name + " (" + nif + "): " + role);

    }
}
