import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File f = new File("src/InputFile");
        Scanner s=  null;
        try {
            s = new Scanner(f);
        }
        catch (FileNotFoundException _){
            System.exit(1);
        }
        String fileData = "";
        while (s.hasNextLine())
        {
            fileData += s.nextLine() + "\n";
        }
        String [] fileArray = fileData.split("\n");
        for (int i = 0; i < fileArray.length; i++)
        {
            String[] splits = fileArray[i].split(",");
            String chop = splits[splits.length - 1];
            String getHi [] = chop.split("\\|");
            splits[splits.length - 1] = getHi[0];
            System.out.println(Arrays.toString(splits));
        }




    }
}