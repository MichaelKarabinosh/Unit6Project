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
        HandChecker allCards = new HandChecker(fileArray);
        boolean jackson = false;
        for (int l = 0; l < 2; l++) {
            int [] numsOfHands = allCards.calculateNumsOfAllHands(jackson);
            String[] fiveOfAKinds = allCards.cleanFiveOfAKindArray();
            String[] fourOfAKinds = allCards.cleanFourOfAKindArray();
            String[] fullHouseOfAKinds = allCards.cleanFullHouseArray();
            String[] threeOfAKinds = allCards.cleanThreeOfAKind();
            String[] twoPairOfAKinds = allCards.cleanTwoPairArray();
            String[] onePairOfAKinds = allCards.cleanOnePairArray();
            String[] highCardOfAKinds = allCards.cleanHighCardArray();

            int total = 0;
            total += allCards.getIndexofBid(fiveOfAKinds);
            total += allCards.getIndexofBid(fourOfAKinds);
            total += allCards.getIndexofBid(fullHouseOfAKinds);
            total += allCards.getIndexofBid(threeOfAKinds);
            total += allCards.getIndexofBid(twoPairOfAKinds);
            total += allCards.getIndexofBid(onePairOfAKinds);
            total += allCards.getIndexofBid(highCardOfAKinds);
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
