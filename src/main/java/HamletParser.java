import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {


    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    /* Using basic "Hamlet" to match b/c regex of [Hh][Aa][Mm][Ll][Ee][Tt] will not address
       places where we come across replacing "Hamlet" vs "HAMLET"
     */

        public String changeHamletToLeon() {

            Pattern pattern = Pattern.compile("Hamlet");
            Matcher matchHamlet = pattern.matcher(hamletData);
            hamletData = (matchHamlet.replaceAll("Leon"));

            Pattern pattern2 = Pattern.compile("HAMLET");
            Matcher matchHamlet2 = pattern2.matcher(hamletData);
            hamletData = (matchHamlet2.replaceAll("LEON"));

            return hamletData;
        }

        public String changeHoratioToTariq () {
            Pattern pattern = Pattern.compile("Horatio");
            Matcher matchHoratio = pattern.matcher(hamletData);
            hamletData = (matchHoratio.replaceAll("Tariq"));

            Pattern pattern2 = Pattern.compile("HORATIO");
            Matcher matchHoratio2 = pattern2.matcher(hamletData);
            hamletData = (matchHoratio2.replaceAll("TARIQ"));

            return hamletData;
        }

    public String getHamletData() {
        hamletData = changeHamletToLeon();
        hamletData = changeHoratioToTariq();
        return hamletData;
    }
}
