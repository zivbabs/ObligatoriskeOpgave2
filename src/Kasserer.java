import java.io.FileNotFoundException; //Import til exception, localdate til dato, period til at udregne forskelle i datoer, arraylist.
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Kasserer extends Ansat{
    //Import af scanner til inpurt og texthandler til konsol udprintninger.
    Texthandler th = new Texthandler();
    SystemInScanner sc = new SystemInScanner();
    //Constructor uden parametre
    public Kasserer(){

    }
    //Constructor med parametre
    public Kasserer(String medlemsskab, String fornavn, String efternavn, String pw){
        super(medlemsskab, fornavn, efternavn, pw);
    }
    //Metode til at printe alle medlemmer som der er i restance eller ikke har betalt endnu.
    public void printMedlemmerRestance() throws FileNotFoundException {
        th.printRestance();
    }
    //Metode til at betale kontingent på medlemmer
    public void betalKontigentMedlemmer() throws FileNotFoundException {
        th.printMedlemmer();

        FilTilListe ftl = new FilTilListe();
        ArrayList<Medlem> mdl = new ArrayList<>();
        mdl.addAll(ftl.FilTilListe("KonkurrenceSvømmere.txt"));

        th.redigerMedlemRestance();
        //Bruger period between years til at se hvad forskellen er mellem fødselsalder og datoen i dag.
        int i = sc.inputInt();
        int alder = Period.between(LocalDate.parse(mdl.get(i).alder), LocalDate.now()).getYears();
        //Metode der udregner og printer det korrekte kontingent der skal betales ud fra alder og medlemsskab.
        th.visKontingentBeløb(alder, mdl.get(i).medlemsskab);
        //Extra check om du medlemmet har betalt eller ej, da det foregår eksternt.
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
