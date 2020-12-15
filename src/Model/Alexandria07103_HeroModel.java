package Model;
import Entity.Alexandria07103_HeroEntity;
import java.util.ArrayList;
public class Alexandria07103_HeroModel implements Alexandria07103_ModelInterfaces{
    private ArrayList <Alexandria07103_HeroEntity> heroEntityArrayList;
    
    public Alexandria07103_HeroModel() {
        heroEntityArrayList = new ArrayList <Alexandria07103_HeroEntity>();}
    
    public void insert(Alexandria07103_HeroEntity hero){
        heroEntityArrayList.add(hero);}
    @Override
    public void view(int index){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println(" No Hero       : "+heroEntityArrayList.get(index).getNoHero());
            System.out.println(" Nama Hero     : "+heroEntityArrayList.get(index).getNama());
            System.out.println(" Power         : "+heroEntityArrayList.get(index).getPower());
            System.out.println(" Health        : "+heroEntityArrayList.get(index).getHealth());
            System.out.println(" Role          : "+heroEntityArrayList.get(index).getRole());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");        
    }
    public Alexandria07103_HeroEntity showData(int index){
        return heroEntityArrayList.get(index);
    }
    
    public Alexandria07103_HeroEntity getHeroEntityArrayList(int index){
        return heroEntityArrayList.get(index);}
    
    public int cekdataH(int nohero){
        int loop=0;
        for(Alexandria07103_HeroEntity heroEntity : heroEntityArrayList){
            if(heroEntity.getNoHero()==heroEntityArrayList.get(loop).getNoHero()){
                break;
            }else{
                loop++;
            }
        }
        return loop;}
    
    public void setstats(){
        heroEntityArrayList.get(0).setHealth(3100);
        heroEntityArrayList.get(1).setHealth(3400);
        heroEntityArrayList.get(2).setHealth(4300);
        heroEntityArrayList.get(3).setHealth(3400);
    }
}
    

