public class Client {
    private String name;
    private String id;

    public Client(String na, String i){
        name = na;
        id = i;
    }

    public int compareTo(Object o){
        if (o == null){
            return -1;
        }
        var oCast = (Client) o;
        int ret = this.id.compareTo(oCast.id);
        if (ret == 0){
            return this.name.compareTo(oCast.name);
        }
        return ret;
    }
}
