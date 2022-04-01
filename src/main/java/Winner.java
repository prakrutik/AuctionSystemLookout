package main.java;

public class Winner {
    String bidderName;
    int currentBid;

    public Winner(String currentWinner, int currentValue) {
        this.bidderName = currentWinner;
        this.currentBid = currentValue;
    }

    public String getBidderName() {
        return bidderName;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    public int getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(int currentBid) {
        this.currentBid = currentBid;
    }
}
