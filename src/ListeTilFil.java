import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class ListeTilFil {
    public void ListeTilKonkurrence(String file, ArrayList<Medlem> list) throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream(file));

        for(Medlem m : list){
            out.println(m.medlemsskab + ", " + m.fornavn + ", " + m.efternavn + ", " + m.alder + ", " + m.restance + ", " + m.oprettelsesDato + ", " + m.discipliner + ", " + m.bedsteTid + ", " + m.stævne + ", " + m.træner);
        }
    }
    public void tilføjTræner(){

    }
}
