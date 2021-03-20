package warmUpProblems;

import models.Genre;
import models.Movie;
import models.Rating;
import parseDataFromDataFiles.ParseData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HighestRatedGenre {
    public static void higestRatedGenre() throws IOException {
        List<Long> genreids = new ArrayList<>();
        for (int i = 0; i < 19; i++)
            genreids.add(0L);
        List<Rating> ra =new ArrayList<Rating>() ;
        ParseData.parsingRating(ra);

        List<Movie> mo =new ArrayList<Movie>() ;
        ParseData.parsingMovie(mo);

        for(int i=0;i<ra.size();i++){
            int currmovieid=ra.get(i).ItemId;
            int currmovierating=ra.get(i).rating;

            List<Integer> genid = mo.get(currmovieid-1).genre;


            for(int j=0;j<genid.size();j++){
                if(genid.get(j)==1){
                    genreids.set(j,genreids.get(j)+currmovierating);
                }
            }
        }


        int highestratedgenreid=-1;
        Long maxx= Long.valueOf(0);
        for(int i=0;i<genreids.size();i++){
            //   System.out.println(genreids.get(i));
            if(maxx<genreids.get(i)){
                maxx=genreids.get(i);
                highestratedgenreid=i;
            }
        }

        System.out.println("Highest Rated Genre Id: "+ highestratedgenreid);

        List<Genre> go =new ArrayList<Genre>() ;
        ParseData.parsingGenre(go);


        System.out.println("Highest Rated Genre Name: "+go.get(highestratedgenreid).genrename);
    }
}
