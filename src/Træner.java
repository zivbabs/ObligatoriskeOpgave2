import java.io.FileNotFoundException; //Import af exception og arraylist
import java.util.ArrayList;

public class Træner extends Ansat{
    //Import af de scanner til inputs og texthandler til konsol udprintninger.
    Texthandler th = new Texthandler();
    SystemInScanner sc = new SystemInScanner();
    //Constructor uden parametre
    public Træner(){
    }
    //Constructor med parametre, bruger super for at undgå settere.
    public Træner(String medlemsskab, String fornavn, String efternavn, String pw){
        super(medlemsskab, fornavn, efternavn, pw);
    }
    //Metode for at tilføje discipliner til medlemmer op til alle 5 man kan have med en concat string build
    private void tilFøjdisciplin() throws FileNotFoundException {
        th.printKonkurrenceSvømmere();

        FilTilListe ftl = new FilTilListe();
        ListeTilFil ltf = new ListeTilFil();
        ArrayList<Medlem> mdl = new ArrayList<>();
        mdl.addAll(ftl.filTilListe("KonkurrenceSvømmere.txt"));

        if(mdl.size() < 1){
            return;
        }

        th.redigerDisciplin();

        int idTemp = sc.inputInt();
        int id = sc.inputOOBLength(idTemp, mdl.size());
        th.printDisciplin(mdl.get(id).fornavn);

        String disciplin = discValg();
        if(mdl.get(id).discipliner.contains(disciplin)) {
            th.harAlleredeDisciplin();
        }
        else if(mdl.get(id).discipliner.contains("TBD")){
            mdl.get(id).setDisciplin(disciplin);
            ltf.listeTilFilDisc(mdl, id, disciplin);
        }
        else {
            mdl.get(id).setDisciplin(mdl.get(id).discipliner.concat("-").concat(disciplin));
            ltf.listeTilFilDisc(mdl, id, disciplin);
        }
    }

    //Metode med input for valg af disciplienr som vælger den disciplin der skal bruges.
    private String valgDisciplin(int disciplinValg) {
        String disciplin = "";
        if(disciplinValg == 1){
            disciplin = "Crawl";
        }
        else if(disciplinValg == 2){
            disciplin = "Brystsvøm";
        }
        else if(disciplinValg == 3){
            disciplin = "Butterfly";
        }
        else if(disciplinValg == 4){
            disciplin = "Rygcrawl";
        }
        else {
            disciplin = "Medley";
        }

        return disciplin;
    }
    //Metode for at tilføje træner da der kun kan være 1 træner til hver medlem selvom de kan have flere discipliner
    private void tilføjTræner() throws FileNotFoundException {
        th.printKonkurrenceSvømmere();

        FilTilListe ftl = new FilTilListe();
        ArrayList<Medlem> mdl = new ArrayList<>();
        mdl.addAll(ftl.filTilListe("KonkurrenceSvømmere.txt"));

        if(mdl.size() < 1){
            return;
        }

        th.redigerTrænerPrint();
        int idTemp = sc.inputInt();
        int id = sc.inputOOBLength(idTemp, mdl.size());

        th.indtastTræner();
        String trænerInitialer = sc.inputTræner();

        mdl.get(id).setTræner(trænerInitialer);

        ListeTilFil ltf = new ListeTilFil();
        ltf.listeTilMedlemmer("KonkurrenceSvømmere.txt", mdl);
    }
    //Vælg af træningsdiscipliner ud fra de discipliner medlemmet er tildelt
    private String discValg() {
        boolean success = false;
        int discValgId = 0;

        while (!success) {
            discValgId = sc.inputInt();
            if (discValgId < 6 && discValgId > 0) {
                success = true;
            }
            else {
                th.forkertInputPrint();
            }
        }
        return valgDisciplin(discValgId);
    }
    //Redigering af træningstider ud fra de træningstider man kan se hos træningstider.txt
    private void redigerTræningsTid() throws FileNotFoundException {
        th.printTræningsTider();

        ArrayList<Medlem> mdl = new ArrayList<>();
        FilTilListe ftl = new FilTilListe();
        mdl.addAll(ftl.filTilListe("Træningstider.txt"));

        if(mdl.size() < 1){
            return;
        }

        th.redigerTræningPrint();

        int idTemp = sc.inputInt();
        int id = sc.inputOOBLength(idTemp, mdl.size());

        th.valgTræningsTid();
        String træningstid = sc.inputTid();
        mdl.get(id).setTid(træningstid);

        ListeTilFil ltf = new ListeTilFil();
        ltf.listeTilMedlemmer("Træningstider.txt",mdl);

    }
    // Vælge medlem, indtaste stævne + dato, indtast placering, indtast disciplin. Derefter appende det til "stævner.txt"
    private void tilføjStævneTid() throws FileNotFoundException {
        th.printKonkurrenceSvømmere();

        ArrayList<Medlem> mdl = new ArrayList<>();
        FilTilListe ftl = new FilTilListe();
        ListeTilFil ltf = new ListeTilFil();
        mdl.addAll(ftl.filTilListe("KonkurrenceSvømmere.txt"));

        if(mdl.size() < 1){
            return;
        }

        th.vælgMedlemStævnePrint();
        int idTemp = sc.inputInt();
        int id = sc.inputOOBLength(idTemp, mdl.size());

        th.indtastStævne();
        String stævne = sc.inputString();

        th.indtastPlacering();
        int placering = sc.inputInt();

        th.discValgStævne();
        String stævneDisciplin = discValg();

        mdl.get(id).setStævne(stævne + " " + setDato());
        mdl.get(id).setPlacering(placering);
        mdl.get(id).setDisciplin(stævneDisciplin);

        ArrayList<Medlem> tempMdl = new ArrayList<>();
        tempMdl.add(mdl.get(id));
        ltf.listeTilFilAppend("Stævner.txt", tempMdl);

    }
    //Metode til at printe top 5 bedste træningstider inden for valgt disciplin
    private void printTop5() throws FileNotFoundException {
        th.vælgDiscTop5();
        String disciplin = discValg();
        th.printTop5(disciplin);
    }
    //Menu for træner.
    protected void menu() throws FileNotFoundException {
        boolean success = false;

        while(!success){

            th.trænerMenuOptions();
            int inputMenu = sc.inputInt();

            switch(inputMenu){
                case 1 -> tilFøjdisciplin();
                case 2 -> tilføjTræner();
                case 3 -> redigerTræningsTid();
                case 4 -> tilføjStævneTid();
                case 5 -> printTop5();
                case 6 -> success = true;
            }
            if(inputMenu < 1 || inputMenu > 6){
                th.forkertInputPrint();
            }
        }
    }
}

