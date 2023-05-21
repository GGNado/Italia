package Com.gigi.actionListeners;

import Com.gigi.Citta;
import Com.gigi.ItaliaDatabase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionDelete extends AactionSuperclasse implements ActionListener {

    public ActionDelete(ItaliaDatabase italiaDatabase) {
        super(italiaDatabase);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Quale id cancellare?"));
            boolean cancellare = getItaliaDatabase().deleteCitta(id);
            if (cancellare){
                JOptionPane.showMessageDialog(null, "Eliminato");
            }
        } catch (NumberFormatException exception){
            System.out.println(exception);
        }
    }
}
