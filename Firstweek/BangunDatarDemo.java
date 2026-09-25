public class BangunDatarDemo {
    public static void main(String[] args) {
        BangunDatar s = new BangunDatar(7);

        BangunDatar r1= new BangunDatar();
        r1.setLength(18);
        r1.setWidth(6);

        BangunDatar r2= new BangunDatar(10, 5);
        System.out.println("The Output");
        System.out.println("Area of square with side " + s.getSide() + " = " + s.calculateSquareArea());
        System.out.println("Perimeter of square with side " + s.getSide() + " = " + s.calculateSquarePerimeter());
        System.out.println("=============================================");
        System.out.println("Area of rectangle with length " + r1.getLength() + " and width " + r1.getWidth() + " = " + r1.calculateRectangleArea());
        System.out.println("Perimeter of rectangle with length " + r1.getLength() + " and width " + r1.getWidth() + " = " + r1.calculateRectanglePerimeter());
        System.out.println("=============================================");
        System.out.println("Area of rectangle with length " + r2.getLength() + " and width " + r2.getWidth() + " = " + r2.calculateRectangleArea());
        System.out.println("Perimeter of rectangle with length " + r2.getLength() + " and width " + r2.getWidth() + " = " + r2.calculateRectanglePerimeter());
        System.out.println("=============================================");
    }    
}
