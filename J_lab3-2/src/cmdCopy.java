
import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class cmdCopy {
    public static File wd;
    Scanner scanner = new Scanner(System.in);

    public void run() throws IOException {
        String[] cmd = (scanner.nextLine()).split(" ");
        switch (cmd[0]) {
            case "exit" -> System.exit(0);
            case "pwd" -> pwd(cmd);
            case "ls" -> ls(cmd);
            case "cd" -> cd(cmd);
            case "mkdir" -> mkdir(cmd);
            case "cp" -> cp(cmd);
            case "mv" -> mv(cmd);
            case "head" -> head(cmd);
            default -> {
            }
        }
    }

    protected void pwd(String[] cmd) {
        try {
            System.out.println(wd.getCanonicalPath());
        } catch (IOException e) {
            System.out.println("Hiba: " + e);
        }
        System.out.println(Objects.requireNonNull(wd.listFiles()).length);
    }

    protected void ls(String[] cmd) {
        try {
            if (cmd.length > 1 && cmd[1].equals("-l")) {
                for (File file : wd.listFiles()) {
                    System.out.print(file.getName() + "\t");
                    System.out.print(file.length() / 1024 + "KB" + "\t\n");
                }
            } else {
                for (File file : wd.listFiles())
                    System.out.println(file.getName());
            }
        } catch (NullPointerException e) {
            System.out.println("Hiba: " + e);
        }
    }

    protected void cd(String[] cmd) {
        try {
            if (cmd[1].equals(".."))
                wd = wd.getParentFile();
            else {
                for (File f : wd.listFiles()) {
                    if (f.getName().equals(cmd[1])) {
                        wd = new File(wd, cmd[1]);
                    } else {
                        throw new NullPointerException();
                    }
                }
            }

        } catch (NullPointerException e) {
            System.out.println("Hiba: " + e);
        }
    }

    protected void mkdir(String[] cmd) {
        File file = new File(cmd[1]);
        for (File f : wd.listFiles()) {
            if (f.getName().equals(file.getName())) {
                System.out.println("A fájl már létezik");
            } else if (file.mkdir()) {
                System.out.println(cmd[1]);
            }
        }
    }

    protected void cp(String[] cmd) {
        try {
            FileInputStream fileIn = new FileInputStream(cmd[1]);
            FileOutputStream fileOut = new FileOutputStream(cmd[2]);
            int c;
            while ((c = fileIn.read()) != -1) {
                fileOut.write(c);
            }
            fileIn.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            System.err.println("Fájl nem található!");
        } catch (IOException e) {
            System.err.println(e);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Hiba: " + e);
        }
    }

    protected void mv(String[] cmd) {
        try {
            File file1 = new File(cmd[1]);
            File file2 = new File(cmd[2]);
            if (file1.renameTo(file2))
                System.out.println(file2.getName());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Hiba: "+ e);
        } catch (SecurityException e) {
            System.err.println("Hiba: " + e);
        }
    }

    protected void head(String[] cmd) {
        try {
            int n = 10;
            File file;
            if (cmd.length > 2 && cmd[1].equals("-n")) {
                n = Integer.parseInt(cmd[2]);
                file = new File(cmd[3]);
            } else if (cmd.length == 2) {
                file = new File(cmd[1]);
            } else {
                throw new IndexOutOfBoundsException();
            }
            try (Scanner scanner = new Scanner(file)) {
                for (int i = 0; i < n && scanner.hasNextLine(); i++) {
                    System.out.println(scanner.nextLine());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fájl nem található.");
        }
    }
}