public class Medlem {
    //Variabler til medlemmer
    protected String medlemsskab;
    protected String fornavn;
    protected String efternavn;
    protected String alder;
    protected String restance;
    protected String træningsDisc;
    protected String discipliner;
    protected String bedsteTid;
    protected String stævne;
    protected String træner;
    //Constructor uden parametre
    public Medlem(){
    }
    //Constructor med parametre til motionister bruger this for at undgå sættere i subclasses.
    public Medlem(String medlemsskab, String fornavn, String efternavn, String alder, String restance, String træningsDisc){
        this.medlemsskab = medlemsskab;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.alder = alder;
        this.restance = restance;
        this.træningsDisc = træningsDisc;
    }
    //Constructor med parametre til konkurrencesvømmere bruger this for at undgå settere i subclasses.
    public Medlem(String medlemsskab, String fornavn, String efternavn, String alder, String restance, String træningsDisc, String discipliner, String bedsteTid, String stævne, String træner){
        this.medlemsskab = medlemsskab;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.alder = alder;
        this.restance = restance;
        this.træningsDisc = træningsDisc;
        this.discipliner = discipliner;
        this.bedsteTid = bedsteTid;
        this.stævne = stævne;
        this.træner = træner;
    }
    //Setter til restance for at kunne redigere den.
    public void setRestance(String restance) {
        this.restance = restance;
    }
    //Setter til discipliner for at kunne redigere den.
    public void setDisciplin(String discipliner) {
        this.discipliner = discipliner;
    }
    //Setter til træner for at kunne redigere den.
    public void setTræner(String træner) {
        this.træner = træner;
    }

    public void setTræningsDisc(String træningsDisc) {
        this.træningsDisc = træningsDisc;
    }

    public void setTid(String bedsteTid) {
        this.bedsteTid = bedsteTid;
    }

    public void setStævne(String stævne)
    {
        this.stævne = stævne;
    }

    public void setPlacering(int placering)
    {
        bedsteTid = String.valueOf(placering);
    }
}
