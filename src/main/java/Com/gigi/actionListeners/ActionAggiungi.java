package Com.gigi.actionListeners;

import Com.gigi.Citta;
import Com.gigi.ItaliaDatabase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionAggiungi extends AactionSuperclasse implements ActionListener {
    private JTextField citta;
    private JTextField cap;
    private JTextField regione;

    public ActionAggiungi(ItaliaDatabase italiaDatabase, JTextField citta, JTextField cap, JTextField regione) {
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

        boolean cancellare = getItaliaDatabase().addCitta(new Citta(citta.getText(), cap.getText(), regione.getText()));
        if (cancellare){
            JOptionPane.showMessageDialog(null, "Inserita correttamente");
            regione.setText("");
            cap.setText("");
            citta.setText("");
        }
    }
}
