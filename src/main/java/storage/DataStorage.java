package storage;

import model.Category;
import model.Item;
import model.User;
import util.FileUtil;



import java.util.*;




public class DataStorage {
    private static long itemId = 1;
    private Map<String, User> userMap = new HashMap<>();
    private List<Item> items = new ArrayList<>();


    public void addUser(User user)  {
        userMap.put(user.getPhoneNumber(), user);
        FileUtil.serializeUserMap(userMap);
    }

    public void add(Item item)  {
        item.setId(itemId++);
        items.add(item);
       FileUtil.serializeItemList( items);
   }


    public User getUser(String phoneNumber) {
        return userMap.get(phoneNumber);
    }

    public Item getItemByID(long id) {

        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void printItems() {
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public void printItemsOrderByTitle() {
        List<Item> orderList = new ArrayList<>(items);
        Collections.sort(orderList);
//        orderList.sort(Item::compareTo);
        for (Item item : orderList) {
            System.out.println(item);
        }
    }

    public void printItemsOrderByDate() {
        List<Item> orderList = new ArrayList<>(items);
        orderList.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o2.getCreatedDate().compareTo(o1.getCreatedDate());
            }
        });
        for (Item item : orderList) {
            System.out.println(item);
        }
    }

    public void printItemsByUser(User user) {
        for (Item item : items) {
            if (item.getUser().equals(user)) {
                System.out.println(item);
            }
        }
    }

    public void printItemsByCategory(Category category) {
        for (Item item : items) {
            if (item.getCategory().equals(category)) {
                System.out.println(item);
            }
        }
    }

    public void deleteItemByUser(User user) {

        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item next = iterator.next();
            if (next.getUser().equals(user)) {
                iterator.remove();
            }
        }
        FileUtil.serializeItemList(items);
//        items.removeIf(item -> item.getUser().equals(user));
//        for (Item item : items) {
//            if (item.getUser().equals(user))
//                items.remove(item);
//        }

    }

    public void deleteItemById(long id){
        items.remove(getItemByID(id));
        FileUtil.serializeItemList(items);

    }

    public void initData()  {
        userMap = FileUtil.deserializeUserMap();
        items =  FileUtil.deserializeItem();
if (items!=null && !items.isEmpty()) {
    Item item = items.get(items.size() - 1);
    itemId=item.getId()+1;
}
    }


}
