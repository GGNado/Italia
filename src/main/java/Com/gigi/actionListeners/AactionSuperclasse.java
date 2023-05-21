package Com.gigi.actionListeners;

import Com.gigi.ItaliaDatabase;

public class AactionSuperclasse {
    private ItaliaDatabase italiaDatabase;

    public AactionSuperclasse(ItaliaDatabase italiaDatabase) {
        this.italiaDatabase = italiaDatabase;
    }

    public ItaliaDatabase getItaliaDatabase() {
        return italiaDatabase;
    }

}
