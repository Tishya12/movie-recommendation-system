package warmUpProblems;

import models.Movie;
import models.Rating;
import parseDataFromDataFiles.ParseData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MostWatchedMovie {
    public static void mostWatchedMovie() throws IOException {
        List<Integer> movieids = new ArrayList<>();
        for (int i = 0; i < 1683; i++)
            movieids.add(0);
        List<Rating> ra =new ArrayList<Rating>() ;
        ParseData.parsingRating(ra);


        for(int i=0;i<ra.size();i++){
            int currmovieid=ra.get(i).ItemId;
            movieids.set(currmovieid,movieids.get(currmovieid)+1);
        }

        int mostwatchedmovieid=-1;
        int maxx=-1;
        for(int i=0;i<movieids.size();i++){

            if(maxx<movieids.get(i)){
                maxx=movieids.get(i);
                mostwatchedmovieid=i;
            }
        }

        System.out.println("Most Watched Movie Id: "+ mostwatchedmovieid);

        List<Movie> mo =new ArrayList<Movie>() ;
        ParseData.parsingMovie(mo);

        System.out.println("Most Watched Movie Name: "+mo.get(mostwatchedmovieid).movieTitle);


    }
}
