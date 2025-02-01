import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {


        File f = new File("src/InputFile");
        Scanner s = null;
        try {
            s = new Scanner(f);
        } catch (FileNotFoundException _) {
            System.exit(1);
        }
        String fileData = "";
        while (s.hasNextLine()) {
            fileData += s.nextLine() + "\n";
        }
        String[] fileArray = fileData.split("\n");
        Integer[] bidNums = new Integer[fileArray.length];
        String[] faceCardsNotFixed = new String[fileArray.length];
        for (int i = 0; i < fileArray.length; i++) {
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
        HandChecker allCards = new HandChecker(fileArray);
        boolean jackson = false;
        for (int l = 0; l < 2; l++) {
            if (jackson) {
                for (int i = 0; i < faceCardsNotFixed.length; i++) {
                    faceCardsNotFixed[i] = faceCardsNotFixed[i].replace("D", "Z");
                }
            }
            Arrays.sort(fileArray);
            int [] numsOfHands = allCards.calculateNumsOfAllHands(jackson);
            String[] fiveOfAKinds = allCards.cleanFiveOfAKindArray();
            String[] fourOfAKinds = allCards.cleanFourOfAKindArray();
            String[] fullHouseOfAKinds = allCards.cleanFullHouseArray();
            String[] threeOfAKinds = allCards.cleanThreeOfAKind();
            String[] twoPairOfAKinds = allCards.cleanTwoPairArray();
            String[] onePairOfAKinds = allCards.cleanOnePairArray();
            String[] highCardOfAKinds = allCards.cleanHighCardArray();

            int total = 0;
            total += allCards.getIndexofBid(fiveOfAKinds, faceCardsNotFixed, bidNums);
            total += allCards.getIndexofBid(fourOfAKinds, faceCardsNotFixed, bidNums);
            total += allCards.getIndexofBid(fullHouseOfAKinds, faceCardsNotFixed, bidNums);
            total += allCards.getIndexofBid(threeOfAKinds, faceCardsNotFixed, bidNums);
            total += allCards.getIndexofBid(twoPairOfAKinds, faceCardsNotFixed, bidNums);
            total += allCards.getIndexofBid(onePairOfAKinds, faceCardsNotFixed, bidNums);
            total += allCards.getIndexofBid(highCardOfAKinds, faceCardsNotFixed, bidNums);
            if (!jackson) {
                System.out.println("Number of five of a kind hands: " + numsOfHands[0]);
                System.out.println("Number of full house hands: " + numsOfHands[2]);
                System.out.println("Number of four of a kind hands: " + numsOfHands[1]);
                System.out.println("Number of three of a kind hands: " + numsOfHands[3]);
                System.out.println("Number of two pair hands: " + numsOfHands[4]);
                System.out.println("Number of one pair hands: " + numsOfHands[5]);
                System.out.println("Number of high card hands: " + numsOfHands[6]);
                System.out.println("Total Bid Value: " + total);
                allCards.resetRank();
            }
            if (jackson) {
                System.out.println("Total Bid Value With Jacks Wild: " + total);
            }
            jackson = true;
        }
    }
}
