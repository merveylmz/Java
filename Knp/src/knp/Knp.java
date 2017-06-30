
package knp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Knp {

    public static String[] altKumeBul(String dizi[]){
        int diziElemanSayisi=dizi.length;
        int altKumeSayisi=(int)Math.pow(2, diziElemanSayisi); //2 üzeri eleman sayısı
        String altKume[]=new String[altKumeSayisi];
        int durum=0;
        altKume[0]="[]";
        boolean bosKontrol=true;
        for (int i = 0; i < altKumeSayisi; i++) {
            int araSayi=i;
            bosKontrol=true;
            for (int j = 0; j < diziElemanSayisi; j++) {
                durum=araSayi & 1;
                if(durum==1){
                    if(bosKontrol){
                        altKume[i]=" "+dizi[j];
                        bosKontrol=false;
                    }else {
                    altKume[i]+=" "+dizi[j];
                    }
                }
                araSayi>>=1;
            }
        }
        return altKume;
    }
   
    public static void main(String[] args) throws IOException {
       
          int maxagirlik;
          Scanner bilgi= new Scanner(System.in);
          System.out.println("maksimum agirligi giriniz:");
          maxagirlik=bilgi.nextInt();

        int fiyattoplam=0,agirliktoplam=0,enbuyuk=0;
        String agirlik[],eleman[],fiyat[] = null,dizii[] = null,altküme[];
        String elemanString="",agirlikString="",fiyatString="",uygunküme = null,bos="";

        ArrayList<String> liste=new ArrayList<String>();
     
        //Dosyadan okuma
        File file = new File("canta.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String satir ;  
        while((satir=br.readLine())!=null)
            {
                liste.add(satir);
            }  
           for (int i = 0; i < liste.size(); i++){ 
           dizii=liste.get(i).split("-");          
          elemanString=elemanString+dizii[0]+"-";
          agirlikString=agirlikString+dizii[1]+"-";
          fiyatString=fiyatString+dizii[2]+"-";
      
          }
         
           eleman=elemanString.split("-");
           agirlik=agirlikString.split("-");
           fiyat=fiyatString.split("-");
          
        
        altküme=altKumeBul(eleman);
        for(int i=0;i<altküme.length;i++){
            for(int j=0;j<altküme[i].length();j++){
                for(int k=0;k<eleman.length;k++){
                    if((Character.toString(altküme[i].charAt(j)).equals(eleman[k]))){
                       fiyattoplam=fiyattoplam+Integer.parseInt(fiyat[k]); 
                       agirliktoplam=agirliktoplam+Integer.parseInt(agirlik[k]);
                     
                    }
                }
              }
            if(agirliktoplam>maxagirlik){
                
            System.out.print("["+altküme[i]+" ]"+" \n Toplam Agirlik:"+agirliktoplam+" \n Fiyat=----");
            System.out.println("\n");
            fiyattoplam=0;
            agirliktoplam=0;
            }
            else{
           
            System.out.print("["+altküme[i]+" ]"+" \nToplam Agirlik="+agirliktoplam+"\n Toplam Fiyat="+fiyattoplam);
            System.out.println("\n");
            if(enbuyuk<fiyattoplam){
                enbuyuk=fiyattoplam;
                uygunküme="["+altküme[i]+" ]";
                
            }
            
            fiyattoplam=0;
            agirliktoplam=0;
            }
        }
        
        System.out.println("En Uygun Alt Küme= "+uygunküme+"="+enbuyuk);    
    }
    }
