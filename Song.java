/* Daniella Prado 
CSE 007: Lab 10
Make a playlist using "has a" codes. This is the songs class.*/

public class Song{
    private String name;
    private String artist; 
    private String album; 
    private int time; 
    private static int numSongs;

    /* precondition: name, artist, album and artist are not assigned values. 
    postcondition: name, artist, album and artist are assigned values. */
    Song(String name, String artist, String album, int time){
        this.name = name; 
        this.artist = artist; 
        this.album = album; 
        this.time = time; 
        numSongs++;  
    }

    /* precondition: songs cannot be displayed. 
    postcondition: songs are displayed*/
    void displaySong(){
        System.out.println("song " + name); 
        System.out.println("artist " + artist);
        System.out.println("album " + album);
        System.out.println("duration " + time);
    }

    /* precondition: name is null
    postcondition: name is retrieved*/
    public String getName(){
        return name; 
    }

    /* precondition: artist is null
    postcondition: artist is retrieved. */
    public String getArtist(){
        return artist; 
    }

    /* precondition: album is null
    postcondition: album is retrieved. */
    public String getAlbum(){
        return album; 
    }

    /* precondition: time is null
    postcondition: time is retrieved */
    public int getTime(){
        return time; 
    }
}