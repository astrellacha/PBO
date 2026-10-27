public class PopRock extends Music implements PopStyle, RockStyle {
   private String vocalCharacter;
    private String leadInstrument;

    public PopRock (String title, String artist, int durationInSeconds, 
                        String vocalCharacter, String leadInstrument) {
        super(title, artist, durationInSeconds);
        this.vocalCharacter = vocalCharacter;
        this.leadInstrument = leadInstrument;
    } 

    public void displayTrackDetails() {
        System.out.println("Track Info: [Subgenre: Pop-Rock]");
        System.out.println("Vocal Character : " + vocalCharacter);
        System.out.println("Lead Instrument : " + leadInstrument);
    }

    public void performClimax() {
        System.out.println("\n[UPBEAT POP-ROCK CLIMAX]");
        System.out.println("Klimaks energetic dengan perpaduan vokal " + vocalCharacter + " dan synth-rock " + leadInstrument + "!");
    }

    public void playCatchyHook(String vocalStyle) {
        System.out.println("[POP] Memutar vocal hook catchy (" + vocalStyle + ") diulang " + hookRepeat + "x.");
    }

    public void playSynthesizerRiff() {
        System.out.println("[POP] Memutar lapisan synth pad yang cepat dan catchy.");
    }

    public void playGuitarSolo(int distortionLevel) {
        System.out.println("[ROCK] Solo gitar " + leadInstrument + " dengan distorsi level " + distortionLevel + "/10!");
    }

    public void triggerDrumClimax(boolean hasDoubleBass) {
        System.out.println("[ROCK] Hentakan drum fast-beat" + (hasDoubleBass ? " (dengan double pedal)" : "") + ".");
    }
}