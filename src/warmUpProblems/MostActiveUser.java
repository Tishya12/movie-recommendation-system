package warmUpProblems;

import models.Rating;
import parseDataFromDataFiles.ParseData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MostActiveUser {
    public static void mostActiveUser() throws IOException {
        List<Integer> userids = new ArrayList<>();
        for (int i = 0; i < 944; i++)
            userids.add(0);
        List<Rating> ra = new ArrayList<Rating>();
        ParseData.parsingRating(ra);


        for (int i = 0; i < ra.size(); i++) {
            int curruserid = ra.get(i).UserId;
            userids.set(curruserid, userids.get(curruserid) + 1);
        }

        int mostactiveuserid = -1;
        int maxx = -1;
        for (int i = 0; i < userids.size(); i++) {
            if (maxx < userids.get(i)) {
                maxx = userids.get(i);
                mostactiveuserid = i;
            }
        }

        System.out.println("Most Active User Id: " + mostactiveuserid);
    }
}
