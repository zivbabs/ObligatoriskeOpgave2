public class Motionist extends Medlem{
    //Constructor til motionister bruger super for at undgå settere.
    public Motionist(String medlemsskab, String fornavn, String efternavn, String alder, String restance, String træningsDisc){
        super(medlemsskab, fornavn, efternavn, alder, restance, træningsDisc);
    }
}
