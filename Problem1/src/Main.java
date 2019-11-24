import java.util.Scanner;

public class Main {
    StringBuilder stringBuilder = new StringBuilder();
    void calc(int x){
        if(x == 1){stringBuilder.append(1);}
        else{
            calc(x/2);
            stringBuilder.append(x%2);
        }
    }
    String solve(){
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        calc(number);
        stringBuilder.append("#");
        boolean flag = true;
        for(int i=2;i*i<=number;i++){
            while(number%i==0){
                if(flag){
                    stringBuilder.append(i);
                    flag = false;
                } else {
                    stringBuilder.append(","+i);
                }
                number /= i;
            }
        }
        if(number > 1){
            if(flag)stringBuilder.append(number);
            else stringBuilder.append(","+number);
        }
        return stringBuilder.toString();
    }
    Main(){
        System.out.println(solve());
    }
    public static void main(String[] args){
        new Main();
    }
}