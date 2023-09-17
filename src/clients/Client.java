package clients;

import accounts.Account;

public class Client {
    protected String name;
    protected Account[] accounts;

    public Client(String name, int maxAccount) {
        this.name = name;
        this.accounts = new Account[maxAccount];
    }

    public void add(Account account) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                System.out.println("Добавлен аккаунт " + account.getName());
                return;
            }
        }
        System.out.println("Мест для добавления нового счёта нет! :(");
    }

    public boolean pay(long amount) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                break;
            }
            if (accounts[i].pay(amount)) {
                System.out.println("Списание " + amount + " проведено ");
                return true;
            }
        }
        System.out.println("Списание " + amount + " не проведено ");
        return false;
    }

    public boolean accept(int amount) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                break;
            }
            if (accounts[i].add(amount)) {
                System.out.println("Добавлено " + amount + " проведено ");
                return true;
            }
        }
        System.out.println("Добавлено " + amount + " не проведено ");
        return false;
    }

    public void getInfo() {
        System.out.println();
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                break;
            }
            System.out.println("Аккаунт " + accounts[i].getName() + " имеет баланс: " + accounts[i].getBalance());
        }
        System.out.println();
    }
}
