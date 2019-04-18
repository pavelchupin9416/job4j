package ru.job4j.tracker;
import java.util.*;
import java.util.function.Consumer;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);




    @Override
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
           if (value == key) {
               exist = true;
               break;
           }
        }

        if (!exist) {
            throw new MenuOutException("Out of menu range.");
        }
        return key;

    }
}
