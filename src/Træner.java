import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Træner extends Ansat{
    Texthandler th = new Texthandler();
    SystemInScanner sc = new SystemInScanner();
    protected String dicipliner;
    public Træner(){

    }
    public Træner(String medlemsskab, String fornavn, String efternavn, String pw, String dicipliner){
        super(medlemsskab, fornavn, efternavn, pw);
        this.dicipliner = dicipliner;
    }
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

            if (d == 1) {

                th.printDisciplin(mdl.get(a).fornavn);
                int e = sc.inputInt();
                String f = valgDisciplin(e);

                if(!mdl.get(a).discipliner.contains(f))
                    mdl.get(a).setDisciplin(mdl.get(a).discipliner.concat("-").concat(f));
            }
            else {
                success = true;
            }
        }
        ListeTilFil ltf = new ListeTilFil();
        ltf.ListeTilKonkurrence("KonkurrenceSvømmere.txt", mdl);
    }

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

    public void tilføjTræner(){

    }
    public void tilføjTræningsTid(){

    }
    public void tilføjStævneTid(){

    }
    public void printTop5(){

    }
}
