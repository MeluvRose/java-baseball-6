package baseball;

public class Validation {

    public boolean isValidate(String val, String option){
        if (option.equals("playing")){
            boolean lineValid = val.length() != 3;
            return !lineValid;
        }
        if (option.equals("over")){
            boolean choiceValid = (!val.equals("1")
                    && !val.equals("2"));
            return !choiceValid;
        }
        return true;
    }

    public void runException(String val, String option){
        if (!isValidate(val, option))
            throw new IllegalArgumentException();
    }
}
