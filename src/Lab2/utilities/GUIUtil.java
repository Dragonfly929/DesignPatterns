package Lab2.utilities;

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

    public static boolean getBooleanInput(String message) {
        String[] options = {"Yes", "No"};
        int result = JOptionPane.showOptionDialog(
                null,
                message,
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        return result == JOptionPane.YES_OPTION;
    }
}
