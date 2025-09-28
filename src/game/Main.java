package game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("=== Создание игрока ===");
            System.out.print("Введите имя игрока: ");
            String playerName = scanner.nextLine();

            System.out.print("Введите Атаку игрока (1-30): ");
            int pAttack = scanner.nextInt();

            System.out.print("Введите Защиту игрока (1-30): ");
            int pDefense = scanner.nextInt();

            System.out.print("Введите максимальное Здоровье игрока (>0): ");
            int pHealth = scanner.nextInt();

            System.out.print("Введите минимальный Урон игрока (>0): ");
            int pDamageMin = scanner.nextInt();

            System.out.print("Введите максимальный Урон игрока (>=min): ");
            int pDamageMax = scanner.nextInt();
            scanner.nextLine();

            Player player = new Player(pAttack, pDefense, pHealth, pDamageMax, pDamageMin, playerName);

            System.out.println("\n=== Создание монстра ===");
            System.out.print("Введите имя монстра: ");
            String monsterName = scanner.nextLine();

            System.out.print("Введите Атаку монстра (1-30): ");
            int mAttack = scanner.nextInt();

            System.out.print("Введите Защиту монстра (1-30): ");
            int mDefense = scanner.nextInt();

            System.out.print("Введите максимальное Здоровье монстра (>0): ");
            int mHealth = scanner.nextInt();

            System.out.print("Введите минимальный Урон монстра (>0): ");
            int mDamageMin = scanner.nextInt();

            System.out.print("Введите максимальный Урон монстра (>=min): ");
            int mDamageMax = scanner.nextInt();

            Monster monster = new Monster(mAttack, mDefense, mHealth, mDamageMax, mDamageMin, monsterName);

            System.out.println("\n=== Битва началась! ===\n");

            while (player.isAlive() && monster.isAlive()) {
                player.attack(monster);

                if (monster.isAlive()) {
                    monster.attack(player);
                }
            }

            if (player.isAlive()) {
                System.out.println(player.getName() + " побеждает!");
            }
            else {
                System.out.println(monster.getName() + " побеждает!");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания существа: " + e.getMessage());
        }
    }
}
