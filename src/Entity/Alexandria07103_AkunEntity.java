package Entity;
public class Alexandria07103_AkunEntity {
    private String email;
    private String username;
    private String password;
    private int uangR,umur,id,indexAkun;
    public Alexandria07103_AkunEntity(String nama, String password, int umur, String email,int uangR) {
        this.username=nama;
        this.password=password;
        this.email=email;
        this.uangR=uangR;
        this.umur=umur;
        this.id=id;
    }

    public Alexandria07103_AkunEntity(int indexAkun) {
        this.indexAkun = indexAkun;
    }

    public int getIndexAkun() {
        return indexAkun;
    }

    public void setIndexAkun(int indexAkun) {
        this.indexAkun = indexAkun;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;}

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getUangR() {
        return uangR;
    }
    public void setUangR(int uangR) {
        this.uangR = uangR;
    }
    public int getUmur() {
        return umur;
    }
    public void setUmur(int umur) {
        this.umur = umur;
    }
}
