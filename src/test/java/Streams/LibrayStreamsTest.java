package Streams;

import Comparable_Comparator.Song;
import Comparable_Comparator.SongComparator;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void testNestedLoops() {
        List<Song> albumA = Stream.of(new Song(2.65), new Song(5.63), new Song(4.2)).collect(Collectors.toList());
        List<Song> albumB = Stream.of(new Song(1.5), new Song(0.6352), new Song(2.2)).collect(Collectors.toList());

        List<List<Song>> albums = Stream.of(albumA, albumB).collect(Collectors.toList());

        Set<Song> selected = new HashSet<>();

        for(List<Song> album : albums){
            for(Song song : album){
                if(song.getDuration() > 2){
                    selected.add(song);
                }
            }
        }

        albums.stream().forEach(album -> {
            album.stream().filter(s->s.getDuration()>2).forEach(selected::add);
        });


        Set<Song> songs = albums.stream()
                .map(album->album.get(0))
                .filter(song -> song.getDuration()>2)
                .collect(Collectors.toSet());
        System.out.println(songs.toString());

        List<Song> subSelection = albumA.stream().filter(s->s.getDuration()>2).peek(System.out::println).collect(Collectors.toList());


    }

    @Test
    public void testIntStreams() {
        IntToDoubleFunction func = n -> n * 2 ;
        List<Double> nums = IntStream.range(0,9).limit(10).mapToDouble(func).boxed().collect(Collectors.toList());
        System.out.println(nums);
    }
}