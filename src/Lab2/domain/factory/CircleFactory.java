package Lab2.domain.factory;

import Lab2.domain.models.Circle;
import Lab2.domain.models.Shape;

import java.awt.Color;

public class CircleFactory implements ShapeFactory {
    @Override
    public Shape createShape(int x, int y, int[] dimensions, Color color) {
        return new Circle(x, y, dimensions[0], color);
    }
}
