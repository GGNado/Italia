package Com.gigi;

/**
 * Classe oggetto di citta
 */
public class Citta {

    private String nome;
    private String CAP;
    private String regione;

    /**
     * @param nome è il nome della città (es Massa Lubrense)
     * @param CAP è un numero che viene trattato come Stringa di 5 cifre (es 80061)
     * @param regione regione della citta (es Campania)
     */
    public Citta(String nome, String CAP, String regione) {
        this.nome = nome;
        this.CAP = CAP;
        this.regione = regione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCAP() {
        return CAP;
    }

    public void setCAP(String CAP) {
        this.CAP = CAP;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }

    @Override
    public String toString() {
        return "Citta{" +
                "nome='" + nome + '\'' +
                ", CAP='" + CAP + '\'' +
                ", regione='" + regione + '\'' +
                '}';
    }
}
