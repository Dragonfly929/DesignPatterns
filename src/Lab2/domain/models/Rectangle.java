package Lab2.domain.models;

import java.awt.Color;
import java.awt.Graphics2D;

public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height, Color color) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    public Rectangle(Rectangle source) {
        super(source);
        this.width = source.width;
        this.height = source.height;
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillRect(x, y, width, height);
    }

    @Override
    public Bounds getBounds() {
        return new Bounds(x, y, width, height);
    }
}