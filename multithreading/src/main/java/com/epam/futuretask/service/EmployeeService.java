package com.epam.futuretask.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import com.epam.futuretask.entity.Employee;
import com.google.common.collect.ImmutableList;

public class EmployeeService {

    public static final List<String> FIRST_NAMES = ImmutableList.of(
            "Aliaksei", "Igar", "Oleg", "Oleksandr", "Oleksii", "Artemy"
    );

    public static final List<String> LAST_NAMES = ImmutableList.of(
            "Bezpalyu", "Klimovich", "Bliznichenka", "Korshak", "Kuzik", "Zhabinka", "Mikalayu", "Tewari", "Tripathy"
    );

    public static final int MIN_SALARY = 9000;
    public static final int MAX_SALARY = 15000;

    public Future<List<Employee>> getEmployees() {
        CompletableFuture<List<Employee>> employees = new CompletableFuture<>();
        employees.completeAsync(this::generateRandomEmployees);
        return employees;
    }

    public Future<Integer> getSalary(int id) {
        CompletableFuture<Integer> futureSalary = new CompletableFuture<>();
        futureSalary.completeAsync(() -> {
            Random random = new Random();
            return random.nextInt(MIN_SALARY, MAX_SALARY);
        });
        return futureSalary;
    }

    private List<Employee> generateRandomEmployees() {
        Random random = new Random();
        List<Employee> res = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            res.add(new Employee(i,
                    FIRST_NAMES.get(random.nextInt(FIRST_NAMES.size())),
                    LAST_NAMES.get(random.nextInt(LAST_NAMES.size())),
                    random.nextInt(MIN_SALARY, MAX_SALARY)));
        }
        return res;
    }

}
