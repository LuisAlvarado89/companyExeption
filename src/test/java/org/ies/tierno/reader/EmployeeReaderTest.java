package org.ies.tierno.reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Incubating;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeReaderTest {

    @Mock
    private Random random;

    @InjectMocks
    private EmployeeReader employeeReader;

    @Test
    public void readTest() {
        when(random.nextInt(10000000, 99999999)).thenReturn(100000);
        when(random.nextInt(anyInt()))

                // Nombre
                .thenReturn(1)
                // Apellido
                .thenReturn(0)
                // Role
                .thenReturn(2);

        var employee = employeeReader.read();

        //Aserciones

        Assertions.assertEquals(
                "10000X",
                employee.getNif()
        );

        Assertions.assertEquals(
                "Erick",
                employee.getName()
        );
        Assertions.assertEquals(
                "Velasquez",
                employee.getSurname()
        );
        Assertions.assertEquals(
                "Senior",
                employee.getRole()
        );


    }
}
