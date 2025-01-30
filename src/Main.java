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
            }
            else {
                high++;
            }
        }




        String[] fiveOfAKinds = new String[five];
        String[] fourOfAKinds = new String[four];
        String[] fullHouseOfAKinds = new String[full];
        String[] threeOfAKinds = new String[three];
        String[] twoPairOfAKinds = new String[twopair];
        String[] onePairOfAKinds = new String[onepair];
        String[] highCardOfAKinds = new String[high];


        five = 0;
        four = 0;
        full = 0;
        three = 0;
        twopair = 0;
        onepair = 0;
        high = 0;




        for (int i = 0; i < fileArray.length; i++)
        {
            if (handCheckee.checkFiveOfAKind(i))
            {
                fiveOfAKinds[five] = handCheckee.getLine(i);
                five++;
            }
            else if (handCheckee.checkFourOfAKind(i))
            {
                fourOfAKinds[four] = handCheckee.getLine(i);
                four++;
            }
            else if (handCheckee.checkFullHouseOfAKind(i))
            {
                fullHouseOfAKinds[full] = handCheckee.getLine(i);
                full++;
            }
            else if (handCheckee.checkThreeOfAKind(i))
            {
                threeOfAKinds[three] = handCheckee.getLine(i);
                three++;
            }
            else if (handCheckee.checkTwoPairOfAKind(i))
            {
                twoPairOfAKinds[twopair] = handCheckee.getLine(i);
                twopair++;
            }
            else if (handCheckee.checkOnePairOfAKind(i))
            {
                onePairOfAKinds[onepair] = handCheckee.getLine(i);
                onepair++;
            }
            else {
                highCardOfAKinds[high] = handCheckee.getLine(i);
                high++;
            }
        }


        System.out.println(Arrays.toString(fiveOfAKinds));
        System.out.println(Arrays.toString(fourOfAKinds));
        System.out.println(Arrays.toString(fullHouseOfAKinds));
        System.out.println(Arrays.toString(threeOfAKinds));
        System.out.println(Arrays.toString(twoPairOfAKinds));
        System.out.println(Arrays.toString(onePairOfAKinds));
        System.out.println(Arrays.toString(highCardOfAKinds));

    }
}

