package Lab2.client;

import Lab2.domain.factory.CircleFactory;
import Lab2.domain.factory.RectangleFactory;
import Lab2.domain.factory.ShapeFactory;
import Lab2.domain.models.Shape;
import Lab2.domain.models.BorderDecorator;
import Lab2.domain.models.ShapeManager;
import Lab2.utilities.GUIUtil;

import java.awt.Color;

public class DrawingFacade {
    private final CircleFactory circleFactory;
    private final RectangleFactory rectangleFactory;

    public DrawingFacade() {
        this.circleFactory = new CircleFactory();
        this.rectangleFactory = new RectangleFactory();
    }

    public void drawCircle(int x, int y, int radius, Color fillColor) {
        Shape shape = circleFactory.createShape(x, y, new int[]{radius}, fillColor);
        ShapeManager.getInstance().addShape(shape);
    }

    public void drawCircleWithBorder(int x, int y, int radius, Color fillColor, Color borderColor) {
        Shape shape = circleFactory.createShape(x, y, new int[]{radius}, fillColor);
        Shape decoratedShape = new BorderDecorator(shape, borderColor);
        ShapeManager.getInstance().addShape(decoratedShape);
    }

    public void drawRectangle(int x, int y, int width, int height, Color fillColor) {
        Shape shape = rectangleFactory.createShape(x, y, new int[]{width, height}, fillColor);
        ShapeManager.getInstance().addShape(shape);
    }

    public void drawRectangleWithBorder(int x, int y, int width, int height, Color fillColor, Color borderColor) {
        Shape shape = rectangleFactory.createShape(x, y, new int[]{width, height}, fillColor);
        Shape decoratedShape = new BorderDecorator(shape, borderColor);
        ShapeManager.getInstance().addShape(decoratedShape);
    }
}