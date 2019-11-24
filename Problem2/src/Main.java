import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private StringBuilder stringBuilder = new StringBuilder();
    private int value[],dataForSort[],n,tot;
    private void dfs(int x){
        if(x>n)return;
        dfs(x*2);
        dfs(x*2+1);
        dataForSort[++tot]=value[x];
    }
    private String solve(){
        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split(",");
        n = data.length;
        value=new int[n+1];
        dataForSort=new int[n+1];
        double sum = 0;
        for(int i=1;i<=n;i++) {
            dataForSort[i] = value[i] = Integer.parseInt(data[i - 1]);
            sum += value[i];
        }
        stringBuilder.append((int)(sum/n)+"#");
        Arrays.sort(dataForSort,1,n+1);
        stringBuilder.append(dataForSort[1]);
        for(int i=2;i<=n;i++){
            stringBuilder.append(","+dataForSort[i]);
        }
        stringBuilder.append("#");
        tot = 0;
        dfs(1);
        stringBuilder.append(dataForSort[1]);
        for(int i=2;i<=n;i++)
            stringBuilder.append(","+dataForSort[i]);
        return stringBuilder.toString();
    }
    Main(){
        System.out.println(solve());
    }
    public static void main(String[] args){
        new Main();
    }
}
