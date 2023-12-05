package Lab2.domain.models;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class ShapeGroup implements CompositeShape {
    private List<CompositeShape> shapes = new ArrayList<>();

    public void addShape(CompositeShape shape) {
        shapes.add(shape);
    }

    @Override
    public void draw(Graphics2D g2d) {
        for (CompositeShape shape : shapes) {
            shape.draw(g2d);
        }
    }

    @Override
    public Bounds getBounds() {
        Bounds groupBounds = null;
        for (CompositeShape shape : shapes) {
            Bounds shapeBounds = shape.getBounds();
            if (groupBounds == null) {
                groupBounds = shapeBounds;
            } else {
                groupBounds = unionBounds(groupBounds, shapeBounds);
            }
        }
        return groupBounds;
    }

    private Bounds unionBounds(Bounds bounds1, Bounds bounds2) {
        int minX = Math.min(bounds1.getX(), bounds2.getX());
        int minY = Math.min(bounds1.getY(), bounds2.getY());
        int maxX = Math.max(bounds1.getX() + bounds1.getWidth(), bounds2.getX() + bounds2.getWidth());
        int maxY = Math.max(bounds1.getY() + bounds1.getHeight(), bounds2.getY() + bounds2.getHeight());

        int width = maxX - minX;
        int height = maxY - minY;

        return new Bounds(minX, minY, width, height);
    }
}