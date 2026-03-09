package org.ies.tierno.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@Log4j
@Data
public class Employees {
    private String nif;
    private String name;
    private String surname;
    private String workstation;

    public void showInfo() {
        log.info("NIF" + nif);
        log.info("Nombre" + name);
        log.info("Apellidos" + surname);
        log.info("Puesto" + workstation);

    }


}
