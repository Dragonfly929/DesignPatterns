package Lab2.domain.models;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class ShapeDecorator extends Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
        this.decoratedShape = decoratedShape;
    }

    @Override
    public abstract void draw(Graphics2D g2d);
}