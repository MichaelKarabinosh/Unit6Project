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
    private Integer [] bidNums;
   private  String [] faceCardsNotFixed;

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
         bidNums = new Integer[list.length];
        faceCardsNotFixed = new String[list.length];
        for (int i = 0; i < list.length; i++) {
            bidNums[i] = Integer.parseInt(list[i].substring(list[i].indexOf("|") + 1));
            list[i] = list[i].substring(0, list[i].indexOf("|"));
            list[i] = list[i].replace("Ace", "A");
            list[i] = list[i].replace("King", "B");
            list[i] = list[i].replace("Queen", "C");
            list[i] = list[i].replace("Jack", "D");
            list[i] = list[i].replace("10", "E");
            list[i] = list[i].replace("9", "F");
            list[i] = list[i].replace("8", "G");
            list[i] = list[i].replace("7", "H");
            list[i] = list[i].replace("6", "I");
            list[i] = list[i].replace("5", "J");
            list[i] = list[i].replace("4", "K");
            list[i] = list[i].replace("3", "L");
            list[i] = list[i].replace("2", "M");
        }
        System.arraycopy(list, 0, faceCardsNotFixed, 0, faceCardsNotFixed.length);
    }



    public boolean checkFiveOfAKind(int line, boolean jackson){
        String[] singleHand = list[line].split(",");
        if (!jackson)
            return singleHand[0].equals(singleHand[1]) && singleHand[1].equals(singleHand[2]) && singleHand[2].equals(singleHand[3]) && singleHand[3].equals(singleHand[4]);
        else
            return (checkFourOfAKind(line,false) && checkForJacks(line) == 1) || (checkFourOfAKind(line,false) && checkForJacks(line) == 4) || (checkFullHouseOfAKind(line,false) && (checkForJacks(line) == 2) || (checkFullHouseOfAKind(line,false) && checkForJacks(line) == 3) || checkFiveOfAKind(line,false));
        }

        public boolean checkFourOfAKind(int line, boolean jackson){
            String[] singleHand = list[line].split(",");
            Arrays.sort(singleHand);
            if(!jackson)
                return singleHand[0].equals(singleHand[1]) && singleHand[1].equals(singleHand[1+1]) && singleHand[1+1].equals(singleHand[1+1+1]) || singleHand[1].equals(singleHand[1 + 1]) && singleHand[1 + 1].equals(singleHand[1 + 1 + 1]) && singleHand[1 + 1 + 1].equals(singleHand[1 + 1 + 1 + 1]);
            else
                return (checkThreeOfAKind(line, false) && checkForJacks(line) == 1) || (checkThreeOfAKind(line, false) && checkForJacks(line) == 3) || (checkTwoPairOfAKind(line) && (checkForJacks(line) == 2) || checkFourOfAKind(line, false));


        }

    public boolean checkFullHouseOfAKind(int line, boolean jackson){
        String[] singleHand = list[line].split(",");
        Arrays.sort(singleHand);

        if (!jackson)
            return singleHand[0].equals(singleHand[1]) && singleHand[2].equals(singleHand[2+1]) && singleHand[1+1].equals(singleHand[1+1+1+1]) || singleHand[0].equals(singleHand[1]) && singleHand[2].equals(singleHand[1]) && singleHand[3].equals(singleHand[1 + 1 + 1 + 1]);
        else
            return (checkTwoPairOfAKind(line) && checkForJacks(line) == 1) || checkFullHouseOfAKind(line, false);

    }

    public boolean checkThreeOfAKind(int line, boolean jackson){
        String[] singleHand = list[line].split(",");
        Arrays.sort(singleHand);

        if (!jackson)
            return (singleHand[0].equals(singleHand[1]) && singleHand[2].equals(singleHand[0])) || (singleHand[1].equals(singleHand[2]) && singleHand[1].equals(singleHand[3])) || singleHand[2].equals(singleHand[3]) && singleHand[2].equals(singleHand[4]);
        else
            return (checkOnePairOfAKind(line, false) && checkForJacks(line) == 1) || (checkOnePairOfAKind(line, false) && checkForJacks(line) == 2) || checkThreeOfAKind(line, false);
    }

    public boolean checkTwoPairOfAKind(int line){
        String[] singleHand = list[line].split(",");
        Arrays.sort(singleHand);
        return (singleHand[0].equals(singleHand[1]) && singleHand[3].equals(singleHand[4])) || (singleHand[1].equals(singleHand[2]) && singleHand[3].equals(singleHand[4])) || singleHand[0].equals(singleHand[1]) && singleHand[2].equals(singleHand[3]);
    }
    public boolean checkOnePairOfAKind(int line, boolean jackson){
        String[] singleHand = list[line].split(",");
        Arrays.sort(singleHand);
        if (!jackson)
            return singleHand[0].equals(singleHand[1]) || singleHand[1].equals(singleHand[2]) || singleHand[2].equals(singleHand[3]) || singleHand[3].equals(singleHand[4]);
        else
            return checkForJacks(line) == 1 || checkOnePairOfAKind(line, false);

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


    public int getIndexofBid(String [] typeOfHand)
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
            Arrays.fill(fiveOfAKinds,null);
            Arrays.fill(fourOfAKinds,null);
            Arrays.fill(fullHouseOfAKinds,null);
            Arrays.fill(threeOfAKinds,null);
            Arrays.fill(twoPairOfAKinds,null);
            Arrays.fill(onePairOfAKinds,null);
            Arrays.fill(highCardOfAKinds,null);
            Arrays.sort(list);
        for (int i = 0; i < list.length; i++) {
            if (jackson) {
                for (int j = 0; j < list.length; j++) {
                    list[j] = list[j].replace("D", "Z");
                    faceCardsNotFixed[i] = faceCardsNotFixed[i].replace("D", "Z");
                    Arrays.sort(list);
                }
            }
            if (checkFiveOfAKind(i,jackson)) {
                five++;
                fiveOfAKinds[i] = list[i];
            } else if (checkFourOfAKind(i,jackson)) {
                four++;
                fourOfAKinds[i] = list[i];
            } else if (checkFullHouseOfAKind(i,jackson)) {
                full++;
                fullHouseOfAKinds[i] = list[i];
            } else if (checkThreeOfAKind(i,jackson)) {
                three++;
                threeOfAKinds[i] = list[i];
            } else if (checkTwoPairOfAKind(i)) {
                twoPair++;
                twoPairOfAKinds[i] = list[i];
            } else if (checkOnePairOfAKind(i,jackson)) {
                onePair++;
                onePairOfAKinds[i] = list[i];
            } else {
                high++;
                highCardOfAKinds[i] = list[i];
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