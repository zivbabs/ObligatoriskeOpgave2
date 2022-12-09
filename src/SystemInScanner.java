import java.time.LocalDate; //Import af localdate til dato og scanner.
import java.util.Scanner;
//SystemInScanner klassen bruges for at undgå repetition i kode da den skal bruges ved alle inputs
public class SystemInScanner {
    //Import af texthandler til konsol udprintninger.
    Texthandler th = new Texthandler();
    //Metode til at håndtere input som forventes at være en integer på maks 9999
    public int inputInt() {
        boolean success = false;
        int output = 0;
        //while loop med boolean som condition til break
        while (!success) {
            try {
                //Scanner så den starter forfra ved break
                Scanner scn = new Scanner(System.in);
                String input = scn.next();
                //Check af længde da den aldrig skal bruges som større end 4 for at undgå store tal ved fejl
                if(input.length() <= 4) {
                    output = Integer.parseInt(input); //Parse til int for at være sikker på det er et tal
                    success = true;
                }
                else{
                    th.forMangeCharPrint(); //Så den starter forfra ved for mere end 4 chars.
                }
            }catch (NumberFormatException notNumber) { //Exception hvis det ikke er et tal
                th.kunTalPrint();
            }
        }
        return output;
    }
    //Metode for at lave et string input som ikke må indeholde tal.
    public String inputString(){
        boolean success = false;
        String output = "";

        while(!success){

            Scanner scn = new Scanner(System.in);
            String input = scn.next();
            char[] chars = input.toCharArray();
            //Laver string input om til chars og kører ind i et array
            if(input.length() < 20) {
                for (char aChar : chars) { //for each loop med chars i array checker derefter om det er en letter char eller specificerede chars
                    if(Character.isLetter(aChar) || aChar == 'æ' || aChar == 'Æ' || aChar == 'ø' || aChar == 'Ø' || aChar == 'å' || aChar == 'Å'){
                        output = output.concat(Character.toString(aChar)); //Bygger chars tilbage til en string
                        //Checker længden er den samme efter vi har checket for chars og bygget string igen
                        if(output.length() == input.length() && output.lastIndexOf(output) == input.lastIndexOf(input)){
                            success = true;
                        }
                    }
                    else{ //Hvis den indeholder ting der ikke er bogstaver eller specificerede chars
                        th.ingenBogstavPrint();
                        output = "";
                        break;
                    }
                }
            }
            else{ //Hvis der er mere end 20 chars som specificeret i if sætning
                th.forMangeCharPrint();
            }
        }
        return output;
    }
    //Metode til at bygge fødselsdato til en string som kan parses til localdate
    public String inputAlder() {
        boolean success = false;
        String årstal = "";
        String måned = "";
        String dag = "";

        while(!success) {
            //første input som skal være 4 pga. den er et årstal og checker den er mindre end vores nuværende årstal
            th.printIndtastÅrstal();
            String inputÅrstal = String.valueOf(inputInt());
            if (inputÅrstal.length() == 4 && Integer.parseInt(inputÅrstal) < LocalDate.now().getYear()) {
                årstal = inputÅrstal;
            }
            //andet input der checker at den er mindre end 2 lang og mindre end tallet 12 da det er måneder
            th.printIndtastMåned();
            String inputMåned = String.valueOf(inputInt());
            if (inputMåned.length() <= 2 && Integer.parseInt(inputMåned) <= 12 && Integer.parseInt(inputMåned) > 0) {
                //checker her om den er længden kun er 1 hvis den er skal der tilføjes et 0 fx. januer = 1.
                if (inputMåned.length() == 1) {
                    måned = "0" + inputMåned;
                } else {
                    måned = inputMåned;
                }
            }
            //Tredje input til dage checker om på samme måde som måned checker, bortset fra tallet kan være op til 31.
            th.printIndtastDag();
            String inputDag = String.valueOf(inputInt());
            if (inputDag.length() <= 2 && Integer.parseInt(inputDag) <= 31 && Integer.parseInt(inputDag) > 0) {
                if (inputDag.length() == 1) {
                    dag = "0" + inputDag;
                } else {
                    dag = inputDag;
                }
            }
            if (!årstal.isEmpty() && !måned.isEmpty() && !dag.isEmpty()) {
                success = true;
            } else {
                th.forkertInputPrint();
                årstal = "";
                måned = "";
                dag = "";
            }
        }
        //Bygger string som en localdate
        return årstal + "-" + måned + "-" + dag;
    }
    //Metode som returnere træningstid som en string, indelt i minutter, sekunder og miliskeunder, adskilt af :
    public String inputTid() {
        String min = "";
        String sek = "";
        String mili = "";
        boolean success = false;

        while(!success) {
            th.printMinutter();
            String inputMin = String.valueOf(inputInt());
            if (inputMin.length() <= 2 && Integer.parseInt(inputMin) <= 59 && Integer.parseInt(inputMin) >= 0) {
                if (inputMin.length() == 2) {
                    min = inputMin;
                } else {
                    min = "0" + inputMin;
                }
            }
            //andet input der checker at den er mindre end 2 lang og mindre end tallet 59 da det er sekunder
            th.printSekunder();
            String inputSek = String.valueOf(inputInt());
            if (inputSek.length() <= 2 && Integer.parseInt(inputSek) <= 59 && Integer.parseInt(inputSek) >= 0) {
                //checker her om den er længden kun er 1 hvis den er skal der tilføjes et 0
                if (inputSek.length() == 2) {
                    sek = inputSek;
                } else {
                    sek = "0" + inputSek;
                }
            }
            //Tredje input der checker at den er mindre end 2 lang og mindre end tallet 59 da det er 100 dele kun 2 decimaler
            th.print100dele();
            String inputMili = String.valueOf(inputInt());
            if (inputMili.length() <= 2 && Integer.parseInt(inputMili) <= 99 && Integer.parseInt(inputMin) >= 0) {
                if (inputMili.length() == 2) {
                    mili = inputMili;
                } else {
                    mili = "0" + inputMili;
                }
            }
            if (!min.isEmpty() && !sek.isEmpty() && !mili.isEmpty()) {
                success = true;
            } else {
                th.forkertInputPrint();
                min = "";
                sek = "";
                mili = "";
            }
        }
        return min+":"+sek+":"+mili;
    }
    //Metode som tjekker at når der bliver tilføjet en træner til en konkurrencesvømmer, må træneren maks have 3 initialer.
    public String inputTræner() {
        String trænerInitialer = "";
        boolean success = false;

        while(!success){
            String inputTrænerInitialer = inputString();

            if(inputTrænerInitialer.length() <= 3 && inputTrænerInitialer.length() > 1){
                trænerInitialer = inputTrænerInitialer.toUpperCase();
                success = true;
            }
            else{
                th.forkertInputPrint();
            }
        }
        return trænerInitialer;
    }
    //Metode som tjekker om input er uden for de rammer vi har sat de forskellige steder.
    public int inputOOBLength(int idTemp, int listSize){
        int id = 0;
        boolean success = false;

        while(!success){

            if(idTemp <= listSize -1 && idTemp > -1){
                id = idTemp;
                success = true;
            }
            else{
                th.forkertInputPrint();
                idTemp = inputInt();
            }

        }
        return id;
    }
}
