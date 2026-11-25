public class Trainee {
    private String idTrainee;
    private String nama;
    private int rank;
    private String tglLahir;
    private String idLagu;
    private String judulLagu;
    private String ogSinger;

    public Trainee(String idTrainee, String nama, int rank, String tglLahir, String idLagu, String judulLagu, String ogSinger) {
        this.idTrainee = idTrainee;
        this.nama = nama;
        this.rank = rank;
        this.tglLahir = tglLahir;
        this.idLagu = idLagu;
        this.judulLagu = judulLagu;
        this.ogSinger = ogSinger;
    }

    public String getIdTrainee() { 
        return idTrainee; 
    }
    public String getNama() { 
        return nama; 
    }
    public int getRank() { 
        return rank; 
    }
    public String getTglLahir() { 
        return tglLahir; 
    }
    public String getIdLagu() { 
        return idLagu; 
    }
    public String getJudulLagu() {
         return judulLagu; 
    }
    public String getOgSinger() {
         return ogSinger; 
    }
}
