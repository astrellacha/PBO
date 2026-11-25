import java.sql.Connection;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SurvivalFrame().setVisible(true));
    }
}