package accounts;

import accounts.*;
import currency.Currency;

public class Main {
    public static void main(String[] args) {
        // Currency creation
        Currency juan = new Currency("CNY", 0.15);
        Currency euro = new Currency("EUR", 1.12);

        // Carter's accounts creation
        CheckingAccount carterCheckingAccount = new CheckingAccount(1000.0, 0.05, 0.01, 1000.0, 1000.0);


        // Steve's accounts creation
        CheckingAccount steveCheckingAccount = new CheckingAccount(1200.0, 0.05, 0.01, 1000.0, 1000.0);
        // ForeignAccount

        // Frank's accounts creation
        ForeignAccount frankForeignAccount = new ForeignAccount(2000.0, 0.02, 0.02, 1000.0, 1000.0, euro);
        SavingsAccount frankSavingAccount = new SavingsAccount(500.0, 0.02);

        // Tim's accounts creation
        CheckingAccount timCheckingAccount = new CheckingAccount(1500.0, 0.05, 0.01, 1000.0, 1000.0);
        SavingsAccount timSavingsAccount = new SavingsAccount(1000.0, 0.02);

        // Shop's account creation
        CheckingAccount shopCheckingAccount = new CheckingAccount(200000.0, 0.05, 0.01, 5000.0, 10000.0);

        // Petrol station's account creation
        ForeignAccount petrolStationForeignAccount = new ForeignAccount(1000000.0, 0.05, 0.01, 20000.0, 50000.0, juan);

        // January
        System.out.println("January 2024 \n");

        System.out.println("Carter starts working at the shop with salary of 1200$ / month");
        System.out.println("Steve starts working at the petrol station with salary of 1500$ / month");
        System.out.println("Tim become a manager at the shop with salary of 4000$ / month");

        System.out.println("Tim is getting his interest from his savings account");
        timSavingsAccount.addInterest();

        System.out.println("Frank is getting his interest from his savings account");
        frankSavingAccount.addInterest();

        // February
        System.out.println("\nFebruary 2024 \n");

        System.out.println("Shop earns 12000$ in January");
        shopCheckingAccount.deposit(12000.0);

        System.out.println("Petrol station earns 15000$ in January");
        petrolStationForeignAccount.deposit(15000.0);

        System.out.println("Carter is getting his salary of 1200$");
        shopCheckingAccount.transfer(carterCheckingAccount, 1200.0);

        System.out.println("Carter is going to party to celebrate his 1st salary so he's withdrawing 200$");
        carterCheckingAccount.withdraw(200.0);

        System.out.println("Steve is getting his salary of 1500$");
        petrolStationForeignAccount.transfer(steveCheckingAccount, 1500.0);

        System.out.println("Steve wants to save for new apartment so he's creating savings account with 500$");
        SavingsAccount steveSavingsAccount = new SavingsAccount(0.0, 0.02);
        steveCheckingAccount.transfer(steveSavingsAccount, 500.0);

        System.out.println("Tim is getting his salary of 4000$");
        shopCheckingAccount.transfer(timCheckingAccount, 4000.0);

        System.out.println("Tim is getting his interest from his savings account");
        timSavingsAccount.addInterest();

        System.out.println("Tim is going to buy new car so he's creating credit account with 50000$");
        CreditCard timCreditAccount = new CreditCard(0.0, 50000.0);

        System.out.println("Tim is buying new car for 30000$");
        timCreditAccount.withdraw(30000.0);

        System.out.println("Frank is getting is becoming a manager at the petrol station with salary of 5000$");

        System.out.println("Frank is getting his interest from his savings account");

        System.out.println("\nAll of them are spending money on typical things like food, bills, etc.");
        carterCheckingAccount.withdraw(432.2);
        steveCheckingAccount.withdraw(328.9);
        frankForeignAccount.withdraw(527.7);
        timCheckingAccount.withdraw(412.7);

        // March
        System.out.println("\nMarch 2024 \n");

        System.out.println("Shop earns 13000$ in February");
        shopCheckingAccount.deposit(13000.0);

        System.out.println("Petrol station earns 16000$ in February");
        petrolStationForeignAccount.deposit(16000.0);

        System.out.println("Carter is getting his salary of 1200$");
        shopCheckingAccount.transfer(carterCheckingAccount, 1200.0);

        System.out.println("Steve is getting his salary of 1500$");
        petrolStationForeignAccount.transfer(steveCheckingAccount, 1500.0);

        System.out.println("Steve got his first interest from his savings account");
        steveSavingsAccount.addInterest();

        System.out.println("Tim is getting his salary of 4000$");
        shopCheckingAccount.transfer(timCheckingAccount, 4000.0);

        System.out.println("Tim is paying off part of his credit card debt of 1000$");
        timCreditAccount.payOff(1000.0);

        System.out.println("Tim is getting his interest from his savings account");
        timSavingsAccount.addInterest();

        System.out.println("Frank is getting his salary of 5000$");
        petrolStationForeignAccount.transfer(frankForeignAccount, 5000.0);

        System.out.println("Frank is getting his interest from his savings account");
        frankSavingAccount.addInterest();

        System.out.println("\nAll of them are spending money on typical things like food, bills, etc.");
        carterCheckingAccount.withdraw(622.9);
        steveCheckingAccount.withdraw(658.2);
        frankForeignAccount.withdraw(327.7);
        timCheckingAccount.withdraw(432.4);

        // April
        System.out.println("\nApril 2024 \n");

        System.out.println("Shop earns 13500$ in March");
        shopCheckingAccount.deposit(13500.0);

        System.out.println("Petrol station earns 16500$ in March");
        petrolStationForeignAccount.deposit(16500.0);

        System.out.println("Carter is getting his salary of 1200$");
        shopCheckingAccount.transfer(carterCheckingAccount, 1200.0);

        System.out.println("Steve is getting his salary of 1500$");
        petrolStationForeignAccount.transfer(steveCheckingAccount, 1500.0);

        System.out.println("Steve got his interest from his savings account");
        steveSavingsAccount.addInterest();

        System.out.println("Tim is getting his salary of 4000$");
        shopCheckingAccount.transfer(timCheckingAccount, 4000.0);

        System.out.println("Tim is paying off part of his credit card debt of 1000$");
        timCreditAccount.payOff(1000.0);

        System.out.println("Tim is getting his interest from his savings account");
        timSavingsAccount.addInterest();

        System.out.println("Frank is getting his salary of 5000$");
        petrolStationForeignAccount.transfer(frankForeignAccount, 5000.0);

        System.out.println("Frank is getting his interest from his savings account");
        frankSavingAccount.addInterest();

        System.out.println("\nAll of them are spending money on typical things like food, bills, etc.");
        carterCheckingAccount.withdraw(472.1);
        steveCheckingAccount.withdraw(368.2);
        frankForeignAccount.withdraw(422.3);
        timCheckingAccount.withdraw(452.1);

        // May
        System.out.println("\nMay 2024 \n");

        System.out.println("Shop earns 13500$ in March");
        shopCheckingAccount.deposit(13500.0);

        System.out.println("Petrol station earns 16500$ in March");
        petrolStationForeignAccount.deposit(16500.0);

        System.out.println("Carter is getting his salary of 1200$");
        shopCheckingAccount.transfer(carterCheckingAccount, 1200.0);

        System.out.println("Steve is getting his salary of 1500$");
        petrolStationForeignAccount.transfer(steveCheckingAccount, 1500.0);

        System.out.println("Steve got his interest from his savings account");
        steveSavingsAccount.addInterest();

        System.out.println("Tim is getting his salary of 4000$");
        shopCheckingAccount.transfer(timCheckingAccount, 4000.0);

        System.out.println("Tim is paying off part of his credit card debt of 1000$");
        timCreditAccount.payOff(1000.0);

        System.out.println("Tim is getting his interest from his savings account");
        timSavingsAccount.addInterest();

        System.out.println("Frank is getting his salary of 5000$");
        petrolStationForeignAccount.transfer(frankForeignAccount, 5000.0);

        System.out.println("Frank is getting his interest from his savings account");
        frankSavingAccount.addInterest();

        System.out.println("\nAll of them are spending money on typical things like food, bills, etc.");
        carterCheckingAccount.withdraw(361.23);
        steveCheckingAccount.withdraw(462.9);
        frankForeignAccount.withdraw(642.7);
        timCheckingAccount.withdraw(342.7);

        // June
        System.out.println("\nJune 2024 \n");

        System.out.println("Shop earns 13500$ in March");
        shopCheckingAccount.deposit(13500.0);

        System.out.println("Petrol station earns 16500$ in March");
        petrolStationForeignAccount.deposit(16500.0);

        System.out.println("Carter is getting his salary of 1200$");
        shopCheckingAccount.transfer(carterCheckingAccount, 1200.0);

        System.out.println("Steve is getting his salary of 1500$");
        petrolStationForeignAccount.transfer(steveCheckingAccount, 1500.0);

        System.out.println("Steve got his interest from his savings account");
        steveSavingsAccount.addInterest();

        System.out.println("Tim is getting his salary of 4000$");
        shopCheckingAccount.transfer(timCheckingAccount, 4000.0);

        System.out.println("Tim is paying off part of his credit card debt of 1000$");
        timCreditAccount.payOff(1000.0);

        System.out.println("Tim is getting his interest from his savings account");
        timSavingsAccount.addInterest();

        System.out.println("Frank is getting his salary of 5000$");
        petrolStationForeignAccount.transfer(frankForeignAccount, 5000.0);

        System.out.println("Frank is getting his interest from his savings account");
        frankSavingAccount.addInterest();

        System.out.println("\nAll of them are spending money on typical things like food, bills, etc.");
        carterCheckingAccount.withdraw(322.2);
        steveCheckingAccount.withdraw(491.4);
        frankForeignAccount.withdraw(421.5);
        timCheckingAccount.withdraw(632.12);

        // July
        System.out.println("\nJuly 2024 \n");

        System.out.println("Shop earns 13500$ in March");
        shopCheckingAccount.deposit(13500.0);

        System.out.println("Petrol station earns 16500$ in March");
        petrolStationForeignAccount.deposit(16500.0);

        System.out.println("Carter is getting his salary of 1200$");
        shopCheckingAccount.transfer(carterCheckingAccount, 1200.0);

        System.out.println("Steve is getting his salary of 1500$");
        petrolStationForeignAccount.transfer(steveCheckingAccount, 1500.0);

        System.out.println("Steve got his interest from his savings account");
        steveSavingsAccount.addInterest();

        System.out.println("Tim is getting his salary of 4000$");
        shopCheckingAccount.transfer(timCheckingAccount, 4000.0);

        System.out.println("Tim is paying off part of his credit card debt of 1000$");
        timCreditAccount.payOff(1000.0);

        System.out.println("Tim is getting his interest from his savings account");
        timSavingsAccount.addInterest();

        System.out.println("Frank is getting his salary of 5000$");
        petrolStationForeignAccount.transfer(frankForeignAccount, 5000.0);

        System.out.println("Frank is getting his interest from his savings account");
        frankSavingAccount.addInterest();

        System.out.println("\nAll of them are spending money on typical things like food, bills, etc.");
        carterCheckingAccount.withdraw(323.7);
        steveCheckingAccount.withdraw(522.9);
        frankForeignAccount.withdraw(377.7);
        timCheckingAccount.withdraw(532.7);

        // August
        System.out.println("\nAugust 2024 \n");

        System.out.println("Shop earns 13500$ in March");
        shopCheckingAccount.deposit(13500.0);

        System.out.println("Petrol station earns 16500$ in March");
        petrolStationForeignAccount.deposit(16500.0);

        System.out.println("Carter is getting his salary of 1200$");
        shopCheckingAccount.transfer(carterCheckingAccount, 1200.0);

        System.out.println("Steve is getting his salary of 1500$");
        petrolStationForeignAccount.transfer(steveCheckingAccount, 1500.0);

        System.out.println("Steve got his interest from his savings account");
        steveSavingsAccount.addInterest();

        System.out.println("Tim is getting his salary of 4000$");
        shopCheckingAccount.transfer(timCheckingAccount, 4000.0);

        System.out.println("Tim is paying off part of his credit card debt of 1000$");
        timCreditAccount.payOff(1000.0);

        System.out.println("Tim is getting his interest from his savings account");
        timSavingsAccount.addInterest();

        System.out.println("Frank is getting his salary of 5000$");
        petrolStationForeignAccount.transfer(frankForeignAccount, 5000.0);

        System.out.println("Frank is getting his interest from his savings account");
        frankSavingAccount.addInterest();

        System.out.println("\nAll of them are spending money on typical things like food, bills, etc.");
        carterCheckingAccount.withdraw(334.1);
        steveCheckingAccount.withdraw(414.9);
        frankForeignAccount.withdraw(424.4);
        timCheckingAccount.withdraw(352.1);

        // September
        System.out.println("\nSeptember 2024 \n");

        System.out.println("Shop earns 13500$ in March");
        shopCheckingAccount.deposit(13500.0);

        System.out.println("Petrol station earns 16500$ in March");
        petrolStationForeignAccount.deposit(16500.0);

        System.out.println("Carter is getting his salary of 1200$");
        shopCheckingAccount.transfer(carterCheckingAccount, 1200.0);

        System.out.println("Steve is getting his salary of 1500$");
        petrolStationForeignAccount.transfer(steveCheckingAccount, 1500.0);

        System.out.println("Steve got his interest from his savings account");
        steveSavingsAccount.addInterest();

        System.out.println("Tim is getting his salary of 4000$");
        shopCheckingAccount.transfer(timCheckingAccount, 4000.0);

        System.out.println("Tim is paying off part of his credit card debt of 1000$");
        timCreditAccount.payOff(1000.0);

        System.out.println("Tim is getting his interest from his savings account");
        timSavingsAccount.addInterest();

        System.out.println("Frank is getting his salary of 5000$");
        petrolStationForeignAccount.transfer(frankForeignAccount, 5000.0);

        System.out.println("Frank is getting his interest from his savings account");
        frankSavingAccount.addInterest();

        System.out.println("\nAll of them are spending money on typical things like food, bills, etc.");
        carterCheckingAccount.withdraw(498.2);
        steveCheckingAccount.withdraw(222.1);
        frankForeignAccount.withdraw(417.4);
        timCheckingAccount.withdraw(232.1);

        // October
        System.out.println("\nOctober 2024 \n");

        System.out.println("Shop earns 13500$ in March");
        shopCheckingAccount.deposit(13500.0);

        System.out.println("Petrol station earns 16500$ in March");
        petrolStationForeignAccount.deposit(16500.0);

        System.out.println("Carter is getting his salary of 1200$");
        shopCheckingAccount.transfer(carterCheckingAccount, 1200.0);

        System.out.println("Steve is getting his salary of 1500$");
        petrolStationForeignAccount.transfer(steveCheckingAccount, 1500.0);

        System.out.println("Steve got his interest from his savings account");
        steveSavingsAccount.addInterest();

        System.out.println("Tim is getting his salary of 4000$");
        shopCheckingAccount.transfer(timCheckingAccount, 4000.0);

        System.out.println("Tim is paying off part of his credit card debt of 1000$");
        timCreditAccount.payOff(1000.0);

        System.out.println("Tim is getting his interest from his savings account");
        timSavingsAccount.addInterest();

        System.out.println("Frank is getting his salary of 5000$");
        petrolStationForeignAccount.transfer(frankForeignAccount, 5000.0);

        System.out.println("Frank is getting his interest from his savings account");
        frankSavingAccount.addInterest();

        System.out.println("\nAll of them are spending money on typical things like food, bills, etc.");
        carterCheckingAccount.withdraw(365.1);
        steveCheckingAccount.withdraw(353.2);
        frankForeignAccount.withdraw(421.2);
        timCheckingAccount.withdraw(543.1);

        // November
        System.out.println("\nNovember 2024 \n");

        System.out.println("Shop earns 13500$ in March");
        shopCheckingAccount.deposit(13500.0);

        System.out.println("Petrol station earns 16500$ in March");
        petrolStationForeignAccount.deposit(16500.0);

        System.out.println("Carter is getting his salary of 1200$");
        shopCheckingAccount.transfer(carterCheckingAccount, 1200.0);

        System.out.println("Steve is getting his salary of 1500$");
        petrolStationForeignAccount.transfer(steveCheckingAccount, 1500.0);

        System.out.println("Steve got his interest from his savings account");
        steveSavingsAccount.addInterest();

        System.out.println("Tim is getting his salary of 4000$");
        shopCheckingAccount.transfer(timCheckingAccount, 4000.0);

        System.out.println("Tim is paying off part of his credit card debt of 1000$");
        timCreditAccount.payOff(1000.0);

        System.out.println("Tim is getting his interest from his savings account");
        timSavingsAccount.addInterest();

        System.out.println("Frank is getting his salary of 5000$");
        petrolStationForeignAccount.transfer(frankForeignAccount, 5000.0);

        System.out.println("Frank is getting his interest from his savings account");
        frankSavingAccount.addInterest();

        System.out.println("\nAll of them are spending money on typical things like food, bills, etc.");
        carterCheckingAccount.withdraw(532.1);
        steveCheckingAccount.withdraw(321.4);
        frankForeignAccount.withdraw(227.1);
        timCheckingAccount.withdraw(431.1);

        // December
        System.out.println("\nDecember 2024 \n");

        System.out.println("Shop earns 13500$ in March");
        shopCheckingAccount.deposit(13500.0);

        System.out.println("Petrol station earns 16500$ in March");
        petrolStationForeignAccount.deposit(16500.0);

        System.out.println("Carter is getting his salary of 1200$");
        shopCheckingAccount.transfer(carterCheckingAccount, 1200.0);

        System.out.println("Carter had to pay ticket for speeding of 200$");
        carterCheckingAccount.withdraw(200.0);

        System.out.println("Steve is getting his salary of 1500$");
        petrolStationForeignAccount.transfer(steveCheckingAccount, 1500.0);

        System.out.println("Steve got his interest from his savings account");
        steveSavingsAccount.addInterest();

        System.out.println("Tim is getting his salary of 4000$");
        shopCheckingAccount.transfer(timCheckingAccount, 4000.0);

        System.out.println("Tim is paying off part of his credit card debt of 1000$");
        timCreditAccount.payOff(1000.0);

        System.out.println("Tim is getting his interest from his savings account");
        timSavingsAccount.addInterest();

        System.out.println("Frank is getting his salary of 5000$");
        petrolStationForeignAccount.transfer(frankForeignAccount, 5000.0);

        System.out.println("Frank is getting his interest from his savings account");
        frankSavingAccount.addInterest();

        System.out.println("\nAll of them are spending money on typical things like food, bills, etc.");
        carterCheckingAccount.withdraw(354.5);
        steveCheckingAccount.withdraw(548.9);
        frankForeignAccount.withdraw(432.7);
        timCheckingAccount.withdraw(712.1);

        // Print final balances
        System.out.println("\nFinal balances: ");
        System.out.println("Carter's checking account: " + carterCheckingAccount.getBalance());
        System.out.println("Steve's checking account: " + steveCheckingAccount.getBalance());
        System.out.println("Steve's savings account: " + steveSavingsAccount.getBalance());
        System.out.println("Frank's foreign account: " + frankForeignAccount.getBalance());
        System.out.println("Tim's checking account: " + timCheckingAccount.getBalance());
        System.out.println("Tim's savings account: " + timSavingsAccount.getBalance());
        System.out.println("Tim's credit account: " + timCreditAccount.getBalance());
        System.out.println("Tim's credit debt: " + timCreditAccount.getDebt());
        System.out.println("Shop's checking account: " + shopCheckingAccount.getBalance());
        System.out.println("Petrol station's foreign account: " + petrolStationForeignAccount.getBalance());

    }
}
