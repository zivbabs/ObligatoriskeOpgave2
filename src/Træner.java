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
    public void tilFøjdisciplin() throws FileNotFoundException {
        boolean success = false;

        th.printKonkurrenceSvømmere();

        FilTilListe ftl = new FilTilListe();
        ListeTilFil ltf = new ListeTilFil();
        ArrayList<Medlem> mdl = new ArrayList<>();
        mdl.addAll(ftl.filTilListe("KonkurrenceSvømmere.txt"));

        th.redigerDisciplin();

        int x = sc.inputInt();
        int a = sc.inputOOBLength(x, mdl.size());
        th.printDisciplin(mdl.get(a).fornavn);

        String b = discValg();
        if(mdl.get(a).discipliner.contains(b)) {
            th.harAlleredeDisciplin();
        }
        else if(mdl.get(a).discipliner.contains("TBD")){
            mdl.get(a).setDisciplin(b);
            ListeTilFil.listeTilFilDisc(mdl, a, b);
        }
        else {
            mdl.get(a).setDisciplin(mdl.get(a).discipliner.concat("-").concat(b));
            ListeTilFil.listeTilFilDisc(mdl, a, b);
        }
    }

    //Metode med input for valg af disciplienr som vælger den disciplin der skal bruges.
    private String valgDisciplin(int input) {
        String disciplin = "";
        if(input == 1){
            disciplin = "Crawl";
        }
        else if(input == 2){
            disciplin = "Brystsvøm";
        }
        else if(input == 3){
            disciplin = "Butterfly";
        }
        else if(input == 4){
            disciplin = "Rygcrawl";
        }
        else {
            disciplin = "Medley";
        }

        return disciplin;
    }
    //Metode for at tilføje træner da der kun kan være 1 træner til hver medlem selvom de kan have flere discipliner
    public void tilføjTræner() throws FileNotFoundException {
        th.printKonkurrenceSvømmere();

        FilTilListe ftl = new FilTilListe();
        ArrayList<Medlem> mdl = new ArrayList<>();
        mdl.addAll(ftl.filTilListe("KonkurrenceSvømmere.txt"));

        th.redigerTrænerPrint();
        int x = sc.inputInt();
        int a = sc.inputOOBLength(x, mdl.size());

        th.indtastTræner();
        String b = sc.inputTræner();

        mdl.get(a).setTræner(b);

        ListeTilFil ltf = new ListeTilFil();
        ltf.listeTilMedlemmer("KonkurrenceSvømmere.txt", mdl);
    }
    //Vælg af træningsdiscipliner ud fra de discipliner medlemmet er tildelt
    private String discValg() {
        boolean success = false;
        int a = 0;

        while (!success) {
            a=sc.inputInt();
            if (a < 6 && a > 0) {
                success = true;
            }
            else {
                th.forkertInputPrint();
            }
        }
        return valgDisciplin(a);
    }
    //Redigering af træningstider ud fra de træningstider man kan se hos træningstider.txt
    public void redigerTræningsTid() throws FileNotFoundException {
        th.printTræningsTider();

        ArrayList<Medlem> mdl = new ArrayList<>();
        FilTilListe ftl = new FilTilListe();
        mdl.addAll(ftl.filTilListe("Træningstider.txt"));

        th.redigerTræningPrint();

        int x = sc.inputInt();
        int a = sc.inputOOBLength(x, mdl.size());

        th.valgTræningsTid();
        String b = sc.inputTid();
        mdl.get(a).setTid(b);

        ListeTilFil ltf = new ListeTilFil();
        ltf.listeTilMedlemmer("Træningstider.txt",mdl);

    }
    // Vælge medlem, indtaste stævne + dato, indtast placering, indtast disciplin
    public void tilføjStævneTid() throws FileNotFoundException {
        th.printKonkurrenceSvømmere();

        ArrayList<Medlem> mdl = new ArrayList<>();
        FilTilListe ftl = new FilTilListe();
        ListeTilFil ltf = new ListeTilFil();
        mdl.addAll(ftl.filTilListe("KonkurrenceSvømmere.txt"));

        th.vælgMedlemStævnePrint();
        int x = sc.inputInt();
        int a = sc.inputOOBLength(x, mdl.size());

        th.indtastStævne();
        String b = sc.inputString();

        th.indtastPlacering();
        int c = sc.inputInt();

        th.discValgStævne();
        String e = discValg();

        mdl.get(a).setStævne(b+" "+setDato());
        mdl.get(a).setPlacering(c);
        mdl.get(a).setDisciplin(e);

        ArrayList<Medlem> tempmdl = new ArrayList<>();
        tempmdl.add(mdl.get(a));
        ltf.listeTilFilAppend("Stævner.txt", tempmdl);

    }
    public void printTop5() throws FileNotFoundException {
        th.vælgDiscTop5();
        String a = discValg();
        th.printTop5(a);
    }

    public void menu() throws FileNotFoundException {
        boolean success = false;

        while(!success){

            th.trænerMenuOptions();
            int i = sc.inputInt();

            switch(i){
                case 1 -> tilFøjdisciplin();
                case 2 -> tilføjTræner();
                case 3 -> redigerTræningsTid();
                case 4 -> tilføjStævneTid();
                case 5 -> printTop5();
                case 6 -> success = true;
            }
            if(i < 1 || i > 6){
                th.forkertInputPrint();
            }
        }
    }
}

