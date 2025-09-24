public class Manager extends Employee {
   private double bonus;
   
   public Manager(String name, double salary, int day, int month, int year, double bonus) {
       super(name, salary, day, month, year);
       this.bonus = bonus;
   }
   
   @Override
   public int compare(Sortable b) {
       if (!(b instanceof Manager)) {
           Employee eb = (Employee) b;
           double totalComp = getSalary() + bonus;
           if (totalComp < eb.getSalary()) return -1;
           if (totalComp > eb.getSalary()) return +1;
           return 0;
       }
       
       Manager mb = (Manager) b;
       double totalComp1 = getSalary() + bonus;
       double totalComp2 = mb.getSalary() + mb.bonus;
       
       if (totalComp1 < totalComp2) return -1;
       if (totalComp1 > totalComp2) return +1;
       return 0;
   }
   
   public double getBonus() { return bonus; }
   
   @Override
   public String toString() {
       return String.format("%s - Salary: %.0f, Bonus: %.0f, Total: %.0f", 
                          getName(), getSalary(), bonus, getSalary() + bonus);
   }
}