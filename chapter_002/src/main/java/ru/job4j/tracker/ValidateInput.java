package ru.job4j.tracker;
import java.util.*;
public class ValidateInput extends ConsoleInput {
    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                 value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moee) {
                System.out.println("Plese select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Plese enter data again.");
            }
        } while (invalid);
        return value;
    }
}
