import java.io.FileNotFoundException;
import java.time.LocalDate; //Import af localtime for at kunne sætte datoer.
import java.util.ArrayList;
public class Ansat {
    Texthandler th = new Texthandler();
    SystemInScanner sc = new SystemInScanner();
    //Variabler til ansat
    protected String medlemsskab;
    protected String fornavn;
    protected String efternavn;
    protected String pw;
    //Ansat constructor uden parametre
    public Ansat(){
    }
    //Ansat constructor med parametre, bruger this. til at sette parametre for at undgå at lave setters i subclasses.
    public Ansat(String medlemsskab, String fornavn, String efternavn, String pw){
        this.medlemsskab = medlemsskab;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.pw = pw;
    }
    //Metode til at sætte dagens dato
    protected String setDato(){
        return String.valueOf(LocalDate.now());
    }
    // Metode for login for ansatte som sender en videre til en menu hvis password er korrekt
    protected void login() throws FileNotFoundException {
        ArrayList<Ansat> ansatte = new ArrayList<>();
        FilTilListe ftl = new FilTilListe();
        ansatte.addAll(ftl.filTilListeAnsatte("Ansatte.txt"));
        boolean success = false;

        Formand fmd = new Formand();
        Kasserer ksr = new Kasserer();
        Træner trn = new Træner();

        loop:
        while(!success) {
            th.loginOptions();
            int loginValg = sc.inputInt();

            switch (loginValg) {
                case 1 -> {
                    th.passwordAnsat();
                    String passwordA = sc.inputString();
                    for (Ansat ansat : ansatte) {
                        if (ansat.pw.equals(passwordA) && ansat.medlemsskab.equals("Formand")) {
                            fmd.menu();
                            continue loop;
                        }
                    }
                    th.forkertInputPrint();
                    continue;
                }
                case 2 -> {
                    th.passwordAnsat();
                    String passwordB = sc.inputString();
                    for (Ansat ansat : ansatte) {
                        if (ansat.pw.equals(passwordB) && ansat.medlemsskab.equals("Kasserer")) {
                            ksr.menu();
                            continue loop;
                        }
                    }
                    th.forkertInputPrint();
                    continue;
                }
                case 3 -> {
                    th.passwordAnsat();
                    String passwordC = sc.inputString();
                    for (Ansat ansat : ansatte) {
                        if (ansat.pw.equals(passwordC) && ansat.medlemsskab.equals("Træner")) {
                            trn.menu();
                            continue loop;
                        }
                    }
                    th.forkertInputPrint();
                    continue;
                }
                case 4 -> success = true;
            }
            if(loginValg < 1 || loginValg > 4) {
                th.forkertInputPrint();
            }
        }
    }
}
