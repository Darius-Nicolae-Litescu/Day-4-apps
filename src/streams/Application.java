package streams;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        Set<Employee> employeeSet = new HashSet<>();

        Employee e1 = new Employee("101", "Darius", 2000, 1, "GO");
        Employee e2 = new Employee("102", "Nicolae", 2000, 2, "Oracle");
        Employee e3 = new Employee("101", "Enterprise", 2000, 1, "Salesforce");
        Employee e4 = new Employee("103", "Pout", 3000, 1, "Java");
        Employee e5 = new Employee("104", "Turis", 1000, 1, "Salesforce");
        Employee e6 = new Employee("106", "Enterprise", 3000, 1, "GO");

        employeeSet.add(e1);
        employeeSet.add(e2);
        employeeSet.add(e3);
        employeeSet.add(e4);
        employeeSet.add(e5);
        employeeSet.add(e6);

        List<Employee> list = new ArrayList<>(employeeSet);
        System.out.println(list);

        Optional<Employee> highestSalary = list.stream().min((emp1, emp2) -> (emp2.getSalary() - emp1.getSalary()));

        Comparator<Employee> smallestSalaryComparator = (emp1, emp2) -> (emp1.getSalary() - emp2.getSalary());
        Optional<Employee> smallestSalary = list.stream().min(smallestSalaryComparator);

        if (highestSalary.isPresent()) {
            System.out.println("Highest salary " + highestSalary.get());
        } else {
            System.out.println("No highest salary employee available");
        }

        if (smallestSalary.isPresent()) {
            System.out.println("Smallest salary " + smallestSalary.get());
        } else {
            System.out.println("No smallest salary employee available");
        }

        //filter -> foreach
        list.stream()
                .filter((employee) -> employee.getEducation().equals("GO"))
                .forEach((employee -> employee.setSalary(employee.getSalary() + 1000)));
        System.out.println(list);

        //map -> new employees -> collect
        List<Employee> newList =
                list.stream().filter((employee) -> employee.getEducation().equals("GO"))
                        .map((employee -> new Employee(
                                employee.getId(),
                                employee.getName(),
                                employee.getSalary() + 1000,
                                employee.getBankAccount(),
                                employee.getEducation())))
                        .collect(Collectors.toList());
        System.out.println(newList);

        //map -> collect
        List<Employee> newList2 =
                list.stream().filter((employee) -> employee.getEducation().equals("GO"))
                        .map((employee -> {
                            employee.setSalary(employee.getSalary() + 1000);
                            return employee;
                        }))
                        .collect(Collectors.toList());
        System.out.println(newList2);
    }
}
