import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Kasserer extends Ansat{
    Texthandler th = new Texthandler();
    SystemInScanner sc = new SystemInScanner();
    public Kasserer(){

    }
    public Kasserer(String medlemsskab, String fornavn, String efternavn, String pw){
        super(medlemsskab, fornavn, efternavn, pw);
    }

    public void printMedlemmerRestance() throws FileNotFoundException {
        th.printRestance();
    }
    public void betalKontigentMedlemmer() throws FileNotFoundException {
        th.konkurrenceSvømmere();

        FilTilListe ftl = new FilTilListe();
        ArrayList<Medlem> mdl = new ArrayList<>();
        mdl.addAll(ftl.FilTilListe("KonkurrenceSvømmere.txt"));

        th.redigerMedlemRestance();

        int i = sc.inputInt();
        int alder = Period.between(LocalDate.parse(mdl.get(i).alder), LocalDate.now()).getYears();

        th.visKontingentBeløb(alder, mdl.get(i).medlemsskab);

        int j = sc.inputInt();
        if(j == 1) {
            mdl.get(i).setRestance("Betalt" + setDato());
        }
        else{
            th.annuleretBetaling();
        }
        ListeTilFil ltf = new ListeTilFil();
        ltf.ListeTilKonkurrence("KonkurrenceSvømmere.txt", mdl);
    }
}
