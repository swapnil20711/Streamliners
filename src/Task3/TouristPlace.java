package Task3;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class TouristPlace implements Serializable {
    String workingHrs = "09:00AM to 16:30PM";
    ArrayList<String> famousFor = new ArrayList<>();
    String name;
    int ticketprice;
    float previousRating;
    int numberRates = 0;
    String category;

    public TouristPlace(String workingHrs, String name, int ticketprice, String category) {
        this.workingHrs = workingHrs;
        this.name = name;
        this.ticketprice = ticketprice;
        this.category = category;
    }

    //Add famous things of the places
    public TouristPlace addFamousFor(String s) {
        famousFor.add(s);
        return this;
    }

    //default constructor
    public TouristPlace() {

    }

    //To get the rating from the user
    public TouristPlace rateFromUser(int... starRating) {
        /****** Previous logic
         float totalStars = previousRating * numberRates;
         totalStars += starRating;
         numberRates++;
         previousRating = (totalStars / numberRates);
         System.out.println(previousRating);
         *****/
        for (int stars : starRating) {
            previousRating += (stars - previousRating) / ++numberRates;
        }
        System.out.println(previousRating);
        return this;

    }

    //To check that place is open or not at the current time
    public boolean isPlaceOpen(String currenttime) {
        String input = "10:00AM to 08:00PM";
//        input = input.replace("AM to ", ":")
//                .replace("PM to ", ":")
//                .replace("AM", "")
//                .replace("PM", "");
//
//        String[] nums = input.split(":");
//
//        int startHr = Integer.parseInt(nums[0]),
//                startMin = Integer.parseInt(nums[1]),
//                endHr = Integer.parseInt(nums[2]),
//                endMin = Integer.parseInt(nums[3]);
//
//        WorkingHour hour = new WorkingHour(startHr, startMin, endHr, endMin);
//        System.out.println(hour.checkIsInInterval());
        //Split both the times
        String[] times = input.split(" to ");
        if (times[0].length() == 6) {
            times[0] = '0' + times[0];
        }
        if (times[1].length() == 6) {
            times[1] = '0' + times[1];
        }

        //Parse times
        LocalTime startTime = LocalTime.parse(times[0], DateTimeFormatter.ofPattern("hh:mma")), endTime = LocalTime.parse(times[1], DateTimeFormatter.ofPattern("hh:mma")), currTime = LocalTime.now();

        //startTime.compare(currTime) : -1, 0
        //endTime.compareTo(currTime) : 1, 0
        return (startTime.compareTo(currTime) <= 0 && endTime.compareTo(currTime) >= 0);
    }

    //Things to do at the place of visit
    public TouristPlace thingsToDo(String placeName, ArrayList<String> todoList) {
        System.out.println("Todo things on " + placeName + " is " + todoList);
        return this;
    }

    public static TouristPlace newPlaceFromUser() {
        Scanner scanner = new Scanner(System.in);
        TouristPlace newPlace = new TouristPlace();
        System.out.println("Enter the name");
        newPlace.name = scanner.nextLine();
        return newPlace;
    }

    @Override
    public String toString() {
        return String.format("Name=%s,Rating = %s,Number of ratings %d", name, previousRating, numberRates);
    }
}
