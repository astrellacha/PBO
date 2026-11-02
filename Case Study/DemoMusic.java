public class DemoMusic {
    public static void main(String[] args) {
        Music[] playlist = new Music[] {
            new PopRock("Hold My Hand", "HAN (Stray Kids)", 184, "Upbeat Rock Vocal", "Electric Guitar"),
            new BalladRock("Drowning", "WOODZ", 245, "Emotional High-Pitch Belting", "Electric Guitar & Grand Piano")
        };

        for (Music song : playlist) {
            song.startPlayback();
            song.displayTrackDetails();
            song.performClimax();  
            System.out.println("\n--------------------------------------------------\n");
        }
    }
}