package Lab2.domain.models;

import java.awt.Color;
import java.awt.Graphics2D;

public class BorderDecorator extends ShapeDecorator {
    private Color borderColor;

    public BorderDecorator(Shape decoratedShape, Color borderColor) {
        super(decoratedShape);
        this.borderColor = borderColor;
    }

    @Override
    public Shape clone() {
        return new BorderDecorator(decoratedShape.clone(), borderColor);
    }

    @Override
    public void draw(Graphics2D g2d) {
        decoratedShape.draw(g2d);

        // Add border drawing logic based on bounds
        g2d.setColor(borderColor);
        Bounds bounds = decoratedShape.getBounds();

        if (decoratedShape instanceof Circle) {
            // Draw circular border for circles
            g2d.drawOval(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
        } else {
            // Draw rectangular border for other shapes
            g2d.drawRect(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
        }
    }

    @Override
    public Bounds getBounds() {
        Bounds decoratedBounds = decoratedShape.getBounds();
        int borderWidth = 1; // You may adjust this value based on your preferences for border width
        return new Bounds(decoratedBounds.getX() - borderWidth, decoratedBounds.getY() - borderWidth,
                decoratedBounds.getWidth() + 2 * borderWidth, decoratedBounds.getHeight() + 2 * borderWidth);
    }
}