package Com.gigi;

import java.util.ArrayList;

public interface CittaDAO {
    public Citta getCittaById(int id);
    public ArrayList<Citta> getAllcitta();
    public boolean addCitta(Citta citta);
    public boolean updateCitta(Citta citta, int id);
    public boolean deleteCitta(int id);
}
