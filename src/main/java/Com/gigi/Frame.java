package Com.gigi;

import Com.gigi.actionListeners.ActionAggiungi;
import Com.gigi.actionListeners.ActionDelete;
import Com.gigi.actionListeners.ActionUpdate;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class Frame extends JFrame {
    ItaliaDatabase italiaDatabase = new ItaliaDatabase();
    public Frame(){
        setTitle("Rubrica");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(null);

        //TextField
        JTextField citta = new JTextField("Massa Lubrense");
        citta.setBounds(300, 25, 150, 40);
        panel.add(citta);

        JTextField cap = new JTextField("80061");
        cap.setBounds(citta.getX(), citta.getY() + 50, citta.getBounds().width, citta.getBounds().height);
        panel.add(cap);

        JTextField regione = new JTextField("Campania");
        regione.setBounds(cap.getX(), cap.getY() + 50, citta.getBounds().width, citta.getBounds().height);
        panel.add(regione);

        //labels
        JLabel nomeLabel = new JLabel("Citta");
        nomeLabel.setBounds(citta.getX() - 100, citta.getY() + 10, nomeLabel.getPreferredSize().width, nomeLabel.getPreferredSize().height);
        panel.add(nomeLabel);

        JLabel cognomeLabel = new JLabel("Cap");
        cognomeLabel.setBounds(cap.getX() - 100, cap.getY() + 10, cognomeLabel.getPreferredSize().width, cognomeLabel.getPreferredSize().height);
        panel.add(cognomeLabel);

        JLabel telefonoLabel = new JLabel("Regione");
        telefonoLabel.setBounds(regione.getX() - 100, regione.getY() + 10, telefonoLabel.getPreferredSize().width, telefonoLabel.getPreferredSize().height);
        panel.add(telefonoLabel);

        //Bottoni
        JButton aggiungi = new JButton("Aggiungi citta");
        aggiungi.setBounds(300, 400, 250, 50);
        panel.add(aggiungi);

        //ActionLsitener aggiungi
        ActionAggiungi actionAggiungi = new ActionAggiungi(italiaDatabase, citta, cap, regione);
        aggiungi.addActionListener(actionAggiungi);

        JButton visualizza = new JButton("Visualizza Citta (Da fare)");
        visualizza.setBounds(aggiungi.getX(), aggiungi.getY() + 50, aggiungi.getBounds().width, aggiungi.getBounds().height);
        panel.add(visualizza);

        JButton cerca = new JButton("Cerca");
        cerca.setBounds(visualizza.getX(), visualizza.getY() + 50, visualizza.getBounds().width, visualizza.getBounds().height);
        panel.add(cerca);

        cerca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        JButton modifica = new JButton("Modifica");
        modifica.setBounds(10, aggiungi.getY(), visualizza.getBounds().width, visualizza.getBounds().height);
        panel.add(modifica);
        ActionUpdate actionUpdate = new ActionUpdate(italiaDatabase, citta, cap, regione);
        modifica.addActionListener(actionUpdate);

        JButton cancella = new JButton("Cancella");
        cancella.setBounds(modifica.getX(), visualizza.getY(), visualizza.getBounds().width, visualizza.getBounds().height);
        panel.add(cancella);
        ActionDelete actionDelete = new ActionDelete(italiaDatabase);
        cancella.addActionListener(actionDelete);
        add(panel);
        setVisible(true);
    }

}
