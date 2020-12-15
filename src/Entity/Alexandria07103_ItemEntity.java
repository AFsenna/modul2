package Entity;

public class Alexandria07103_ItemEntity extends Alexandria07103_GameAbstractEntity{
    int harga,idx;
    public Alexandria07103_ItemEntity(String nama, int health,int power,int harga) {
        super(nama,health,power);
        this.harga=harga;
    }
    
    public Alexandria07103_ItemEntity(int idx){
        this.idx=idx;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }
    
    public int getHarga() {
        return harga;
    }

        @Override
    public int getHealth() {
        return health;}

}
