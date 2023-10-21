import java.io.*;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    static ArrayDeque<Integer> stack = new ArrayDeque<>();
    static HashMap<String, Integer> labels = new HashMap<>();
    static int pc = 0;
    public static void main(String[] args) throws IOException{
        HashMap<String, Command> map = fillHashMap();

        if(args.length == 1){
            LinkedList<String> lines = new LinkedList<>();
            String fileName = args[0];
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
                String inputLine;
                while((inputLine = reader.readLine()) != null){
                    if(inputLine.charAt(0) == '#')
                        labels.put(inputLine, lines.size());
                    else
                        lines.add(inputLine);
                }
            }catch (Exception e){
                System.out.println(e);
            }

            for(String item : lines){
                System.out.println(item);
            }

            while(pc != lines.size()){
                String[] cmd = lines.get(pc).split(" ");
                Command c = map.get(cmd[0]);
                c.execute(cmd);
                pc++;
            }


        }else if(args.length == 0){
            String wd = System.getProperty("user.dir");
            File f = new File(wd);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = null;

            while((line = br.readLine()) != null){
                String[] cmd = line.split(" ");
                Command c = map.get(cmd[0]);
                c.execute(cmd);
            }
        }

    }

    public static HashMap<String, Command> fillHashMap(){
        HashMap<String, Command> map = new HashMap<>();

        map.put("exit", new Exit());
        map.put("dup", new Dup());
        map.put("list", new List());
        map.put("pop", new Pop());
        map.put("push", new Push());
        map.put("read", new Read());
        map.put("write", new Write());
        map.put("add", new Add());
        map.put("mult", new Mult());
        map.put("div", new Div());
        map.put("sub", new Sub());
        map.put("junp", new Jump());
        map.put("onzero", new OnZero());
        map.put("onnonzero", new OnNonZero());
        map.put("onnegative", new OnNegative());

        return map;
    }
}