package pkg2projekt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import static javax.management.Query.value;

public class Projekt2 {

    private List<String> sorok;
    private Szemely[] szemelyek;
    private String fejlec;

    public static void main(String[] args) throws IOException {
        new Projekt2().feladat();

    }

    private Projekt2() throws IOException {
        sorok = Files.readAllLines(Path.of("adatok.txt"));
        assert !sorok.isEmpty() : "üres a fájl";

        szemelyek = new Szemely[sorok.size() - 1];
        for (int i = 1; i < sorok.size(); i++) {
            szemelyek[i - 1] = new Szemely(sorok.get(i));

        }

        fejlec = sorok.get(0);
        assert sorok.size() - 1 == szemelyek.length : "nincs meg minden fuvar!";
        assert szemelyek[0] != null : "első fuvar hibás!";
        assert szemelyek[szemelyek.length - 1] != null : "utolsó fuvar hibás";
    }

    private void feladat() throws IOException {
        feladat0();
        feladat1();
        feladat2();
        feladat3();
        feladat4();
        feladat5();
        feladat6();
        feladat7();

    }

    private void feladat0() {
        System.out.println("Ellenőrzés: a file sorainak a száma: ");
        int i = sorok.size();
        System.out.printf("A fájl %d sort tartalmaz.\n", sorok.size());
        System.out.println(" ");
    }

    private void feladat1() {
        System.out.println("1. feladat: Ki keresi a legtöbbet? ");
        int index = 0;
        for (int i = 0; i < szemelyek.length; i++) {
            if (szemelyek[i].getFizetes() > szemelyek[index].getFizetes()) {
                index = i;
            }

        }
        System.out.println("Neki van a legnagyobb fizetése: " + szemelyek[index].getNev());
        System.out.println("Az Ő fizetése: " + szemelyek[index].getFizetes());
        System.out.println(" ");
    }

    private void feladat2() {
        System.out.println("2. feladat: Mennyi az átlag fizetés? ");
        int osszeg = 0;
        for (int i = 0; i < szemelyek.length; i++) {
            osszeg += szemelyek[i].getFizetes();

        }
        Locale loc = Locale.ENGLISH;

        System.out.printf(loc, "%d", osszeg / szemelyek.length);
        System.out.println("\n");

    }

    private void feladat3() {
        System.out.println("3. feladat: Mindenki budapesti?");
        int i = 0, N = szemelyek.length;
        while (i < N && szemelyek[i].getCim().equals("Budapest")) {
            i++;
        }

        //válasz:
        //boolean mind = i  >= N;
        System.out.println((i >= N ? "igen" : "nem"));
        System.out.println("");

    }

    private void feladat4() {
        System.out.println("4. feladat: Van 20 év feletti budapesti?");
        int i = 0, N = szemelyek.length;
        while (i < N
                && !(szemelyek[i].getKor() > 20 && szemelyek[i].getCim().equals("Budapest"))) {
            i++;
        }

        //válasz:
        //boolean mind = i  >= N;
        System.out.println((i < N ? "igen" : "nem"));
        System.out.println("");

    }

    private void feladat5() {
        System.out.println("5. feladat: Milyen címek vannak eltárolva? ");
        Set<String> Cimek = new HashSet<>();
        for (Szemely szemely : szemelyek) {
            Cimek.add(szemely.getCim());

        }
        for (String Cim : Cimek) {
            System.out.println(Cim);
        }

    }

    private void feladat6() {
        System.out.println("6. feladat: Melyik címen hányan laknak?");
        Map<String, Integer> CimDb = new HashMap<>();
        for (Szemely szemely : szemelyek) {
            String kulcs = szemely.getCim();
            if (CimDb.containsKey(kulcs)) {
                int ertek = CimDb.get(kulcs);
                CimDb.put(kulcs, ++ertek);
            } else {
                CimDb.put(kulcs, 1);
            }
        }

        //assert CimDb.get("bankkártya") > 1 : "bk  -> hibás Map";
        //assert CimDb.get("készpénz") == kpFuvarok.size() : "hibás Map";
        for (Map.Entry<String, Integer> entry : CimDb.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.printf("%-11s %4d db \n", key + ":", value);
        }

        System.out.println("\n");
    }

    private void feladat7() throws IOException {
        System.out.println("7. feladat: Írd ki a nemBp.txt fájlba Fejléccel a nem budapestiek minden adatát!");

        String kimenet = fejlec + "\n" ;
        for (Szemely szemely : szemelyek) {
            if (!szemely.getCim().equals("Budapest")){
                kimenet += szemely.getNev() + ";";
                kimenet += szemely.getKor() + ";";
                kimenet += szemely.getCim() + ";";
                kimenet += szemely.getFizetes() + "\n";
            }
            
        }
        
        Files.writeString(Path.of("nemBp.txt"), kimenet);

    }
}
