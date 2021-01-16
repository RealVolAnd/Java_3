package Homework_5;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private Object ob1 = new Object();
    private Object ob2 = new Object();

    private Race race;
    private int speed;
    private String name;
    private RaceRules rules;
    private int readyToStart = 0;
    private int finishDone = 0;
    private long raceTime = 0l;

    static {
        CARS_COUNT = 0;
    }

    public Car(Race race, int speed, RaceRules rules) {
        this.race = race;
        this.speed = speed;
        this.rules = rules;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getReadyState() {
        return readyToStart;
    }

    public int getFinishDone() {
        return finishDone;
    }

    public long getRaceTime() {
        return raceTime;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");

            this.readyToStart = 1;
            rules.ready();
        } catch (Exception e) {
            e.printStackTrace();
        }

        long startRaceTime = System.currentTimeMillis();

        for (int i = 0; i < race.getStages().size(); i++) {

            if (race.getStages().get(i).getClass().equals(Tunnel.class)) {
                rules.tunnelIn();
                race.getStages().get(i).go(this);
                rules.tunnelOut();
            } else {
                race.getStages().get(i).go(this);
            }
        }

        finishDone = 1;

        rules.countDownWaitingForFinish();
        this.raceTime = System.currentTimeMillis() - startRaceTime;
    }
}
