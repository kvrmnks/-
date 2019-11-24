
public class Course {
    private long courseNum;
    private String courseName;
    private double creditTotal;

    @Override
    public int hashCode(){
        return (courseName + "$" + courseNum + "$" + creditTotal).hashCode();
    }

    private Course(){}
    public Course(long courseNum,String courseName,double creditTotal){
        this.courseName = courseName;
        this.courseNum = courseNum;
        this.creditTotal = creditTotal;
    }

    @Override
    public boolean equals(Object b){
       return courseNum == ((Course)b).getCourseNum();
    }

    public long getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(long courseNum) {
        this.courseNum = courseNum;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getCreditTotal() {
        return creditTotal;
    }

    public void setCreditTotal(double creditTotal) {
        this.creditTotal = creditTotal;
    }
}
