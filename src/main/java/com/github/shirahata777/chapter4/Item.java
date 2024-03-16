package com.github.shirahata777.chapter4;

public class Item {

    private int id;
    private ItemType type;
    private String name;
    private int price;

    public Item(int id, ItemType type, String name, int price) {
        super();
        this.id = id;
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public ItemType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", type=" + type + ", name=" + name + ", price=" + price + "]";
    }

}
