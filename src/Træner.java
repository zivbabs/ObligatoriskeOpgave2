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
        ArrayList<Medlem> mdl = new ArrayList<>();
        mdl.addAll(ftl.FilTilListe("KonkurrenceSvømmere.txt"));

        th.redigerDisciplin();

        int a = sc.inputInt();
        th.printDisciplin(mdl.get(a).fornavn);

        int b = sc.inputInt();
        String c = valgDisciplin(b);
        mdl.get(a).setDisciplin(c);

        while(!success) {
            th.flereDiscPrint();
            int d = sc.inputInt();
            //Checker om der skal vælges ekstra discipliner
            if (d == 1) {

                th.printDisciplin(mdl.get(a).fornavn);
                int e = sc.inputInt();
                String f = valgDisciplin(e);
                //Checker om den allerede indeholder den disciplin der blev valgt
                if(!mdl.get(a).discipliner.contains(f))
                    mdl.get(a).setDisciplin(mdl.get(a).discipliner.concat("-").concat(f));
            }
            else {
                success = true;
            }
        }
        //Kører arrayliste med ændringer tilbage til fil
        ListeTilFil ltf = new ListeTilFil();
        ltf.ListeTilKonkurrence("KonkurrenceSvømmere.txt", mdl);
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
        else{
            disciplin = "Medley";
        }
        return disciplin;
    }
    //Metode for at tilføje træner da der kun kan være 1 træner til hver medlem selvom de kan have flere discipliner
    public void tilføjTræner() throws FileNotFoundException {
        th.printKonkurrenceSvømmere();

        FilTilListe ftl = new FilTilListe();
        ArrayList<Medlem> mdl = new ArrayList<>();
        mdl.addAll(ftl.FilTilListe("KonkurrenceSvømmere.txt"));

        th.redigerTrænerPrint();
        int a = sc.inputInt();

        th.indtastTræner();
        String b = sc.inputString();

        mdl.get(a).setTræner(b);

        ListeTilFil ltf = new ListeTilFil();
        ltf.ListeTilKonkurrence("KonkurrenceSvømmere.txt", mdl);

    }
    //Metode til at tilføje træningstid til medlemmer hvis de ikke har en træningstid endnu.
    public void tilføjTræningsTid() throws FileNotFoundException {
        th.printKonkurrenceSvømmere();

        FilTilListe ftl = new FilTilListe();
        ArrayList<Medlem> mdl = new ArrayList<>();
        mdl.addAll(ftl.FilTilListe("KonkurrenceSvømmere.txt"));

        th.vælgMedlemNyTid();
        int a = sc.inputInt();

        String b = træningsDiscValg(mdl.get(a).discipliner, mdl.get(a).fornavn);
        mdl.get(a).setTræningsDisc(b);

        th.valgTræningsTid();
        String c = sc.inputTid();

        mdl.get(a).setTid(c);

        ListeTilFil ltf = new ListeTilFil();
        ltf.ListeTilKonkurrence("Træningstider.txt", mdl);
    }
    //Vælg af træningsdiscipliner ud fra de discipliner medlemmet er tildelt
    private String træningsDiscValg(String discipliner, String fornavn) {
        th.printValgteDiscipliner(discipliner);
        th.printDisciplin(fornavn);
        int a = sc.inputInt();
        return valgDisciplin(a);
    }
    //Redigering af træningstider ud fra de træningstider man kan se hos træningstider.txt
    public void redigerTræningsTid() throws FileNotFoundException
    {
        ArrayList<Medlem> mdl = new ArrayList<>();
        FilTilListe ftl = new FilTilListe();
        mdl.addAll(ftl.FilTilListe("Træningstider.txt"));

        th.printTræningsTider();
        th.redigerTræningPrint();

        int a = sc.inputInt();

        th.valgTræningsTid();
        String b = sc.inputTid();
        mdl.get(a).setTid(b);

        ListeTilFil ltf = new ListeTilFil();
        ltf.ListeTilKonkurrence("Træningstider.txt",mdl);

    }
    // Vælge medlem, indtaste stævne + dato, indtast placering, indtast disciplin
    public void tilføjStævneTid() throws FileNotFoundException
    {
        ArrayList<Medlem> mdl = new ArrayList<>();
        FilTilListe ftl = new FilTilListe();
        mdl.addAll(ftl.FilTilListe("KonkurrenceSvømmere.txt"));

        th.printKonkurrenceSvømmere();
        th.vælgMedlemStævnePrint();

        int a = sc.inputInt();
        th.indtastStævne();

        th.indtastPlacering();

    }
    public void printTop5(){

    }
}
