package ru.job4j.tracker;
import java.util.*;
import java.util.function.Consumer;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);


    private final List<Consumer<Boolean>> validates = Arrays.asList(
            exi -> { if (!exi) {
                throw new MenuOutException("Out of menu range.");
            }
            }
    );

    int hasAccess(final Boolean exi, int key) {
        this.validates.forEach(action -> action.accept(exi));
        return key;
    }

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

        return hasAccess(exist, key);
        /*if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range.");
        }*/


    }
}
