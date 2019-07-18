package ru.job4j.bank;

import java.util.Objects;

/**
 * Class User Класс пользователя+.
 * @author chupin
 * @version $Id$
 * @since 0.1
 */

public class User {

    private int id;
    private String name;
    private String passport;


    public User(int id, String name, String passport) {
        this.name = name;
        this.id = id;
        this.passport = passport;
    }

    public String getPassport(){
        return passport;
    }

    public Boolean matchPassport(String passport) {
        boolean match = false;
        if (this.passport.equals(passport)) {
            match = true;
        }
        return match;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, passport);
    }
}
