import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File f = new File("src/InputFile");
        try {
            Scanner s = new Scanner(f);
        }
        catch (FileNotFoundException _){
            System.exit(1);
        }



    }
}