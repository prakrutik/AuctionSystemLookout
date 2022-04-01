package main.java;

import java.util.HashMap;

public class Bidder {
    String bidderName;
    Bid b1= new Bid();

    public Bidder(String bidderName) {
        this.bidderName = bidderName;
    }

    void submitBid(Bid bid, HashMap<Bid, Bidder> bidMap){

    }
    void incrementBids(Bid bid){
       if(bid.getMaxBid()>= bid.getStartingBid()+bid.getBidIncrement()){
           bid.setStartingBid(bid.getStartingBid() + bid.getBidIncrement());
       }
       else{
           bid.setStartingBid(bid.getMaxBid());
       }
    }
}
