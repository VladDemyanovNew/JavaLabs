package VDemyanov.Multithreading.Task2.Airport;

import java.util.ArrayList;

public class Aiport {

    private ArrayList<Ladder> ladders;
    private ArrayList<Terminal> terminals;
    private ArrayList<Aircraft> aircrafts;

    /**
     * Возвращает колекцию трапов
     * @return ArrayList<Ladder> ladders
     */
    public ArrayList<Ladder> getLadders() {
        return ladders;
    }

    /**
     * Возвращает колекцию терминалов
     * @return ArrayList<Terminal> terminals
     */
    public ArrayList<Terminal> getTerminals() {
        return terminals;
    }

    /**
     * Возвращает колекцию самолётов
     * @return ArrayList<Aircraft> aircrafts
     */
    public ArrayList<Aircraft> getAircrafts() {
        return aircrafts;
    }

    public Aiport(int terminalCount, int ladderCount) {
        generateTerminals(terminalCount);
        generateLadders(ladderCount);
        this.aircrafts = new ArrayList<>();
    }

    public void addAircraft() {

    }

    /**
     * Генерирует колекцию из count терминалов
     * @param count
     */
    private void generateTerminals(int count) {
        while (count != 0) {
            this.terminals.add(new Terminal());
            count--;
        }
    }

    /**
     * Генерирует колекцию из count терминалов
     * @param count
     */
    private void generateLadders(int count) {
        while (count != 0) {
            this.ladders.add(new Ladder());
            count--;
        }
    }
}
