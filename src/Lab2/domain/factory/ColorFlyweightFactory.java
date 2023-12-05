package Lab2.domain.factory;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class ColorFlyweightFactory {
    private static final Map<String, Color> colorFlyweights = new HashMap<>();

    public ColorFlyweightFactory() {
        // Private constructor to prevent instantiation
    }

    public static Color getColor(String colorType) {
        if (!colorFlyweights.containsKey(colorType)) {
            colorFlyweights.put(colorType, createColor(colorType));
        }
        return colorFlyweights.get(colorType);
    }

    private static Color createColor(String colorType) {
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
