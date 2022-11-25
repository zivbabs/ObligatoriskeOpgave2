import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Medlem> mdl = new ArrayList<>();
        FilTilListe ftl = new FilTilListe();
        mdl.addAll(ftl.FilTilListeRestance("Medlemmer.txt"));



    }
}