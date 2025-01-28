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
        int five = 0;
        int four = 0;
        int full = 0;
        int three = 0;
        int twopair = 0;
        int onepair = 0;
        int high = 0;
        for (int i = 0; i < fileArray.length; i++)
        {
            if (handCheckee.checkFiveOfAKind(i))
            {
                five++;
            }
            else if (handCheckee.checkFourOfAKind(i))
            {
                four++;
            }
            else if (handCheckee.checkFullHouseOfAKind(i))
            {
                full++;
            }
            else if (handCheckee.checkThreeOfAKind(i))
            {
                three++;
            }
            else if (handCheckee.checkTwoPairOfAKind(i))
            {
                twopair++;
            }
            else if (handCheckee.checkOnePairOfAKind(i))
            {
                onepair++;
                System.out.println(fileArray[i]);
            }
            else {
                high++;
            }
        }
        System.out.println(five);
        System.out.println(four);
        System.out.println(full);
        System.out.println(three);
        System.out.println(twopair);
        System.out.println(onepair);
        System.out.println(high);





    }
}