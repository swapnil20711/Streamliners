package Task3;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    HashMap<String, TouristPlace> map = new HashMap<>();
    private final String PATH = "D:\\IdeaProjects\\Streamliners\\src\\Task3\\src.txt";

    private int showMenuAndGetChoice() {
        System.out.println("------MENU-------");
        System.out.println("1. Add a new Place ");
        System.out.println("2. Find a Place ");
        System.out.println("3. Rate a Place");
        System.out.println("4. Remove  a Place");
        System.out.println("Enter your choice\n");
        return new Scanner(System.in).nextInt();

    }

    void show() throws Exception {
        readMapFromFile();
        while (true) {
            int choice = showMenuAndGetChoice();
            switch (choice) {
                case 1:
                    addNewPlace();
                    break;
                case 2:
                    findPlace();
                    break;
                case 3:
                    ratePlace();
                    break;
                case 4:
                    removePlace();
                    break;
                default:
                    System.out.println("Invalid choice!!");
                    break;
            }
            showPlaces();
            if (wantsToExit()) {
                break;
            }
        }
        savePlaces();
    }

    private void savePlaces() throws IOException {
        FileOutputStream outputStream = new FileOutputStream(PATH);
        ObjectOutputStream stream = new ObjectOutputStream(outputStream);
        stream.writeObject(map.values().toString());
        System.out.println(map.values().toString());
       /* System.out.println("File saved");
        TouristPlace place=new TouristPlace();
        place.name="Jantar mantar";
        place.previousRating=4;
        place.numberRates=2;*/
//        stream.writeObject(place.toString());


    }

    private void removePlace() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the place you want to remove ");
        String placeName = scanner.next();
        if (map.containsKey(placeName)) {
            map.remove(placeName);
            System.out.println("Place removed!!");
        } else {
            System.out.println("Place not found");
        }

    }

    private void ratePlace() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Rate the place between 1-5 by entering name");
        String placeName = scanner.next();
        if (map.containsKey(placeName)) {
            int rate = scanner.nextInt();
            if (rate >= 1 && rate <= 5) {
                TouristPlace place = map.get(placeName);
                place.rateFromUser(rate);
            } else {
                System.out.println("Invalid input");
            }
        } else {
            System.out.println("Place not found!!");
        }

    }

    private void findPlace() {
        Scanner scanner = new Scanner(System.in);
        String place = scanner.next();
        if (map.containsKey(place)) {
            System.out.println("Place searched");
        } else {
            System.out.println("Place not found!!");
        }

    }

    private void addNewPlace() {
        TouristPlace place = TouristPlace.newPlaceFromUser();
        map.put(place.name, place);
        System.out.println("Place added");
    }

    private boolean wantsToExit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to continue y/n?");
        String input = scanner.next();
        return input.equals("n");
    }

    private void showPlaces() {
        System.out.println(">>Places " + map.values().toString());
    }

    @Override
    public String toString() {
        return String.format("%s", map.values());
    }

    private void readMapFromFile() throws Exception {
        try {
            FileInputStream fileInputStream = new FileInputStream(PATH);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            HashMap<String, TouristPlace> hashMap = (HashMap<String, TouristPlace>) objectInputStream.readObject();
            System.out.println(hashMap.values().toString());
        } catch (Exception e) {
            //If file is not found
            map = new HashMap<>();
        }
        showPlaces();

    }
}