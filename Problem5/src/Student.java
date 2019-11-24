public class Student extends Person{
    protected double englishScore,mathScore,programScore;
    public final double ENGLISH = 6;
    public final double MATH = 5;
    public final double PROGRAM = 4;

    @Override
    protected double getCompareValue() {
        return (englishScore+mathScore+programScore)/(ENGLISH+MATH+PROGRAM);
    }
}
