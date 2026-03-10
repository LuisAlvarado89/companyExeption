package org.ies.tierno;

import lombok.extern.log4j.Log4j;
import org.ies.tierno.reader.CompanyReader;
import org.ies.tierno.reader.DeparmentReader;
import org.ies.tierno.reader.EmployeeReader;

import java.util.Random;

@Log4j
public class main {
    public static void main(String[] args) {

        Random random = new Random();
        EmployeeReader employeeReader = new EmployeeReader(random);
        DeparmentReader deparmentReader = new DeparmentReader(random, employeeReader);
        CompanyReader companyReader = new CompanyReader(random, deparmentReader);

    }
}
