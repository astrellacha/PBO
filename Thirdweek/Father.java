public class Father {
    private String name;
    private House house;

    public Father(String name, House house) {
        this.name = name;
        this.house = house;
    }

    public void displayPBB() {
        System.out.println(name + " PBB = Rp" + house.calculatePBB());
    }
}
