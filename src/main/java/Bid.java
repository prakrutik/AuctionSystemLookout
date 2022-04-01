package main.java;

public class Bid {
    String bidId;
    String bidderName;
    String itemName;
    String itemId;
    int startingBid;
    int maxBid;
    int bidIncrement;

    Bid(){

    }
    public Bid(String bidId, String bidderName, String itemName, String itemId, int startingBid, int maxBid, int bidIncrement) {
        this.bidId = bidId;
        this.bidderName = bidderName;
        this.itemName = itemName;
        this.itemId = itemId;
        this.startingBid = startingBid;
        this.maxBid = maxBid;
        this.bidIncrement = bidIncrement;
    }

    public String getBidId() {
        return bidId;
    }

    public void setBidId(String bidId) {
        this.bidId = bidId;
    }

    public String getBidderName() {
        return bidderName;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getStartingBid() {
        return startingBid;
    }

    public void setStartingBid(int startingBid) {
        this.startingBid = startingBid;
    }

    public int getMaxBid() {
        return maxBid;
    }

    public void setMaxBid(int maxBid) {
        this.maxBid = maxBid;
    }

    public int getBidIncrement() {
        return bidIncrement;
    }

    public void setBidIncrement(int bidIncrement) {
        this.bidIncrement = bidIncrement;
    }

}
