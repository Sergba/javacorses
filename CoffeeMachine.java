import java.util.Scanner;

public class CoffeeMachine {
        private int amountOfWater;
        private int amountOfMilk;
        private int amountOfCoffeeBeans;
        private int amountOfDisposableCups;
        private int amountOfMoney;
        private States state;
    public static void main(String[] args){
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540,
                120, 9, 550, States.MENU);
        handler(coffeeMachine);
    }
    public static void handler(CoffeeMachine coffeeMachine) {
        Scanner scanner = new Scanner(System.in);
        boolean program = true;

        while (program) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            switch (scanner.next()) {
                case "remaining":
                    coffeeMachine.setState(States.REMAINING);
                    break;
                case "buy":
                    coffeeMachine.setState(States.BUY);
                    break;
                case "fill":
                    coffeeMachine.setState(States.FILL);
                    break;
                case "take":
                    coffeeMachine.setState(States.TAKE);
                    break;
                case "back":
                    coffeeMachine.setState(States.MENU);
                    break;
                default:
                    coffeeMachine.setState(States.EXIT);
            }
            System.out.println();
            switch (coffeeMachine.getState()) {
                case REMAINING:
                    coffeeMachine.remaining();
                    break;
                case BUY:
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, " +
                            "3 - cappuccino, back - to main menu:");
                    String ord = scanner.next();
                    if (ord.equals("back")) {
                        break;
                    } else {
                        coffeeMachine.buy(ord);
                        break;
                    }
                case FILL:
                    System.out.println("Write how many ml of water do you want to add:");
                    int water = scanner.nextInt();
                    System.out.println("Write how many ml of milk do you want to add:");
                    int milk = scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    int coffee = scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    int cups = scanner.nextInt();
                    coffeeMachine.fill(water, milk, coffee, cups);
                    break;
                case TAKE:
                    coffeeMachine.take();
                    break;
                case MENU:
                    break;
                default:
                    program = false;
            }
            System.out.println();
        }
    }
        enum States {
            REMAINING("remaining"),
            BUY("buy"),
            FILL("fill"),
            TAKE("take"),
            MENU("back"),
            EXIT("exit");

            private final String cstate;

            States(String cstate) {
            this.cstate = cstate;
        }

            public String getCstate() {
            return this.cstate;
        }
        }
        public CoffeeMachine(int amountOfWater, int amountOfMilk,  int amountOfCoffeeBeans,
                             int amountOfDisposableCups, int amountOfMoney, States state) {
            this.amountOfWater = amountOfWater;
            this.amountOfMilk = amountOfMilk;
            this.amountOfCoffeeBeans = amountOfCoffeeBeans;
            this.amountOfDisposableCups = amountOfDisposableCups;
            this.amountOfMoney = amountOfMoney;
            this.state = state;
        }
        public void remaining( ) {
            System.out.println("The coffee machine has:" + "\n" + amountOfWater + " of water" + "\n" + amountOfMilk +
                    " of milk" + "\n" + amountOfCoffeeBeans + " of coffee beans" + "\n" + amountOfDisposableCups +
                    " of disposable cups" + "\n" + amountOfMoney + " of money");
        }
        public void buy(String varietiesOfCoffee) {
            switch (varietiesOfCoffee) {
                case "1":
                    if (amountOfWater < 250) {
                        System.out.println("Sorry, not enough water!");
                        break;
                    } else if (amountOfCoffeeBeans < 16) {
                        System.out.println("Sorry, not enough coffee beans!");
                        break;
                    } else if (amountOfDisposableCups < 1) {
                        System.out.println("Sorry, not enough disposable cups!");
                        break;
                    } else {
                        amountOfWater -= 250;
                        amountOfCoffeeBeans -= 16;
                        amountOfMoney += 4;
                        amountOfDisposableCups--;
                        System.out.println("I have enough resources, making you a coffee!");
                        break;
                    }
                case "2":
                    if (amountOfWater < 350) {
                        System.out.println("Sorry, not enough water!");
                        break;
                    } else if (amountOfMilk < 75) {
                        System.out.println("Sorry, not enough milk!");
                        break;
                    } else if (amountOfCoffeeBeans < 20) {
                        System.out.println("Sorry, not enough coffee beans!");
                        break;
                    } else if (amountOfDisposableCups < 1) {
                        System.out.println("Sorry, not enough disposable cups!");
                        break;
                    } else {
                        amountOfWater -= 350;
                        amountOfMilk -= 75;
                        amountOfCoffeeBeans -= 20;
                        amountOfMoney += 7;
                        amountOfDisposableCups--;
                        System.out.println("I have enough resources, making you a coffee!");
                        break;
                    }
                case "3":
                    if (amountOfWater < 200) {
                        System.out.println("Sorry, not enough water!");
                        break;
                    } else if (amountOfMilk < 100) {
                        System.out.println("Sorry, not enough milk!");
                        break;
                    } else if (amountOfCoffeeBeans < 12) {
                        System.out.println("Sorry, not enough coffee beans!");
                        break;
                    } else if (amountOfDisposableCups < 1) {
                        System.out.println("Sorry, not enough disposable cups!");
                        break;
                    } else {
                        amountOfWater -= 200;
                        amountOfMilk -= 100;
                        amountOfCoffeeBeans -= 12;
                        amountOfMoney += 6;
                        amountOfDisposableCups--;
                        System.out.println("I have enough resources, making you a coffee!");
                        break;
                    }
                default:
                    System.out.println();
            }
        }

        public void fill(int addWater, int addMilk, int addCoffeeBeans, int addCups) {
            amountOfWater += addWater;
            amountOfMilk += addMilk;
            amountOfCoffeeBeans += addCoffeeBeans;
            amountOfDisposableCups += addCups;
        }

        public void take() {
            System.out.println("I gave you $" + amountOfMoney);
            amountOfMoney = 0;
        }

        public void setState(States nstate) {
            state = nstate;
        }

        public States getState() {
            return state;
        }
}


