package Model;

import Entity.Alexandria07103_ItemEntity;
import java.util.ArrayList;

public class Alexandria07103_ItemModel implements Alexandria07103_ModelInterfaces{
    private ArrayList <Alexandria07103_ItemEntity> itemEntityArrayList;

    public Alexandria07103_ItemModel() {
        itemEntityArrayList = new ArrayList <Alexandria07103_ItemEntity>();
    }
    
    public void insert(Alexandria07103_ItemEntity itemEntity){
        itemEntityArrayList.add(itemEntity);
    }
    @Override
    public void view(int index){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(" Potion  : "+itemEntityArrayList.get(index).getNama());
        System.out.println(" Atribut : + Health "+itemEntityArrayList.get(index).getHealth());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");   
    }
 
    public Alexandria07103_ItemEntity showData(int index){
        return itemEntityArrayList.get(index);
    }
    public Alexandria07103_ItemEntity getItemEntityArrayList(int index){
        return itemEntityArrayList.get(index);
    }
}
