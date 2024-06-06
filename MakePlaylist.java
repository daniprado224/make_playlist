/* Daniella Prado 
CSE 007: Lab 10
Make a playlist using "has a" codes. This is the main method.*/

import java.util.Scanner; 
public class MakePlaylist {
    public static void main(String[] args){
        /* precondition: some variables have already been declared such as a Playlist object, a string for playlistName and creator,
        and int size. 
        postcondition: the main method will use several methods from this code.*/ 
        Scanner myScanner = new Scanner(System.in); 
        doWork(myScanner); 
    }

    public static void doWork(Scanner myScanner){
        Playlist playlist1; 
        String creator = " "; 
        String playlistName = " ";  
        int size;          
        do{
            System.out.println("Please enter your name"); 
            if(checkInput(myScanner)){
                creator = setInput(myScanner); 
                break;   
            } else{
                System.out.println("Invalid input. Try again."); 
                String junk = myScanner.next(); 
                continue; 
            }           
        }while(true); 

        do{
            System.out.println("Please enter the playlist name."); 
            if(checkInput(myScanner)){
                playlistName = setInput(myScanner); 
                break; 
            } else{
                System.out.println("Invalid input. Try again."); 
                String junk = myScanner.next(); 
                continue; 
            } 
        }while(true);

        do{
            System.out.println("Please enter playlist size."); 
            boolean correct = myScanner.hasNextInt();      
                if(correct){
                    size = myScanner.nextInt(); 
                    if(size <= 20 && size > 0){
                    playlist1 = new Playlist(playlistName, creator, size); //passing in these variables to Playlist class. 
                    playlist1.setCapacity(size);
                    break;                         
                    }else{
                        System.out.println("Invalid range. Try again."); 
                        continue;   
                    }
                    }else{
                    System.out.println("Invalid size. try again."); 
                    String junk = myScanner.next(); 
                    continue; 
                }
            
        } while(true); 

        for(int i = 1; i <= size; i++){
            myScanner.nextLine(); 
            System.out.println("Song : " + i); 
            Song  newSong = songInfo(myScanner); 
            playlist1.addSong(newSong); 
        }
        
        System.out.println("Your playlist: "); 
        System.out.println(); 
        playlist1.display();
 
        int queue = 0;
        do{
             System.out.println("Please enter how many songs you want to queue. Press -1 to quit."); 
             boolean correct = myScanner.hasNextInt();    
             if(correct){
                 queue = myScanner.nextInt(); 
                 if(queue > size){
                     System.out.println("Not enough songs to do that. Select fewer songs.");  
                     continue; 
                 }else{
                    queueSongs(queue, playlist1);
                 }
             }else{
                 System.out.println("Invalid input. Try again."); 
                 String junk = myScanner.next(); 
                 continue; 
             }
        } while(queue != -1); 
    }
        /* precondition: Scanner object is passed down for input validation. 
        postcondition: boolean true or false is returned depending if input is correct*/ 
    public static boolean checkInput(Scanner myScanner){
        boolean correct = myScanner.hasNextLine(); 
        if(correct){
            return true; 
        }else{
            return false; 
        }
    }
        /* precondition: scanner object is passed down to set a variable 
        postcondition: a string is set to equal what was written in the scanner by the user. */ 
    public static String setInput(Scanner myScanner){
        String input = myScanner.nextLine(); 
        return input; 
    }
        /* precondition: scanner object is passed down so user will be able to type answers 
        postcondition: information given by the user is sent to the song class and becomes a part of the song array. */ 
    public static Song songInfo(Scanner myScanner){
        String song = ""; 
        String artist = ""; 
        String album = ""; 
        int songTime = 0; 
       

        do{
            System.out.println("Please enter the name of the song."); 
            boolean correct = myScanner.hasNextLine(); 
            if(correct){
                song = myScanner.nextLine(); 
                break; 
            }else{
                System.out.println("Invalid input for a song. Try again."); 
                String junk = myScanner.next(); 
                continue; 
            }
        }while(true); 
        
        do{
            System.out.println("Please enter the name of the artist."); 
            boolean correct = myScanner.hasNextLine(); 
            if(correct){
                artist = myScanner.nextLine(); 
                break;  
            }else{
                System.out.println("Invalid input for an artist. Try again."); 
                String junk = myScanner.next(); 
                continue;
                 
            }                
        } while(true); 

        do{
            System.out.println("Please enter the name of the album."); 
            boolean correct = myScanner.hasNextLine(); 
            if(correct){
                album = myScanner.nextLine(); 
                break; 
            }else{
                System.out.println("Invalid input for an album. Try again."); 
                String junk = myScanner.next(); 
                continue; 
            }
        }while(true); 

        do{
            System.out.println("Please enter how long the song is."); 
            boolean correct = myScanner.hasNextInt(); 
            if(correct){
                 songTime = myScanner.nextInt(); 
                break; 
            }else{
                System.out.println("Invalid input for a song. Try again."); 
                String junk = myScanner.next(); 
                continue; 
            }
        }while(true); 

        Song newSong = new Song (song, artist, album, songTime); 
        return newSong;  
    }
        /* precondition: calling the number of songs the user wants to queue and the Playlist object created.
        postcondition: depending on the */ 
    public static void queueSongs(int numSongs, Playlist playlist1){  
        for(int i = 0; i < numSongs; i++){
            int random = (int)(Math.random()* numSongs) + 1; 
            System.out.println("Queued song: ");
            playlist1.queue(random);
            System.out.println(); 
        }
    }
}
