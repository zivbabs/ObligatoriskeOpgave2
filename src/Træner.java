public class Træner extends Ansat{
    protected String dicipliner;
    public Træner(){

    }
    public Træner(String medlemsskab, String fornavn, String efternavn, String pw, String dicipliner){
        super(medlemsskab, fornavn, efternavn, pw);
        this.dicipliner = dicipliner;
    }
}
