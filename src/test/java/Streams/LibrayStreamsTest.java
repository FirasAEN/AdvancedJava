package Streams;

import Comparable_Comparator.Song;
import Comparable_Comparator.SongComparator;
import org.junit.Test;
import sun.plugin2.gluegen.runtime.StructAccessor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * Created by Firas on 5/21/2017.
 */
public class LibrayStreamsTest {

    @Test
    public void testCollectToList() {
        List<String> strings = Stream.of("a", "b", "c").collect(Collectors.toList());
        assertEquals(Arrays.asList("a", "b", "c"), strings);
    }

    @Test
    public void testCollectToMap() throws Exception {
        List<String> collection = Stream.of("firas", "amani", "rida", "karim").collect(Collectors.toList());
        List<String> upperCollection = collection.stream().map(name->name.toUpperCase()).collect(Collectors.toList());
        assertEquals(Arrays.asList("FIRAS", "AMANI", "RIDA", "KARIM"), upperCollection);
    }

    @Test
    public void testCollectToMapWithFunction() throws Exception {
        List<String> collection = Stream.of("firas", "amani", "rida", "karim").collect(Collectors.toList());
        Function<String, String> toUpperCase =  string -> string.toUpperCase();
        List<String> upperCollection = collection.stream().map(toUpperCase).collect(Collectors.toList());
        assertEquals(Arrays.asList("FIRAS", "AMANI", "RIDA", "KARIM"), upperCollection);
    }

    @Test
    public void testToSquare() throws Exception {
        List<String> nums = Stream.of("1","4","6","45","87").collect(Collectors.toList());
        Function<String, Double> toSquare = stringNum -> Math.pow(Double.parseDouble(stringNum),2);
        List<Double> numsSquares = nums.stream().map(toSquare).collect(Collectors.toList());
        numsSquares.forEach(System.out::println);
    }

    @Test
    public void testMapping() throws Exception {
        List<Integer> num1 = Stream.of(1,2,3).collect(Collectors.toList());
        List<Integer> num2 = Stream.of(10,20,30).collect(Collectors.toList());
        List<List<Integer>> nestedLists = Stream.of(num1, num2).collect(Collectors.toList());

        List<Integer> flatList = Stream.of(num1, num2).flatMap(n->n.stream()).collect(Collectors.toList());
        System.out.println(flatList);
        assertEquals(6, flatList.size());
    }

    @Test
    public void testMin() throws Exception {
        List<Song> songs = Stream.of(new Song("Blue Jazz"), new Song("Ash")).collect(Collectors.toList());
        Song s = songs.stream().min(new SongComparator()).get();
        assertEquals("Ash", s.getTitle());

       Song s2 =  songs.stream().max(Comparator.comparing(song -> song.getTitle().length())).get();
       assertEquals("Blue Jazz", s2.getTitle());
    }
}