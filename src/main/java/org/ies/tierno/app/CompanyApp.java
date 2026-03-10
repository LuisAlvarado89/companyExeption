package org.ies.tierno.app;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.ies.tierno.exeptions.DepartmentNotFoundException;
import org.ies.tierno.exeptions.EmployeeNoFoundException;
import org.ies.tierno.model.Company;
import org.ies.tierno.model.Department;
import org.ies.tierno.model.Employee;
import org.ies.tierno.reader.CompanyReader;

import java.util.List;
import java.util.Scanner;

@Log4j
@AllArgsConstructor
public class CompanyApp implements App {
    private final Scanner scanner;
    private final CompanyReader companyReader;


    @Override
    public int run() {
        Company company = companyReader.read();
        int opt;
        do {
            log.info("Elija una opción: ");
            log.info("1. Mostrar Departamentos");
            log.info("2. Empleados del Departamento");
            log.info("3. Ver Departamentos");
            log.info("4. Ver Departamentos");
            log.info("5. Salir. . .");
            opt = scanner.nextInt();
            scanner.nextLine();
            if (opt == 1) {
                company.showInfo();
            } else if (opt == 2) {
                log.info("Introduce el nombre del departamento");
                String name = scanner.nextLine();
                try {
                    List<Employee> employees = company.findEmployees(name);
                    for (Employee employee : employees) {
                        employee.showInfo();
                    }
                } catch (DepartmentNotFoundException e) {
                    log.error("Departamento no encontrado");
                }

            } else if (opt == 3) {
                String name = scanner.nextLine();
                try {
                    Department department = company.findDeparment(name);
                    department.showInfo();
                } catch (DepartmentNotFoundException e) {
                    log.error("No se ha encontrado el puto departamento");
                }
            } else if (opt == 4) {
                String name = scanner.nextLine();
                try {
                    Employee employee = company.findEmployeeByNif(name);
                    employee.showInfo();

                } catch (EmployeeNoFoundException e) {
                    log.error("No se encuentra al empleado");
                }

            }

        } while (opt == 5);
        return opt;
    }

}

