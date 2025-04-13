package entity;

import entity.enums.Genre;

import java.time.Duration;
import java.util.List;

public class Movie {
    public int movieId;
    public String title;
    public String language;
    public Genre genre;
    public Duration duration;
    public List<Show> shows;
}
