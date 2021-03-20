package warmUpProblems;

import models.Genre;
import models.Movie;
import models.Rating;
import parseDataFromDataFiles.ParseData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MostWatchedGenre {
    public static void mostWatchedGenre() throws IOException {
        List<Integer> genreids = new ArrayList<>();
        for (int i = 0; i < 19; i++)
            genreids.add(0);
        List<Rating> ra =new ArrayList<Rating>() ;
        ParseData.parsingRating(ra);

        List<Movie> mo =new ArrayList<Movie>() ;
        ParseData.parsingMovie(mo);

        for(int i=0;i<ra.size();i++){
            int currmovieid=ra.get(i).ItemId;

            List<Integer> genid = mo.get(currmovieid-1).genre;


            for(int j=0;j<genid.size();j++){
                if(genid.get(j)==1){
                    genreids.set(j,genreids.get(j)+1);
                }
            }
        }


        int mostwatchedgenreid=-1;
        int maxx=-1;
        for(int i=0;i<genreids.size();i++){
            //   System.out.println(genreids.get(i));
            if(maxx<genreids.get(i)){
                maxx=genreids.get(i);
                mostwatchedgenreid=i;
            }
        }

        System.out.println("Most Watched Genre Id: "+ mostwatchedgenreid);


        List<Genre> go =new ArrayList<Genre>() ;
        ParseData.parsingGenre(go);

        System.out.println("Most Watched Genre Name: "+go.get(mostwatchedgenreid).genrename);


    }
}
