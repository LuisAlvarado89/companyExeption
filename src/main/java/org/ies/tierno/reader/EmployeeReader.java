package org.ies.tierno.reader;

import lombok.AllArgsConstructor;
import org.ies.tierno.model.Employee;

import java.util.Random;

@AllArgsConstructor
public class EmployeeReader implements Reader<Employee> {
    final static String[] NAMES = {"Pablo", "Juan", "Lucía", "Paloma", "Erick", "Shayla"};
    final static String[] SURNAMES = {"Lopez", "Perez", "Alvarez", "Fernandez", "Velasquez", "Díaz"};
    final static String[] ROLES = {"Jefe", "Peón", "Senior", "Programador", "Recruiter"};
    private final Random random;

    @Override
    public Employee read() {
        return new Employee(
                random.nextInt(10000000, 99999999) + "X",
                NAMES[random.nextInt(NAMES.length)],
                SURNAMES[random.nextInt(SURNAMES.length)],
                ROLES[random.nextInt(ROLES.length)]
        );
    }
}
