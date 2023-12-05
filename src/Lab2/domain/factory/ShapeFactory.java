package Lab2.domain.factory;

import Lab2.domain.models.Shape;

import java.awt.Color;

// Factory Method
public interface ShapeFactory {
    Shape createShape(int x, int y, int[] dimensions, Color color);
}