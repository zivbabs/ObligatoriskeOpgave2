import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class FilTilListe {
    public ArrayList<Medlem> FilTilListeRestance(String file) throws FileNotFoundException {
        File filInput = new File(file);
        Scanner sc = new Scanner(filInput);
        ArrayList<Medlem> mdl = new ArrayList<>();

        while(sc.hasNextLine()){
            String[] i = sc.nextLine().split(",");
            String medlemsskab = i[0].trim();
            String fornavn = i[1].trim();
            String efternavn = i[2].trim();
            int alder = Integer.parseInt(i[3].trim());
            String restance = i[4].trim();
            String oprettelsesDato = i[5].trim();
            if(medlemsskab.equals("Motionist")){
                Medlem m = new Motionist(medlemsskab, fornavn, efternavn, alder, restance, oprettelsesDato);
                mdl.add(m);
            }
            if(medlemsskab.equals("KonkurrenceSvømmer")){
                String dicipliner = i[6].trim();
                String bedsteTid = i[7].trim();
                String stævne = i[8].trim();
                String træner = i[9].trim();

                Medlem m = new KonkurrenceSvømmer(medlemsskab, fornavn, efternavn, alder, restance, oprettelsesDato, dicipliner, bedsteTid, stævne, træner);
                mdl.add(m);
            }
         }
        mdl.sort(Comparator.comparing(m -> m.medlemsskab));
        return mdl;
    }
}
