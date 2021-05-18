package machine;

import java.util.Scanner;

public class Main {
    enum Coffee {
        ESPRESSO(250, 0, 16, 1, 4),
        LATTE(350, 75, 20, 1, 7),
        CAPPUCCINO(200, 100, 12, 1, 6);

        int water;
        int milk;
        int coffee;
        int disposableCups;
        int money;

        Coffee(int water, int milk, int coffee, int cups, int money) {
            this.water = water;
            this.milk = milk;
            this.coffee = coffee;
            this.disposableCups = cups;
            this.money = money;
        }
    }

    public static int waterInMachine = 400;
    public static int milkInMachine = 540;
    public static int coffeeInMachine = 120;
    public static int disposableCupsInMachine = 9;
    public static int moneyInMachine = 550;

    public static void useCoffee(int amount) {
        coffeeInMachine -= amount;
    }

    public static void useWater(int amount) {
        waterInMachine -= amount;
    }

    public static void useMilk(int amount) {
        milkInMachine -= amount;
    }

    public static void useCups(int amount) {
        disposableCupsInMachine -= amount;
    }

    public static void addMoney(int money) {
        moneyInMachine += money;
    }

    public static void addCoffee(int amount) {
        coffeeInMachine += amount;
    }

    public static void addWater(int amount) {
        waterInMachine += amount;
    }

    public static void addMilk(int amount) {
        milkInMachine += amount;
    }

    public static void addCups(int amount) {
        disposableCupsInMachine += amount;
    }

    public static void takeMoney() {
        System.out.println("I gave you " + moneyInMachine + "\n");
        moneyInMachine = 0;
    }

    public static void makeCoffee(Coffee type) {
        boolean isEnough = true;
        if (waterInMachine < type.water) {
            isEnough = false;
            System.out.println("Sorry, not enough water!\n");
        }
        if (milkInMachine < type.milk) {
            isEnough = false;
            System.out.println("Sorry, not enough milk!\n");
        }
        if (coffeeInMachine < type.coffee) {
            isEnough = false;
            System.out.println("Sorry, not enough coffee!\n");
        }
        if (disposableCupsInMachine < type.disposableCups) {
            isEnough = false;
            System.out.println("Sorry, not enough cups!\n");
        }
        if (isEnough) {
            System.out.println("I have enough resources, making you a coffee!\n");
            useWater(type.water);
            useMilk(type.milk);
            useCoffee(type.coffee);
            useCups(type.disposableCups);
            addMoney(type.money);
        }
    }

    public static void choosingType(String coffeeNum) {
        Coffee type;
        switch (coffeeNum) {
            case "1":
                type = Coffee.ESPRESSO;
                makeCoffee(type);
                break;
            case "2":
                type = Coffee.LATTE;
                makeCoffee(type);
                break;
            case "3":
                type = Coffee.CAPPUCCINO;
                makeCoffee(type);
                break;
            case "back":
                break;
        }
    }

    public static void status() {
        System.out.println("\nThe coffee machine has :\n" + waterInMachine + " of water\n" + milkInMachine + " of milk\n" + coffeeInMachine +
                " of coffee beans\n" + disposableCupsInMachine + " of disposable cups\n" + moneyInMachine + " of money\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String option = scanner.nextLine();
            switch (option) {
                case "buy":
                    System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String typeOfCoffee = scanner.nextLine();
                    choosingType(typeOfCoffee);
                    break;
                case "fill":
                    System.out.println("Write how many ml of water do you want to add:");
                    addWater(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Write how many ml of milk do you want to add:");
                    addMilk(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    addCoffee(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    addCups(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    status();
                    break;
                case "exit":
                    running = false;
                    break;
            }
        }
    }

}
