package warmUpProblems;

import models.Movie;
import models.Rating;
import parseDataFromDataFiles.ParseData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TopMoviebyYearAndGenre {
    public static void topByYearAndGenre(int yr, int gen) throws IOException {
        List<Movie> mo =new ArrayList<Movie>() ;
        ParseData.parsingMovie(mo);

        List<Integer> movieIds=new ArrayList<>();   //To get the list of movie id's with the given year yr and genre gen
        for(int i=0;i<mo.size();i++){
            String curryear=mo.get(i).releaseDate;
            int curryr=-1;
            if(curryear.length()>=4)
                curryr=Integer.parseInt(curryear.substring(curryear.length()-4,curryear.length()));
            if(curryr==yr && mo.get(i).genre.get(gen)==1)
                movieIds.add(mo.get(i).movieId);
        }

        if(movieIds.isEmpty()){
            System.out.println("No movie released in this year");
        }

        List<Rating> ra =new ArrayList<Rating>() ;
        ParseData.parsingRating(ra);

        int top_average_rating_movie_id_by_year=-1;

        float maxx=0;
        for(int j=0;j<movieIds.size();j++) {
            int sum=0;
            int count=0;
            for (int i = 0; i < ra.size(); i++) {
                if (ra.get(i).ItemId ==movieIds.get(j)){
                    sum+=ra.get(i).rating;
                    count++;
                }
            }
            float avg= sum/(float)count;
            if(maxx<avg){
                maxx=avg;
                top_average_rating_movie_id_by_year=movieIds.get(j);
            }
        }

        if(!movieIds.isEmpty())
            System.out.println("Top Movie Id By Year " + yr + " and genre " + gen + ": "+top_average_rating_movie_id_by_year);

        if(!movieIds.isEmpty())
            System.out.println("Top Movie Name By Year " + yr + " and genre " + gen + ": "+mo.get(top_average_rating_movie_id_by_year).movieTitle);


    }
}
