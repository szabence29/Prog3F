public class Student extends Human{
    private String neptun;

    public Student(String pname, String pneptun) {
        super(pname);
        neptun = pneptun;
    }

    public Student(){
        this("John Doe", "qwerty");
    }

    public String getNeptun() {
        return neptun;
    }
}
