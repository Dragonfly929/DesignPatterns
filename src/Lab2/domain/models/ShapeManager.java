package Lab2.domain.models;

import Lab2.gui.DrawingCanvas;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class ShapeManager {
    private static ShapeManager instance;
    private final List<Shape> shapes;

    private ShapeManager() {
        shapes = new ArrayList<>();
    }

    public static ShapeManager getInstance() {
        if (instance == null) {
            instance = new ShapeManager();
        }
        return instance;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
        repaintCanvas();
    }

    public void drawShapes(Graphics2D g2d) {
        for (Shape shape : shapes) {
            shape.draw(g2d);
        }
    }

    private static void repaintCanvas() {
        DrawingCanvas.getInstance().repaint();
    }
}
