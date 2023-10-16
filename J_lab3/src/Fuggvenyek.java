import java.awt.datatransfer.FlavorListener;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Fuggvenyek {

    protected static void exit(String[] cmd){
        System.exit(0);
    }

    protected static void pwd(String[] cmd, File f) throws IOException{
        while (f.isFile()) {
            f = f.getParentFile();
        }
        System.out.println(f.getCanonicalPath());

        System.out.println(Objects.requireNonNull(f.listFiles()).length);
    }

    protected static void ls(String cmd[], File f){
        while (f.isFile())
            f = f.getParentFile();
        if (cmd.length > 1) {
            if (cmd[1].equals("-l")) {
                File[] filesList = f.listFiles();
                for (int i = 0; i < Objects.requireNonNull(filesList).length; i++) {
                    if (filesList[i].isDirectory() & filesList[i] != null) {
                        System.out.println("d - " + filesList[i].getName() + " - " + filesList[i].getTotalSpace());
                    } else {
                        assert filesList[i] != null;
                        if (filesList[i].isFile()) {
                            System.out.println("f - " + filesList[i].getName() + " - " + filesList[i].getTotalSpace());
                        }
                    }
                }
            }
        } else {
            File[] filesList = f.listFiles();
            if (filesList != null) {
                for (int i = 0; i < filesList.length; i++) {
                    if (filesList[i].isDirectory() & filesList[i] != null) {
                        System.out.println(filesList[i].getName());
                    } else {
                        System.out.println(filesList[i].getName());
                    }
                }
            } else
                System.out.println("Hiba");
        }
    }

    /*
    protected static File cd(String cmd[], File f) throws IOException{

    }
     */

    
}
