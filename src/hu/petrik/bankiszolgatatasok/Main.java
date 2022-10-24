package hu.petrik.bankiszolgatatasok;

public class Main {
    public static void main(String[] args) {
        //vékonyan szedett----> abstract osztály
        Tulajdonos t1=new Tulajdonos("Kovács Géza");
        Tulajdonos t2=new Tulajdonos("Tóth Árpád");

        Bank bank=new Bank();
        bank.szamlaNyitas(t1, 1000).befizet(3490);
        //bank.szamlaNyitas(t1,-8).kivesz(2000);
        bank.szamlaNyitas(t2,5000).befizet(59000);
        Szamla s_t1=new HitelSzamla(t1, 200);
        s_t1.befizet(5000);
        s_t1.kivesz(2000);
        System.out.println(s_t1.aktualisEgyenleg);
        System.out.println(bank.getOsszHitelkeret());
        System.out.println(bank.getOsszEgyenleg(t2));
        System.out.println(bank.getLegnagyobbEgyenleguSzamla(t2));

    }
}
