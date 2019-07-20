package ru.job4j.bank;

import java.util.Objects;

/**
 * Class Account Класс аккаунта.
 * @author chupin
 * @version $Id$
 * @since 0.1
 */
public class Account {

   private double values;
   private String reqs;

    public Account(double values, String requisites) {
        this.values = values;
        this.reqs = requisites;
    }

    public double getValues() {
        return this.values;
    }


    public String getReqs() {
        return this.reqs;
    }

   public boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount < this.values && destination != null) {
            success = true;
            this.values -= amount;
            destination.values += amount;
        }
        return success;
    }

    public String toString() {
        String otvet;
        otvet = "Account{" + "values=" + this.values + ", reqs='" + this.reqs + "\\" + "}";
        return otvet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Double.compare(account.values, values) == 0
                && Objects.equals(reqs, account.reqs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values, reqs);
    }
}