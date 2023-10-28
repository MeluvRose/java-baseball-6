package baseball;

public class Validation {
    public boolean isDigitStr(String val){
        for (int i = 0; i < val.length(); i++){
            char c = val.charAt(i);
            if (c < '1' || c > '9') return false;
        }
        return true;
    }
    public boolean isValidLength(String val){
        boolean valid = val.length() != 3;

        return !valid;
    }

    public boolean isValidate(String val, String option){
        if (option.equals("playing")){
            if (!isValidLength(val) || !isDigitStr(val)){
                return false;
            }
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
