package Entity;
public class Alexandria07103_HeroEntity extends Alexandria07103_GameAbstractEntity{
    private String role;
    private int index,nohero;
    public Alexandria07103_HeroEntity(String nama, int health, int power,String role,int nohero) {
        super(nama, health, power);
        this.role = role;
        this.nohero=nohero;
    }  
    public Alexandria07103_HeroEntity(int index){
        this.index=index;
    }
    
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getNoHero() {
        return nohero;
    }

    public void setNoHero(int nohero) {
        this.nohero = nohero;
    }
    
    public String getRole() {
        return role;}

    @Override
    public int getHealth() {
        return health;}

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return power;}

    public void setPower(int power) {
        this.power = power;
    }
    
    public String getNama() {
        return nama;}    
}

