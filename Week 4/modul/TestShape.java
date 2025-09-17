public class TestShape {
   public static void main(String[] args) {
      // Test CircleShape
      CircleShape c1 = new CircleShape(5.5, "RED", false);
      System.out.println(c1);
      System.out.println("Area: " + c1.getArea());
      System.out.println("Perimeter: " + c1.getPerimeter());
      System.out.println();

      // Test Rectangle
      Rectangle r1 = new Rectangle(1.0, 2.0, "yellow", true);
      System.out.println(r1);
      System.out.println("Area: " + r1.getArea());
      System.out.println("Perimeter: " + r1.getPerimeter());
      System.out.println();

      // Test Square
      Square s1 = new Square(6.6);
      System.out.println(s1);
      System.out.println("Area: " + s1.getArea());
      System.out.println("Perimeter: " + s1.getPerimeter());
      System.out.println();

      // Test Square side modification
      s1.setSide(7.7);
      System.out.println("After setting side to 7.7:");
      System.out.println(s1);
      System.out.println("Side: " + s1.getSide());
   }
}