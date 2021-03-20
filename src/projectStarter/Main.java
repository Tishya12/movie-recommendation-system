package projectStarter;

import models.User;
import parseDataFromDataFiles.ParseData;
import recommend5Movies.Top5MoviesByUserInterest;
import warmUpProblems.HighestRatedGenre;
import warmUpProblems.MostActiveUser;
import warmUpProblems.MostWatchedGenre;
import warmUpProblems.MostWatchedMovie;
import warmUpProblems.TopMovieByGenre;
import warmUpProblems.TopMovieByYear;
import warmUpProblems.TopMoviebyYearAndGenre;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static parseDataFromDataFiles.ParseData.parsingUser;

public class Main {
    public static void main(String[] args) throws IOException {
        // write your code here
        Scanner sc1 = new Scanner(System.in);    //System.in is a standard input stream
        System.out.print("Enter 1 == Top Movie By Genre\n" +
                "2 == Top Movie By Year\n" +
                "3 == Top Movie By Year & Genre\n" +
                "4 == Most watched Movie\n" +
                "5 == Most watched Genre\n" +
                "6 == Highest rated Genre\n" +
                "7 == Most Active User\n" + "8 == Top 5 Movies By User's interest\n");
        int choice = sc1.nextInt();

        Scanner sc2 = new Scanner(System.in);    //System.in is a standard input stream

        if(choice ==1) {
            System.out.print("Enter Genre id- \n");
            System.out.println("0: unknown | 1: Action | 2: Adventure | 3: Animation |" +
                    " 4: Children's | 5: Comedy | 6: Crime | 7:Documentary | 8:Drama | 9:Fantasy |\n" +
                    "       10:Film-Noir | 11:Horror | 12:Musical | 13:Mystery | 14:Romance | 15:Sci-Fi |" +
                    " 16:Thriller | 17:War | 18:Western |");
            int gen = sc2.nextInt();
            TopMovieByGenre.topByGenre(gen);
        }

        if(choice ==2) {
            System.out.print("Enter Year- ");
            int year = sc2.nextInt();
            TopMovieByYear.topByYear(year);
        }

        if(choice ==3) {
            System.out.print("Enter Genre id- \n");
            System.out.println("0: unknown | 1: Action | 2: Adventure | 3: Animation |" +
                    " 4: Children's | 5: Comedy | 6: Crime | 7:Documentary | 8:Drama | 9:Fantasy |\n" +
                    "       10:Film-Noir | 11:Horror | 12:Musical | 13:Mystery | 14:Romance | 15:Sci-Fi |" +
                    " 16:Thriller | 17:War | 18:Western |");
            int gen = sc2.nextInt();
            System.out.print("Enter Year- ");
            int year = sc2.nextInt();

            TopMoviebyYearAndGenre.topByYearAndGenre(year,gen);
        }

        if(choice==4){
            MostWatchedMovie.mostWatchedMovie();
        }

        if(choice==5){
            MostWatchedGenre.mostWatchedGenre();
        }

        if(choice==6){
            HighestRatedGenre.higestRatedGenre();
        }

        if(choice==7){
            MostActiveUser.mostActiveUser();
        }

        if(choice == 8) {
            System.out.print("Enter User Id- ");
            int us_id = sc2.nextInt();
            Top5MoviesByUserInterest.findtop5(us_id);
        }

    }
    }


