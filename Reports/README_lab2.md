# Topic: *Creational Design Patterns*
### Course: TMPS
### Author: Maia Zaica

----

## Theory

**Creational design patterns** abstract the instantiation process.They help make a
system independent of how its objects are created,composed, and represented. A
class creational pattern uses inheritance to vary the class that's instantiated,
whereas an object creational pattern will delegate instantiation to another object.

**Creational design patterns** provide various object creation mechanism, which
increase flexibility and reuse of existing code.

**Creational patterns** give you a lot of flexibility in what
getscreated, who creates it, how it gets created, and when. They let you configure
a system with "product" objects thatvary widely in structure and functionality.
Configuration can bestatic (that is, specified at compile-time) or dynamic
(atrun-time).
### Factory Method
Factory Method is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.

### Builder
Builder is a creational design pattern that lets you construct complex objects step by step. The pattern allows you to produce different types and representations of an object using the same construction code.

### Prototype
Prototype is a creational design pattern that lets you copy existing objects without making your code dependent on their classes.

### Singleton
Singleton is a creational design pattern that lets you ensure that a class has only one instance, while providing a global access point to this instance.

A type of object that can only be instantiated once

## Objectives:
&ensp; &ensp; __1. Study and understand the Creational Design Patterns.__

&ensp; &ensp; __2. Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.__

&ensp; &ensp; __3. Use some creational design patterns for object instantiation in a sample project.__

## Implementation

simple drawing application that demonstrates the use of creational design patterns

## Table of Contents

- [Overview](#overview)
- [Creational Design Patterns](#creational-design-patterns)
    - [1. Singleton Pattern](#1-singleton-pattern)
    - [2. Factory Method Pattern](#2-factory-method-pattern)
    - [3. Builder Pattern](#3-builder-pattern)
    - [4. Prototype Pattern](#4-prototype-pattern)

## Overview

The application allows users to draw circles and rectangles on a canvas. It incorporates four creational design patterns: Singleton, Factory Method, Builder, and Prototype.

## Creational Design Patterns

### 1. Singleton Pattern

The `ShapeManager` class is implemented as a singleton to manage a single instance of shape storage.

```java
public class ShapeManager {
    // Singleton implementation...
}
```
implementiong singleton class called `ShapeManager`, we'll give it a static instance property and make it's constructor private so that it cannot be instantiated with a new keyword, we then create a static instance method
that will check to see if the instance has alreadybeen created and if notit will create a new one, and that ensures taht only one object can be created
```java
    private static ShapeManager instance;
```
```java
    private ShapeManager() {
        shapes = new ArrayList<>();
        }
```
```java
    public static ShapeManager getInstance() {
        if (instance == null) {
            instance = new ShapeManager();
        }
        return instance;
    }
```

### 2. Factory Method Pattern
Shapes are created through the `ShapeFactory` interface, with concrete factories for circles and rectangles.
```java
public interface ShapeFactory {
    Shape createShape(int x, int y, int[] dimensions, Color color);
}

public class CircleFactory implements ShapeFactory {
    // factory method for creating circles
}

public class RectangleFactory implements ShapeFactory {
    // factory method for creating rectangles
}
```
- Implemented in the `ShapeFactory` interface and concrete classes (`CircleFactory`, `RectangleFactory`).
- The `createShape` method is responsible for creating instances of shapes.

we can add shapes and other things we want

instead of using new keyword to instantiate an object we use a function or method to do it for us
### 3. Builder Pattern

The ShapeBuilder class provides a fluent interface for building Shape objects

```java
public class ShapeBuilder {
    // Builder implementation...
}
```

- Implemented in the `ShapeBuilder` class.
- Provides a fluent interface (`setX`, `setY`, `setDimensions`, `setColor`, and `build`) for constructing complex objects (`Shape` instances).

with builder pattern we create an object step by step using methods rather than a constructor, and we can even delegate the building logic to an entirely different class(method chianing)
````java
       ShapeBuilder shapeBuilder = new ShapeBuilder();
        Shape shape = (Shape) shapeBuilder
                .setX(x)
                .setY(y)
                .setDimensions(dimensions)
                .setColor(color)
                .build(shapeFactory);
````
### 4. Prototype Pattern

The Prototype Pattern is a creational design pattern that allows for the creation of new objects by copying an existing object, known as the prototype. This pattern is particularly useful when the cost of creating a new object is more expensive or complex than copying an existing one.

The Shape class declares an abstract method clone, which must be implemented by its concrete subclasses.
```java
public abstract class Shape {
    protected int x;
    protected int y;
    protected Color color;

    // other common attributes and methods

    public abstract Shape clone();
}
```
- Implemented in the `Shape` class and its subclasses (`Circle`, `Rectangle`).
- The `clone` method is declared in the `Shape` class and overridden in concrete classes to create a copy of the object.

in simple words a clone, from oo we are familiar with inheritance, where a class can be extended with a subclass, one problem with inheritance is that it can lead to a complex hierarchy of code
, the prototype pattern is an alternative way to implement inheritance but instead of inheriting functionality from a class, it comes from an object that's already been created, this creates a flat prototype chain that makes it much easier to share functionality between objects
**Concrete Shape Classes**

Concrete shape classes, such as Circle and Rectangle, extend the Shape class and provide their own implementations of the clone method.

`Circle` class
```java
public class Circle extends Shape {
    private int radius;

    public Circle(int x, int y, int radius, Color color) {
        super(x, y, color);
        this.radius = radius;
    }

    @Override
    public Shape clone() {
        return new Circle(this.x, this.y, this.radius, this.color);
    }

    // other methods...
}
```
`Rectangle` class
```java
public class Rectangle extends Shape {
private int width;
private int height;

    public Rectangle(int x, int y, int width, int height, Color color) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public Shape clone() {
        return new Rectangle(this.x, this.y, this.width, this.height, this.color);
    }

    // other methods...
}
```
**Client usage**

In the client code, such as the DrawingApp, the Prototype Pattern is applied when creating new shapes.
```java
Circle originalCircle = new Circle(10, 10, 20, Color.RED);

// clone the original circle to create a new one
Circle clonedCircle = (Circle) originalCircle.clone();

```
By using the clone method, a new object is created with the same properties as the original one. This approach is advantageous when creating multiple similar objects with slight variations.

The Prototype Pattern simplifies object creation and ensures that the new objects are consistent with the existing ones.

## References:
[1]. Gamma, E., Vlissides, J., Helm, R., & Johnson, R. (1994). *Design Patterns: Elements of Reusable Object-Oriented Software* (1st ed.).

[2]. Refactoring GURU. [*Creational Design Patterns*](https://refactoring.guru/design-patterns/creational-patterns)

[3]. Mosh HAMEDANI. [*Design Patterns in Plain English*](https://www.youtube.com/watch?v=NU_1StN5Tkk&ab_channel=ProgrammingwithMosh)

[4]. [*10 Design Patterns Explained in 10 Minutes*](https://www.youtube.com/watch?v=tv-_1er1mWI&ab_channel=Fireship)