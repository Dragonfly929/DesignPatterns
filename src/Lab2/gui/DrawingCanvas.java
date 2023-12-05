package Lab2.gui;

import Lab2.domain.models.ShapeManager;

import javax.swing.*;
import java.awt.*;

public class DrawingCanvas extends JPanel {
    private static DrawingCanvas instance;

    private DrawingCanvas() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(800, 600));
        setDoubleBuffered(true);
    }

    public static DrawingCanvas getInstance() {
        if (instance == null) {
            instance = new DrawingCanvas();
        }
        return instance;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw all shapes stored in the ShapeManager
        ShapeManager.getInstance().drawShapes(g2d);
    }
}