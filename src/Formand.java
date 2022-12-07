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
    private void opretMedlem() throws FileNotFoundException {
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
        th.opretStatus();
        String e = statusValg();

        while (!success) {
            //Valg mellem motionist eller konkurrencesvømmer
            th.opretMedlemskab();
            int d = sc.inputInt();
            //Oprettelse af motionister med "," som divider til brug for indlæsning.
            if (d == 1) {
                out1.println("Motionist, " + a + ", " + b + ", " + c + ", " + "I restance, " + e);
                success = true;
            }
            //Oprettelse af konkurrencesvømmere med "," som divider til brug for indlæsning.
            else if (d == 2) {
                out1.println("KonkurrenceSvømmer, " + a + ", " + b + ", " + c + ", " + "I restance, " + e + ", " + "TBD" + ", " + "TBD" + ", " + "TBD" + ", " + "TBD" + ", " + "TBD");
                out2.println("KonkurrenceSvømmer, " + a + ", " + b + ", " + c + ", " + "I restance, " + e + ", " + "TBD" + ", " + "TBD" + ", " + "TBD" + ", " + "TBD" + ", " + "TBD");
                success = true;
            }
            //Forkert input print hvis man ikke trykker 1 eller 2
            else {
                th.forkertInputPrint();
            }
        }
    }
    //Metode som bliver brugt i opretMedlem() for at vælge aktivt eller passivt medlemskab
    private String statusValg() {
        String status = "";
        boolean success = false;
        while(!success){

            int a = sc.inputInt();

            if(a == 1){
                status = "Aktiv";
                success = true;
            }
            else if(a == 2){
                status = "Passiv";
                success = true;
            }
            else{
                th.forkertInputPrint();
            }
        }
        return status;
    }
    //Menu for Formand
    protected void menu() throws FileNotFoundException {
        boolean success = false;

        while(!success){

            th.formandMenuOptions();
            int i = sc.inputInt();

            switch(i){
                case 1 -> opretMedlem();
                case 2 -> success = true;
            }
            if(i < 1 || i > 2){
                th.forkertInputPrint();
            }
        }
    }
}
