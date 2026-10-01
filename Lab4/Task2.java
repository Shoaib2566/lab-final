class Employee {
    private String name;
    private double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double calculateSalary() {
        return baseSalary;
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }
}

class Developer extends Employee {
    private int overtimeHours;

    public Developer(String name, double baseSalary, int overtimeHours) {
        super(name, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + (overtimeHours * 500);
    }
}

public class Task2 {
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
