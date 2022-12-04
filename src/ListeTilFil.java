import java.io.FileNotFoundException; //Input af exception outputstream, printstream og arraylist.
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
//Klassen bruges til at undgå repetition da det metoder bliver brugt mange gange.
public class ListeTilFil {
    public static void ListeTilFilDisc(ArrayList<Medlem> mdl, int a, String b) throws FileNotFoundException {
            ListeTilFil ltf = new ListeTilFil();
            ltf.ListeTilMedlemmer("KonkurrenceSvømmere.txt", mdl);

            mdl.get(a).setTræningsDisc(b);
            PrintStream out = new PrintStream(new FileOutputStream("Træningstider.txt", true));
            out.println(mdl.get(a).medlemsskab + ", " + mdl.get(a).fornavn + ", " + mdl.get(a).efternavn + ", " + mdl.get(a).alder + ", " + mdl.get(a).restance + ", " + mdl.get(a).træningsDisc + ", " + mdl.get(a).discipliner + ", " + mdl.get(a).resultat + ", " + mdl.get(a).stævne + ", " + mdl.get(a).træner);
    }

    //Metode til at køre listen over til en fil.
    public void ListeTilMedlemmer(String file, ArrayList<Medlem> list) throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream(file));
        //Kører et for each loop med typen "Medlem" som vi kalder "m" for hvert "list" der er.
        for(Medlem m : list){
            if(m.medlemsskab.contains("KonkurrenceSvømmer"))
                out.println(m.medlemsskab + ", " + m.fornavn + ", " + m.efternavn + ", " + m.alder + ", " + m.restance + ", " + m.træningsDisc + ", " + m.discipliner + ", " + m.resultat + ", " + m.stævne + ", " + m.træner);
            else if(m.medlemsskab.contains("Motionist")){
                out.println(m.medlemsskab + ", " + m.fornavn + ", " + m.efternavn + ", " + m.alder + ", " + m.restance);
            }
        }
    }
    public void ListeTilFilAppend(String file, ArrayList<Medlem> list) throws FileNotFoundException
    {
        PrintStream out = new PrintStream(new FileOutputStream(file,true));
        for(Medlem m : list) {
            out.println(m.medlemsskab + ", " + m.fornavn + ", " + m.efternavn + ", " + m.alder + ", " + m.restance + ", " + m.træningsDisc + ", " + m.discipliner + ", " + m.resultat + ", " + m.stævne + ", " + m.træner);
        }
    }
}
