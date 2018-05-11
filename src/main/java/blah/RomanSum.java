package blah;

public class RomanSum {
    private int number;
    private final StringBuffer result;

    public RomanSum(int number, StringBuffer result) {
        this.number = number;
        this.result = result;
    }

    public int getNumber() {
        return number;
    }

    public StringBuffer getResult() {
        return result;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
