package Lab2.gui;

import javax.swing.*;

public class GUIUtil {
    public static int getUserInput(String message) {
        String input = JOptionPane.showInputDialog(null, message);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
