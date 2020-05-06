package main;

import javafx.scene.chart.ScatterChart;
import model.Category;
import model.Gender;
import model.Item;
import model.User;
import storage.DataStorage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class AdvertismentMain implements Commands {

    private static Scanner scanner = new Scanner(System.in);
    private static DataStorage dataStorage = new DataStorage();
    private static User currentUser=null;
    private static Item item=null;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        dataStorage.addUser(new User("as","yan",21,Gender.FEMALE,"2211","2233"));
        dataStorage.addUser(new User("asa","yan",71,Gender.MALE,"5544","5566"));
        dataStorage.initData(currentUser);
        boolean isRun = true;
        while (isRun) {
            Commands.printMainCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case LOGIN:
                    loginUser();
                    break;
                case REGISTER:
                    registerUser();
                    break;
                default:
                    System.out.println("Wrong Commands");
            }

        }

    }

    private static void registerUser() {
        System.out.println("Please input user data " +
                " name, surname, age, gender(MALE,FEMALE), phoneNumber, password");
        try {


            String userDataStr = scanner.nextLine();
            String[] userDataArr = userDataStr.split(",");
            User userFromStorage = dataStorage.getUser(userDataArr[4]);
            if (userFromStorage == null) {
                User user = new User();
                user.setName(userDataArr[0]);
                user.setSurname(userDataArr[1]);
                user.setAge(Integer.parseInt(userDataArr[2]));
                user.setGender(Gender.valueOf(userDataArr[3].toUpperCase()));
                user.setPhoneNumber(userDataArr[4]);
                user.setPassword(userDataArr[5]);
                dataStorage.addUser(user);
                System.out.println("User was successfully added");

            } else
                System.out.println("User already exists!");
        } catch (ArrayIndexOutOfBoundsException | IOException e) {
            System.out.println("Wrong Data");



        }

    }

    private static void loginUser() {
        System.out.println("Please input phoneNumber, password");
        try {
            String loginDataStr = scanner.nextLine();
            String[] loginData = loginDataStr.split(",");
            User user = dataStorage.getUser(loginData[0]);
            if (user != null && user.getPassword().equals(loginData[1])) {
                currentUser = user;
                loginSuccess();
            } else {
                System.out.println("Wrong phoneNumber or password");
            }
        } catch (ArrayIndexOutOfBoundsException | IOException e) {
            System.out.println("Wrong Data");
        }

    }

    private static void loginSuccess() throws IOException {

        System.out.println("Welcome " + currentUser.getName() + " !");
        boolean isRun = true;
        while (isRun) {
            Commands.printUserCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case LOGOUT:
                    isRun = false;
                    break;
                case ADD_NEW_AD:
                    addNewAd();
                    break;
                case PRINT_MY_ADS:
                    dataStorage.printItemsByUser(currentUser);
                    break;
                case PRINT_ALL_ADS:
                    dataStorage.printItems();
                    break;
                case PRINT_ALL_BY_CATEGORY:
                    printAllBycategory();
                    break;
                case PRINT_ALL_ADS_SORT_BY_TITLE:
               dataStorage.printItemsOrderByTitle();
                break;
                case PRINT_ALL_ADS_SORT_BY_DATE:
                    dataStorage.printItemsOrderByDate();
                    break;
                case DELETE_MY_ALL_ADS:
                    dataStorage.deleteItemByUser(currentUser);
                    break;
                case DELETE_ADS_BY_ID:
                    deleteById();
                    break;
                default:
                    System.out.println("Wrong Commands");
            }

        }
    }

    private static void deleteById()   {
        try {


            System.out.println("Please choose id from list");
            dataStorage.printItemsByUser(currentUser);
            long id = Long.parseLong(scanner.nextLine());
            Item itemByID = dataStorage.getItemByID(id);
            if (itemByID != null && itemByID.getUser().equals(currentUser)) {
                dataStorage.deleteItemById(id);
            } else {
                System.out.println("Wrong Id!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void printAllBycategory() {
        System.out.println("Please choose category name from list: "
                + Arrays.toString(Category.values()));
        try {
            String categoryStr = scanner.nextLine().toUpperCase();
            Category category = Category.valueOf(categoryStr);
            dataStorage.printItemsByCategory(category);
        }catch (Exception e){
            System.out.println("Wrong category");

        }
    }

    private static void addNewAd() {
        System.out.println("Please input item data  title, text,price,category");
        System.out.println("Please choose category name from list: "
                + Arrays.toString(Category.values()));
        try {


        String itemDataStr = scanner.nextLine();
        String[] itemData = itemDataStr.split(",");
        Item item = new Item();
        item.setTitle(itemData[0]);
        item.setText( itemData[1]);
        item.setPrice(Double.parseDouble(itemData[2]));
        item.setUser(currentUser);
        item.setCategory(Category.valueOf(itemData[3].toUpperCase()));
        item.setCreatedDate(new Date());
        dataStorage.add(item);
            System.out.println("Item was successfully added");
    }catch (Exception e){
            System.out.println("Wrong Data!");
        }
    }
}

