public class EmployeeMain {
    public static void main(String[] args) {
        Employee[] employees = {
            new Manager("Ali", 100000, 25000),
            new Developer("Sara", 80000, 10),
            new Manager("Usman", 120000, 30000),
            new Developer("Ayesha", 75000, 20)
        };

        for (Employee e : employees) {
            System.out.println(e.getClass().getSimpleName() + " " + e.getName() + " Salary: " + e.calculateSalary());
        }
    }
}
