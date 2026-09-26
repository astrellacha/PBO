public class Main {
    public static void main(String[] args) {

        BujurSangkar b = new BujurSangkar(6, "Merah");

        Lingkaran l = new Lingkaran(8, "Biru");

        Silinder s = new Silinder(10, 8, "Hijau");


        System.out.println("===== BUJUR SANGKAR =====");
        b.printInfo();

        System.out.println("\n===== LINGKARAN =====");
        l.printInfo();

        System.out.println("\n===== SILINDER =====");
        s.printInfo();
    }
}
