package Model;
import Entity.Alexandria07103_AkunEntity;
import java.util.ArrayList;
import java.util.Scanner;
public class Alexandria07103_AkunModel implements Alexandria07103_ModelInterfaces{
    private ArrayList <Alexandria07103_AkunEntity> akunEntityArrayList;
    private static Scanner input = new Scanner(System.in);

    public Alexandria07103_AkunModel(){
        akunEntityArrayList = new ArrayList <Alexandria07103_AkunEntity>();
    }
    
    public void insert (Alexandria07103_AkunEntity penggunaEntity){
        akunEntityArrayList.add(penggunaEntity);
    }
    
    @Override
    public void view(int index){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println(" Username      : "+akunEntityArrayList.get(index).getUsername());
            System.out.println(" Password      : "+akunEntityArrayList.get(index).getPassword());
            System.out.println(" Email         : "+akunEntityArrayList.get(index).getEmail());
            System.out.println(" Uang          : "+akunEntityArrayList.get(index).getUangR());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
    public int cekdata(String nama, String password){
        int loop = 0;
        while(!akunEntityArrayList.get(loop).getUsername().equals(nama)&&
                !akunEntityArrayList.get(loop).getPassword().equals(password)){
            loop++;
        }
        return loop;
    }
    
    public Alexandria07103_AkunEntity getAkunEntityArrayList(int index){
        return akunEntityArrayList.get(index);
    }
    
    public void delete(int index){
        akunEntityArrayList.remove(index);
    }
    
    public boolean cekempty(boolean cek){
        while(akunEntityArrayList.isEmpty()){
            System.out.println("\nBELUM ADA AKUN YANG TERDAFTAR\n");
            cek=true;
            break;
        }
        while(!akunEntityArrayList.isEmpty()){
            cek=false;
            break;
        }
        return cek;
    }
}
