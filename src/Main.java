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
        boolean jacks = false;
        int five = 0;
        int four = 0;
        int full = 0;
        int three = 0;
        int twoPair = 0;
        int onePair = 0;
        int high = 0;
        for (int l = 0; l < 2; l++) {
            if (jacks) {
                for (int i = 0; i < faceCardsNotFixed.length; i++) {
                    faceCardsNotFixed[i] = faceCardsNotFixed[i].replace("D", "Z");
                    fileArray[i] = fileArray[i].replace("D", "Z");
                }
            }
            Arrays.sort(fileArray);
            for (int i = 0; i < fileArray.length; i++) {
                if (!jacks) {
                    if (allCards.checkFiveOfAKind(i)) {
                        five++;
                    } else if (allCards.checkFourOfAKind(i)) {
                        four++;
                    } else if (allCards.checkFullHouseOfAKind(i)) {
                        full++;
                    } else if (allCards.checkThreeOfAKind(i)) {
                        three++;
                    } else if (allCards.checkTwoPairOfAKind(i)) {
                        twoPair++;
                    } else if (allCards.checkOnePairOfAKind(i)) {
                        onePair++;
                    } else {
                        high++;
                    }
                } else {
                    if (allCards.checkFiveOfAKindJackWild(i)) {
                        five++;
                    } else if (allCards.checkFourOfAKindJackWild(i)) {
                        four++;
                    } else if (allCards.checkFullHouseOfAKindJackWild(i)) {
                        full++;
                    } else if (allCards.checkThreeOfAKindJackWild(i)) {
                        three++;
                    } else if (allCards.checkTwoPairOfAKindJackWild(i)) {
                        twoPair++;
                    } else if (allCards.checkOnePairOfAKindJackWild(i)) {
                        onePair++;
                    } else {
                        high++;
                    }
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


            for (int i = 0; i < fileArray.length; i++) {
                if (!jacks) {
                    if (allCards.checkFiveOfAKind(i)) {
                        fiveOfAKinds[five] = allCards.getLine(i);
                        five++;
                    } else if (allCards.checkFourOfAKind(i)) {
                        fourOfAKinds[four] = allCards.getLine(i);
                        four++;
                    } else if (allCards.checkFullHouseOfAKind(i)) {
                        fullHouseOfAKinds[full] = allCards.getLine(i);
                        full++;
                    } else if (allCards.checkThreeOfAKind(i)) {
                        threeOfAKinds[three] = allCards.getLine(i);
                        three++;
                    } else if (allCards.checkTwoPairOfAKind(i)) {
                        twoPairOfAKinds[twoPair] = allCards.getLine(i);
                        twoPair++;
                    } else if (allCards.checkOnePairOfAKind(i)) {
                        onePairOfAKinds[onePair] = allCards.getLine(i);
                        onePair++;
                    } else {
                        highCardOfAKinds[high] = allCards.getLine(i);
                        high++;
                    }
                } else {
                    if (allCards.checkFiveOfAKindJackWild(i)) {
                        fiveOfAKinds[five] = allCards.getLine(i);
                        five++;
                    } else if (allCards.checkFourOfAKindJackWild(i)) {
                        fourOfAKinds[four] = allCards.getLine(i);
                        four++;
                    } else if (allCards.checkFullHouseOfAKindJackWild(i)) {
                        fullHouseOfAKinds[full] = allCards.getLine(i);
                        full++;
                    } else if (allCards.checkThreeOfAKindJackWild(i)) {
                        threeOfAKinds[three] = allCards.getLine(i);
                        three++;
                    } else if (allCards.checkTwoPairOfAKindJackWild(i)) {
                        twoPairOfAKinds[twoPair] = allCards.getLine(i);
                        twoPair++;
                    } else if (allCards.checkOnePairOfAKindJackWild(i)) {
                        onePairOfAKinds[onePair] = allCards.getLine(i);
                        onePair++;
                    } else {
                        highCardOfAKinds[high] = allCards.getLine(i);
                        high++;
                    }
                }
            }
            int rank = fileArray.length;
            int indexBid = 0;
            int total = 0;
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
            if (!jacks) {
                System.out.println("Number of five of a kind hands: " + five);
                System.out.println("Number of four of a kind hands: " + four);
                System.out.println("Number of full house hands: " + full);
                System.out.println("Number of three of a kind hands: " + three);
                System.out.println("Number of two pair hands: " + twoPair);
                System.out.println("Number of one pair hands: " + onePair);
                System.out.println("Number of high card hands: " + high);
                System.out.println("Total Bid Value: " + total);
            }
            if (jacks) {
                System.out.println("Total Bid Value With Jacks Wild: " + total);
            }
            five = 0;
            four = 0;
            full = 0;
            three = 0;
            twoPair = 0;
            onePair = 0;
            high = 0;
            jacks = true;
        }
    }
}
