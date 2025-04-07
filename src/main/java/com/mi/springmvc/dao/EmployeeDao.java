package com.mi.springmvc.dao;

import com.mi.springmvc.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    private static Map<Long, Employee> employees = null;

    static {
        employees = new HashMap<>();

        employees.put(1001L, new Employee(1001L, "E-AA", "aa@163.com", 1));
        employees.put(1002L, new Employee(1002L, "E-BB", "bb@163.com", 1));
        employees.put(1003L, new Employee(1003L, "E-CC", "cc@163.com", 0));
        employees.put(1004L, new Employee(1004L, "E-DD", "dd@163.com", 0));
        employees.put(1005L, new Employee(1005L, "E-EE", "ee@163.com", 1));
    }

    private static Long initId = 1006L;

    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employees.put(employee.getId(), employee);
    }

    public Collection<Employee> getAll() {
        return employees.values();
    }

    public Employee get(Long id) {
        return employees.get(id);
    }

    public void delete(Long id) {
        employees.remove(id);
    }


}
