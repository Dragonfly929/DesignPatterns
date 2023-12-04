package Lab2.domain.models;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Shape {
    protected int x;
    protected int y;
    protected Color color;

    public Shape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Shape(Shape source) {
        this.x = source.x;
        this.y = source.y;
        this.color = source.color;
    }

    public abstract Shape clone();

    public abstract void draw(Graphics2D g2d);

    public abstract Bounds getBounds();
}