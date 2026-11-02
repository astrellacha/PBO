public class BalladRock extends Music implements BalladStyle, RockStyle {
    private String vocalCharacter;
    private String leadInstrument;

    public BalladRock(String title, String artist, int durationInSeconds, 
                           String vocalCharacter, String leadInstrument) {
        super(title, artist, durationInSeconds);
        this.vocalCharacter = vocalCharacter;
        this.leadInstrument = leadInstrument;
    }

    public void displayTrackDetails() {
        System.out.println("Track Info: [Subgenre: Ballad-Rock]");
        System.out.println("Vocal Character : " + vocalCharacter);
        System.out.println("Lead Instrument : " + leadInstrument);
    }

    public void performClimax() {
        System.out.println("\n--- STRUKTUR ARANSEMEN BALLAD-ROCK ---");
        playPianoMelody();
        buildEmotionalCrescendo();
        playGuitarSolo(9);
        triggerDrumClimax(true);
        System.out.println("\n[EXPLOSIVE BALLAD-ROCK CLIMAX]");
        System.out.println("Puncak emosi lagu meledak dengan belting vokal " + vocalCharacter + " dan solo gitar " + leadInstrument + "!");
    }
    public void playPianoMelody() {
        System.out.println("[BALLAD] Dentingan piano lembut mengiringi bait pertama.");
    }

    public void buildEmotionalCrescendo() {
        System.out.println("[BALLAD] Dinamika lagu perlahan naik dari bait menuju chorus.");
    }

    public void playGuitarSolo(int distortionLevel) {
        System.out.println("[ROCK] Solo gitar emosional " + leadInstrument + " dengan distorsi level " + distortionLevel + "/10!");
    }

    public void triggerDrumClimax(boolean hasDoubleBass) {
        System.out.println("[ROCK] Hentakan drum powerful mengiringi puncak klimaks.");
    }
}
 