
class Employee extends Sortable {
   private final String name;
   private double salary;
   private final int hireday, hiremonth, hireyear;

   public Employee(String n, double s, int d, int m, int y) {
      name = n;
      salary = s;
      hireday = d;
      hiremonth = m;
      hireyear = y;
   }

   public void print() {
      System.out.println(name + " " + salary + " " + hireYear());
   }

   public void raiseSalary(double byPercent) {
      salary *= 1 + byPercent / 100;
   }

   public int hireYear() { return hireyear; }

   @Override
   public int compare(Sortable b) {
      Employee eb = (Employee) b;
      if (this.salary < eb.salary) return -1;
      if (this.salary > eb.salary) return 1;
      return 0;
   }
}