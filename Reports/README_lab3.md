# Topic: *Structural Design Patterns*
### Course: TMPS
### Author: Maia Zaica


------
## Objectives:
&ensp; &ensp; __1. Study and understand the Structural Design Patterns.__

&ensp; &ensp; __2. As a continuation of the previous laboratory work, think about the functionalities that your system will need to provide to the user.__

&ensp; &ensp; __3. Implement some additional functionalities, or create a new project using structural design patterns.__

## Theoretical background:
&ensp; &ensp; Structural design patterns are a category of design patterns that focus on the composition of classes and objects to form larger structures and systems. They provide a way to organize objects and classes in a way that is both flexible and efficient, while allowing for the reuse and modification of existing code. Structural design patterns address common problems encountered in the composition of classes and objects, such as how to create new objects that inherit functionality from existing objects, how to create objects that share functionality without duplicating code, or how to define relationships between objects in a flexible and extensible way.

&ensp; &ensp; Some examples of from this category of design patterns are:

* Adapter
* Bridge
* Composite
* Decorator
* Facade
* Flyweight
* Proxy

Structural design patterns explain how to assemble objects and classes into larger structures, while keeping these structures flexible and efficient.

### Facade

---

**Facade** is a structural design pattern that provides a simplified interface to a library, a framework, or any other complex set of classes.

This project incorporates the **Facade pattern** to simplify the drawing process. The DrawingFacade class provides a high-level interface for drawing circles and rectangles, making it easier for users to interact with the application.

```java
// Example code snippet
public class DrawingFacade {
    // ... implementation details
}
```

```java
//DrawingApp.java

    private final DrawingFacade drawingFacade;
```
```java
// DrawingApp constructor
public DrawingApp() {
        // ... (existing code)

        // Initialize the DrawingFacade to simplify drawing operations
        drawingFacade = new DrawingFacade();
        }
```        
        
The project employs the **Facade pattern** to simplify the drawing process. The `DrawingFacade` class acts as a high-level interface, encapsulating the complexities of creating and drawing shapes. This simplification enhances the overall usability and readability of the code.

### Decorator


---
The project implements the decorator pattern to enhance the drawing app by allowing users to add borders to shapes.

**Decorator** is a structural design pattern that lets you attach new behaviors to objects by placing these objects inside special wrapper objects that contain the behaviors.

**Implementation Details**

- **Decorator Pattern:** Used to add new behavior (borders) to shapes dynamically.
- **Bounds Class:** Introduced to represent the dimensions of shapes and their decorators.
- **User Interaction:** Users can draw circles and rectangles with or without borders, choosing colors for both fill and border.


### Adapter

---

Adapter is a structural design pattern that allows objects with incompatible interfaces to collaborate.

Convert the interface of a class into another interface clients expect. Adapter
lets classes work together that couldn't otherwise because of incompatible
interfaces.

## References:
[1]. Gamma, E., Vlissides, J., Helm, R., & Johnson, R. (1994). *Design Patterns: Elements of Reusable Object-Oriented Software* (1st ed.).

[2]. Refactoring GURU. [*Structural Design Patterns*](https://refactoring.guru/design-patterns/structural-patterns)

[3]. [*10 Design Patterns Explained in 10 Minutes*](https://www.youtube.com/watch?v=tv-_1er1mWI&ab_channel=Fireship)