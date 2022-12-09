import java.io.FileNotFoundException; //Input af exception outputstream, printstream og arraylist.
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
//Klassen bruges til at undgå repetition da det metoder bliver brugt mange gange.
public class ListeTilFil {

    //Metode som tager ind en liste og smider den over i listeTilMedlemmer() som overskriver "Konkurrencesvømmere.txt.
    //Derefter appender den et valgt medlem med valgt disciplin til træningstider
    public void listeTilFilDisc(ArrayList<Medlem> mdl, int id, String disciplin) throws FileNotFoundException {
            ListeTilFil ltf = new ListeTilFil();
            ltf.listeTilMedlemmer("KonkurrenceSvømmere.txt", mdl);

            mdl.get(id).setDiscValgt(disciplin);
            PrintStream out = new PrintStream(new FileOutputStream("Træningstider.txt", true));
            out.println(mdl.get(id).medlemsskab + ", " + mdl.get(id).fornavn + ", " + mdl.get(id).efternavn + ", " + mdl.get(id).alder + ", " + mdl.get(id).restance + ", "+ mdl.get(id).status + ", " + mdl.get(id).discValgt + ", " + mdl.get(id).discipliner + ", " + mdl.get(id).resultat + ", " + mdl.get(id).stævne + ", " + mdl.get(id).træner);
    }

    //Metode til at køre listen over til en fil.
    public void listeTilMedlemmer(String file, ArrayList<Medlem> list) throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream(file));
        //Kører et for each loop med typen "Medlem" som vi kalder "m" for hvert "list" der er.
        for(Medlem m : list){
            if(m.medlemsskab.contains("KonkurrenceSvømmer"))
                out.println(m.medlemsskab + ", " + m.fornavn + ", " + m.efternavn + ", " + m.alder + ", " + m.restance + ", "+ m.status + ", " + m.discValgt + ", " + m.discipliner + ", " + m.resultat + ", " + m.stævne + ", " + m.træner);
            else if(m.medlemsskab.contains("Motionist")){
                out.println(m.medlemsskab + ", " + m.fornavn + ", " + m.efternavn + ", " + m.alder + ", " + m.restance + ", "+ m.status);
            }
        }
    }
    //Metode som tager ind fil og appender en arrayliste med medlemmer til den
    public void listeTilFilAppend(String file, ArrayList<Medlem> list) throws FileNotFoundException
    {
        PrintStream out = new PrintStream(new FileOutputStream(file,true));
        for(Medlem m : list) {
            out.println(m.medlemsskab + ", " + m.fornavn + ", " + m.efternavn + ", " + m.alder + ", " + m.restance + ", "+ m.status + ", " + m.discValgt + ", " + m.discipliner + ", " + m.resultat + ", " + m.stævne + ", " + m.træner);
        }
    }
}
