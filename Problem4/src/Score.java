
public class Score{
    private long stuNum,courseNum;
    private double creditPoint;
    @Override
    public int hashCode(){
        return (""+stuNum + "$" + courseNum + "$" + creditPoint).hashCode();
    }
    @Override
    public boolean equals(Object o){
        Score b = (Score)o;
        return this.stuNum==b.getStuNum() && this.courseNum==b.getCourseNum()
                && Math.abs(this.creditPoint-b.creditPoint)<0.001;
    }
    private Score(){}
    public Score(long stuNum,long courseNum,double creditPoint){
        this.stuNum = stuNum;
        this.courseNum = courseNum;
        this.creditPoint = creditPoint;
    }
    public long getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(long courseNum) {
        this.courseNum = courseNum;
    }

    public double getCreditPoint() {
        return creditPoint;
    }

    public void setCreditPoint(double creditPoint) {
        this.creditPoint = creditPoint;
    }

    public long getStuNum() {
        return stuNum;
    }

    public void setStuNum(long stuNum) {
        this.stuNum = stuNum;
    }
}
