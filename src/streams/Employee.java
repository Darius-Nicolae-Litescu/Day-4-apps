package streams;

import java.util.Objects;

public class Employee implements Comparable<Employee> {
    private String id;
    private String name;
    private Integer salary;
    private Integer bankAccount;
    private String education;

    public Employee(){

    }

    public Employee(String id, String name, Integer salary, Integer bankAccount, String education) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.bankAccount = bankAccount;
        this.education = education;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(Integer bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", bankAccount=" + bankAccount +
                ", education='" + education + '\'' +
                "}\n";
    }


    @Override
    public int compareTo(Employee o) {
        return this.id.compareTo(o.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!Objects.equals(id, employee.id)) return false;
        if (!Objects.equals(name, employee.name)) return false;
        if (!Objects.equals(salary, employee.salary)) return false;
        if (!Objects.equals(bankAccount, employee.bankAccount))
            return false;
        return Objects.equals(education, employee.education);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (bankAccount != null ? bankAccount.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
        return result;
    }


}
