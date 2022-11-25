public class Kasserer extends Ansat{
    Texthandler th = new Texthandler();
    public Kasserer(){

    }
    public Kasserer(String medlemsskab, String fornavn, String efternavn, String pw){
        super(medlemsskab, fornavn, efternavn, pw);
    }

    public void printMedlemmerRestance(){
        th.printRestance();
    }
    public void betalKontigentMedlemmer(){

    }
}
