import javax.swing.*;
import java.awt.*;

public class FormularTest {
    public static void main(String[] args) {

        // 1. Ein leeres "Blatt Papier"
        JPanel panel = new JPanel(new GridLayout(0, 2));

        // 2. Erste Zeile: Beschriftung + Eingabefeld
        JTextField nachnameFeld = new JTextField();
        panel.add(new JLabel("Nachname:"));
        panel.add(nachnameFeld);

        // 3. Zweite Zeile: Beschriftung + Eingabefeld
        JTextField vornameFeld = new JTextField();
        panel.add(new JLabel("Vorname:"));
        panel.add(vornameFeld);

        // 4. Das Blatt in einem Dialog zeigen
        int antwort = JOptionPane.showConfirmDialog(null, panel, "Test",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // 5. Was hat der Benutzer eingegeben?
        if (antwort == JOptionPane.OK_OPTION) {
            System.out.println("Nachname: " + nachnameFeld.getText());
            System.out.println("Vorname: " + vornameFeld.getText());
        }
    }
}
