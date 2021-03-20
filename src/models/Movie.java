package models;

import java.util.ArrayList;
import java.util.List;

public class Movie {


    public int movieId;
    public String movieTitle ;
    public String releaseDate ;
    public String videoReleaseDate ;
    public String IMDbURL ;
    public List<Integer> genre=new ArrayList<>();
}
