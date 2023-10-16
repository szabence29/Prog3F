public class Complex {
    private double re;
    private double im;

    public Complex(double r, double i){
        re = r;
        im = i;
    }

    public String toString() {return re+"#"+im;}

    public Complex add(Complex c){
        double newR = this.re + c.re;
        double newI = this.im + c.im;
        return new Complex(newR, newI);
    }

    public void print() {System.out.println(toString());}
}
