package Comparable_Comparator;

import org.junit.Test;

/**
 * Created by FAB3659 on 2017-05-19.
 */
public class SongComparatorTest {
    @Test
    public void testSongComparator() {
        SongComparator comparator = new SongComparator();
        int val = comparator.compare(new Song("small"), new Song("small234"));
        System.out.println(val);
    }
}