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
    private static final String FILE_PATH = "C:\\Users\\user\\IntellijProekt\\Advertisment\\src\\util\\user.txt";
    private static final String FILE_PATH1 = "C:\\Users\\user\\IntellijProekt\\Advertisment\\src\\util\\item.txt";

    public static void serializeUserMap(Map<String, User> userMap) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
        outputStream.writeObject(userMap);
        outputStream.close();
    }

    public static Map<String, User> deserializeUserMap() throws IOException {
        Map<String, User> userM = new HashMap<>();

        try {

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_PATH));
            Object deserialize = objectInputStream.readObject();
            userM = (Map<String, User>) deserialize;
            objectInputStream.close();


        } catch (ClassNotFoundException | EOFException e) {
            e.printStackTrace();
        }

        return userM;
    }

    public static void serializeItemList(List<Item> item) throws IOException {
        ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(FILE_PATH1));
        objectOutput.writeObject(item);
        objectOutput.close();
    }

    public static List<Item> deserializeItem() throws IOException {
        List<Item> items = new ArrayList<>();
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_PATH1));
            Object deserialize = objectInputStream.readObject();
            items = (List<Item>) deserialize;
            objectInputStream.close();

        } catch (ClassNotFoundException | EOFException e) {
            e.printStackTrace();
        }
        return items;
    }
}




