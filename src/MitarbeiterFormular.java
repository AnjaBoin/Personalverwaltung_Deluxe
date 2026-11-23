import javax.swing.*;
import java.awt.*;

public class MitarbeiterFormular {
    // FELDER
    private JPanel panel;
    private JComponent[] felder = new JComponent[Mitarbeiter.FELDER_SQL.length];
    // hier merkst du dir die Eingabefelder (siehe unten)

    // KONSTRUKTOR: baut das Formular auf
    public MitarbeiterFormular() {
        panel = new JPanel(new GridLayout(0, 2));
        // für jeden Feldnamen in Mitarbeiter.FELDER_SQL:
        for (int i = 0; i < Mitarbeiter.FELDER_SQL.length; i++) {
            String name = Mitarbeiter.FELDER_SQL[i];
            JComponent feld;
            if (name.equals("Status")) {
                feld = new JCheckBox();
            } else if (name.equals("Abteilung")) {
                feld = new JComboBox<>(Abteilung.getAbteilungen());
            } else {
                feld = new JTextField();
            }
            felder[i] = feld;
            panel.add(new JLabel(name + ":"));
            panel.add(feld);
        }
    }

    // zeigt das Formular und gibt zurück, ob OK gedrückt wurde
    public boolean zeigen(JFrame frame, String titel) {
        int antwort = JOptionPane.showConfirmDialog(frame, panel, titel,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        return antwort == JOptionPane.OK_OPTION;
    }

    public Mitarbeiter getMitarbeiter(String id) {
        String[] werte = new String[Mitarbeiter.SPALTEN.length];   // 11 Plätze
        werte[0] = id;

        for (int i = 0; i < felder.length; i++) {
            if (felder[i] instanceof JTextField tf) {
                werte[i + 1] = tf.getText();
            } else if (felder[i] instanceof JCheckBox cb) {
                werte[i + 1] = String.valueOf(cb.isSelected());
            } else if (felder[i] instanceof JComboBox<?> combo) {
                werte[i + 1] = String.valueOf(combo.getSelectedItem());
            }
        }
        return Mitarbeiter.ausZeile(werte);
    }

}
