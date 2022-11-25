public class Medlem {
    protected String medlemsskab;
    protected String fornavn;
    protected String efternavn;
    protected int alder;
    protected String restance;
    protected String oprettelsesDato;
    protected String dicipliner;
    protected String bedsteTid;
    protected String stævne;
    protected String træner;
    public Medlem(){
    }
    public Medlem(String medlemsskab, String fornavn, String efternavn, int alder, String restance, String oprettelsesDato){
        this.medlemsskab = medlemsskab;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.alder = alder;
        this.restance = restance;
        this.oprettelsesDato = oprettelsesDato;
    }
    public Medlem(String medlemsskab, String fornavn, String efternavn, int alder, String restance, String oprettelsesDato, String dicipliner, String bedsteTid, String stævne, String træner){
        this.medlemsskab = medlemsskab;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.alder = alder;
        this.restance = restance;
        this.oprettelsesDato = oprettelsesDato;
        this.dicipliner = dicipliner;
        this.bedsteTid = bedsteTid;
        this.stævne = stævne;
        this.træner = træner;
    }
}
