package Lab2.domain.models;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public interface CompositeShape {
    void draw(Graphics2D g2d);
    Bounds getBounds();
}
