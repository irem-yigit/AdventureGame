import java.util.Scanner;

public class Player {

    private int damage;
    private int healt;
    private int money;
    private String name;
    private String charName;
    private Scanner scanner = new Scanner(System.in);
    private Inventory inventory;

    public Player(String name){
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar(){

        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("Karakterler");
        System.out.println("----------------------------------------------------------------------------");
        for (GameChar gameChar : charList){
            System.out.println("ID: " + gameChar.getId() +
                    "\t Karakter: " +gameChar.getName() +
                    "\t\t Hasar: "  +gameChar.getDamage() +
                    "\t\t Sağlık: " +gameChar.getHealt() +
                    "\t\t Para: "   +gameChar.getMoney());
        }
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("Lütfen bir karakter seçiniz: ");
        int selectChar = scanner.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        /*System.out.println("Karakter: " + this.getCharName() +
                ", Hasar: " + this.getDamage() +
                ", Sağlık: " + this.getHealt() +
                ", Para: " + this.getMoney());*/
    }

    public void initPlayer(GameChar gameChar){  //Polymorphism uyguladım
        this.setDamage(gameChar.getDamage());
        this.setHealt(gameChar.getHealt());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo(){
        System.out.println(
                "Silah: " + this.getInventory().getWeapon().getName() +
                ", Zırh: " + this.getInventory().getArmor().getName() +
                ", Bloklama: " + this.getInventory().getArmor().getBlock() +
                ", Hasar: " + this.getDamage() +
                ", Sağlık: " + this.getHealt() +
                ", Para: " + this.getMoney());
    }

    public int getDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealt() {
        return healt;
    }

    public void setHealt(int healt) {
        this.healt = healt;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
