package Lab2.domain.factory;

import Lab2.domain.models.Rectangle;
import Lab2.domain.models.Shape;

import java.awt.Color;

public class RectangleFactory implements ShapeFactory {
    @Override
    public Shape createShape(int x, int y, int[] dimensions, Color color) {
        return new Rectangle(x, y, dimensions[0], dimensions[1], color);
    }
}
