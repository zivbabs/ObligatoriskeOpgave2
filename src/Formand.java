import java.io.FileNotFoundException; //Import af exception, input og outputstreams.
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Formand extends Ansat {
    //Import af scanner klasse til alle inputs og texthandler klasse til at håndtere alle udprint til konsol
    SystemInScanner sc = new SystemInScanner();
    Texthandler th = new Texthandler();

    //Formand constructor uden parametre
    public Formand() {

    }

    //Formand constructor med parametre, bruger super så vi ikke behøver setters.
    public Formand(String medlemsskab, String fornavn, String efternavn, String pw) {
        super(medlemsskab, fornavn, efternavn, pw);
    }

    //Funktion til at oprette medlemmer
    public void opretMedlem() throws FileNotFoundException {
        boolean success = false;
        PrintStream out1 = new PrintStream(new FileOutputStream("Medlemmer.txt", true));
        PrintStream out2 = new PrintStream(new FileOutputStream("KonkurrenceSvømmere.txt", true));
        //2 printere så vi kan tilføje til både medlemmer og hvis det er konkurrencesvømmer til konkurrencesvømmere
        th.medlemFornavnPrint();
        String a = sc.inputString();
        th.medlemEfternavnPrint();
        String b = sc.inputString();
        th.opretMedlemAlder();
        String c = sc.inputAlder();

        while (!success) {
            //Valg mellem motionist eller konkurrencesvømmer
            th.opretMedlemMedlemskab();
            int d = sc.inputInt();
            //Oprettelse af motionister med "," som divider til brug for indlæsning.
            if (d == 1) {
                out1.println("Motionist, " + a + ", " + b + ", " + c + ", " + "I restance" + ", " + setDato());
                success = true;
            }
            //Oprettelse af konkurrencesvømmere med "," som divider til brug for indlæsning.
            else if (d == 2) {
                out1.println("KonkurrenceSvømmer, " + a + ", " + b + ", " + c + ", " + "I restance, " + setDato() + ", " + "TBD" + ", " + "TBD" + ", " + "TBD" + ", " + "TBD");
                out2.println("KonkurrenceSvømmer, " + a + ", " + b + ", " + c + ", " + "I restance, " + setDato() + ", " + "TBD" + ", " + "TBD" + ", " + "TBD" + ", " + "TBD");
                success = true;
            }
            //Forkert input print hvis man ikke trykker 1 eller 2
            else {
                th.forkertInputPrint();
            }
        }
    }
}
