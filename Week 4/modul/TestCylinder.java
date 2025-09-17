public class TestCylinder {
   public static void main(String[] args) {
      Cylinder c1 = new Cylinder();
      System.out.println(c1.toString());
      System.out.println("Volume=" + c1.getVolume());

      Cylinder c2 = new Cylinder(10.0);
      System.out.println(c2.toString());
      System.out.println("Volume=" + c2.getVolume());

      Cylinder c3 = new Cylinder(2.0, 10.0);
      System.out.println(c3.toString());
      System.out.println("Volume=" + c3.getVolume());

      Cylinder c4 = new Cylinder(3.0, 5.0, "blue");
      System.out.println(c4.toString());
      System.out.println("Volume=" + c4.getVolume());
   }
}