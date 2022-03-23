package kg.geektech.game.general;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {
    private static int round_number;
    public static Random random = new Random();

    public static void startGame() {
        Boss boss = new Boss("Tanos", 1000, 50);

        Warrior warrior = new Warrior("Ahiles", 270, 10);
        Medic doc = new Medic("Aibolit", 250, 5, 15);
        Magic magic = new Magic("Strange", 260, 15);
        Berserk berserk = new Berserk("Viking", 240, 10);
        Medic assistant = new Medic("Student", 280, 5, 5);
        Hero[] heroes = {warrior, doc, magic, berserk, assistant};

        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        round_number++;
        war(boss, heroes);
        printStatistics(boss, heroes);
    }

    private static void war(Boss boss, Hero[] heroes) {
        boss.hit(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getAbility() != SuperAbility.CRITICAL_DAMAGE) {
                heroes[i].hit(boss);
            }
            if (heroes[i].getHealth() > 0) {
                heroes[i].applySuperPower(boss, heroes);
            }
        }
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + round_number + " ------------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }
}
