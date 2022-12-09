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
    private void printMedlemmerRestance() throws FileNotFoundException {
        th.printRestance();
    }
    //Metode til at betale kontingent på medlemmer
    private void betalKontigentMedlemmer() throws FileNotFoundException {
        th.printMedlemmer();

        //Tager "Medlemmer.txt" og smider det ind i en arrayliste
        FilTilListe ftl = new FilTilListe();
        ArrayList<Medlem> mdl = new ArrayList<>();
        mdl.addAll(ftl.filTilListe("Medlemmer.txt"));

        if(mdl.size() < 1){
            return;
        }

        th.redigerMedlemRestance();
        //Bruger period between years til at se hvad forskellen er mellem fødselsalder og datoen i dag.
        int idTemp = sc.inputInt();
        int id = sc.inputOOBLength(idTemp, mdl.size());
        int alder = Period.between(LocalDate.parse(mdl.get(id).alder), LocalDate.now()).getYears();
        //Metode der udregner og printer det korrekte kontingent der skal betales ud fra alder og medlemsskab.
        th.visKontingentBeløb(alder, mdl.get(id).medlemsskab, mdl.get(id).status);
        //Extra check om du medlemmet har betalt eller ej, da det foregår eksternt.
        int valgBetaling = sc.inputInt();
        if(valgBetaling == 1) {
            mdl.get(id).setRestance("Betalt " + setDato());
        }
        else{
            th.annuleretBetaling();
        }
        ListeTilFil ltf = new ListeTilFil();
        ltf.listeTilMedlemmer("Medlemmer.txt", mdl);
    }
    //Menu til kasserer
    protected void menu() throws FileNotFoundException {
        boolean success = false;

        while(!success){

            th.kassererMenuOptions();
            int inputMenu = sc.inputInt();

            switch (inputMenu) {
                case 1 -> printMedlemmerRestance();
                case 2 -> betalKontigentMedlemmer();
                case 3 -> success = true;
            }
            if(inputMenu < 1 || inputMenu > 2){
                th.forkertInputPrint();
            }
        }
    }
}
