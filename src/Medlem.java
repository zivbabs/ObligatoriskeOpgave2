public class Medlem {
    //Variabler til medlemmer
    protected String medlemsskab;
    protected String fornavn;
    protected String efternavn;
    protected String alder;
    protected String restance;
    protected String status;
    protected String discValgt;
    protected String discipliner;
    protected String resultat;
    protected String stævne;
    protected String træner;
    //Constructor med parametre til motionister bruger this for at undgå sættere i subclasses.
    public Medlem(String medlemsskab, String fornavn, String efternavn, String alder, String restance, String status){
        this.medlemsskab = medlemsskab;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.alder = alder;
        this.restance = restance;
        this.status = status;
    }
    //Constructor med parametre til konkurrencesvømmere bruger this for at undgå settere i subclasses.
    public Medlem(String medlemsskab, String fornavn, String efternavn, String alder, String restance, String status, String discValgt, String discipliner, String resultat, String stævne, String træner){
        this.medlemsskab = medlemsskab;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.alder = alder;
        this.restance = restance;
        this.status = status;
        this.discValgt = discValgt;
        this.discipliner = discipliner;
        this.resultat = resultat;
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

    public void setDiscValgt(String discValgt) {
        this.discValgt = discValgt;
    }

    public void setTid(String resultat) {
        this.resultat = resultat;
    }

    public void setStævne(String stævne)
    {
        this.stævne = stævne;
    }

    public void setPlacering(int placering)
    {
        resultat = String.valueOf(placering);
    }
}
