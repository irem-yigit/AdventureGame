import java.util.Scanner;

public class Game {


    private Scanner scanner = new Scanner(System.in);

    public void start(){
        System.out.println("Macera Oyununa Hoşgeldiniz !");
        System.out.print("Lütfen bir isim giriniz: ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);
        System.out.println("Sayın " + player.getName() + " bu karanlık ve sisli adaya hoşgeldiniz! Burda yaşananların hepsi gerçek...");
        System.out.println("Lütfen bir karakter seçiniz !");
        player.selectChar();

        Location location = null;
        while (true){
            player.printInfo();
            System.out.println();
            System.out.println("######### Bölgeler #########");
            System.out.println();
            System.out.println("1- Güvenli Ev --> Burası sizin için güvenli bir ev, düşman yoktur!");
            System.out.println("2- Mağaza --> Silah veya Zırh satın alabilirsiniz !");
            System.out.println("0- Çıkış Yap --> Oyunu sonlandır.");

            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz: ");
            int selectLoc = scanner.nextInt();
            switch (selectLoc){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);  //this --> hangi nesneden işlem yapıyorsam direk içine atar, yani playerı içine atmış oldu
                    break;
                case 2:
                    location = new ToolStore(player);  //Polymorphism
                    break;
                default:
                    location = new SafeHouse(player);

            }

            if (location == null){
                System.out.println("Oyun Bitti !!!");
                break;
            }

            if (!location.onLocation()){
                System.out.println("GAME OVER! ");
                break;
            }

        }




    }

}
