import javafx.fxml.Initializable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Main() throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入文件地址");
        ArrayList<Person> person = new ArrayList<>();
        ArrayList<Staff> staff = new ArrayList<>();
        ArrayList<Student> student = new ArrayList<>();
        Scanner sc = new Scanner(new File(scan.nextLine()));
        while(sc.hasNextLine()){
            String[] commands = sc.nextLine().split(" ");
            if(commands.length==4){
                Staff s = new Staff();
                s.number=Integer.parseInt(commands[0]);
                s.name=commands[1];
                s.age= Integer.parseInt(commands[2]);
                s.salary = Double.parseDouble(commands[3]);
                staff.add(s);
                person.add(s);
            }else{
                Student s = new Student();
                s.number=Integer.parseInt(commands[0]);
                s.name=commands[1];
                s.age= Integer.parseInt(commands[2]);
                s.englishScore = Double.parseDouble(commands[3]);
                s.mathScore=Double.parseDouble(commands[4]);
                s.programScore=Double.parseDouble(commands[5]);
                student.add(s);
                person.add(s);
            }
        }
        System.out.println("Person排序");
        person.sort((a,b)->{return a.age==b.age?a.number-b.number:a.age-b.age;});
        for(Person p : person){
            System.out.println("name:"+p.name+" number:"+p.number+" age:"+p.age);
        }
        System.out.println("Staff排序");
        staff.sort((a,b)->{return b.getCompareValue()-a.getCompareValue()<0?-1:1;});
        for(Staff s : staff){
            System.out.println("name:"+s.name+" number:"+s.number+" age:"+s.age+" salary:"+s.salary);
        }
        System.out.println("Student排序");
        student.sort((a,b)->{return b.getCompareValue()-a.getCompareValue()<0?-1:1;});
        for(Student s : student){
            System.out.println("name:"+s.name+" number:"+s.number+" age:"+s.age+" eng:"
                    +s.englishScore+" math:"+s.mathScore+" program:"+s.programScore+" GPA:"+s.getCompareValue());
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        new Main();
    }
}
