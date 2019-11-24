public class Staff extends Person {
    protected double salary;

    @Override
    protected double getCompareValue() {
        return salary;
    }
}
