public class BangunDatar{
    private int side;
    private int length;
    private int width;
    public BangunDatar(){
        System.out.println("Default");
    }
    public BangunDatar(int side){
        this.side=side;
    }
    public BangunDatar(int length,int width){
        this.length=length;
        this.width=width;
    }

    public int getSide(){
        return side;
    }
    public int getLength(){
        return length;
    }
    public int getWidth(){
        return width;
    }

    public void setSide(int side){
        this.side=side;
    }
    public void setLength(int length){
        this.length=length;
    }
    public void setWidth(int width){
        this.width=width;
    }

    public int calculateSquareArea(){
        return side*side;
    }
    public int calculateRectangleArea(){
        return length*width;
    }
    public int calculateSquarePerimeter(){
        return 4*side;
    }
    public int calculateRectanglePerimeter(){
        return 2*(length+width);
    }
}