class TortoiseAndHareRace {
    public static void main(String[] args) {
        Tortoise tortoise = new Tortoise();
        Hare hare = new Hare();

        Thread tortoiseThread = new Thread(tortoise);
        Thread hareThread = new Thread(hare);

        tortoiseThread.start();
        hareThread.start();
    }
}

class Tortoise implements Runnable {
    @Override
    public void run() {
        int distance = 12;
        int tortoiseSpeed = 1;

        while (distance > 0) {
            System.out.println("\nTortoise is " + distance + " units away from the finish line.");
            distance -= tortoiseSpeed;
        }

        System.out.println("Tortoise wins the race!");
    }
}

class Hare implements Runnable {
    @Override
    public void run() {
        int distance = 12;
        int hareSpeed = 2;
        int halfway = distance / 2;

        while (distance > 0) {
            System.out.println("Hare is " + distance + " units away from the finish line.");
            distance -= hareSpeed;

            if (distance == halfway) {
                try {
                    System.out.println("Hare falls asleep...");
                    Thread.sleep(5000);
                    System.out.println("Hare wakes up!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Hare loses the race!");
    }
}
