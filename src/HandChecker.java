import java.util.Arrays;
import java.util.Objects;

public class HandChecker {

    String[] list;
    public int rank;
    private String[] fiveOfAKinds;
    private String[] fourOfAKinds;
    private String[] fullHouseOfAKinds;
    private String[] threeOfAKinds;
    private String[] twoPairOfAKinds;
    private String[] onePairOfAKinds;
    private String[] highCardOfAKinds;

    public HandChecker(String[] list){
        this.list = list;
        rank = list.length;
        fiveOfAKinds = new String[list.length];
        fourOfAKinds = new String[list.length];
        fullHouseOfAKinds = new String[list.length];
        threeOfAKinds = new String[list.length];
        twoPairOfAKinds = new String[list.length];
        onePairOfAKinds = new String[list.length];
        highCardOfAKinds = new String[list.length];
    }



    public boolean checkFiveOfAKind(int line){
        String[] singleHand = list[line].split(",");
        return singleHand[0].equals(singleHand[1]) && singleHand[1].equals(singleHand[2]) && singleHand[2].equals(singleHand[3]) && singleHand[3].equals(singleHand[4]);
        }

        public boolean checkFourOfAKind(int line){
            String[] singleHand = list[line].split(",");
            Arrays.sort(singleHand);
            if (singleHand[0].equals(singleHand[1]) && singleHand[1].equals(singleHand[1+1]) && singleHand[1+1].equals(singleHand[1+1+1]))
                return true;
            return singleHand[1].equals(singleHand[1 + 1]) && singleHand[1 + 1].equals(singleHand[1 + 1 + 1]) && singleHand[1 + 1 + 1].equals(singleHand[1 + 1 + 1 + 1]);

        }

    public boolean checkFullHouseOfAKind(int line){
        String[] singleHand = list[line].split(",");
        Arrays.sort(singleHand);

        if (singleHand[0].equals(singleHand[1]) && singleHand[2].equals(singleHand[2+1]) && singleHand[1+1].equals(singleHand[1+1+1+1]))
            return true;
        return singleHand[0].equals(singleHand[1]) && singleHand[2].equals(singleHand[1]) && singleHand[3].equals(singleHand[1 + 1 + 1 + 1]);

    }

    public boolean checkThreeOfAKind(int line){
        String[] singleHand = list[line].split(",");
        Arrays.sort(singleHand);

        if (singleHand[0].equals(singleHand[1]) && singleHand[2].equals(singleHand[0]))
            return true;
        if (singleHand[1].equals(singleHand[2]) && singleHand[1].equals(singleHand[3]))
        {
            return true;
        }
        return singleHand[2].equals(singleHand[3]) && singleHand[2].equals(singleHand[4]);

    }

    public boolean checkTwoPairOfAKind(int line){
        String[] singleHand = list[line].split(",");
        Arrays.sort(singleHand);

        if (singleHand[0].equals(singleHand[1]) && singleHand[3].equals(singleHand[4]))
            return true;
        if (singleHand[1].equals(singleHand[2]) && singleHand[3].equals(singleHand[4]))
            return true;
        return singleHand[0].equals(singleHand[1]) && singleHand[2].equals(singleHand[3]);

    }
    public boolean checkOnePairOfAKind(int line){
        String[] singleHand = list[line].split(",");
        Arrays.sort(singleHand);
        return singleHand[0].equals(singleHand[1]) || singleHand[1].equals(singleHand[2]) || singleHand[2].equals(singleHand[3]) || singleHand[3].equals(singleHand[4]);

    }

    public int checkForJacks(int line){
        int totalJacks = 0;
        String[] singleHand = list[line].split(",");
        for (String card : singleHand) {
            if (card.equals("D")) {
                totalJacks += 1;
            }
            if (card.equals("Z"))
            {
                totalJacks += 1;
            }
        }
        return totalJacks;
    }

    public boolean checkFiveOfAKindJackWild(int line){
        return (checkFourOfAKind(line) && checkForJacks(line) == 1) || (checkFourOfAKind(line) && checkForJacks(line) == 4) || (checkFullHouseOfAKind(line) && (checkForJacks(line) == 2) || (checkFullHouseOfAKind(line) && checkForJacks(line) == 3) || checkFiveOfAKind(line));
    }

    public boolean checkFourOfAKindJackWild(int line){
        return (checkThreeOfAKind(line) && checkForJacks(line) == 1) || (checkThreeOfAKind(line) && checkForJacks(line) == 3) || (checkTwoPairOfAKind(line) && (checkForJacks(line) == 2) || checkFourOfAKind(line));
    }
    public boolean checkFullHouseOfAKindJackWild(int line){
        return (checkTwoPairOfAKind(line) && checkForJacks(line) == 1) || checkFullHouseOfAKind(line);
    }
    public boolean checkThreeOfAKindJackWild(int line){
        return (checkOnePairOfAKind(line) && checkForJacks(line) == 1) || (checkOnePairOfAKind(line) && checkForJacks(line) == 2) || checkThreeOfAKind(line);
    }
    public boolean checkTwoPairOfAKindJackWild(int line){
        return checkTwoPairOfAKind(line);
    }
    public boolean checkOnePairOfAKindJackWild(int line){
        return checkForJacks(line) == 1 || checkOnePairOfAKind(line);
    }



    public String getLine(int lineInput) {
        return list[lineInput];
    }

    public int getIndexofBid(String [] typeOfHand, String [] faceCardsNotFixed, Integer[] bidNums)
    {
        int total = 0;
        int indexBid = 0;
        for (String singleHand : typeOfHand) {
            for (int j = 0; j < faceCardsNotFixed.length; j++) {
                if (faceCardsNotFixed[j].equals(singleHand)) {
                    indexBid = j;
                }
            }

            total += bidNums[indexBid] * rank;
            rank--;
        }
        return total;
    }
    public void resetRank()
    {
        rank = list.length;
    }

    public int [] calculateNumsOfAllHands(boolean jackson) {
        int five = 0;
        int four = 0;
        int full = 0;
        int three = 0;
        int twoPair = 0;
        int onePair =  0;
        int high =  0;
        if (jackson)
        {
            Arrays.fill(fiveOfAKinds,null);
            Arrays.fill(fourOfAKinds,null);
            Arrays.fill(fullHouseOfAKinds,null);
            Arrays.fill(threeOfAKinds,null);
            Arrays.fill(twoPairOfAKinds,null);
            Arrays.fill(onePairOfAKinds,null);
            Arrays.fill(highCardOfAKinds,null);
        }
        for (int i = 0; i < list.length; i++) {
            if (!jackson) {
                if (checkFiveOfAKind(i)) {
                    five++;
                    fiveOfAKinds[i] = list[i];
                } else if (checkFourOfAKind(i)) {
                    four++;
                    fourOfAKinds[i] = list[i];
                } else if (checkFullHouseOfAKind(i)) {
                    full++;
                    fullHouseOfAKinds[i] = list[i];
                } else if (checkThreeOfAKind(i)) {
                    three++;
                    threeOfAKinds[i] = list[i];
                } else if (checkTwoPairOfAKind(i)) {
                    twoPair++;
                    twoPairOfAKinds[i] = list[i];
                } else if (checkOnePairOfAKind(i)) {
                    onePair++;
                    onePairOfAKinds[i] = list[i];
                } else {
                    high++;
                    highCardOfAKinds[i] = list[i];
                }
            } else {
                for (int j = 0; j < list.length; j++) {
                    list[j] = list[j].replace("D", "Z");
                    Arrays.sort(list);
                }
                if (checkFiveOfAKindJackWild(i)) {
                    five++;
                    fiveOfAKinds[i] = list[i];
                } else if (checkFourOfAKindJackWild(i)) {
                    four++;
                    fourOfAKinds[i] = list[i];
                } else if (checkFullHouseOfAKindJackWild(i)) {
                    full++;
                    fullHouseOfAKinds[i] = list[i];
                } else if (checkThreeOfAKindJackWild(i)) {
                    three++;
                    threeOfAKinds[i] = list[i];
                } else if (checkTwoPairOfAKindJackWild(i)) {
                    twoPair++;
                    twoPairOfAKinds[i] = list[i];
                } else if (checkOnePairOfAKindJackWild(i)) {
                    onePair++;
                    onePairOfAKinds[i] = list[i];
                } else {
                    high++;
                    highCardOfAKinds[i] = list[i];
                }
            }
        }
        return new int[]{five, four, full, three, twoPair, onePair, high};
    }

    public String[] cleanFiveOfAKindArray()
    {
        return Arrays.stream(fiveOfAKinds).filter(Objects::nonNull).toArray(String[]::new);
    }
    public String[] cleanFourOfAKindArray()
    {
        return Arrays.stream(fourOfAKinds).filter(Objects::nonNull).toArray(String[]::new);
    }
    public String[] cleanFullHouseArray()
    {
        return Arrays.stream(fullHouseOfAKinds).filter(Objects::nonNull).toArray(String[]::new);
    }
    public String[] cleanThreeOfAKind()
    {
        return Arrays.stream(threeOfAKinds).filter(Objects::nonNull).toArray(String[]::new);
    }
    public String[] cleanTwoPairArray()
    {
        return Arrays.stream(twoPairOfAKinds).filter(Objects::nonNull).toArray(String[]::new);
    }
    public String[] cleanOnePairArray()
    {
        return Arrays.stream(onePairOfAKinds).filter(Objects::nonNull).toArray(String[]::new);
    }
    public String[] cleanHighCardArray()
    {
        return Arrays.stream(highCardOfAKinds).filter(Objects::nonNull).toArray(String[]::new);
    }
}
