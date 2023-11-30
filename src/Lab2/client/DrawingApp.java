package Lab2.client;

import Lab2.domain.builder.ShapeBuilder;
import Lab2.domain.factory.CircleFactory;
import Lab2.domain.factory.RectangleFactory;
import Lab2.domain.factory.ShapeFactory;
import Lab2.domain.models.Shape;
import Lab2.domain.models.ShapeManager;
import Lab2.gui.DrawingCanvas;
import Lab2.gui.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingApp extends JFrame {
    private final DrawingCanvas canvas;

    public DrawingApp() {
        setTitle("✨Drawing App✨");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        canvas = DrawingCanvas.getInstance();
        add(canvas);

        JPanel controlPanel = new JPanel();
        addControlButtons(controlPanel);
        add(controlPanel, BorderLayout.SOUTH);
    }

    private void addControlButtons(JPanel controlPanel) {
        JButton drawCircleButton = new JButton("Draw Circle");
        drawCircleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawShape(new CircleFactory());
            }
        });

        JButton drawRectangleButton = new JButton("Draw Rectangle");
        drawRectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawShape(new RectangleFactory());
            }
        });

        controlPanel.add(drawCircleButton);
        controlPanel.add(drawRectangleButton);
    }

    private void drawShape(ShapeFactory shapeFactory) {
        int x = GUIUtil.getUserInput("Enter X coordinate:");
        int y = GUIUtil.getUserInput("Enter Y coordinate:");

        int[] dimensions = null;

        if (shapeFactory instanceof RectangleFactory) {
            dimensions = new int[2];
            dimensions[0] = GUIUtil.getUserInput("Enter width:");
            dimensions[1] = GUIUtil.getUserInput("Enter height:");
        } else if (shapeFactory instanceof CircleFactory) {
            dimensions = new int[1];
            dimensions[0] = GUIUtil.getUserInput("Enter radius:");
        }

        Color color = chooseColor();

        ShapeBuilder shapeBuilder = new ShapeBuilder();
        Shape shape = (Shape) shapeBuilder
                .setX(x)
                .setY(y)
                .setDimensions(dimensions)
                .setColor(color)
                .build(shapeFactory);

        ShapeManager.getInstance().addShape(shape);
    }

    private Color chooseColor() {
        String[] colors = {"Red", "Blue", "Green", "Yellow", "Black"};
        String selectedColor = (String) JOptionPane.showInputDialog(null,
                "Choose color:", "Color Selection", JOptionPane.QUESTION_MESSAGE, null,
                colors, colors[0]);

        switch (selectedColor) {
            case "Red":
                return Color.RED;
            case "Blue":
                return Color.BLUE;
            case "Green":
                return Color.GREEN;
            case "Yellow":
                return Color.YELLOW;
            case "Black":
            default:
                return Color.BLACK;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DrawingApp().setVisible(true);
        });
    }
}
