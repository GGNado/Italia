package Com.gigi.actionListeners;

import Com.gigi.Citta;
import Com.gigi.ItaliaDatabase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionUpdate extends AactionSuperclasse implements ActionListener {
    private JTextField citta;
    private JTextField cap;
    private JTextField regione;
    public ActionUpdate(ItaliaDatabase italiaDatabase, JTextField citta, JTextField cap, JTextField regione) {
        super(italiaDatabase);
        this.citta = citta;
        this.cap = cap;
        this.regione = regione;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (citta.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Inserire citta", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cap.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Inserire cap", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cap.getText().length() != 5){
            JOptionPane.showMessageDialog(null, "Il CAP è formato da 5 numeri", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }


        if (regione.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Inserire regione", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Quale id modificare?"));
            boolean cancellare = getItaliaDatabase().updateCitta(new Citta(citta.getText(), cap.getText(), regione.getText()), id);
            if (cancellare){
                JOptionPane.showMessageDialog(null, "Modifica effettuata");
                regione.setText("");
                cap.setText("");
                citta.setText("");
            }
        } catch (NumberFormatException exception){
            System.out.println(exception);
        }

    }
}
