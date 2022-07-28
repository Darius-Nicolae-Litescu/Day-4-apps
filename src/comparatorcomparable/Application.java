package comparatorcomparable;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Set<Employee> employeeSet = new HashSet<>();

        Employee e1 = new Employee(101, "mike", 2000, 1, "ADF-Java");
        Employee e2 = new Employee(102, "jenny", 2000, 2, "Oracle");
        Employee e3 = new Employee(101, "mike", 2000, 1, "Java");
        Employee e4 = new Employee(103, "mi", 3000, 1, "Java");
        Employee e5 = new Employee(104, "Yong", 1000, 1, "Salesforce");
        Employee e6 = new Employee(106, "Yong", 3000, 1, "ADF-Java");


        employeeSet.add(e1);
        employeeSet.add(e2);
        employeeSet.add(e3);
        employeeSet.add(e4);
        employeeSet.add(e5);
        employeeSet.add(e6);


        List<Employee> list = new ArrayList<>(employeeSet);

        System.out.println(list);

        System.out.println("\n------------------------\n");

        list.sort(new EmployeeSalaryComparator());
        System.out.println(list);

    }
}
