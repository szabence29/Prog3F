import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Main extends Fuggvenyek{
    public static void main(String[] args) throws Exception{
        String wd = System.getProperty("user.dir");
        File f = new File(wd);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;

        while ((line = br.readLine()) != null){
            String[] cmd = line.split(" ");
            if(cmd[0].equals("exit")){
                exit(cmd);
            }else if(cmd[0].equals("pwd")){
                pwd(cmd, f);
            }else if(cmd[0].equals("ls")){
                ls(cmd, f);
            }
        }

    }
}