import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> hp = new HashMap<>();
        Map<String, Integer> mana = new HashMap<>();


        for (int i = 1; i <= n ; i++) {

            String[] input = scanner.nextLine().split(" ");
            String key = input[0];
            int hpp = Integer.parseInt(input[1]);
            int manna = Integer.parseInt(input[2]);

            if (hpp > 100) {
                hpp = 100;
            }
            if (manna > 200) {
                manna = 200;
            }

            hp.put(key, hpp);
            mana.put(key, manna);
        }

        String input = scanner.nextLine();

        while (!input.equals("End")){

            String[] command = input.split(" - ");

            if(command[0].contains("CastSpell")){

                String heroName = command[1];
                int mpNeeded = Integer.parseInt(command[2]);
                String spellName = command[3];

                int currentMana = mana.get(heroName);

                if(currentMana >= mpNeeded){

                    mana.put(heroName, currentMana - mpNeeded);
                    int totalMana = currentMana - mpNeeded;
                    System.out.printf("%s has successfully cast %s and now has %d MP!%n",heroName,spellName,totalMana);

                }else {
                    System.out.printf("%s does not have enough MP to cast %s!%n",heroName,spellName);
                }

            } else if (command[0].contains("TakeDamage")) {

                String heroName = command[1];
                int damage = Integer.parseInt(command[2]);
                String atakuvasht = command[3];

                int currentHp = hp.get(heroName);

                if(currentHp > damage){

                    hp.put(heroName, currentHp - damage);
                    int totalHp = currentHp - damage;
                    System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",heroName, damage, atakuvasht, totalHp);

                }else {
                    hp.remove(heroName);
                    mana.remove(heroName);

                    System.out.printf("%s has been killed by %s!%n",heroName,atakuvasht);
                }
            } else if (command[0].contains("Recharge")) {

                String heroName = command[1];
                int amount = Integer.parseInt(command[2]);

                int currentMana = mana.get(heroName);

                int total = currentMana + amount;

                if (total <= 200){

                    mana.put(heroName, currentMana + amount);
                    System.out.printf("%s recharged for %d MP!%n", heroName,amount);

                }else {
                    int ttotal = 200 - currentMana;
                    mana.put(heroName, 200);
                    System.out.printf("%s recharged for %d MP!%n",heroName,ttotal);
                }


            } else if (command[0].contains("Heal")) {

                String heroName = command[1];
                int amount = Integer.parseInt(command[2]);

                int currentHp = hp.get(heroName);
                int total = currentHp + amount;

                if (total <= 100){

                    hp.put(heroName, currentHp + amount);
                    System.out.printf("%s healed for %d HP!%n",heroName,amount);

                }else {

                    int ttotal = 100 - currentHp;
                    hp.put(heroName, 100);
                    System.out.printf("%s healed for %d HP!%n",heroName,ttotal);
                }


            }


            input = scanner.nextLine();

        }

        for (String hero : hp.keySet()){

            int health = hp.get(hero);
            int mannna = mana.get(hero);

            System.out.println(hero);
            System.out.printf(" HP: %d%n",health);
            System.out.printf(" MP: %d%n",mannna);

        }
    }
}
