import java.io.FileNotFoundException; //Import af exception og arraylist
import java.util.ArrayList;
import java.util.List;

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

        String b = discValg();
        if(mdl.get(a).discipliner.contains(b)) {
            th.harAlleredeDisciplin();
        }
        else if(mdl.get(a).discipliner.contains("TBD")){
            mdl.get(a).setDisciplin(b);
            ListeTilFil.ListeTilFilDisc(mdl, a, b);
        }
        else {
            mdl.get(a).setDisciplin(mdl.get(a).discipliner.concat("-").concat(b));
            ListeTilFil.ListeTilFilDisc(mdl, a, b);
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
        mdl.addAll(ftl.FilTilListe("KonkurrenceSvømmere.txt"));

        th.redigerTrænerPrint();
        int a = sc.inputInt();

        th.indtastTræner();
        String b = sc.inputString();

        mdl.get(a).setTræner(b);

        ListeTilFil ltf = new ListeTilFil();
        ltf.ListeTilMedlemmer("KonkurrenceSvømmere.txt", mdl);
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
        mdl.addAll(ftl.FilTilListe("Træningstider.txt"));

        th.redigerTræningPrint();

        int a = sc.inputInt();

        th.valgTræningsTid();
        String b = sc.inputTid();
        mdl.get(a).setTid(b);

        ListeTilFil ltf = new ListeTilFil();
        ltf.ListeTilMedlemmer("Træningstider.txt",mdl);

    }
    // Vælge medlem, indtaste stævne + dato, indtast placering, indtast disciplin
    public void tilføjStævneTid() throws FileNotFoundException {
        th.printKonkurrenceSvømmere();

        ArrayList<Medlem> mdl = new ArrayList<>();
        FilTilListe ftl = new FilTilListe();
        ListeTilFil ltf = new ListeTilFil();
        mdl.addAll(ftl.FilTilListe("KonkurrenceSvømmere.txt"));

        th.vælgMedlemStævnePrint();
        int a = sc.inputInt();

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
        ltf.ListeTilFilAppend("Stævner.txt", tempmdl);

    }
    public void printTop5() throws FileNotFoundException {

        ArrayList<Medlem> mdl = new ArrayList<>();
        FilTilListe ftl = new FilTilListe();
        mdl.addAll(ftl.FilTilListe("Træningstider.txt"));
        ArrayList<Medlem> temp1 = new ArrayList<>();
        ArrayList<Medlem> temp2 = new ArrayList<>();

        th.vælgTop5Disc();
        String a = "";
        a = discValg();

        for (Medlem m : mdl) {
            if (a.equals(m.træningsDisc)) {
                temp1.add(m);
            }
        }
        for (int i = 0; i<=temp1.size(); i++) {
            for (int j = 0; j<=temp1.size(); j++) {
                if (Integer.parseInt(temp1.get(j+1).resultat.substring(0,2))>Integer.parseInt(temp1.get(i).resultat.substring(0,2))) {
                    listSortTop5(mdl, temp1, temp2, i, j);
                }
                else if(temp1.get(j+1) != null && Integer.parseInt(temp1.get(j+1).resultat.substring(3,5))>Integer.parseInt(temp1.get(i).resultat.substring(3,5))){
                    listSortTop5(mdl, temp1, temp2, i, j);
                }
                else if(temp1.get(j+1) != null && Integer.parseInt(temp1.get(j+1).resultat.substring(6,8))>Integer.parseInt(temp1.get(i).resultat.substring(6,8))){
                    listSortTop5(mdl, temp1, temp2, i, j);
                }
            }
        }
        /*if(temp1.size() == 5) {
            for (int k = 0; k < 5; k++) {
                temp1.get(k);
            }
        }*/
        //else{
            int f = temp1.size();
            for (int l = 0; l < f; l++ ){
                temp1.get(l);
                System.out.println(temp1.get(l).fornavn + " " + temp1.get(l).resultat);
            }
        //}
    }

    private void listSortTop5(ArrayList<Medlem> mdl, ArrayList<Medlem> temp1, ArrayList<Medlem> temp2, int i, int j) {
        int p1;
        int p2;
        temp2.add(temp1.get(i));
        temp2.add(temp1.get(j));
        p1 = temp1.indexOf(i);
        p2 = temp1.indexOf(j);
        temp1.remove(i);
        temp1.add(p1,temp2.get(1));
        temp1.remove(j);
        temp1.add(p2,temp2.get(0));
        temp2.removeAll(mdl);
    }
}

