package parseDataFromDataFiles;

import models.Genre;
import models.Movie;
import models.Rating;
import models.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class ParseData {
    public static void parsingUser(List<User> u) throws IOException {

        File file = new File("src/dataFiles/user.data");

        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            String string = st;
            String[] parts = string.split(Pattern.quote("|"));
            User dummy = new User();
            dummy.userid= Integer.parseInt(parts[0]);
            dummy.age= Integer.parseInt(parts[1]);
            dummy.gender=parts[2];
            dummy.occupation=parts[3];
            dummy.zipcode=parts[4];

            u.add(dummy);
        }

    }
    public static void parsingRating(List<Rating> r) throws IOException{

        File file = new File("src/dataFiles/ratings.data");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            String string = st;
            StringTokenizer parts = new StringTokenizer(st);
            Rating dummy = new Rating();
            dummy.UserId= Integer.parseInt(parts.nextToken());
            dummy.ItemId= Integer.parseInt(parts.nextToken());
            dummy.rating= Integer.parseInt(parts.nextToken());


            r.add(dummy);
        }

    }
    public static void parsingMovie(List<Movie> m) throws IOException {

        File file = new File("src/dataFiles/movie.data");

        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            String string = st;
            String[] parts = string.split(Pattern.quote("|"));
            Movie dummy = new Movie();
            dummy.movieId= Integer.parseInt(parts[0]);
            dummy.movieTitle=parts[1];
            dummy.releaseDate=parts[2];
            dummy.IMDbURL=parts[4];

            for(int i=0;i<19;i++){
                dummy.genre.add(Integer.parseInt(parts[i+5]));
            }
            m.add(dummy);
        }
    }
    public static void parsingGenre(List<Genre> g) throws IOException {

        File file = new File("src/dataFiles/genre.data");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            String string = st;
            String[] parts = string.split(Pattern.quote("|"));
            Genre dummy = new Genre();
            if(parts.length==2) {
                dummy.genrename = parts[0];
                dummy.genreid = Integer.parseInt(parts[1]);
            }
            g.add(dummy);
        }


    }
}
