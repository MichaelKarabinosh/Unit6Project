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

    public String getLine(int lineInput) {
        return list[lineInput];
    }



}
