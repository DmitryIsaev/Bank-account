import accounts.Account;
import clients.Client;

public class Main {
    public static void main(String[] args) {
        String name;
        long amount;
        name = "Петя";
        int maxAccount = 3;

        System.out.println("Имя аккаунта: " + name + ". Максимальное количество аккаунтов: " + maxAccount);

        Client client1 = new Client(name, maxAccount);
        Account account = new accounts.CheckingAccount("Расчётный счёт", 200);
        client1.add(account);

        Account account1 = new accounts.SavingsAccount("Накопительный счёт", 100, 150);
        client1.add(account1);

        Account account2 = new accounts.CreditAccount("Кредитный счёт", 0);
        client1.add(account2);

        Account account3 = new accounts.SavingsAccount("Накопительный счёт", 100, 150);
        client1.add(account3);

        client1.getInfo();

        amount = 200;
        client1.pay(amount);
        amount = 500;
        client1.pay(amount);

        client1.getInfo();

        client1.accept(1000);

        client1.getInfo();

        Account accountFrom = account2;
        Account accountTo = account3;
        int remittance = 5000;
        System.out.println("Берём из " + accountFrom.getName() + " сумму " + remittance + " и переводим в " + accountTo.getName());
        System.out.println("Осуществляем перевод " + accountFrom.transfer(accountTo, remittance));

        client1.getInfo();
    }
}