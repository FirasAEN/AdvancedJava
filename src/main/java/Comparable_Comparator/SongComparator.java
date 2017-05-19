package Comparable_Comparator;

import java.util.Comparator;

/**
 * Created by FAB3659 on 2017-05-19.
 */
public class SongComparator implements Comparator<Song> {

    @Override
    public int compare(Song o1, Song o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
