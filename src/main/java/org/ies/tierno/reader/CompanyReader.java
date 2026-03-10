package org.ies.tierno.reader;

import lombok.AllArgsConstructor;
import org.ies.tierno.model.Company;
import org.ies.tierno.model.Department;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@AllArgsConstructor

public class CompanyReader implements Reader<Company> {
    private final Random random;
    private final Reader<Department> departmentReader;


    @Override
    public Company read() {
        Map<String, Department> departmentByName = new HashMap<>();
        int numDeparments = random.nextInt(1, 10);
        for (int i = 0; i < numDeparments; i++) {
            Department department = departmentReader.read();
            departmentByName.put(department.getName(), department);

        }
        return new Company(
                "Company" + random.nextInt(1000),
                "A" + random.nextInt(10000000, 99999999),
                departmentByName
        );
    }

}
