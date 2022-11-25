public class Ansat {
    protected String medlemsskab;
    protected String fornavn;
    protected String efternavn;
    protected String pw;

    public Ansat(){

    }
    public Ansat(String medlemsskab, String fornavn, String efternavn, String pw){
        this.medlemsskab = medlemsskab;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.pw = pw;
    }
}
