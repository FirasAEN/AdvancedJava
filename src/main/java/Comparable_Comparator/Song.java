package Comparable_Comparator;

/**
 * Created by FAB3659 on 2017-05-19.
 */
public class Song implements Comparable<Song>{
    private String title;
    private double duration;

    public Song() {
    }

    public Song(String s) {

        title = s;
    }
    public Song(double duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public int compareTo(Song o) {
        return this.getTitle().compareTo(o.getTitle());
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}

