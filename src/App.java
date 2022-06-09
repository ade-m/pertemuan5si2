import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        //1. TRANFER DARI SUSI KE BUDI
        //2. CETAK LOG MUTASI
        //3. KELUAR
        Nasabah susi = new Nasabah();
        susi.Nama="Susi";
        susi.NoRek="0214578";
        Nasabah budi = new Nasabah();
        budi.Nama="Budi";
        budi.NoRek="0214577";
        ArrayList<String> logMutasiSusi = new ArrayList<String>();
        ArrayList<String> logMutasiBudi = new ArrayList<String>();
        int pilihan;
        String yn="y";
        Scanner input = new Scanner(System.in);
        //perulangan untuk menu
        do{
            //cetak menu
            cetakMenu();
            pilihan = input.nextInt();

            //percabangan
            if(pilihan==1){
                String NoRekTujuan="";
                int nominal;
                input.nextLine();
                //transfer
                //1. masukkan no rek
                System.out.print("Masukkan Nomor Rekening Tujuan :");
                NoRekTujuan = input.nextLine();
                //2. masukkan nominal transfer
                System.out.print("Masukkan Nominal Transfer : ");
                nominal = input.nextInt();
                //3. cek apakah no rek ada/cocok/sesuai
                if(NoRekTujuan.equals(budi.NoRek)){
                        //4. cek apakah no rek 1 punya uang yang cukup
                    if((susi.Saldo -100000)>nominal){
                             //jika semua kondisi benar, transfer uang, tulis log mutasi
                            susi.Saldo-=nominal;
                             int tmp = nominal;
                             budi.Saldo+=tmp;
                             System.out.println("Transfer Telah Berhasil, sisa saldo "+ susi.Saldo);
                             //catat log mutasi
                             logMutasiSusi.add("Transfer ke Rek "+ budi.NoRek + " Sebesar "+ nominal);
                             logMutasiBudi.add("Kredit dari Rek "+ susi.NoRek + " Sebesar "+ nominal);
                    }
                }
            }
            else if(pilihan==2){
                //cetak mutasi
                for (String mutasi : logMutasiSusi) {
                    System.out.println(mutasi);
                }
            }
            else if(pilihan==3) break;
            else continue;
        }while(yn.equalsIgnoreCase("y"));

    }
    public static void cetakMenu(){
        System.out.println("Bank ABCD");
        System.out.println("1. TRANFER DARI SUSI KE BUDI");
        System.out.println("2. CETAK LOG MUTASI");
        System.out.println("3. KELUAR");
        System.out.print("Masukkan pilihan anda ... ");
    }
}
