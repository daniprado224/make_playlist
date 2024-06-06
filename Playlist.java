/* Daniella Prado 
CSE 007: Lab 10
Make a playlist using "has a" codes. This is the playlist class.*/

public class Playlist{
    private String name;
    private String creator;
    private Song[] songs;
    private int CAPACITY=20; //max size of a playlist

    /* precondition: string name, string creator, and int size are called by this method.
    postcondition: name and creator are initialized. the songs array is set to the size inputted by the user.*/ 
    Playlist(String name, String creator, int size){
        this.name = name; 
        this.creator = creator; 
        System.out.println("Playlist: " + name + " created by: " + creator);
        songs = new Song [size]; 
    }

    /* precondition: string name had is called.
    postcondition: the value given to string name is now visible in this program.*/  
    String getName(){
        return name; 
    }
    /* precondition: song object is called in. songs array does not have any values in it.  
    postcondition: songs array is filled with song object informtion. */ 
    void addSong(Song song){ 
        for(int i = 0; i < CAPACITY; i++){
            if(songs[i] == null){
                songs[i] = song; 
                break; 
            }else{
                continue; 
            } 
        }
    }

    /* precondition: songs cannot be removed 
    postcondition: a song chosen by the user can be removed from the playlist. */
    void removeSong(Song song){
        for(int i = 0; i < CAPACITY; i++){
            if(songs[i] == song){
                songs[i] = null; 
            }else{
                continue; 
            }
        } 
    }

    /* precondition: songs are not assigned to anything.
    postcondition: songs are retrieved. */
    Song [] getSongs(){
        return songs; 
    }

    /* precondition: You cannot display the playlist
    postcondition: Playlist is displayed*/
    void display(){
        for(int i = 0; i < songs.length; i++){
            System.out.println("Song: " + songs[i].getName()); 
            System.out.println("Artist: " + songs[i].getArtist()); 
            System.out.println("Album: " + songs[i].getAlbum()); 
            System.out.println("Duration: " + songs[i].getTime() + " minutes"); 
            System.out.println(); 
        }
    }

    /* precondition: A random song is picked based on a random number 
    postcondition: this random song is put in the queue*/
    void queue(int randomSong){
        System.out.println("Song: " + songs[randomSong].getName()); 
        System.out.println("Artist: " + songs[randomSong].getArtist()); 
        System.out.println("Album: " + songs[randomSong].getAlbum()); 
        System.out.println("Duration: " + songs[randomSong].getTime() + " minutes"); 
        System.out.println(); 
    }

    /* precondition: CAPACITY is 20
    postcondition: a new capacity is retrieved*/
    int getCapacity(){
        return CAPACITY; 
    }

    /* precondition: CAPACITY is 20
    postcondition: new CAPACITY is set to the size the user inputted*/
    void setCapacity(int size){
        this.CAPACITY = size; 
    }

}
