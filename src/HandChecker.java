public class HandChecker {

    String[] list;
    public HandChecker(String[] list){
        this.list = list;
    }


    public boolean checkFiveOfAKind(int line){
        String currentString = list[line];
        String firstCard = currentString.substring(0,currentString.indexOf(","));
        for (int i = 0; i < 5; i++) {
            currentString = currentString.substring(currentString.indexOf(","));
            if (firstCard.equals(currentString.substring(0,firstCard.length()))){
                
            }
            else{
                return false;
            }

        }
        return true;
    }
}
