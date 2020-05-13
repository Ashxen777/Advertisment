package util;

import model.Item;
import model.User;

import java.io.*;

import storage.DataStorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Մեր վերջին արած օրինակի մեջ ավելացնում ենք ֆայլային համակարգի հետ աշխատանքը,
// որպեսզի ամեն անգամ տվյալների կորուստ չունենանք։
//Սարքելու ենք FileUtil կլասս, որի մեջ կարող ենք User-ի համար 2 մեթոդ ունենալ։
//public static void serializeUserMap(Map<String, User> userMap){
////ստեղ մեր եկած մապ-ը կսերիալիզացնենք ինչ որ ֆայլի մեջ։
//}
//public static Map<String, User> deserializeUserMap(){
////ստեղ էլ նույն ֆայլից կվերցնենք օբյեկտը, ու կվերադարնենք։
//}
////Նույն տրամաբանությամբ էլ կգրենք Item-ների համար, բայց արդեն ուրիշ ֆայլի մեջ։
//——————————————————————————
//Իմաստը կայանում է նրանում, որ հենց ծրագրով ինչ որ բան ավելացնենք կամ ջնջենք,
// կամ փոփոխենք պետք է կանչել serialize -ը, ու տալ մապը կամ լիստը։
//Երբ ծրագիրը առաջին անգամ միացնենք, պետք է կանչել storage-ի initData() մեթոդը,
// որտեղ կկանչենք FileUtil-ի դեսերիալայզ մեթոոդները, և
// վերադարձրած օբյեկտները կվերագրենք մեր գլոբալ օբյեկտներին։
//Այսինքն իրանք էլ դատարկ չեն լինի։
public class FileUtil {
    private static final String USER_PATH = "src\\main\\resources\\userMap.obj";
    private static final String ITEM_PATH = "src\\main\\resources\\itemList.obj";

    public static void serializeUserMap(Map<String, User> userMap) {
        File userMapFile = new File(USER_PATH);
        try {


            if (!userMapFile.exists()) {
                userMapFile.createNewFile();
            }
            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(USER_PATH))) {
                outputStream.writeObject(userMap);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }


    public static Map<String, User> deserializeUserMap() {
        Map<String, User> userM = new HashMap<>();
        File userMapFile = new File(USER_PATH);
        if (userMapFile.exists()){
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(USER_PATH))) {
                Object deserialize = objectInputStream.readObject();
                return (Map<String, User>) deserialize;

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return userM;
    }

    public static void serializeItemList(List<Item> item) {
        File itemListFile = new File(ITEM_PATH);
        try {


            if (!itemListFile.exists()) {
                itemListFile.createNewFile();
            }
            try (ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(ITEM_PATH))) {
                objectOutput.writeObject(item);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Item> deserializeItem() {
        List<Item> items = new ArrayList<>();
        File itemListFile = new File(ITEM_PATH);
        if (itemListFile.exists()){
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(ITEM_PATH))) {
                Object deserialize = objectInputStream.readObject();
                return (List<Item>) deserialize;

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return items;
    }
}




