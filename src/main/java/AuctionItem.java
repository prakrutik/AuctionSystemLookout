package main.java;

public class AuctionItem {
    String itemId;
    String name;
    String description;
    int timeOfAuction;

    AuctionItem(){}

    public AuctionItem(String itemId, String name, String description, int timeOfAuction) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.timeOfAuction = timeOfAuction;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTimeOfAuction() {
        return timeOfAuction;
    }

    public void setTimeOfAuction(int timeOfAuction) {
        this.timeOfAuction = timeOfAuction;
    }

    @Override
    public String toString() {
        return "AuctionItem{" +
                "itemId='" + itemId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", timeOfAuction=" + timeOfAuction +
                '}';
    }
}
