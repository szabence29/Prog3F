public class Car {
    private String plate;
    private String colour;

    public Car(String pl, String co){
        plate = pl;
        colour = co;
    }

    public int compareTo(Object o){
        if(o == null){
            return 1;
        }
        var oCast = (Car) o;
        int ret = this.plate.compareTo(oCast.plate);
        if(ret == 0){
            return this.colour.compareTo(oCast.colour);
        }
        return ret;
    }
}
