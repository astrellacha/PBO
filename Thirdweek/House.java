public class House{
    private int type;
    private double price;

    public House(int type, double price){
        this.type=type;
        this.price=price;
    }
    public double calculatePBB() {
        double taxrate;

        if (type==36){
            taxrate=0.04;
        }else if (type == 45) {
            taxrate = 0.06;
        } else {
            taxrate = 0.09;
        }

        return price * taxrate;
    }
}