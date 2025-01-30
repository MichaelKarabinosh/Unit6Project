import java.util.Arrays;
import java.util.Objects;

public class HandChecker {

    String[] list;
    public HandChecker(String[] list){
        this.list = list;
    }


    public boolean checkFiveOfAKind(int line){
        String[] whatever = list[line].split(",");
        for (int i = 0; i < whatever.length; i++) {
            try {
                if (Objects.equals(whatever[i], whatever[i + 1])) {

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
            String[] whatever = list[line].split(",");
            Arrays.sort(whatever);

            if (whatever[0].equals(whatever[1]) && whatever[1].equals(whatever[1+1]) && whatever[1+1].equals(whatever[1+1+1]))
                return true;
            if (whatever[1].equals(whatever[1+1]) && whatever[1+1].equals(whatever[1+1+1]) && whatever[1+1+1].equals(whatever[1+1+1+1]))
                return true;

            else return false;

        }

    public boolean checkFullHouseOfAKind(int line){
        String[] whatever = list[line].split(",");
        Arrays.sort(whatever);

        if (whatever[0].equals(whatever[1]) && whatever[2].equals(whatever[2+1]) && whatever[1+1].equals(whatever[1+1+1+1]))
            return true;
        return whatever[0].equals(whatever[1]) && whatever[2].equals(whatever[1]) && whatever[3].equals(whatever[1 + 1 + 1 + 1]);

    }

    public boolean checkThreeOfAKind(int line){
        String[] whatever = list[line].split(",");
        Arrays.sort(whatever);

        if (whatever[0].equals(whatever[1]) && whatever[2].equals(whatever[0]))
            return true;
        if (whatever[1].equals(whatever[2]) && whatever[1].equals(whatever[3]))
        {
            return true;
        }
        return whatever[2].equals(whatever[3]) && whatever[2].equals(whatever[4]);

    }

    public boolean checkTwoPairOfAKind(int line){
        String[] whatever = list[line].split(",");
        Arrays.sort(whatever);

        if (whatever[0].equals(whatever[1]) && whatever[3].equals(whatever[4]))
            return true;
        if (whatever[1].equals(whatever[2]) && whatever[3].equals(whatever[4]))
            return true;
        return whatever[0].equals(whatever[1]) && whatever[2].equals(whatever[3]);

    }
    public boolean checkOnePairOfAKind(int line){
        String[] whatever = list[line].split(",");
        Arrays.sort(whatever);
        return whatever[0].equals(whatever[1]) || whatever[1].equals(whatever[2]) || whatever[2].equals(whatever[3]) || whatever[3].equals(whatever[4]);

    }

    public int checkForJacks(int line){
        int totalJacks = 0;
        String[] whatever = list[line].split(",");
        for (String card : whatever) {
            if (card.equals("D")) {
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
