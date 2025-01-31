import java.util.Arrays;
import java.util.Objects;

public class HandChecker {

    String[] list;
    public HandChecker(String[] list){
        this.list = list;
    }


    public boolean checkFiveOfAKind(int line){
        String[] singleHand = list[line].split(",");
        for (int i = 0; i < singleHand.length; i++) {
            try {
                if (Objects.equals(singleHand[i], singleHand[i + 1])) {

                } else {
                    return false;
                }
            }
            catch(Exception _)
            {

            }
        }
        return true;
        }

        public boolean checkFourOfAKind(int line){
            String[] singleHand = list[line].split(",");
            Arrays.sort(singleHand);

            if (singleHand[0].equals(singleHand[1]) && singleHand[1].equals(singleHand[1+1]) && singleHand[1+1].equals(singleHand[1+1+1]))
                return true;
            if (singleHand[1].equals(singleHand[1+1]) && singleHand[1+1].equals(singleHand[1+1+1]) && singleHand[1+1+1].equals(singleHand[1+1+1+1]))
                return true;

            else return false;

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



}
