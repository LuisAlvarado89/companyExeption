package org.ies.tierno.reader;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Incubating;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

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
    }
}
