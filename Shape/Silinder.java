public class Silinder extends Lingkaran {
   private double tinggi;
   
   public Silinder(double tinggi, double radius, String warna) {
        super(radius, warna);
        this.tinggi = tinggi;
    }

    public double gettinggi() {
        return tinggi;
    }

    public void settinggi(double t) {
        this.tinggi = t;
    }

    public double hitungvolume() {
        return hitungluas() * tinggi;
    }

    public void printInfo() {
        System.out.println("Silinder berwarna " + warna + ", volume = " + hitungvolume());
    }
}
