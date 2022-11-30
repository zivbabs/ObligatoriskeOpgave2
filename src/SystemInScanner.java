import java.time.LocalDate;
import java.util.Scanner;

public class SystemInScanner {
    Texthandler th = new Texthandler();
    public int inputInt() {
        boolean success = false;
        int output = 0;

        while (!success) {
            try {

                Scanner scn = new Scanner(System.in);
                String input = scn.next();

                if(input.length() <= 4) {
                    output = Integer.parseInt(input);
                    success = true;
                }
                else{
                    th.forMangeCharPrint();
                }
            }catch (NumberFormatException e) {
                th.kunTalPrint();
            }
        }
        return output;
    }
    public String inputString(){
        boolean success = false;
        String output = "";

        while(!success){

            Scanner scn = new Scanner(System.in);
            String input = scn.next();
            char[] chars = input.toCharArray();

            if(input.length() < 20) {
                for (char aChar : chars) {
                    if(Character.isLetter(aChar) || aChar == 'æ' || aChar == 'Æ' || aChar == 'ø' || aChar == 'Ø' || aChar == 'å' || aChar == 'Å'){
                        output = output.concat(Character.toString(aChar));
                        if(output.length() == input.length() && output.lastIndexOf(output) == input.lastIndexOf(input)){
                            success = true;
                        }                    }
                    else{
                        th.ingenBogstavPrint();
                        output = "";
                        break;
                    }
                }
            }
            else{
                th.forMangeCharPrint();
            }
        }
        return output;
    }

    public String inputAlder() {
        String fDato = "";
        boolean success = false;
        String årstal = "";
        String måned = "";
        String dag = "";

        while(!success){
            try {

                th.printIndtastÅrstal();
                String input1 = String.valueOf(inputInt());
                if(input1.length() == 4 && Integer.parseInt(input1) < LocalDate.now().getYear()){
                    årstal = input1;
                }

                th.printIndtastMåned();
                String input2 = String.valueOf(inputInt());
                if(input2.length() <= 2 && Integer.parseInt(input2) <= 12){
                    if(input2.length() == 1){
                        måned = "0"+input2;
                    }
                    else {
                        måned = input2;
                    }
                }

                th.printIndtastDag();
                String input3 = String.valueOf(inputInt());
                if(input3.length() <= 2 && Integer.parseInt(input3) <= 31){
                    if(input3.length() == 1){
                        dag = "0"+input3;
                    }
                    else{
                        dag = input3;
                    }
                    success = true;
                }

            }catch(Exception e){
                th.forkertInputPrint();
            }
        }
        fDato = årstal + "-" + måned + "-" + dag;
        return fDato;
    }
}
