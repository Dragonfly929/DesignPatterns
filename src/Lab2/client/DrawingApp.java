package Lab2.client;

import Lab2.domain.factory.ColorFlyweightFactory;
import Lab2.domain.models.ShapeManager;
import Lab2.gui.DrawingCanvas;
import Lab2.utilities.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingApp extends JFrame {
    private final DrawingCanvas canvas;
    private final DrawingFacade drawingFacade;

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

        drawingFacade = new DrawingFacade();
    }

    private void addControlButtons(JPanel controlPanel) {
        JButton drawCircleButton = new JButton("Draw Circle");
        drawCircleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = GUIUtil.getUserInput("Enter X coordinate:");
                int y = GUIUtil.getUserInput("Enter Y coordinate:");
                int radius = GUIUtil.getUserInput("Enter radius:");

                Color fillColor = chooseColor();
                drawingFacade.drawCircle(x, y, radius, fillColor);
            }
        });

        JButton drawCircleWithBorderButton = new JButton("Draw Circle with Border");
        drawCircleWithBorderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = GUIUtil.getUserInput("Enter X coordinate:");
                int y = GUIUtil.getUserInput("Enter Y coordinate:");
                int radius = GUIUtil.getUserInput("Enter radius:");

                Color fillColor = chooseColor();
                Color borderColor = chooseColor();
                drawingFacade.drawCircleWithBorder(x, y, radius, fillColor, borderColor);
            }
        });

        JButton drawRectangleButton = new JButton("Draw Rectangle");
        drawRectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = GUIUtil.getUserInput("Enter X coordinate:");
                int y = GUIUtil.getUserInput("Enter Y coordinate:");
                int width = GUIUtil.getUserInput("Enter width:");
                int height = GUIUtil.getUserInput("Enter height:");

                Color fillColor = chooseColor();
                drawingFacade.drawRectangle(x, y, width, height, fillColor);
            }
        });

        JButton drawRectangleWithBorderButton = new JButton("Draw Rectangle with Border");
        drawRectangleWithBorderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = GUIUtil.getUserInput("Enter X coordinate:");
                int y = GUIUtil.getUserInput("Enter Y coordinate:");
                int width = GUIUtil.getUserInput("Enter width:");
                int height = GUIUtil.getUserInput("Enter height:");

                Color fillColor = chooseColor();
                Color borderColor = chooseColor();
                drawingFacade.drawRectangleWithBorder(x, y, width, height, fillColor, borderColor);
            }
        });

        controlPanel.add(drawCircleButton);
        controlPanel.add(drawCircleWithBorderButton);
        controlPanel.add(drawRectangleButton);
        controlPanel.add(drawRectangleWithBorderButton);
    }

    private Color chooseColor() {
        String[] colors = {"Red", "Blue", "Green", "Yellow", "Black"};
        String selectedColor = (String) JOptionPane.showInputDialog(null,
                "Choose color:", "Color Selection", JOptionPane.QUESTION_MESSAGE, null,
                colors, colors[0]);

        return ColorFlyweightFactory.getColor(selectedColor);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DrawingApp().setVisible(true);
        });
    }
}