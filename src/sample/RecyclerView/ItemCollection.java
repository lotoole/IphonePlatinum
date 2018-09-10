package com.example.jhibbele.recyclerview;

import java.util.ArrayList;
import java.util.List;

public class ItemCollection {
    private static ItemCollection sItemCollection;
    private List<Item> mItems;

    public static ItemCollection get() {
        if (sItemCollection == null) {
            sItemCollection = new ItemCollection();
        }
        return sItemCollection;
    }

    private ItemCollection() {
        mItems = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Item item = new Item();
            item.setTitle("Item #" + i);
            item.setDate("date for Item " + i);
            switch (i % 4) {
                case 0:
                    item.setImageResource(R.drawable.night);
                    break;
                case 1:
                    item.setImageResource(R.drawable.hot);
                    break;
                case 2:
                    item.setImageResource(R.drawable.scattered);
                    break;
                case 3:
                    item.setImageResource(R.drawable.sunny);
                    break;
            }
            mItems.add(item);
        }
    }

    public List<Item> getItems() {
        return mItems;
    }
}
