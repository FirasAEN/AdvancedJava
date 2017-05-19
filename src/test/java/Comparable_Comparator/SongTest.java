package Comparable_Comparator;

import org.junit.Test;

/**
 * Created by FAB3659 on 2017-05-19.
 */
public class SongTest {

    @Test
    public void testCompareSongs() {
        Song s1 = new Song();
        s1.setTitle("Something");

        Song s2 = new Song();
        s2.setTitle("Something else !");

        if(s1.compareTo(s2) > 0) {
            System.out.println("I am a longer title song");
        } else if(s1.compareTo(s2) == 0) {
            System.out.println("I am a same length title song");
        } else if(s1.compareTo(s2) < 0){
            System.out.println("I am a shorter title song");
        }
    }
}