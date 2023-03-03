package app;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = EmployeeUtils.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalaryFilter = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println("Employee with highest salary in 2017:\n " + employeeMaxSalaryFilter);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> employees, int year) {
        Optional<Employee> maxSalaryEmployee = employees.stream()
                .filter(e -> e.getWorkStart().getYear() == year)
                .max(Comparator.comparing(Employee::getSalary));
        return maxSalaryEmployee.orElseThrow(() -> new RuntimeException("No employee found for the specified year"));
    }
}
