package Lab2.domain.models.bridge;

import Lab2.domain.models.bridge.Color;

public class RedColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Red Color");
    }
}
