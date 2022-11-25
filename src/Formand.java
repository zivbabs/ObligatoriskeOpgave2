import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Formand extends Ansat{

    SystemInScanner sc = new SystemInScanner();
    Texthandler th = new Texthandler();
    public Formand(){

    }
    public Formand(String medlemsskab, String fornavn, String efternavn, String pw){
    }

    public void opretMedlem() throws FileNotFoundException {
        boolean success = false;
        PrintStream out = new PrintStream(new FileOutputStream("Medlemmer.txt", true));

        th.medlemFornavnPrint();
        String a = sc.inputString();
        th.medlemEfternavnPrint();
        String b = sc.inputString();
        th.opretMedlemAlder();
        int c = sc.inputInt();

        while(!success){

            th.opretMedlemMedlemskab();
            int d = sc.inputInt();

            if (d == 1) {
                out.println("Motionist, " + a + ", " + b + ", " + c + ", " + "I restance");
                success = true;
            }
            if (d == 2) {
                out.println("KonkurrenceSvømmer, " + a + ", " + b + ", " + c + ", " + "I restance, " + "TBD" + ", " + "TBD" + ", " + "TBD" + ", " + "TBD");
                success = true;
            } else {
                th.forkertInputPrint();
            }
        }
    }
}
