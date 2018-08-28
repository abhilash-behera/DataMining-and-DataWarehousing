import java.io.*;
import java.util.*;

public class AssociationRuleMining{
    
    public static void main(String[] args){
        ArrayList<PurchaseRecord> purchaseRecords=new ArrayList<PurchaseRecord>();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number of purchase records: ");
        int totalPurchaseRecords=scanner.nextInt();

        System.out.println("Enter the minimum confidence value: ");
        int minConfidence=scanner.nextInt();

        System.out.println("Enter the minimum support value: ");
        int minSupport=scanner.nextInt();
        
        for(int i=0;i<totalPurchaseRecords;i++){
            int tId=i;
            System.out.println("Enter the itemset for Tid="+i+" : (separate items using \',\')");
            String[] items=scanner.next().split(",");

            ArrayList<String> itemSet=new ArrayList<String>();

            Collections.addAll(itemSet,items);
            // for(String item:itemSet){
            //     System.out.println("Item: "+item);
            // }

            PurchaseRecord purchaseRecord=new PurchaseRecord(tId,itemSet);
            purchaseRecords.add(purchaseRecord);
        }

        System.out.println("\n\nTid\tItemSet");
        System.out.println("---\t-------");
        for(PurchaseRecord purchaseRecord:purchaseRecords){
            System.out.println(purchaseRecord.getTid()+"\t"+purchaseRecord.getItemSet().toString());
        }

        ArrayList<String> checkItemSet=new ArrayList<String>();
    }
}

class PurchaseRecord{
    private int tId;
    private ArrayList<String> itemSet;

    public PurchaseRecord(int tId,ArrayList<String> itemSet){
        this.tId=tId;
        this.itemSet=itemSet;
    }

    public int getTid(){
        return this.tId;
    }

    public ArrayList<String> getItemSet(){
        return this.itemSet;
    }

    public void setTid(int tId){
        this.tId=tId;
    }

    public void setItemSet(ArrayList<String> itemSet){
        this.itemSet=itemSet;
    }
}

class SupportRecord{
    private ArrayList<String> itemSet;
    private int supportCount;

    public SupportRecord(ArrayList<String> itemSet,int supportCount){
        this.itemSet=itemSet;
        this.supportCount=supportCount;
    }

    public ArrayList<String> getItemSet(){
        return this.itemSet;
    }

    public int getSupportCount(){
        return this.supportCount;
    }

    public void setItemSet(ArrayList<String> itemSet){
        this.itemSet=itemSet;
    }
}