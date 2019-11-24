import java.io.File;
import java.util.Scanner;

public class Main {
    private void printFile(File file,int depth){
        for(int i=0;i<=3*depth;i++)System.out.print(" ");
        System.out.println("<f>"+file.getName());
    }
    private void dfs(File file, int depth){
        for(int i=0;i<=3*depth;i++){System.out.print(" ");}
        System.out.println("<d>"+file.getName());
        File[] children = file.listFiles();
        for(File f : children){
            if(f.isFile())
                printFile(f,depth+1);
        }
        for(File f : children){
            if(f.isDirectory()){
                dfs(f,depth+1);
            }
        }
    }
    Main(){
        Scanner scan = new Scanner(System.in);
        String location = scan.nextLine();
        dfs(new File(location),0);
    }
    public static void main(String[] args){
        new Main();
    }
}
