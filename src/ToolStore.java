public class ToolStore extends NormalLoc{

    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("------- Mağazaya hoşgeldiniz ! -------");
        boolean showMenu = true;
        while (showMenu){
            System.out.println("1- Silahlar");
            System.out.println("2- Zırhlar");
            System.out.println("0- Çıkış yap");
            System.out.print("Seçiminiz: ");
            int selectCase = scanner.nextInt();

            while (selectCase < 1 || selectCase > 3){
                System.out.println("Geçersiz değer, tekrar giriniz: ");
                selectCase = scanner.nextInt();
            }
            switch (selectCase){
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Bir daha bekleriz !");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon(){
        System.out.println("----- Silahlar -----");
        System.out.println();
        for (Weapon w: Weapon.weapons()) {
            System.out.println(w.getId() + " - " + w.getName() +
                    " < Para: " + w.getPrice() + ", Hasar: " + w.getDamage() + " >");
        }
        System.out.println("0- Çıkış Yap");

    }
    public void buyWeapon(){
        System.out.print("Bir silah seçiniz: ");

        int selectWeaponID = scanner.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length){
            System.out.println("Geçersiz değer, tekrar giriniz: ");
            selectWeaponID = scanner.nextInt();
        }

        if (selectWeaponID != 0){
            Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeaponID);

            if (selectedWeapon != null){
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli paranız bulunmamaktadır.");
                }
                else {
                    System.out.println(selectedWeapon.getName() + " silahını satın aldınız.");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan bakiye: " + this.getPlayer().getMoney());
                    System.out.println("Önceki Silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Yeni Silahınız: " + this.getPlayer().getInventory().getWeapon().getName());

                }
            }
        }
    }

    public void printArmor(){
        System.out.println("----- Zırhlar -----");
        System.out.println();
        for (Armor a : Armor.armors()){
            System.out.println(a.getId() + " - " + a.getName() +
                    " < Para: " + a.getPrice() + " , Zırh: " + a.getBlock() + " >" );
        }
        System.out.println("0- Çıkış Yap");

    }

    public void buyArmor(){
        System.out.print("Bir zırh seçiniz: ");

        int selectArmorID = scanner.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length){
            System.out.println("Geçersiz değer, tekrar giriniz: ");
            selectArmorID = scanner.nextInt();
        }

        if (selectArmorID != 0 ){
            Armor selectedArmor = Armor.getArmorObjById(selectArmorID);

            if (selectedArmor != null){
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli paranız bulunmamaktadır.");
                }
                else {
                    System.out.println(selectedArmor.getName() + " zırhını satın aldınız !");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Kalan bakiye: " + this.getPlayer().getMoney());
                }
            }

        }

    }

}
