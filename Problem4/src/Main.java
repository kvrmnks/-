import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    Student[] student;
    Score[] score;
    Course[] course;
    void readStudent(String location) throws FileNotFoundException {
        HashSet<Student> set = new HashSet<Student>();
        if(student != null)
        for(Student s:student){set.add(s);}
        Scanner sc = new Scanner(new File(location));
        while(sc.hasNextLine()){
            String[] infos = sc.nextLine().split(" ");
            set.add(new Student(Long.parseLong(infos[1]),infos[0]));
        }
        student = new Student[set.size()];
        set.toArray(student);
    }
    void readCourse(String location) throws FileNotFoundException {
        HashSet<Course> set = new HashSet<Course>();
        if(course!=null)
        for(Course c : course){set.add(c);}
        Scanner sc = new Scanner(new File(location));
        while(sc.hasNextLine()){
            String[] infos = sc.nextLine().split(" ");
            set.add(new Course(Long.parseLong(infos[1]),infos[0],Double.parseDouble(infos[2])));
        }
        course = new Course[set.size()];
        set.toArray(course);
    }
    void readScore(String location) throws FileNotFoundException{
        Student[] data = new Student[student.length];
        for(int i=0;i<data.length;i++){data[i]=student[i].clone();}
        HashSet<Score> set = new HashSet<Score>();
        if(score != null)
        for(Score c : score){
            set.add(c);
            for(Student s : data){
                if(s.getStrNum() == c.getStuNum()){
                    s.setCreditScoreTotal(s.getCreditScoreTotal()+c.getCreditPoint());
                    for(Course cour : course){
                        if(cour.getCourseNum() == c.getCourseNum()){
                            s.setCreditTotal(s.getCreditTotal()+cour.getCreditTotal());
                            break;
                        }
                    }
                    break;
                }
            }
        }
        Scanner sc = new Scanner(new File(location));
        while(sc.hasNextLine()){
            String[] infos = sc.nextLine().split(" ");
            int tmp = set.size();
            set.add(new Score(Long.parseLong(infos[0]),Long.parseLong(infos[1]),Double.parseDouble(infos[2])));
            if(set.size()>tmp){
                Score c = new Score(Long.parseLong(infos[0]),Long.parseLong(infos[1]),Double.parseDouble(infos[2]));
                for(Student s : data){
                    if(s.getStrNum() == c.getStuNum()){
                        s.setCreditScoreTotal(s.getCreditScoreTotal()+c.getCreditPoint());
                        for(Course cour : course){
                            if(cour.getCourseNum() == c.getCourseNum()){
                                s.setCreditTotal(s.getCreditTotal()+cour.getCreditTotal());
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
        score = new Score[set.size()];
        set.toArray(score);
        Arrays.sort(data,(a, b)->{return a.getCreditScoreTotal()/a.getCreditTotal() - b.getCreditScoreTotal()/b.getCreditTotal()<0?1:-1;});
        for(Student s : data){
            System.out.println(s.getStrNum() + " " + s.getStrName() + " " + s.getCreditScoreTotal()/s.getCreditTotal());
        }
    }
    Main() throws FileNotFoundException{
        Scanner scan = new Scanner(System.in);
        for(int i=1;i<=3;i++){
            System.out.println("请输入3个文件名 用空格隔开");
            String[] commands = scan.nextLine().split(" ");
            readStudent(commands[0]);
            readCourse(commands[1]);
            readScore(commands[2]);

        }
    }
    public static void main(String[] args) throws FileNotFoundException{
        new Main();
    }
}
