import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

public class Formand extends Ansat{

    SystemInScanner sc = new SystemInScanner();
    Texthandler th = new Texthandler();
    public Formand(){

    }
    public Formand(String medlemsskab, String fornavn, String efternavn, String pw){
        super(medlemsskab, fornavn, efternavn, pw);
    }

    public void opretMedlem() throws FileNotFoundException {
        boolean success = false;
        PrintStream out1 = new PrintStream(new FileOutputStream("Medlemmer.txt", true));
        PrintStream out2 = new PrintStream(new FileOutputStream("KonkurrenceSvømmere.txt", true));

        th.medlemFornavnPrint();
        String a = sc.inputString();
        th.medlemEfternavnPrint();
        String b = sc.inputString();
        th.opretMedlemAlder();
        String c = sc.inputAlder();

        while(!success){

            th.opretMedlemMedlemskab();
            int d = sc.inputInt();

            if (d == 1) {
                out1.println("Motionist, " + a + ", " + b + ", " + c + ", " + "I restance" + ", " +localDate());
                success = true;
            }
            if (d == 2) {
                out1.println("KonkurrenceSvømmer, " + a + ", " + b + ", " + c + ", " + "I restance, " + localDate() + ", " + "TBD" + ", " + "TBD" + ", " + "TBD" + ", " + "TBD");
                out2.println("KonkurrenceSvømmer, " + a + ", " + b + ", " + c + ", " + "I restance, " + localDate() + ", " + "TBD" + ", " + "TBD" + ", " + "TBD" + ", " + "TBD");
                success = true;
            }
            if (d != 1 && d != 2){
                th.forkertInputPrint();
            }
        }
    }
    public String localDate(){
        return String.valueOf(LocalDate.now());
    }
}
