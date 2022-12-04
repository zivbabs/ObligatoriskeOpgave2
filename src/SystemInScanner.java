import java.time.LocalDate; //Import af localdate til dato og scanner.
import java.util.Scanner;
//SystemInScanner klassen bruges for at undgå repetition i kode da den skal bruges ved alle inputs
public class SystemInScanner {
    //Import af texthandler til konsol udprintninger.
    Texthandler th = new Texthandler();
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
            }catch (NumberFormatException e) { //Exception hvis det ikke er et tal
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
        String fDato = "";
        boolean success = false;
        String årstal = "";
        String måned = "";
        String dag = "";

        while(!success){
            try {
                //første input som skal være 4 pga. den er et årstal og checker den er mindre end vores nuværende årstal
                th.printIndtastÅrstal();
                String input1 = String.valueOf(inputInt());
                if(input1.length() == 4 && Integer.parseInt(input1) < LocalDate.now().getYear()){
                    årstal = input1;
                }
                //andet input der checker at den er mindre end 2 lang og mindre end tallet 12 da det er måneder
                th.printIndtastMåned();
                String input2 = String.valueOf(inputInt());
                if(input2.length() <= 2 && Integer.parseInt(input2) <= 12 && Integer.parseInt(input2)>0){
                    //checker her om den er længden kun er 1 hvis den er skal der tilføjes et 0 fx. januer = 1.
                    if(input2.length() == 1){
                        måned = "0"+input2;
                    }
                    else {
                        måned = input2;
                    }
                }
                //Tredje input til dage checker om på samme måde som måned checker, bortset fra tallet kan være op til 31.
                th.printIndtastDag();
                String input3 = String.valueOf(inputInt());
                if(input3.length() <= 2 && Integer.parseInt(input3) <= 31 && Integer.parseInt(input3)>0){
                    if(input3.length() == 1){
                        dag = "0"+input3;
                    }
                    else{
                        dag = input3;
                    }
                }
                if (!årstal.isEmpty() && !måned.isEmpty() && !dag.isEmpty()) {
                    success = true;
                }
                else {
                    th.forkertInputPrint();
                    årstal = "";
                    måned = "";
                    dag = "";
                }
            }catch(Exception e){ //Catch hvis inputs ikke stemmer overens med det der skal bruges
                th.forkertInputPrint();
            }
        }
        //Bygger string som en localdate
        fDato = årstal + "-" + måned + "-" + dag;
        return fDato;
    }

    public String inputTid() {
        String tid = "";
        String min = "";
        String sek = "";
        String mili = "";
        boolean success = false;

        while(!success){
            try{
                th.printMinutter();
                String input1 = String.valueOf(inputInt());
                if(input1.length() <= 2 && Integer.parseInt(input1) <= 59){
                    if(input1.length() == 2) {
                        min = input1;
                    }
                    else{
                        min = "0"+input1;
                    }
                }
                //andet input der checker at den er mindre end 2 lang og mindre end tallet 59 da det er sekunder
                th.printSekunder();
                String input2 = String.valueOf(inputInt());
                if(input2.length() <= 2 && Integer.parseInt(input2) <= 59){
                    //checker her om den er længden kun er 1 hvis den er skal der tilføjes et 0
                    if(input2.length() == 2){
                        sek = input2;
                    }
                    else {
                        sek = "0"+input2;
                    }
                }
                //Tredje input der checker at den er mindre end 2 lang og mindre end tallet 59 da det er 100 dele kun 2 decimaler
                th.print100dele();
                String input3 = String.valueOf(inputInt());
                if(input3.length() <= 2 && Integer.parseInt(input3) <= 99) {
                    if (input3.length() == 2) {
                        mili = input3;
                    } else {
                        mili = "0"+input3;
                    }
                }
                if (!min.isEmpty() && !sek.isEmpty() && !mili.isEmpty()) {
                    success = true;
                }
                else {
                    th.forkertInputPrint();
                    min = "";
                    sek = "";
                    mili = "";
                }

            }catch(Exception e){
                th.forkertInputPrint();
            }
        }
        tid = min+":"+sek+":"+mili;
        return tid;
    }
    public int inputTræner(int a, int b) {
        int c = 0;



        return c;
    }
}
