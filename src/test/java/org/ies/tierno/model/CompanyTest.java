package org.ies.tierno.model;

import org.ies.tierno.exeptions.DepartmentNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class CompanyTest {
    @Test
    public void findDepartmentTest() throws DepartmentNotFoundException {
        Company company = createTestCompany();

        Department department = company.findDeparment("IT");

        Assertions.assertEquals(
                new Department("IT", List.of(new Employee("1X", "Julian", "Perez", "Jefe"))),
                department
        );

    }

    private Company createTestCompany() {
        return new Company(
                "Ies Tierno SL",
                "A8989897X",
                Map.of(
                        "IT", new Department("IT", List.of(new Employee("1X", "Julian", "Perez", "Jefe"))),
                        "RRHH", new Department("RRHH", List.of(new Employee("2X", "Luis", "Alvarez", "Recuiter")))
                )
        );

    }

    @Test
    public void findDepartmentNotFoundTest() {
        Company company = createTestCompany();
        Assertions.assertThrows(
                DepartmentNotFoundException.class,
                () -> {
                    company.findDeparment("Otro");
                }
        );
    }


    @Test
    public void findEmployeeByDepartmentTest() throws DepartmentNotFoundException {
        Company company = createTestCompany();
        var res = company.findEmployees("IT");
        Assertions.assertEquals(
                List.of(
                        new Employee("Y17172X", "Erick", "Velasquez", "Informatico")),
                res
        );
    }
    @Test
    public void findEmployeeByDepartmentNotFoundTest() {
        Company company = createTestCompany();
        Assertions.assertThrows(
                DepartmentNotFoundException.class,
                ()-> {
                    company.findEmployees("Otro");
                }
        );
    }
}
