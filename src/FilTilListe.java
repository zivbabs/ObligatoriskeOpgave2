import java.io.File; //Import til at kunne bruge filer, exception til filer, arraylist, comparator og scanner.
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
//Klassen bruges til at undgå repetition da metoder skal bruges flere gange.
public class FilTilListe {
    //Metode til at kører filer ind i en liste og sende listen videre
    public ArrayList<Medlem> FilTilListe(String file) throws FileNotFoundException {
        File filInput = new File(file);
        Scanner sc = new Scanner(filInput);
        ArrayList<Medlem> mdl = new ArrayList<>();
        //Smider information ind i array med "," til at splitte information med
        while(sc.hasNextLine()){
            String[] i = sc.nextLine().split(",");
            String medlemsskab = i[0].trim();
            String fornavn = i[1].trim();
            String efternavn = i[2].trim();
            String alder = i[3].trim();
            String restance = i[4].trim();
            //Deler medlemmer op hvis de indeholder motionist eller konkurrencesvømmer i medlemsskab.
            if(medlemsskab.equals("Motionist")){
                Medlem m = new Motionist(medlemsskab, fornavn, efternavn, alder, restance);
                mdl.add(m);
            }
            if(medlemsskab.equals("KonkurrenceSvømmer")){
                String træningsDisc = i[5].trim();
                String discipliner = i[6].trim();
                String resultat = i[7].trim();
                String stævne = i[8].trim();
                String træner = i[9].trim();

                Medlem m = new KonkurrenceSvømmer(medlemsskab, fornavn, efternavn, alder, restance, træningsDisc, discipliner, resultat, stævne, træner);
                mdl.add(m);
            }
         }
        //Sorterering efter medlemsskab så motionister og konkurrencesvømmere kommer til at stå sammen.
        mdl.sort(Comparator.comparing(m -> m.medlemsskab));
        return mdl;
    }
}
