/*
SORU2: ogrenci isimli sınıf oluşturun bu sınıfta ogrencinin ıdsi ve
not degeri tutulmalı. 100 elemanlı bir dizide id ve not degerlerini
rastgele oluşturarak bu ogrencileri saklayın ve bu ogrencileri aldıkları
notlara gore artan sırada yazdıran metodu yazın.
 */

package bolum7_sorular;

public class ders65_soru2 {
    public static void main(String[] args) {
         Ogrenci[] tumOgrenciler = new Ogrenci[100]; //100 elemanlı dizi oluşturuyorum

         for(int i=0; i<100; i++){
             int rastgeleId = (int)(Math.random() * 5000);  //diyelim ki id degerleri 5000 farklı sayi olsun
             int rastgeleNotDegeri = (int)(Math.random() * 100); // bunu da 1002 kadar yapalım

             Ogrenci yeni = new Ogrenci(rastgeleId, rastgeleNotDegeri);
             tumOgrenciler[i] = yeni;
         }

         ogrencileriNotlarinaGoreSirala(tumOgrenciler);
         for(int i=0; i<100; i++){
             tumOgrenciler[i].ogrenciBilgileriniGetir();
         }
    }


    private static void ogrencileriNotlarinaGoreSirala(Ogrenci[] tumOgrenciler){
        //selection sorta göre sıralama
        for(int i=0; i<tumOgrenciler.length-1; i++){
            // en kucuk elemanın indexinin bulunması:
            int oankiEnKucukSayi = tumOgrenciler[i].getNotDegeri();
            int oankiEnKucukElemaninIndexi = i;

            //simdi ondan sonraki elemanlar sectiğim elemandan kucuk mu kontrolunu yapalım.
            for(int j=i+1; j<tumOgrenciler.length; j++){
                if(oankiEnKucukSayi > tumOgrenciler[j].getNotDegeri()){
                    oankiEnKucukSayi =tumOgrenciler[j].getNotDegeri();
                    oankiEnKucukElemaninIndexi = j;
                }
            }
            if(oankiEnKucukElemaninIndexi != i){
                tumOgrenciler[oankiEnKucukElemaninIndexi] = tumOgrenciler[i];
                tumOgrenciler[i].setNotDegeri(oankiEnKucukSayi);
            }
        }
    }
}


class Ogrenci{

    private int id;
    private int notDegeri;

    //senden bir nesne uretildiginde bu degerleri mutlaka iste diyip
    public Ogrenci(int id, int notDegeri) { //constructor oluşturuyorum.
        this.id = id;
        this.notDegeri = notDegeri;
    }

    //yukarıdaki degerlere erişmek için getter ve setterlar oluşturuyorum:
    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public int getNotDegeri() {

        return notDegeri;
    }

    public void setNotDegeri(int notDegeri) {

        this.notDegeri = notDegeri;
    }

    public void ogrenciBilgileriniGetir(){

        System.out.println("id: " +id+ "not: " +not
