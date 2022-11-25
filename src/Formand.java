public class Formand extends Ansat{

    SystemInScanner sc = new SystemInScanner();
    Texthandler th = new Texthandler();
    public Formand(){

    }
    public Formand(String medlemsskab, String fornavn, String efternavn, String pw){
    }

    public void opretMedlem() {
        th.opretMedlemMedlemskab();
        sc.inputInt();
    }
}
