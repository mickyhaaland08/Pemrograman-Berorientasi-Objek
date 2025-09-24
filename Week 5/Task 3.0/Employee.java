public class Employee {
    private String name;
    private double salary;
    private int day, month, year;

    public Employee(String name, double salary, int day, int month, int year) {
        this.name = name;
        this.salary = salary;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void raiseSalary(int percent) {
        salary += salary * percent / 100.0;
    }

    public void print() {
        System.out.println("Name: " + name + ", Salary: " + salary + ", Hire Date: " + day + "/" + month + "/" + year);
    }

    public double getSalary() {
        return salary;
    }
}