package Com.gigi;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class ItaliaDatabase implements CittaDAO{
    private static String url = "jdbc:mysql://localhost:3306/Italia";
    private static String user = "root";
    private static String psw = "";

    private Connection connetti(){
        try {
            return DriverManager.getConnection(url, user, psw);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Errore nel collegamento del DataBase", "Errore", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    private boolean isConnesso(Connection connection){
        if (connection != null)
            return true;

        JOptionPane.showMessageDialog(null, "Non riesco a collegarmi al DB");
        return false;

    }
    @Override
    public Citta getCittaById(int id) {
        Connection connection = connetti();
        if (!isConnesso(connection)) return null;

        String sql = "SELECT * FROM citta WHERE id=" + id;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            Citta citta = null;
            if (resultSet.next()) {
                citta = new Citta(resultSet.getString("nome"), resultSet.getString("cap"), resultSet.getString("regione"));
            }
            resultSet.close();
            preparedStatement.close();
            return citta;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ArrayList<Citta> getAllcitta() {
        return null;
    }

    @Override
    public boolean addCitta(Citta citta) {
        Connection connection = connetti();
        if (!isConnesso(connection)) return false;

        String sql = "INSERT INTO citta(nome, cap, regione) VALUES (?,?,?)";

        try {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, citta.getNome());
                preparedStatement.setString(2, citta.getCAP());
                preparedStatement.setString(3, citta.getRegione());
                preparedStatement.execute();
                preparedStatement.close();
                connection.close();
                return true;
            }catch (SQLIntegrityConstraintViolationException e){
                JOptionPane.showMessageDialog(null, "Esiste gia una citta inserita con questo CAP");
            }
        }catch (SQLException ex){
            System.out.println(ex);
        }

        return false;

    }

    @Override
    public boolean updateCitta(Citta citta, int id) {
        Connection connection = connetti();
        if (!isConnesso(connection)) return false;

        if (getCittaById(id) == null){
            JOptionPane.showMessageDialog(null, "Nessuna città trovata con questo ID");
            return false;
        }

        String sql = "UPDATE citta SET nome = ?,cap = ?, regione = ? WHERE id =" + id;
        try {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, citta.getNome());
                preparedStatement.setString(2, citta.getCAP());
                preparedStatement.setString(3, citta.getRegione());
                preparedStatement.executeUpdate();
                connection.close();
                return true;

            }catch (SQLIntegrityConstraintViolationException e){
                JOptionPane.showMessageDialog(null, "Esiste gia una citta inserita con questo CAP");
            }
        }catch (SQLException exception){
            System.out.println(exception);
        }


        return false;
    }

    @Override
    public boolean deleteCitta(int id) {
        Connection connection = connetti();
        if (!isConnesso(connection)) return false;

        if (getCittaById(id) == null){
            JOptionPane.showMessageDialog(null, "Nessuna città trovata con questo ID");
            return false;
        }

        String sql = "DELETE FROM citta WHERE id =" + id;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Cancellato");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore");
        }

        return false;
    }
}
