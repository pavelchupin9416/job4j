package ru.job4j.bank;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BankTest {


    @Test
    public void whenUserAdd() {
        Bank bank=new Bank();
        User us1=new User(1,"Victor", "234353");
        bank.addUser(us1);
        boolean result=false;
        for (User user : bank.getUsers()) {
            if (user.equals(us1)) {
               result = true;
            }
        }
        assertThat(result, is(true));
    }

    @Test
    public void whenUserDelete() {
        Bank bank=new Bank();
        User us1=new User(1,"Victor", "234353");
        bank.addUser(us1);
        bank.deleteUser(us1);
        boolean result=false;
        for (User user : bank.getUsers()) {
            if (user.equals(us1)) {
                result = true;
            }
        }
        assertThat(result, is(false));
    }

    @Test
    public void whenAddAccount() {
        Bank bank=new Bank();
        User us1=new User(1,"Victor", "234353");
        Account ac1=new Account(123,"123");
        bank.addUser(us1);
        bank.addAccountToUser(us1.getPassport(),ac1);
        boolean result=false;
        for (Account account : bank.getUserAccounts(us1.getPassport())) {
            if (account.equals(ac1)) {
                result = true;
            }
        }
        assertThat(result, is(true));
    }


    @Test
    public void whenTransferUser1ToUser2() {
        Bank bank=new Bank();
        User us1=new User(1,"Victor", "234353");
        User us2=new User(2,"Miha", "756456");
        Account ac1=new Account(120,"123");
        Account ac2=new Account(450,"456");
        bank.addUser(us1);
        bank.addUser(us2);
        bank.addAccountToUser(us1.getPassport(),ac1);
        bank.addAccountToUser(us2.getPassport(),ac2);
        bank.transferMoney(us1.getPassport(),ac1.getReqs(),us2.getPassport(),ac2.getReqs(),50);
        boolean  result= false;
        for (Account account : bank.getUserAccounts(us1.getPassport())) {
            if (account.equals(ac1)) {
                if (account.getValues() == 70) {}
                result = true;
            }
        }
        assertThat(result, is(true));
    }

    @Test
    public void whenTransferUser1ValueMisTUser2Value() {
        Bank bank=new Bank();
        User us1=new User(1,"Victor", "234353");
        User us2=new User(2,"Miha", "756456");
        Account ac1=new Account(30,"123");
        Account ac2=new Account(450,"456");
        bank.addUser(us1);
        bank.addUser(us2);
        bank.addAccountToUser(us1.getPassport(),ac1);
        bank.addAccountToUser(us2.getPassport(),ac2);
        boolean  result = bank.transferMoney(us1.getPassport(),ac1.getReqs(),us2.getPassport(),ac2.getReqs(),50);
        assertThat(result, is(false));
    }

    @Test
    public void whenTransferUser1AbsentAccount() {
        Bank bank=new Bank();
        User us1=new User(1,"Victor", "234353");
        User us2=new User(2,"Miha", "756456");
        Account ac1=new Account(120,"123");
        Account ac2=new Account(450,"456");
        bank.addUser(us1);
        bank.addUser(us2);
        //bank.addAccountToUser(us1.getPassport(),ac1);
        bank.addAccountToUser(us2.getPassport(),ac2);
        boolean  result = bank.transferMoney(us1.getPassport(),ac1.getReqs(),us2.getPassport(),ac2.getReqs(),50);
        assertThat(result, is(false));
    }
}
