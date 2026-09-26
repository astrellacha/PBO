public class Bentuk {
    public String warna;
    
    public Bentuk(String warna){
        this.warna = warna;
    }
    public String getwarna(){
        return warna;
    }
    public void setwarna(String warna){
        this.warna = warna;
    }
    public void printInfo(){
        System.out.println("Bentuk berwarna " + warna);
    }
}
