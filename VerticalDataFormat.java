//A java program for the implementation of Mining Frequent Itemsets Using Vertical Data Format
import java.io.*;
import java.net.*;
import java.util.*;

public class VerticalDataFormat{
    private static ArrayList<Transaction> transactions;
    private static ArrayList<Frequent> frequents;
    private static String[] items=new String[]{"Beer","Nuts","Diaper","Coffee","Eggs","Milk"};
    private static int min_sup=0;

    public static void main(String[] args){
        transactions=new ArrayList<Transaction>();
        transactions.add(new Transaction("T10",new String[]{"Beer","Nuts","Diaper"}));
        transactions.add(new Transaction("T20",new String[]{"Beer","Coffee","Diaper"}));
        transactions.add(new Transaction("T30",new String[]{"Beer","Diaper","Eggs"}));
        transactions.add(new Transaction("T40",new String[]{"Nuts","Eggs","Milk"}));
        transactions.add(new Transaction("T50",new String[]{"Nuts","Coffee","Diaper","Eggs","Milk"}));

        System.out.println("\nTID\tItem Set");
        System.out.println("---\t--------");
    
        for(Transaction transaction:transactions){
            System.out.println(transaction.getTid()+"\t"+transaction.getItems().toString());
        }

        System.out.print("\nEnter the minimum support value:");
        Scanner s=new Scanner(System.in);
        min_sup=s.nextInt();
        s.close();
        
        System.out.println("min_sup = "+min_sup);

        frequents=new ArrayList<Frequent>();
        for(String item:items){
            Frequent frequent=new Frequent(item,new ArrayList<String>());
            for(Transaction transaction:transactions){
                for(String i:transaction.getItems()){
                    if(i.equals(item)){
                        frequent.getTidSet().add(transaction.getTid());
                        break;
                    }
                }
            }

            frequents.add(frequent);
        }

        removeLessPriorityTransactions();

        System.out.println("\nFrequent 1 itemset\n------------------\n");
        System.out.println("Item Set\tTID Set");
        System.out.println("--------\t-------");
        for(Frequent frequent:frequents){
            System.out.println(frequent.getItem()+"\t\t"+frequent.getTidSet());
        }

    }

    private static void removeLessPriorityTransactions(){
        ArrayList<Frequent> frequentsToRemove=new ArrayList<Frequent>();
        for(Frequent frequent:frequents){
            if(frequent.getTidSet().size()<min_sup){
                frequentsToRemove.add(frequent);
            }
        }
    

        for(Frequent frequent:frequentsToRemove){
            frequents.remove(frequent);
        }
    }
}

class Transaction{
    private String tid;
    private ArrayList<String> items;
    public Transaction(String tid,String[] items){
        this.tid=tid;
        this.items=new ArrayList<String>();
        for(String item:items){
            this.items.add(item);
        }
    }

    public String getTid(){
        return this.tid;
    }

    public ArrayList<String> getItems(){
        return this.items;
    }
}

class Frequent{
    private String item;
    private ArrayList<String> tidSet;

    public Frequent(String item,ArrayList<String> tidSet){
        this.item=item;
        this.tidSet=tidSet;
    }

    public String getItem(){
        return this.item;
    }

    public ArrayList<String> getTidSet(){
        return this.tidSet;
    }
}