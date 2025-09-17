public class Cylinder extends Circle {  // Save as Cylinder.java
   private final double height;

   // Default constructor
   public Cylinder() {
      super();   // call Circle()
      height = 1.0;
   }

   // Constructor with height
   public Cylinder(double height) {
      super();   // Circle()
      this.height = height;
   }

   // Constructor with radius & height
   public Cylinder(double radius, double height) {
      super(radius);  // Circle(radius)
      this.height = height;
   }

   // Constructor with radius, height, color
   public Cylinder(double radius, double height, String color) {
      super(radius, color);  // Circle(radius, color)
      this.height = height;
   }

   public double getHeight() {
      return height;
   }

   // Override getArea() → Surface area of cylinder
   @Override
   public double getArea() {
      double baseArea = super.getArea();
      double radius = getRadius();
      return 2 * Math.PI * radius * height + 2 * baseArea;
   }

   // Fix getVolume() → use Circle's area
   public double getVolume() {
      return super.getArea() * height;
   }

   @Override
   public String toString() {
      return "Cylinder: subclass of " + super.toString() + " height=" + height;
   }
}