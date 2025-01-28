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
        String bigList [] = new String[158];
        for (int i = 0; i < fileArray.length; i++)
        {
            fileArray[i] = fileArray[i].substring(0, fileArray[i].indexOf("|"));
        }
        HandChecker handCheckee = new HandChecker(fileArray);
        System.out.println(handCheckee.checkFiveOfAKind(0));
        System.out.println(Arrays.toString(fileArray));

        System.out.println(handCheckee.checkFourOfAKind(0));
        System.out.println(handCheckee.checkFullHouseOfAKind(0));
        System.out.println(handCheckee.checkThreeOfAKind(0));
        System.out.println(handCheckee.checkTwoPairOfAKind(0));
        System.out.println(handCheckee.checkOnePairOfAKind(0));





    }
}