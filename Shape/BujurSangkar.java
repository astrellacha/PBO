public class BujurSangkar extends Bentuk{
    private double sisi;

    public BujurSangkar (double sisi, String warna){
        super(warna);
        this.sisi = sisi;
    }

    public double getsisi(){
        return sisi;
    }

    public void setsisi(double sisi){
        this.sisi= sisi;
    }

    public double hitungluas(){
        return sisi * sisi;
    }

     public void printInfo() {
        System.out.println("BujurSangkar berwarna " + warna + ", luas = " + hitungluas());
    }


}