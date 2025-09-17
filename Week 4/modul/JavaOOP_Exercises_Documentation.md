# Java OOP Exercises Documentation
**Date**: September 17, 2025  
**Author**: Programming Exercise Documentation  

---

## Table of Contents
1. [Exercise 1: Circle & Cylinder](#exercise-1-circle--cylinder)
2. [Exercise 2: Shape Hierarchy](#exercise-2-shape-hierarchy)
3. [Exercise 3: Employee System with Abstract Classes](#exercise-3-employee-system-with-abstract-classes)
4. [Key OOP Concepts Demonstrated](#key-oop-concepts-demonstrated)

---

## Exercise 1: Circle & Cylinder

### Overview
This exercise demonstrates **inheritance** and **method overriding** by creating a `Circle` base class and a `Cylinder` subclass that extends it.

### Code Implementation

#### Circle.java
```java
/**
 * The Circle class models a circle with a radius and color.
 */
public class Circle {  // Save as Circle.java
   private double radius;
   private String color;

   // Default constructor
   public Circle() {
      radius = 1.0;
      color = "red";
   }

   // Constructor with radius
   public Circle(double r) {
      radius = r;
      color = "red";
   }

   // Constructor with radius and color
   public Circle(double r, String c) {
      radius = r;
      color = c;
   }

   public double getRadius() {
      return radius;
   }

   public String getColor() {
      return color;
   }

   public void setColor(String c) {
      this.color = c;
   }

   public double getArea() {
      return radius * radius * Math.PI;
   }

   @Override
   public String toString() {
      return "Circle[radius=" + radius + ", color=" + color + "]";
   }
}
```

**Key Features:**
- **Encapsulation**: Private fields `radius` and `color`
- **Multiple Constructors**: Default, with radius, and with radius & color
- **Area Calculation**: Using formula πr²
- **toString() Override**: Custom string representation

#### Cylinder.java
```java
public class Cylinder extends Circle {  // Save as Cylinder.java
   private double height;

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
```

**Key Features:**
- **Inheritance**: Extends Circle class
- **Constructor Chaining**: Uses `super()` to call parent constructors
- **Method Overriding**: Overrides `getArea()` for cylinder surface area
- **Volume Calculation**: Base area × height
- **Super Usage**: Calls parent methods with `super.getArea()`

#### TestCylinder.java
```java
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
```

### Output
```
Cylinder: subclass of Circle[radius=1.0, color=red] height=1.0
Volume=3.141592653589793
Cylinder: subclass of Circle[radius=1.0, color=red] height=10.0
Volume=31.41592653589793
Cylinder: subclass of Circle[radius=2.0, color=red] height=10.0
Volume=125.66370614359172
Cylinder: subclass of Circle[radius=3.0, color=blue] height=5.0
Volume=141.3716694115407
```

### Explanation
- **c1**: Default cylinder (radius=1.0, height=1.0) → Volume = π × 1² × 1 = 3.14
- **c2**: Height=10.0, default radius=1.0 → Volume = π × 1² × 10 = 31.4
- **c3**: Radius=2.0, height=10.0 → Volume = π × 2² × 10 = 125.7
- **c4**: Radius=3.0, height=5.0, blue color → Volume = π × 3² × 5 = 141.4

---

## Exercise 2: Shape Hierarchy

### Overview
This exercise demonstrates a complete **inheritance hierarchy** with `Shape` as the superclass and `Circle`, `Rectangle`, and `Square` as subclasses.

### Code Implementation

#### Shape.java
```java
public class Shape {
   private String color;
   private boolean filled;

   public Shape() {
      color = "green";
      filled = true;
   }

   public Shape(String color, boolean filled) {
      this.color = color;
      this.filled = filled;
   }

   public String getColor() { return color; }
   public void setColor(String color) { this.color = color; }

   public boolean isFilled() { return filled; }
   public void setFilled(boolean filled) { this.filled = filled; }

   @Override
   public String toString() {
      return "A Shape with color of " + color + " and " +
             (filled ? "filled" : "not filled");
   }
}
```

#### CircleShape.java
```java
public class CircleShape extends Shape {
   private double radius;

   public CircleShape() {
      radius = 1.0;
   }

   public CircleShape(double radius) {
      this.radius = radius;
   }

   public CircleShape(double radius, String color, boolean filled) {
      super(color, filled);
      this.radius = radius;
   }

   public double getRadius() { return radius; }
   public void setRadius(double radius) { this.radius = radius; }

   public double getArea() { return Math.PI * radius * radius; }
   public double getPerimeter() { return 2 * Math.PI * radius; }

   @Override
   public String toString() {
      return "A Circle with radius=" + radius + ", which is a subclass of " + super.toString();
   }
}
```

#### Rectangle.java
```java
public class Rectangle extends Shape {
   private double width;
   private double length;

   public Rectangle() {
      width = 1.0;
      length = 1.0;
   }

   public Rectangle(double width, double length) {
      this.width = width;
      this.length = length;
   }

   public Rectangle(double width, double length, String color, boolean filled) {
      super(color, filled);
      this.width = width;
      this.length = length;
   }

   public double getWidth() { return width; }
   public void setWidth(double width) { this.width = width; }

   public double getLength() { return length; }
   public void setLength(double length) { this.length = length; }

   public double getArea() { return width * length; }
   public double getPerimeter() { return 2 * (width + length); }

   @Override
   public String toString() {
      return "A Rectangle with width=" + width + " and length=" + length +
             ", which is a subclass of " + super.toString();
   }
}
```

#### Square.java
```java
public class Square extends Rectangle {
   public Square() {
      super(1.0, 1.0);
   }

   public Square(double side) {
      super(side, side);
   }

   public Square(double side, String color, boolean filled) {
      super(side, side, color, filled);
   }

   public double getSide() { return getLength(); }
   public void setSide(double side) {
      super.setLength(side);
      super.setWidth(side);
   }

   @Override
   public void setLength(double side) { setSide(side); }

   @Override
   public void setWidth(double side) { setSide(side); }

   @Override
   public String toString() {
      return "A Square with side=" + getSide() + ", which is a subclass of " + super.toString();
   }
}
```

### Output
```
A Circle with radius=5.5, which is a subclass of A Shape with color of RED and not filled
Area: 95.03317777109123
Perimeter: 34.55751918948772

A Rectangle with width=1.0 and length=2.0, which is a subclass of A Shape with color of yellow and filled
Area: 2.0
Perimeter: 6.0

A Square with side=6.6, which is a subclass of A Rectangle with width=6.6 and length=6.6, which is a subclass of A Shape with color of green and filled
Area: 43.559999999999995
Perimeter: 26.4

After setting side to 7.7:
A Square with side=7.7, which is a subclass of A Rectangle with width=7.7 and length=7.7, which is a subclass of A Shape with color of green and filled
Side: 7.7
```

---

## Exercise 3: Employee System with Abstract Classes

### Overview
This exercise demonstrates **abstract classes**, **inheritance**, and **sorting algorithms** using an Employee management system.

### Code Implementation

#### Sortable.java (Abstract Class)
```java
abstract class Sortable {
   public abstract int compare(Sortable b);

   public static void shell_sort(Sortable[] a) {
      int n = a.length;
      int gap = n / 2;
      while (gap > 0) {
         for (int i = gap; i < n; i++) {
            Sortable temp = a[i];
            int j = i;
            while (j >= gap && a[j - gap].compare(temp) > 0) {
               a[j] = a[j - gap];
               j -= gap;
            }
            a[j] = temp;
         }
         gap /= 2;
      }
   }
}
```

**Key Features:**
- **Abstract Class**: Cannot be instantiated directly
- **Abstract Method**: `compare()` must be implemented by subclasses
- **Shell Sort Algorithm**: Static method for sorting Sortable objects

#### Employee.java
```java
class Employee extends Sortable {
   private String name;
   private double salary;
   private int hireday, hiremonth, hireyear;

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
```

**Key Features:**
- **Extends Abstract Class**: Implements required `compare()` method
- **Salary Comparison**: Compares employees by salary for sorting
- **Salary Raise**: Percentage-based salary increase

#### Manager.java
```java
import java.util.*;

class Manager extends Employee {
   private String secretaryName;

   public Manager(String n, double s, int d, int m, int y) {
      super(n, s, d, m, y);
      secretaryName = "";
   }

   @Override
   public void raiseSalary(double byPercent) {
      GregorianCalendar today = new GregorianCalendar();
      int currentYear = today.get(Calendar.YEAR);
      double bonus = 0.5 * (currentYear - hireYear());
      super.raiseSalary(byPercent + bonus);
   }

   public String getSecretaryName() { return secretaryName; }
}
```

**Key Features:**
- **Method Overriding**: Enhanced `raiseSalary()` with experience bonus
- **Bonus Calculation**: 0.5% per year of service
- **Super Call**: Uses parent's `raiseSalary()` method

### Output
```
Before salary raise:
Antonio Rossi 2000000.0 1989
Maria Bianchi 2500000.0 1991
Isabel Vidal 3000000.0 1993

After 5% salary raise:
Antonio Rossi 2100000.0 1989
Maria Bianchi 3050000.0 1991
Isabel Vidal 3150000.0 1993

Sorting by salary...
Antonio Rossi 2100000.0 1989
Maria Bianchi 3050000.0 1991
Isabel Vidal 3150000.0 1993
```

### Explanation
1. **Initial Salaries**: Antonio (2M), Maria (2.5M), Isabel (3M)
2. **After 5% Raise**: 
   - Antonio: 2M × 1.05 = 2.1M
   - Maria (Manager): 2.5M × 1.05 + bonus = 3.05M (extra bonus for experience)
   - Isabel: 3M × 1.05 = 3.15M
3. **Sorting**: Already sorted by salary (ascending order)

---

## Key OOP Concepts Demonstrated

### 1. Inheritance
- **Circle** → **Cylinder**: Cylinder inherits from Circle
- **Shape** → **CircleShape, Rectangle**: Subclasses inherit properties
- **Rectangle** → **Square**: Square inherits from Rectangle
- **Employee** → **Manager**: Manager inherits from Employee

### 2. Method Overriding
- `toString()`: Custom string representations in all classes
- `getArea()`: Different calculations for Circle vs Cylinder
- `raiseSalary()`: Enhanced version in Manager class

### 3. Abstract Classes
- **Sortable**: Abstract class with abstract `compare()` method
- **Employee**: Concrete implementation of abstract method

### 4. Encapsulation
- **Private fields**: All classes use private member variables
- **Public methods**: Controlled access through getters/setters

### 5. Polymorphism
- **Employee array**: Can hold both Employee and Manager objects
- **Shape hierarchy**: Different shapes with common interface

### 6. Constructor Chaining
- **super()** calls: Subclasses call parent constructors
- **Multiple constructors**: Overloaded constructors for flexibility

### 7. Static Methods
- **Shell Sort**: Static sorting algorithm in Sortable class

---

## Compilation and Execution Commands

### Exercise 1:
```bash
javac Circle.java Cylinder.java TestCylinder.java
java TestCylinder
```

### Exercise 2:
```bash
javac Shape.java CircleShape.java Rectangle.java Square.java TestShape.java
java TestShape
```

### Exercise 3:
```bash
javac Sortable.java Employee.java Manager.java EmployeeTest.java
java EmployeeTest
```

---

## Conclusion

These exercises successfully demonstrate fundamental Java OOP concepts:
- **Inheritance** enables code reuse and establishes "is-a" relationships
- **Method overriding** allows specialized behavior in subclasses
- **Abstract classes** provide common interface while forcing implementation
- **Encapsulation** protects data and controls access
- **Polymorphism** enables treating different objects uniformly

The exercises progress from simple inheritance (Circle/Cylinder) to complex hierarchies (Shape family) to abstract classes with algorithms (Employee system), providing a comprehensive understanding of Java OOP principles.