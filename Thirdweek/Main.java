public class Main {
   public static void main(String[] args) {

        House akbarHouse = new House(36, 100000000);
        House bambangHouse = new House(45, 150000000);
        House charlieHouse = new House(90, 200000000);

        Father akbar = new Father("Akbar", akbarHouse);
        Father bambang = new Father("Bambang", bambangHouse);
        Father charlie = new Father("Charlie", charlieHouse);

        akbar.displayPBB();
        bambang.displayPBB();
        charlie.displayPBB();
    } 
}
