/**
 * 2. Создать класс Employee (Сотрудник) с полями: String name, int age, double salary, String department
 * 2.1 Создать список из 10-20 сотрудников
 * 2.2 Вывести список всех различных отделов (department) по списку сотрудников
 * 2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
 * 2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела
 * 2.5 * Из списока сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела
 */


import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task2 {
    public static void main(String[] args) {


        // 2.2 Вывести список всех различных отделов (department) по списку сотрудников
        List<Employee> allEmployees = allEmployees();

        List<String> uniqueDepartments = allEmployees.stream()
                .map(Employee::getDepartment)
                .distinct() //Метод .distinct() в Java используется в стримах для удаления дубликатов элементов.
                .collect(Collectors.toList());

        System.out.println("The Unique departments are: " + uniqueDepartments);


//2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%

        allEmployees.stream()
                .filter(employee -> employee.getSalary() < 10_000)
                .forEach(employee -> {
                    employee.setSalary(employee.getSalary() * 1.20);
                    System.out.println("Name: " + employee.getName() + ", New Salary: " + employee.getSalary());
                });

// 2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела

        Map<String, List<Employee>> departmentsAndEmployees = allEmployees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("Departments and their employees: " + departmentsAndEmployees);

// 2.5 * Из списока сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела

        Map<String, Double> averageSalaryByDepartment = allEmployees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
        //averageinDouble является частью функциональности, предоставляемой API Stream,
        // и устраняет необходимость вручную написания реализации для вычисления среднего значения

        System.out.println("The departments and the average salary: " + averageSalaryByDepartment);

    }

    private static List<Employee> allEmployees() {
        return List.of(
                new Employee("John", 35, 5_000.00, "HR"),
                new Employee("Mike", 25, 10_000.00, "Security"),
                new Employee("Alice", 30, 7_000.00, "IT"),
                new Employee("Bob", 28, 8_500.00, "Finance"),
                new Employee("Eva", 33, 6_200.00, "Marketing"),
                new Employee("David", 29, 9_800.00, "Operations"),
                new Employee("Grace", 31, 7_500.00, "HR"),
                new Employee("Jack", 26, 10_500.00, "Security"),
                new Employee("Sophie", 32, 6_800.00, "IT"),
                new Employee("Chris", 27, 8_200.00, "Finance"),
                new Employee("Olivia", 34, 6_500.00, "Marketing"),
                new Employee("Ryan", 28, 9_200.00, "Operations"),
                new Employee("Emma", 29, 7_800.00, "HR"),
                new Employee("Jake", 24, 11_000.00, "Security"),
                new Employee("Lily", 31, 6_500.00, "IT"),
                new Employee("Daniel", 27, 8_900.00, "Finance"),
                new Employee("Mia", 30, 6_000.00, "Marketing"),
                new Employee("Nathan", 33, 9_500.00, "Operations")
        );

    }
}