public abstract class Music {
    protected String title;
    protected String artist;
    protected int durationInSeconds; 

    public Music (String title, String artist, int durationInSeconds){
        this.title = title;
        this.artist = artist;
        this.durationInSeconds = durationInSeconds;
    }

    public String getDuration() {
        int minutes = durationInSeconds / 60;
        int seconds = durationInSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    public void startPlayback() {
        System.out.println("==================================================");
        System.out.println("Playing: " + title + " - " + artist + " (" + getDuration() + ")");
        System.out.println("==================================================");
    }

    public abstract void performClimax();
    public abstract void displayTrackDetails();
}
