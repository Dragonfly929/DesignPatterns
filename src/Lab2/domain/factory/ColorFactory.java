package Lab2.domain.factory;

import java.awt.*;


// Singleton Pattern
public class ColorFactory {
    private static ColorFactory instance;

    private ColorFactory() {
        // Private constructor to prevent instantiation
    }

    public static ColorFactory getInstance() {
        if (instance == null) {
            instance = new ColorFactory();
        }
        return instance;
    }

    // also considered as Factory Method?
    public Color createColor(String colorType) {
        switch (colorType.toLowerCase()) {
            case "red":
                return Color.RED;
            case "blue":
                return Color.BLUE;
            case "green":
                return Color.GREEN;
            case "yellow":
                return Color.YELLOW;
            default:
                return Color.BLACK;
        }
    }
}