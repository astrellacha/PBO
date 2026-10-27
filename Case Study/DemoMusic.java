public class DemoMusic {
    public static void main(String[] args) {
        Music[] playlist = new Music[] {
            new PopRock("Hold My Hand", "HAN (Stray Kids)", 184, "Upbeat Rock Vocal", "Electric Guitar"),
            new BalladRock("Drowning", "WOODZ", 245, "Emotional High-Pitch Belting", "Electric Guitar & Grand Piano")
        };
        
        for (Music song : playlist) {
            song.startPlayback();
            song.displayTrackDetails();

            if (song instanceof PopRock) {
                System.out.println("\n--- STRUKTUR ARANSEMEN POP-ROCK ---");
                PopRock popRock = (PopRock) song;
                popRock.playSynthesizerRiff();
                popRock.playCatchyHook("Energetic Hook");
                popRock.playGuitarSolo(7);
                popRock.triggerDrumClimax(false);
            } else if (song instanceof BalladRock) {
                System.out.println("\n--- STRUKTUR ARANSEMEN BALLAD-ROCK ---");
                BalladRock balladRock = (BalladRock) song;
                balladRock.playPianoMelody();
                balladRock.buildEmotionalCrescendo();
                balladRock.playGuitarSolo(9);
                balladRock.triggerDrumClimax(true);
            }

            song.performClimax();
            System.out.println("\n--------------------------------------------------\n");
        }
    }
}
