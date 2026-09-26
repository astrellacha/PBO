public class Lingkaran  extends Bentuk {
   private double radius;
   
   public Lingkaran(double radius, String warna){
    super (warna);
    this.radius=radius;
   }

   public double getradius() {
        return radius;
    }

    public void setradius(double radius) {
        this.radius = radius;
    }

    public double hitungluas() {
        return Math.PI * radius * radius;
    }

    public void printInfo() {
        System.out.println( "Lingkaran berwarna" + warna + ", luas = " + hitungluas());
    }
}
