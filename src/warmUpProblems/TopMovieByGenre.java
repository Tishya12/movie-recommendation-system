package warmUpProblems;

import models.Movie;
import models.Rating;
import parseDataFromDataFiles.ParseData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TopMovieByGenre {
    public static void topByGenre(int gen) throws IOException {
        List<Movie> mo =new ArrayList<Movie>() ;
        ParseData.parsingMovie(mo);

        List<Integer> movieIds=new ArrayList<>();   //To get the list of movie id's with the given genre gen
        for(int i=0;i<mo.size();i++){
            if(mo.get(i).genre.get(gen)==1)
                movieIds.add(mo.get(i).movieId);
        }

        List<Rating> ra =new ArrayList<Rating>() ;
        ParseData.parsingRating(ra);

        int topMovieIdByGenre=-1;

        int maxx=0;
        for(int j=0;j<movieIds.size();j++) {
            int sum=0;
            int count=0;
            for (int i = 0; i < ra.size(); i++) {
                if (ra.get(i).ItemId ==movieIds.get(j)){
                    sum+=ra.get(i).rating;
                    count++;
                }
            }
//            float avg= sum/(float)count;     //if sum is very large then we can also take average
            if(maxx<sum){
                maxx=sum;
                topMovieIdByGenre=movieIds.get(j);
            }
        }


        System.out.println("Top Movie id By Genre " +gen+ ": " +topMovieIdByGenre);


        System.out.println("Top Movie Name By Genre " +gen+ ": " +mo.get(topMovieIdByGenre).movieTitle);

    }
}
