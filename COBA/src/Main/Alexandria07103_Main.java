package Main;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import Entity.*;
import Model.*;

public class Alexandria07103_Main {
    private static Scanner input = new Scanner(System.in);
    private static Alexandria07103_AkunModel akunModel = new Alexandria07103_AkunModel();
    private static Alexandria07103_HeroModel heroModel = new Alexandria07103_HeroModel();
    private static Alexandria07103_MonsterModel monsterModel = new Alexandria07103_MonsterModel();
    private static Alexandria07103_ItemModel itemModel = new Alexandria07103_ItemModel();
    private static Random rand = new Random();
    private static String kembali;
    private static int cekdata,cekH,loop=-1,loopP;

    public static void main(String[] args){
        Alexandria07103_Main main = new Alexandria07103_Main();
        String jawab;
        int pil;
        boolean cek=false;
        main.dataToko();
        main.dataArena();
        do{  
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Selamat Datang Pada Monster Arena~!");
            System.out.println("Sudah memiliki akun?");
            System.out.println("a. sudah");
            System.out.println("b. belum");
            do{
            System.out.print("Pilihan = ");
            jawab = input.next();
            }while(!"a".equals(jawab)&&!"b".equals(jawab));
            if("b".equals(jawab)){
                System.out.println("\nBergabunglah bersama kami~");
                main.Daftar();
                System.out.println();
            }
            while("a".equals(jawab)){
                cek = akunModel.cekempty(cek);
                if(cek==false){
                    System.out.println("\nlogin dulu ya!");
                    System.out.print("Masukkan Username      : ");
                    String nama = input.next();
                    System.out.print("Masukkan Password      : ");
                    String password = input.next();
                    cekdata = akunModel.cekdata(nama,password);
                    main.Login();    
                    System.out.println("Ingin hapus akun atau kembali ke tampilan awal? (kembali/hapus/keluar)");
                    System.out.println("a. kembali");
                    System.out.println("b. hapus");
                    System.out.println("c. keluar");
                    do{
                        System.out.print("Pilihan = ");
                        kembali = input.next();
                    }while(!"a".equals(kembali)&&!"b".equals(kembali)&&"c".equals(kembali));
                    System.out.println();
                    if("c".equals(kembali)){
                        System.out.println("byee~~");
                        System.out.println();
                        break;
                    }
                    else if("b".equals(kembali)){
                        akunModel.delete(cekdata);
                        System.out.println("Akun sudah terhapus");
                        break;
                    }else{
                        break;
                    }
                }else{
                    System.out.println("kembali ke tampilan awal? (kembali/keluar)");
                    System.out.println("a. kembali");
                    System.out.println("b. keluar");
                    do{
                        System.out.print("Pilihan = ");
                        kembali = input.next();
                    }while(!"a".equals(kembali)&&!"b".equals(kembali));
                    if("b".equals(kembali)){
                        System.out.print("byee~");
                    }
                    System.out.println();
                    break;
                }
            }
        }while ("a".equals(kembali)||"b".equals(jawab));
    }
    
    void Daftar(){
        System.out.print("Masukkan Username      : ");
        String username = input.next();
        System.out.print("Masukkan Password      : ");
        String password = input.next();
        System.out.print("Masukkan Umur          : ");
        int umur = input.nextInt();
        System.out.print("Masukkan Email         : ");
        String email = input.next();
        System.out.println("\n Anda Mendapatkan Uang Sebanyak 5.000 !!!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        akunModel.insert(new Alexandria07103_AkunEntity(username,password,umur,email,5000));
    }
    
    void Login(){
        boolean ada;
        int loopL = 0;
        do{  
            System.out.println("\n~~~~Selamat datang "+akunModel.getAkunEntityArrayList(cekdata).getUsername()+"~~");
            try{
                int pilihan;
                System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");  
                System.out.println("1. Shop");
                System.out.println("2. Arena");
                System.out.println("3. Akun");
                System.out.println("4. Exit");
                System.out.print("Kemana kita akan pergi? no ");
                pilihan = input.nextInt();
                switch(pilihan){
                    case 1 :
                        Shop();
                        break;
                    case 2 :
                        Arena();
                        break;
                    case 3:
                        Akun();
                        break;
                    default:
                        loop=1;
                        break;
                };  
            }catch(InputMismatchException e){
                System.out.println("Format Yang anda masukkan salah !!");
            }
            input.nextLine();
        }while(loopL!=1);  
    }
    
    void dataToko(){
        int noHero [] = {1,2,3,4};
        String namaHero[] = {"Felicia","Seanne","Athanasius","Dextera"};
        String roleHero [] = {"Mage","Assassin","Marksman","Support"};
        int healthHero [] = {3100,3400,4300,3400};
        int powerHero [] = {2510,2755,2600,2498};
        String namaP[] = {"A","B","C","D"};
        int healthP[] = {500,600,300,400};
        for(int i = 0; i<4;i++){
            heroModel.insert(new Alexandria07103_HeroEntity(namaHero[i], healthHero[i], powerHero[i],roleHero[i],noHero[i]));
            itemModel.insert(new Alexandria07103_ItemEntity(namaP[i],healthP[i],0,1500));
        }  
    }
      
    void Shop(){
        int nomer,hasil,hasilP,uang,idx,idxP,pilih,loopcek=0;;
        String jawab;
        System.out.println("$$$$$$$$$$ WELCOME TO STORE $$$$$$$$$$\n");
        System.out.println("Uang anda saat ini : "+akunModel.getAkunEntityArrayList(cekdata).getUangR());        
        System.out.println("1. Spin Gacha");
        System.out.println("2. Buy Potion");
        System.out.print("Mau beli no berapa? no ");
        nomer=input.nextInt();
        switch(nomer){
            case 1 :
                if(akunModel.getAkunEntityArrayList(cekdata).getUangR()<2500){
                    System.out.println("Uang anda tidak cukup untuk gacha");
                }
                else{
                    System.out.println("Lakukan gacha? (2500/spin)");
                    jawab = input.next();
                    while("ya".equals(jawab)){
                        loop++;
                        hasil = rand.nextInt(100);
                        idx = hasil%4;
                        System.out.println("Anda Mendapatkan hero "+heroModel.showData(idx).getNama());
                        System.out.println("BIODATA HERO");
                        System.out.println(" Health : "+heroModel.showData(idx).getHealth());
                        System.out.println(" Power  : "+heroModel.showData(idx).getPower());
                        System.out.println(" Role   : "+heroModel.showData(idx).getRole()+"\n");
                        heroModel.getHeroEntityArrayList(loop).setIndex(idx);
                        akunModel.getAkunEntityArrayList(loop).setIndexAkun(cekdata);
                        System.out.println("Hero yang dimiliki : ");
                        for(int i=0;i<=loop;i++){
                            if(akunModel.getAkunEntityArrayList(i).getIndexAkun() == cekdata){
                                heroModel.view(heroModel.showData(i).getIndex());  
                            }
                        }
                        
                        do{
                            System.out.println("no hero yang digunakan = ");
                            pilih=input.nextInt();
                            for(int i=0;i<=loop;i++){
                                if(heroModel.showData(heroModel.showData(i).getIndex()).getNoHero()==pilih){
                                    loopcek=1;
                                    break;
                                }else{
                                    System.out.println("Hero tidak ada ulangi inputan");
                                }   
                            }
                        }while(loopcek!=1);
                        cekH = pilih-1;
                        heroModel.cekdataH(pilih);
                        uang = akunModel.getAkunEntityArrayList(cekdata).getUangR()-2500;
                        akunModel.getAkunEntityArrayList(cekdata).setUangR(uang);
                        break;
                    }        
                }
                break;
            case 2 :
                if(akunModel.getAkunEntityArrayList(cekdata).getUangR()<1500){
                    System.out.println("Uang anda tidak cukup untuk membeli Potion");
                }
                else{
                    System.out.println("Beli potion? (1500/purchase)");
                    jawab=input.next();
                    while("ya".equals(jawab)){
                        hasilP = rand.nextInt(100);
                        idxP = hasilP%3;
                        System.out.println("Potion yang didapat");
                        itemModel.view(idxP);
                        itemModel.getItemEntityArrayList(loopP).setIdx(idxP);
                        loopP++;
                        break;
                    }
                    if("ya".equals(jawab)){
                        uang = akunModel.getAkunEntityArrayList(cekdata).getUangR()-1500;
                        akunModel.getAkunEntityArrayList(cekdata).setUangR(uang);
                    }   
                }
                break;
        }
    }
    
    void dataArena(){
        String namaM[] = {"bubu","baba","bibi","bobo"};
        String karakterM[] = {" ↜(╰ •ω•)╯ψ "," Ψ(☆ｗ☆)Ψ "," (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ "," ◥(ฅº￦ºฅ)◤ "};
        int powerM[] = {2222,2889,1500,1780};
        int healthM[] = {3200,3470,4500,3000};
        int uangM[] = {1500,1500,1400,1300};
        for(int i=0;i<namaM.length;i++){
            monsterModel.insert(new Alexandria07103_MonsterEntity(namaM[i],powerM[i],healthM[i],uangM[i],karakterM[i]));
        }
    }
    
    void Arena(){
        if(loop<0){
            System.out.println("Tidak memiliki hero untuk masuk ke arena");
        }
        else{
            int hasil2,no,uangNew,pilih;
            int darahH,darahM,pilihP,newHealth;
            boolean fight=true;
            System.out.println("----------WELCOME TO ARENA "+akunModel.getAkunEntityArrayList(cekdata).getUsername()+" ~!----------");   
            hasil2 = rand.nextInt(100);
            no = hasil2%4;
            System.out.println("\n"+monsterModel.showData(no).getKarakterM()+"\n");
            System.out.println(monsterModel.showData(no).getNama()+" Has Arrived\n");
            System.out.println("------STATS------");
            System.out.println("Power  : "+monsterModel.showData(no).getPower());
            System.out.println("Health : "+monsterModel.showData(no).getHealth());
            System.out.println("\n###############################################\n");
            System.out.println("---STATS HERO---");
            System.out.println("Nama   : "+heroModel.showData(cekH).getNama());
            System.out.println("Power  : "+heroModel.showData(cekH).getPower());
            System.out.println("Health : "+heroModel.showData(cekH).getHealth());
            System.out.println("\n###############################################\n");
            do {
                System.out.println("1. Attack");
                System.out.println("2. Use Potion");
                System.out.println("3. Go to Shop");
                System.out.println("4. Surrender");
                System.out.print("Apa pilihannya? no ");
                pilih = input.nextInt();
                if(pilih > 3){
                    System.out.println("\nlosers（＞ｙ＜）");
                    break;
                }
                else if(pilih == 2){
                    if(loopP!=0){
                        System.out.println("Potion yang dimiliki : ");
                        for(int i=0;i<loopP;i++){
                            if(akunModel.getAkunEntityArrayList(i).getIndexAkun() == cekdata){
                                itemModel.view(itemModel.showData(i).getIdx());
                            }
                        }
                        System.out.println("Ingin menambah berapa Health?");
                        pilihP=input.nextInt();
                        newHealth = heroModel.showData(cekH).getHealth() + pilihP;
                        heroModel.showData(cekH).setHealth(newHealth);
                    }else{
                        System.out.println("Belum ada potion");
                    }
                }
                else if(pilih == 3){
                    Shop();
                }
                else{
                    switch(pilih){
                        case 1:
                            System.out.println(heroModel.showData(cekH).getNama()+" VS "+monsterModel.showData(no).getNama());
                            System.out.println("Health hero     : "+heroModel.showData(cekH).getHealth());
                            System.out.println("Power hero      : "+heroModel.showData(cekH).getPower());
                            int healthM = monsterModel.showData(no).getHealth();
                            int powerM = monsterModel.showData(no).getPower();
                            System.out.println("Health Monster  : "+healthM);
                            System.out.println("Power Monster   : "+powerM);
                            System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                            System.out.println("Hero memberikan damage sebesar    : "+heroModel.showData(cekH).getPower());
                            darahM = healthM - heroModel.showData(cekH).getPower();
                            if(darahM>0){
                                System.out.println("Health monster saat ini               : "+darahM);
                                monsterModel.getMonsteraEntityArrayList(no).setHealth(darahM);
                            }
                            if(darahM <= 0){
                                System.out.println("Health monster saat ini               : 0");
                                System.out.println("\n***Hasil pertarungan = Monster Kalah***");
                                uangNew = akunModel.getAkunEntityArrayList(cekdata).getUangR() + monsterModel.showData(no).getUangM();
                                akunModel.getAkunEntityArrayList(cekdata).setUangR(uangNew);
                                fight=false;
                            }
                            else{
                                System.out.println("Monster memberikan damage sebesar     : "+powerM);
                                darahH = heroModel.showData(cekH).getHealth() - powerM;
                                if(darahH>0){
                                    System.out.println("Health hero saat ini              : "+darahH);
                                    heroModel.getHeroEntityArrayList(cekH).setHealth(darahH);
                                }
                                else if(darahH <=0){
                                    System.out.println("Health hero saat ini              : 0");
                                    System.out.println("\n@@@Hasil pertarungan = Hero Kalah@@@");
                                    fight=false;
                                }
                            }
                        break;
                    }
                }
            }while(fight==true);
            monsterModel.setstats();
            heroModel.setstats();
        } 
    }
    
    void Akun(){
        String jawab;
        int pil;
        System.out.println("1. Inventory");
        System.out.println("2. Data Akun");
        System.out.print("Ingin lihat yang mana? ");
        pil = input.nextInt();
        switch(pil){
            case 1 :
                System.out.println("\nHero yang dimiliki   : ");
                if(loop<0){
                    System.out.println("Belum punya hero");
                }
                for(int i=0;i<=loop;i++){
                    if(akunModel.getAkunEntityArrayList(i).getIndexAkun() == cekdata){
                        heroModel.view(heroModel.showData(i).getIndex());  
                    }
                }
                System.out.println("\nPotion yang dimiliki : ");
                if(loopP!=0){
                    System.out.println("Potion yang dimiliki : ");
                    for(int i=0;i<loopP;i++){
                        if(akunModel.getAkunEntityArrayList(i).getIndexAkun() == cekdata){
                            itemModel.view(itemModel.showData(i).getIdx());
                        }
                    }
                }else{
                    System.out.println("Belum ada potion");
                }
                break;
            case 2 :
                System.out.println("Data Akun");
                akunModel.view(cekdata);
                do{
                    System.out.println("Update akun?");
                    System.out.println("a. update");
                    System.out.println("b. tidak");
                    jawab=input.next();
                }while(!"a".equals(jawab)||!"b".equals(jawab));
                System.out.println();
                if("a".equals(jawab)){
                int pilih,newumur;
                String newnama,newpassword,newemail;
                System.out.println("1. Update nama");
                System.out.println("2. Update password");
                System.out.println("3. Update umur");
                System.out.println("4. Update email");
                try{
                    System.out.println("Ingin update no berapa? no ");
                    pilih=input.nextInt();
                    switch(pilih){
                        case 1 :
                            System.out.print("Input nama     : ");
                            newnama=input.next();
                            akunModel.getAkunEntityArrayList(cekdata).setUsername(newnama);
                            break;
                        case 2 :
                            System.out.print("Input password : ");
                            newpassword = input.next();
                            akunModel.getAkunEntityArrayList(cekdata).setPassword(newpassword);
                            break;
                        case 3 :
                            System.out.print("Input umur     : ");
                            newumur=input.nextInt();
                            akunModel.getAkunEntityArrayList(cekdata).setUmur(newumur);
                            break;
                        case 4 :
                            System.out.println("Input email  : ");
                            newemail=input.next();
                            akunModel.getAkunEntityArrayList(cekdata).setEmail(newemail);
                            break;
                    }   
                }catch(InputMismatchException e){
                    System.out.println("Format Yang anda masukkan salah !!");
                }
            }break;   
        }   
    }   
}