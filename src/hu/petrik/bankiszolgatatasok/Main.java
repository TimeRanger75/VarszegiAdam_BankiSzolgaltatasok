package hu.petrik.bankiszolgatatasok;

public class Main {
    public static void main(String[] args) {
        //vékonyan szedett----> abstract osztály
        Tulajdonos t1=new Tulajdonos("Kovács Géza");
        Tulajdonos t2=new Tulajdonos("Tóth Árpád");

        Bank bank=new Bank();
        bank.szamlaNyitas(t1, 1000).befizet(3490);
        bank.szamlaNyitas(t2,600).kivesz(500);

        System.out.println(bank.getOsszHitelkeret());
        System.out.println(bank.getOsszEgyenleg(t1));
        System.out.println(bank.getOsszEgyenleg(t2));
    }
}
