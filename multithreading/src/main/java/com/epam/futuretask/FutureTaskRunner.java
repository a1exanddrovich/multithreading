package com.epam.futuretask;

import com.epam.futuretask.service.EmployeeService;
import com.epam.futuretask.service.PrintService;

public class FutureTaskRunner {

    public static void main(String[] args) {
        PrintService printService = new PrintService(new EmployeeService());
        printService.printEmployeesSalary();
    }

}
