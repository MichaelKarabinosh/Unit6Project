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
        String[] jackFileArray = new String[fileArray.length];
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
        HandChecker allCardsJack = new HandChecker(jackFileArray);
        int five = 0;
        int four = 0;
        int full = 0;
        int three = 0;
        int twoPair = 0;
        int onePair = 0;
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
                twoPair++;
            }
            else if (allCards.checkOnePairOfAKind(i))
            {
                onePair++;
            }
            else {
                high++;
            }
        }

        String[] fiveOfAKinds = new String[five];
        String[] fourOfAKinds = new String[four];
        String[] fullHouseOfAKinds = new String[full];
        String[] threeOfAKinds = new String[three];
        String[] twoPairOfAKinds = new String[twoPair];
        String[] onePairOfAKinds = new String[onePair];
        String[] highCardOfAKinds = new String[high];

        five = 0;
        four = 0;
        full = 0;
        three = 0;
        twoPair = 0;
        onePair = 0;
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
                twoPairOfAKinds[twoPair] = allCards.getLine(i);
                twoPair++;
            }
            else if (allCards.checkOnePairOfAKind(i))
            {
                onePairOfAKinds[onePair] = allCards.getLine(i);
                onePair++;
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
        System.out.println("Number of five of a kind hands: " + five);
        System.out.println("Number of four of a kind hands: " + four);
        System.out.println("Number of full house hands: " + full);
        System.out.println("Number of three of a kind hands: " + three);
        System.out.println("Number of two pair hands: " + twoPair);
        System.out.println("Number of one pair hands: " + onePair);
        System.out.println("Number of high card hands: " + high);
        System.out.println("Total Bid Value: " + total);
        total = 0;
        System.arraycopy(fileArray, 0, jackFileArray, 0, fileArray.length);
        for (int i = 0; i <faceCardsNotFixed.length; i++)
        {
            faceCardsNotFixed[i] = faceCardsNotFixed[i].replace("D","Z");
            jackFileArray[i] = jackFileArray[i].replace("D","Z");
        }
        rank = jackFileArray.length;
        Arrays.sort(jackFileArray);
        int fiveJack = 0;
        int fourJack = 0;
        int fullJack = 0;
        int threeJack = 0;
        int twoPairJack = 0;
        int onePairJack = 0;
        int highJack = 0;
        for (int i = 0; i < jackFileArray.length; i++)
        {
            if (allCardsJack.checkFiveOfAKindJackWild(i))
            {
                fiveJack++;
            }
            else if (allCardsJack.checkFourOfAKindJackWild(i))
            {
                fourJack++;
            }
            else if (allCardsJack.checkFullHouseOfAKindJackWild(i))
            {
                fullJack++;
            }
            else if (allCardsJack.checkThreeOfAKindJackWild(i))
            {
                threeJack++;
            }
            else if (allCardsJack.checkTwoPairOfAKindJackWild(i))
            {
                twoPairJack++;
            }
            else if (allCardsJack.checkOnePairOfAKindJackWild(i))
            {
                onePairJack++;
            }
            else {
                highJack++;
            }
        }

        String[] fiveOfAKindsJack = new String[fiveJack];
        String[] fourOfAKindsJack = new String[fourJack];
        String[] fullHouseOfAKindsJack = new String[fullJack];
        String[] threeOfAKindsJack = new String[threeJack];
        String[] twoPairOfAKindsJack = new String[twoPairJack];
        String[] onePairOfAKindsJack = new String[onePairJack];
        String[] highCardOfAKindsJack = new String[highJack];


        fiveJack = 0;
        fourJack = 0;
        fullJack = 0;
        threeJack = 0;
        twoPairJack = 0;
        onePairJack = 0;
        highJack = 0;
        for (int i = 0; i < jackFileArray.length; i++)
        {
            if (allCards.checkFiveOfAKindJackWild(i))
            {
                fiveOfAKindsJack[fiveJack] = allCardsJack.getLine(i);
                fiveJack++;
            }
            else if (allCards.checkFourOfAKindJackWild(i))
            {
                fourOfAKindsJack[fourJack] = allCardsJack.getLine(i);
                fourJack++;
            }
            else if (allCards.checkFullHouseOfAKindJackWild(i))
            {
                fullHouseOfAKindsJack[fullJack] = allCardsJack.getLine(i);
                fullJack++;
            }
            else if (allCards.checkThreeOfAKindJackWild(i))
            {
                threeOfAKindsJack[threeJack] = allCardsJack.getLine(i);
                threeJack++;
            }
            else if (allCards.checkTwoPairOfAKindJackWild(i))
            {
                twoPairOfAKindsJack[twoPairJack] = allCardsJack.getLine(i);
                twoPairJack++;
            }
            else if (allCards.checkOnePairOfAKindJackWild(i))
            {
                onePairOfAKindsJack[onePairJack] = allCardsJack.getLine(i);
                onePairJack++;
            }
            else {
                highCardOfAKindsJack[highJack] = allCardsJack.getLine(i);
                highJack++;
            }
        }

        for (String fiveOfAKind : fiveOfAKindsJack) {
            for (int j = 0; j < faceCardsNotFixed.length; j++) {
                if (faceCardsNotFixed[j].equals(fiveOfAKind)) {
                    indexBid = j;

                }
            }

            total += bidNums[indexBid] * rank;
            rank--;
        }
        for (String fourOfAKind : fourOfAKindsJack) {
            for (int j = 0; j < faceCardsNotFixed.length; j++) {
                if (faceCardsNotFixed[j].equals(fourOfAKind)) {
                    indexBid = j;

                }
            }

            total += bidNums[indexBid] * rank;
            rank--;
        }
        for (String fullHouseOfAKind : fullHouseOfAKindsJack) {
            for (int j = 0; j < faceCardsNotFixed.length; j++) {
                if (faceCardsNotFixed[j].equals(fullHouseOfAKind)) {
                    indexBid = j;

                }
            }
            total += bidNums[indexBid] * rank;
            rank--;
        }
        for (String threeOfAKind : threeOfAKindsJack) {
            for (int j = 0; j < faceCardsNotFixed.length; j++) {
                if (faceCardsNotFixed[j].equals(threeOfAKind)) {
                    indexBid = j;

                }
            }

            total += bidNums[indexBid] * rank;
            rank--;
        }
        for (String twoPairOfAKind : twoPairOfAKindsJack) {
            for (int j = 0; j < faceCardsNotFixed.length; j++) {
                if (faceCardsNotFixed[j].equals(twoPairOfAKind)) {
                    indexBid = j;

                }
            }

            total += bidNums[indexBid] * rank;
            rank--;
        }
        for (String onePairOfAKind : onePairOfAKindsJack) {
            for (int j = 0; j < faceCardsNotFixed.length; j++) {
                if (faceCardsNotFixed[j].equals(onePairOfAKind)) {
                    indexBid = j;

                }
            }

            total += bidNums[indexBid] * rank;
            rank--;
        }
        for (String highCardOfAKind : highCardOfAKindsJack) {
            for (int j = 0; j < faceCardsNotFixed.length; j++) {
                if (faceCardsNotFixed[j].equals(highCardOfAKind)) {
                    indexBid = j;

                }
            }

            total += bidNums[indexBid] * rank;
            rank--;
        }
        System.out.println("Total Bid Value With Jacks Wild: " + total);
    }
}

