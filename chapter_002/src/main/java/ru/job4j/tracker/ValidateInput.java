package ru.job4j.tracker;
import java.util.*;

public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
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
