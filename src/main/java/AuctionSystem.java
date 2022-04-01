package main.java;


import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class AuctionSystem {

    int boardNumber;
    static FileReader fileReader;
    static HashMap<Bid, Bidder> bidMap;
    static HashMap<AuctionItem, List<Bid>> itemBids;
    static HashMap<AuctionItem, Winner> winnerCount;
    static HashMap<String,AuctionItem> itemIdMap;
    static Set<AuctionItem> items;
    static int timer = 172800;

    public AuctionSystem(int boardNumber) {
        this.boardNumber = boardNumber;
    }

    public static void main(String[] args) throws FileNotFoundException {

        AuctionSystem system = new AuctionSystem(1);
        bidMap = new HashMap<>();
        items = new HashSet<>();
        itemBids = new HashMap<>();
        itemIdMap = new HashMap<>();
        winnerCount = new HashMap<>();

        JSONArray arr = new JSONArray(new JSONTokener(new FileReader("src/main/resources/InputTest1.json")));
        for (int i = 0; i < arr.length(); i++) { // Walk through the Array.
            JSONObject obj = arr.getJSONObject(i);
            if(obj.getString("type").equals("bid")){
                Bid b = new Bid(obj.getString("id"),obj.getString("name"),obj.getString("itemName"),obj.getString("item"),obj.getInt("startingBid"), obj.getInt("maxBid"), obj.getInt("bidIncrement"));
                system.submitBid(b);
            }
            else if(obj.getString("type").equals("newItem")){
                AuctionItem item1 = new AuctionItem(obj.getString("id"),obj.getString("name"),obj.getString("description"),obj.getInt("timeOfAuction"));
                items.add(item1);
                itemIdMap.put(item1.itemId,item1);
            }

        }
        // system.printMap(itemBids);
      system.countWinner();
      system.printWinners(system.boardNumber);
    }

    void submitBid(Bid bid){
        Bidder bidder = new Bidder(bid.getBidderName());
        bidMap.put(bid,bidder);

            String tempItemId = bid.getItemId();
            AuctionItem getAuction = itemIdMap.get(tempItemId);
            if(itemBids.get(getAuction)==null) {
                List<Bid> addingBid = new ArrayList<>();
                addingBid.add(bid);
                itemBids.put(getAuction,addingBid);
            }
            else{
                List<Bid> addingBid = itemBids.get(getAuction);
                addingBid.add(bid);
                itemBids.put(getAuction,addingBid);
            }

    }

     void countWinner(){
           for (AuctionItem item : items) {
               List<Bid> listOfBids = itemBids.get(item);
               int maxBid = 0;
               String currentWinner = "";
               int currentValue = 0;
               int currentTimer = item.timeOfAuction;
               while(currentTimer<timer) {
                   if (listOfBids != null) {
                       for (Bid eachBid : listOfBids) {
                           if (eachBid.getStartingBid() > maxBid) {
                               maxBid = eachBid.getStartingBid();
                               currentWinner = eachBid.getBidderName();
                               currentValue = maxBid;
                           }

                           int newBid = Math.min(eachBid.getStartingBid() + eachBid.getBidIncrement(), eachBid.getMaxBid());
                           if(eachBid.getMaxBid()==newBid)break;

                            eachBid.setStartingBid(newBid);
                       }
                       currentTimer+=10;
                       winnerCount.put(item, new Winner(currentWinner,currentValue));
                   }
               }
           }
    }

    private void printWinners(int boardNumber) {
        for(Map.Entry<AuctionItem,Winner> entry : winnerCount.entrySet()){
            String itemName = entry.getKey().getName();
            String bidderName = entry.getValue().getBidderName();
            int bidAmount = entry.getValue().getCurrentBid();
            System.out.println("Auction Board "+boardNumber+" Winner for item "+ itemName+" is "+bidderName+" with amount "+bidAmount);
        }
    }
    private void printMap(HashMap<AuctionItem, List<Bid>> itemBids) {
        for(Map.Entry<AuctionItem,List<Bid>> entry : itemBids.entrySet()){
            if(entry.getKey()!=null)System.out.println(entry.getKey() .getName());
           if(entry.getValue()!=null || !entry.getValue().isEmpty()){
               for(Bid e : entry.getValue())
               System.out.println(e.bidderName);
           }
        }
    }
}
