package org.ies.tierno.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.ies.tierno.exeptions.DepartmentNotFoundException;
import org.ies.tierno.exeptions.EmployeeNoFoundException;

import javax.xml.datatype.DatatypeConfigurationException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Log4j
@Data
@AllArgsConstructor
public class Company {
    private String name;
    private String cif;
    private Map<String, Department> departmentByName;

    public void showInfo() {
        for (Department department1 : departmentByName.values()) {
            department1.showInfo();
        }
    }

    public List<Employee> findEmployees(String name) throws DepartmentNotFoundException {

        return findDeparment(name).getEmployees();

        /*return Optional.ofNullable(departmentByName.get(name))
        .orElseThrow(DepartmentNotFoundException::new);*/
    }

    public Department findDeparment(String name) throws DepartmentNotFoundException {
        for (Department department : departmentByName.values()) {
            if (department.getName().equalsIgnoreCase(name)) {
                return department;
            }
        }
        throw new DepartmentNotFoundException();
    }

    public Employee findEmployeeByNif(String nif) throws EmployeeNoFoundException {
        for (Department department : departmentByName.values()) {
            for (Employee employee : department.getEmployees()) {
                if (employee.getNif().equals(nif)) {
                    return employee;
                }
            }
        }
        throw new EmployeeNoFoundException();

    }

}
