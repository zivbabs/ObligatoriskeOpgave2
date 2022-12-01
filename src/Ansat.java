import java.time.LocalDate; //Import af localtime for at kunne sætte datoer.

public class Ansat {
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
    public String setDato(){
        String date = String.valueOf(LocalDate.now());
        return date;
    }
}
