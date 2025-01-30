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
        Integer[] bidNums = new Integer[fileArray.length];
        String []faceCardsNotFixed = new String[fileArray.length];
        for (int i = 0; i < fileArray.length; i++)
        {
            bidNums[i] = Integer.parseInt(fileArray[i].substring(fileArray[i].indexOf("|") + 1));
            fileArray[i] = fileArray[i].substring(0, fileArray[i].indexOf("|"));
            fileArray[i] = fileArray[i].replace("Ace", "A");
            fileArray[i] = fileArray[i].replace("King", "B");
            fileArray[i] = fileArray[i].replace("Queen", "C");
            fileArray[i] = fileArray[i].replace("Jack", "D");
            fileArray[i] = fileArray[i].replace("10", "E");
            fileArray[i] = fileArray[i].replace("9", "F");
            fileArray[i] = fileArray[i].replace("8", "G");
            fileArray[i] = fileArray[i].replace("7", "H");
            fileArray[i] = fileArray[i].replace("6", "I");
            fileArray[i] = fileArray[i].replace("5", "J");
            fileArray[i] = fileArray[i].replace("4", "K");
            fileArray[i] = fileArray[i].replace("3", "L");
            fileArray[i] = fileArray[i].replace("2", "M");
        }
        System.arraycopy(fileArray, 0, faceCardsNotFixed, 0, fileArray.length);
        Arrays.sort(fileArray);
        HandChecker allCards = new HandChecker(fileArray);
        int five = 0;
        int four = 0;
        int full = 0;
        int three = 0;
        int twopair = 0;
        int onepair = 0;
        int high = 0;
        for (int i = 0; i < fileArray.length; i++)
        {
            if (allCards.checkFiveOfAKind(i))
            {
                five++;
            }
            else if (allCards.checkFourOfAKind(i))
            {
                four++;
            }
            else if (allCards.checkFullHouseOfAKind(i))
            {
                full++;
            }
            else if (allCards.checkThreeOfAKind(i))
            {
                three++;
            }
            else if (allCards.checkTwoPairOfAKind(i))
            {
                twopair++;
            }
            else if (allCards.checkOnePairOfAKind(i))
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
            if (allCards.checkFiveOfAKind(i))
            {
                fiveOfAKinds[five] = allCards.getLine(i);
                five++;
            }
            else if (allCards.checkFourOfAKind(i))
            {
                fourOfAKinds[four] = allCards.getLine(i);
                four++;
            }
            else if (allCards.checkFullHouseOfAKind(i))
            {
                fullHouseOfAKinds[full] = allCards.getLine(i);
                full++;
            }
            else if (allCards.checkThreeOfAKind(i))
            {
                threeOfAKinds[three] = allCards.getLine(i);
                three++;
            }
            else if (allCards.checkTwoPairOfAKind(i))
            {
                twoPairOfAKinds[twopair] = allCards.getLine(i);
                twopair++;
            }
            else if (allCards.checkOnePairOfAKind(i))
            {
                onePairOfAKinds[onepair] = allCards.getLine(i);
                onepair++;
            }
            else {
                highCardOfAKinds[high] = allCards.getLine(i);
                high++;
            }
        }
        int rank = fileArray.length;
        int indexBid = 0;
        int total  = 0;
        for (String fiveOfAKind : fiveOfAKinds) {
            for (int j = 0; j < faceCardsNotFixed.length; j++) {
                if (faceCardsNotFixed[j].equals(fiveOfAKind)) {
                    indexBid = j;

                }
            }

            total += bidNums[indexBid] * rank;
            rank--;
        }
        for (String fourOfAKind : fourOfAKinds) {
            for (int j = 0; j < faceCardsNotFixed.length; j++) {
                if (faceCardsNotFixed[j].equals(fourOfAKind)) {
                    indexBid = j;

                }
            }

            total += bidNums[indexBid] * rank;
            rank--;
        }
        for (String fullHouseOfAKind : fullHouseOfAKinds) {
            for (int j = 0; j < faceCardsNotFixed.length; j++) {
                if (faceCardsNotFixed[j].equals(fullHouseOfAKind)) {
                    indexBid = j;

                }
            }
            total += bidNums[indexBid] * rank;
            rank--;
        }
        for (String threeOfAKind : threeOfAKinds) {
            for (int j = 0; j < faceCardsNotFixed.length; j++) {
                if (faceCardsNotFixed[j].equals(threeOfAKind)) {
                    indexBid = j;

                }
            }

            total += bidNums[indexBid] * rank;
            rank--;
        }
        for (String twoPairOfAKind : twoPairOfAKinds) {
            for (int j = 0; j < faceCardsNotFixed.length; j++) {
                if (faceCardsNotFixed[j].equals(twoPairOfAKind)) {
                    indexBid = j;

                }
            }

            total += bidNums[indexBid] * rank;
            rank--;
        }
        for (String onePairOfAKind : onePairOfAKinds) {
            for (int j = 0; j < faceCardsNotFixed.length; j++) {
                if (faceCardsNotFixed[j].equals(onePairOfAKind)) {
                    indexBid = j;

                }
            }

            total += bidNums[indexBid] * rank;
            rank--;
        }
        for (String highCardOfAKind : highCardOfAKinds) {
            for (int j = 0; j < faceCardsNotFixed.length; j++) {
                if (faceCardsNotFixed[j].equals(highCardOfAKind)) {
                    indexBid = j;

                }
            }

            total += bidNums[indexBid] * rank;
            rank--;
        }
        System.out.println(total);
    }
}

