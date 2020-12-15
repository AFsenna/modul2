package Entity;
public abstract class Alexandria07103_GameAbstractEntity {
    protected String nama;
    protected int health,power;    
    public Alexandria07103_GameAbstractEntity(String nama,int health,int power){
        this.nama=nama;
        this.health = health;
        this.power=power;}
    public Alexandria07103_GameAbstractEntity(){
    }       
    public abstract int getHealth();
    
    public void setHealth(int health) {
        this.health = health;
    }
    
    public String getNama(){
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }    
}
