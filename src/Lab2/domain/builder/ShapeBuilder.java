package Lab2.domain.builder;

import Lab2.domain.factory.ShapeFactory;
import Lab2.domain.models.Shape;

import java.awt.Color;

public class ShapeBuilder {
    private int x;
    private int y;
    private int[] dimensions;
    private Color color;

    public Lab2.domain.builder.ShapeBuilder setX(int x) {
        this.x = x;
        return this;
    }

    public ShapeBuilder setY(int y) {
        this.y = y;
        return this;
    }

    public ShapeBuilder setDimensions(int[] dimensions) {
        this.dimensions = dimensions;
        return this;
    }

    public ShapeBuilder setColor(Color color) {
        this.color = color;
        return this;
    }

    public Shape build(ShapeFactory shapeFactory) {
        return shapeFactory.createShape(x, y, dimensions, color);
    }
}