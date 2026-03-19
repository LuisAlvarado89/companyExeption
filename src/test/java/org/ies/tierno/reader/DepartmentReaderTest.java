package org.ies.tierno.reader;

import org.ies.tierno.model.Department;
import org.ies.tierno.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Random;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DepartmentReaderTest {

    @Mock
    private Random random;

    @InjectMocks

    private Reader<Employee> employeeReader;

    private DeparmentReader deparmentReader;


    @Test
    public void readTest() {
        when(random.nextInt(1, 10)).thenReturn(2);

        var emp1 = new Employee("1X", "Shayla", "Lopez", "Programadora");
        var emp2 = new Employee("2X", "Juan", "Rodriguez", "Manager");

        when(employeeReader.read())
                .thenReturn(emp1, emp2);
        when(random.nextInt(1, 100)).thenReturn(1);

        //Ejecucion

        Department dep = deparmentReader.read();

        //Comprobaciones
        Assertions.assertEquals("Departamento 1", dep.getName());

        Assertions.assertEquals(
                List.of(emp1, emp2),
                dep.getEmployees()
        );
    }
}

