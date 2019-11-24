
public class Student {
    private long strNum;
    private String strName;
    private double creditTotal,creditScoreTotal;
    @Override
    public Student clone(){
        return new Student(strNum,strName);
    }
    private Student(){}
    @Override
    public int hashCode(){
        return (strName +"$"+ strNum +"$"+ creditTotal +"$"+ creditScoreTotal).hashCode();
    }
    @Override
    public boolean equals(Object o){
        return strNum == ((Student)o).getStrNum();
    }

    public Student(long strNum,String strName){
        this.strNum = strNum;
        this.strName = strName;
        this.creditScoreTotal=this.creditTotal=0;
    }

    public long getStrNum() {
        return strNum;
    }

    public void setStrNum(long strNum) {
        this.strNum = strNum;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public double getCreditTotal() {
        return creditTotal;
    }

    public void setCreditTotal(double creditTotal) {
        this.creditTotal = creditTotal;
    }

    public double getCreditScoreTotal() {
        return creditScoreTotal;
    }

    public void setCreditScoreTotal(double creditScoreTotal) {
        this.creditScoreTotal = creditScoreTotal;
    }
}
