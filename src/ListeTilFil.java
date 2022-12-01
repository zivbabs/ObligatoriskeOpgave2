import java.io.FileNotFoundException; //Input af exception outputstream, printstream og arraylist.
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
//Klassen bruges til at undgå repetition da det metoder bliver brugt mange gange.
public class ListeTilFil {
    //Metode til at køre listen over til en fil.
    public void ListeTilKonkurrence(String file, ArrayList<Medlem> list) throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream(file));
        //Kører et for each loop med typen "Medlem" som vi kalder "m" for hvert "list" der er.
        for(Medlem m : list){
            out.println(m.medlemsskab + ", " + m.fornavn + ", " + m.efternavn + ", " + m.alder + ", " + m.restance + ", " + m.træningsDisc + ", " + m.discipliner + ", " + m.bedsteTid + ", " + m.stævne + ", " + m.træner);
        }
    }
}
