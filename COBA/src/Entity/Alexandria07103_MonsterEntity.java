package Entity;
public class Alexandria07103_MonsterEntity extends Alexandria07103_GameAbstractEntity{
    private int uangM;
    private String karakterM;
    public Alexandria07103_MonsterEntity(String nama, int power, int health,int uangM,String karakterM) {
        super(nama,power,health);
        this.power=power;
        this.health=health;
        this.karakterM=karakterM;
        this.uangM=uangM;
    }
    @Override
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
        
    public String getNama() {
        return nama;
    }
    public int getPower() {
        return power;
    }

    public String getKarakterM() {
        return karakterM;
    }

    public int getUangM() {
        return uangM;
    }

}
