import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Integer;
import java.util.Scanner;
import java.io.FileWriter;

public class Main {

    static String[] nyelvFejlec = new String[50];
    static Integer ev09Fejlec[] = new Integer[50];
    static Integer ev10Fejlec[] = new Integer[50];
    static Integer ev11Fejlec[] = new Integer[50];
    static Integer ev12Fejlec[] = new Integer[50];
    static Integer ev13Fejlec[] = new Integer[50];
    static Integer ev14Fejlec[] = new Integer[50];
    static Integer ev15Fejlec[] = new Integer[50];
    static Integer ev16Fejlec[] = new Integer[50];
    static Integer ev17Fejlec[] = new Integer[50];
    static Integer ev18Fejlec[] = new Integer[50];

    static Integer szamlaloSikeres = 0;
    static String[] nyelvNeveSikeres = new String[50];
    static Integer ev2009Sikeres[] = new Integer[50];
    static Integer ev2010Sikeres[] = new Integer[50];
    static Integer ev2011Sikeres[] = new Integer[50];
    static Integer ev2012Sikeres[] = new Integer[50];
    static Integer ev2013Sikeres[] = new Integer[50];
    static Integer ev2014Sikeres[] = new Integer[50];
    static Integer ev2015Sikeres[] = new Integer[50];
    static Integer ev2016Sikeres[] = new Integer[50];
    static Integer ev2017Sikeres[] = new Integer[50];
    static Integer ev2018Sikeres[] = new Integer[50];

    static Integer szamlaloSikertelen = 0;
    static String[] nyelvNeveSikertelen = new String[50];
    static Integer ev2009Sikertelen[] = new Integer[50];
    static Integer ev2010Sikertelen[] = new Integer[50];
    static Integer ev2011Sikertelen[] = new Integer[50];
    static Integer ev2012Sikertelen[] = new Integer[50];
    static Integer ev2013Sikertelen[] = new Integer[50];
    static Integer ev2014Sikertelen[] = new Integer[50];
    static Integer ev2015Sikertelen[] = new Integer[50];
    static Integer ev2016Sikertelen[] = new Integer[50];
    static Integer ev2017Sikertelen[] = new Integer[50];
    static Integer ev2018Sikertelen[] = new Integer[50];

    public static void main(String[] args) {
        System.out.println("0. feladat. Beolvassuk a megjelölt állományokat!");
        beolvasSikeres("sikeres.csv");
        beolvasSikertelen("sikertelen.csv");
        nyelvOsszegzes(); //Évenként összeadjuk a nyelvvizsgák számát és kiírjuk a három legnépszerúbbet.
        // felhasznaloEvet(); // Ezt kikapcsoltam mert valami nem jó a scannernél. Bár lefut de a következő lépésre nem megy tovább. A Scanner class-ra ír valamilyen megjegyzést.
        felhasznaloEveSikertelenArany();
        voltNulla();
        osszesites(); //Kiiratás - nem megy, egy sorban van az egész szöveg, karakterenként tudtam csak iratni, soronként kellene...!
    }

    private static void osszesites() {
        Double[] sikerescountTeljes = new Double[szamlaloSikeres];
        Double[] sikertelencountTeljes = new Double[szamlaloSikertelen];
        Double[] summvizsgaTeljes = new Double[szamlaloSikertelen];
        Double[] sikertelenAranyTeljes = new Double[szamlaloSikertelen];
        Double[] summvizsga = new Double[szamlaloSikertelen];
        String kiir = "";

        try {
            FileWriter fw = new FileWriter("osszesites.csv");

            for (int i = 0; i < szamlaloSikeres; i++) {
                sikerescountTeljes[i] = Double.valueOf(ev2009Sikeres[i] + ev2010Sikeres[i] + ev2011Sikeres[i] + ev2012Sikeres[i] + ev2013Sikeres[i] + ev2014Sikeres[i] + ev2015Sikeres[i] + ev2016Sikeres[i] + ev2017Sikeres[i] + ev2018Sikeres[i]);
                sikertelencountTeljes[i] = Double.valueOf(ev2009Sikertelen[i] + ev2010Sikertelen[i] + ev2011Sikertelen[i] + ev2012Sikertelen[i] + ev2013Sikertelen[i] + ev2014Sikertelen[i] + ev2015Sikertelen[i] + ev2016Sikertelen[i] + ev2017Sikertelen[i] + ev2018Sikertelen[i]);
                summvizsgaTeljes[i] = sikerescountTeljes[i] + sikertelencountTeljes[i];
                sikertelenAranyTeljes[i] = (sikertelencountTeljes[i] / summvizsgaTeljes[i]);

                kiir = (nyelvNeveSikertelen[i] + ";" + summvizsgaTeljes[i] + ";" + Math.round(sikertelenAranyTeljes[i] * 100.00) + "%");
                for (int o = 0; o < kiir.length(); o++) {
                    int kar = (int) kiir.charAt(o);
                    fw.write(kar);
                }


            }
            fw.close();
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }


    private static void voltNulla() {
        Integer[] sikerescount5 = new Integer[szamlaloSikeres];
        Integer[] sikertelencount5 = new Integer[szamlaloSikertelen];
        Integer[] summvizsga5 = new Integer[szamlaloSikertelen];
        Integer melyiknyelv = 0;
        for (int i = 0; i < szamlaloSikeres; i++) {
            sikerescount5[i] = (ev2014Sikeres[i]);
            sikertelencount5[i] = ((ev2014Sikertelen[i]));
            summvizsga5[i] = sikerescount5[i] + sikertelencount5[i];
            if (summvizsga5[i] == 0) {
                melyiknyelv = i;
                System.out.println("2014-ben " + nyelvNeveSikertelen[melyiknyelv] + " nyelvből nem volt egyetlen vizsgázó sem");
            } else {
                System.out.println("2014-ben minden nyelvből volt vizsgázó! ");
                break;
            }
        }
    }

    public static void felhasznaloEveSikertelenArany() {
        Double[] sikerescount4 = new Double[szamlaloSikeres];
        Double[] sikertelencount4 = new Double[szamlaloSikertelen];
        Double[] summvizsga4 = new Double[szamlaloSikertelen];
        Double[] sikertelenArany4 = new Double[szamlaloSikertelen];
        Double legrosszabb = 0.00;
        Integer melyiknyelv = 0;

        for (int i = 0; i < szamlaloSikeres; i++) {
            sikerescount4[i] = Double.valueOf(ev2014Sikeres[i]);
            sikertelencount4[i] = Double.valueOf((ev2014Sikertelen[i]));
            summvizsga4[i] = sikerescount4[i] + sikertelencount4[i];
            sikertelenArany4[i] = (sikertelencount4[i] / summvizsga4[i]);
            //System.out.println(nyelvNeveSikertelen[i] + ": " + Math.round(sikertelenArany4[i] * 100.0) / 100.0 + " , " + sikertelencount4[i] + " , " + sikerescount4[i]);
            if (legrosszabb < sikertelenArany4[i]) {
                legrosszabb = sikertelenArany4[i];
                melyiknyelv = i;
            }
        }
        System.out.println("A legmagasabb sikertelen arányú nyelv 2014-ben a(z):" + nyelvNeveSikertelen[melyiknyelv] + ", aránya a sikertelen vizsgáknak: " + Math.round(legrosszabb * 100.000) / 100.000 + "");
    }

    //Ez nem jött össze ezért a 2014-gyel megyek tovább!
    public static void felhasznaloEvet() {
        System.out.println("Kérlek adj meg egy évszámot 2009 és 2018 között, 'EEEE' formátumban.");
        Boolean joev = false;
        while (joev = true) {
            Scanner sc;
            sc = new Scanner(System.in);
            Integer felhasznaloEve;
            felhasznaloEve = sc.nextInt();
            while (joev = true) {
                if (felhasznaloEve < 2009 || felhasznaloEve > 2018) {
                    System.out.println("Nem jó évszámot adtál meg, adj meg egy évszámot 2009 és 2018 között! ");
                    Scanner sc2;
                    sc2 = new Scanner(System.in);
                    //Integer felhasznaloEve;
                    felhasznaloEve = sc2.nextInt();
                } else {
                    joev = true;
                    System.out.println("Köszönöm, a megadott évszám : " + felhasznaloEve + "!");
                    break;
                }
            }
            sc.close();
        }
    }

    private static void nyelvOsszegzes() {
        Integer[] sikerescount = new Integer[szamlaloSikeres];
        Integer[] sikertelencount = new Integer[szamlaloSikertelen];
        Integer[] summvizsga = new Integer[szamlaloSikertelen];
        for (int i = 0; i < szamlaloSikeres; i++) {
            sikerescount[i] = ev2009Sikeres[i] + ev2010Sikeres[i] + ev2011Sikeres[i] + ev2012Sikeres[i] + ev2013Sikeres[i] + ev2014Sikeres[i] + ev2015Sikeres[i] + ev2016Sikeres[i] + ev2017Sikeres[i] + ev2018Sikeres[i];
            sikertelencount[i] = ev2009Sikertelen[i] + ev2010Sikertelen[i] + ev2011Sikertelen[i] + ev2012Sikertelen[i] + ev2013Sikertelen[i] + ev2014Sikertelen[i] + ev2015Sikertelen[i] + ev2016Sikertelen[i] + ev2017Sikertelen[i] + ev2018Sikertelen[i];
            summvizsga[i] = sikerescount[i] + sikertelencount[i];
            //System.out.println(nyelvNeveSikeres[i] + ": " + summvizsga[i]);
        }
        Integer vizsgaszam01 = -1; //A legnépszerűbb nyelv vizsgaszáma
        Integer vizsgaszam02 = -1; //A második legnépszerűbb nyelv vizsgaszáma
        Integer vizsgaszam03 = -1; //A harmadik legnépszerűbb nyelv vizsgaszáma
        String vizsganev01 = ""; //A legnépszerűbb nyelv neve
        String vizsganev02 = ""; //A másodiklegnépszerűbb nyelv neve
        String vizsganev03 = ""; //A harmadik legnépszerűbb nyelv neve
        for (int i = 0; i < szamlaloSikeres; i++) {
            if (vizsgaszam01 < summvizsga[i]) {
                vizsgaszam01 = summvizsga[i];
                vizsganev01 = nyelvNeveSikeres[i];
            } else if (vizsgaszam02 < summvizsga[i] && summvizsga[i] < vizsgaszam01) {
                vizsgaszam02 = summvizsga[i];
                vizsganev02 = nyelvNeveSikeres[i];
            } else if (vizsgaszam03 < summvizsga[i] && summvizsga[i] < vizsgaszam02) {
                vizsgaszam03 = summvizsga[i];
                vizsganev03 = nyelvNeveSikeres[i];
            }
        }
        System.out.println("A három nyelv sorrendje: " + vizsganev01 + "(db: " + vizsgaszam01 + "), " + vizsganev02 + "(db: " + vizsgaszam02 + "), " + vizsganev03 + "(db: " + vizsgaszam03 + "). ");
    }

    private static void beolvasSikeres(String filename) {
        try {
            System.setProperty("file.encoding", "UTF8"); //karakterkódolás beállítása
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String egysor = "";
            br.readLine();
            while ((egysor = br.readLine()) != null) {
                //System.out.println(egysor);
                String darabokSikeres[] = egysor.split(";");
                nyelvNeveSikeres[szamlaloSikeres] = darabokSikeres[0];
                ev2009Sikeres[szamlaloSikeres] = Integer.valueOf(darabokSikeres[1]);
                ev2010Sikeres[szamlaloSikeres] = Integer.valueOf(darabokSikeres[2]);
                ev2011Sikeres[szamlaloSikeres] = Integer.valueOf(darabokSikeres[3]);
                ev2012Sikeres[szamlaloSikeres] = Integer.valueOf(darabokSikeres[4]);
                ev2013Sikeres[szamlaloSikeres] = Integer.valueOf(darabokSikeres[5]);
                ev2014Sikeres[szamlaloSikeres] = Integer.valueOf(darabokSikeres[6]);
                ev2015Sikeres[szamlaloSikeres] = Integer.valueOf(darabokSikeres[7]);
                ev2016Sikeres[szamlaloSikeres] = Integer.valueOf(darabokSikeres[8]);
                ev2017Sikeres[szamlaloSikeres] = Integer.valueOf(darabokSikeres[9]);
                ev2018Sikeres[szamlaloSikeres] = Integer.valueOf(darabokSikeres[10]);
                szamlaloSikeres++;
            }
            System.out.println("A " + filename + " állomány beolvasása megtörtént");
            br.close();
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }

    private static void beolvasSikertelen(String filename) {
        try {
            System.setProperty("file.encoding", "UTF8"); //karakterkódolás beállítása
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String egysor = "";
            br.readLine();
            while ((egysor = br.readLine()) != null) {
                //System.out.println(egysor);
                String darabokSikertelen[] = egysor.split(";");
                nyelvNeveSikertelen[szamlaloSikertelen] = darabokSikertelen[0];
                ev2009Sikertelen[szamlaloSikertelen] = Integer.valueOf(darabokSikertelen[1]);
                ev2010Sikertelen[szamlaloSikertelen] = Integer.valueOf(darabokSikertelen[2]);
                ev2011Sikertelen[szamlaloSikertelen] = Integer.valueOf(darabokSikertelen[3]);
                ev2012Sikertelen[szamlaloSikertelen] = Integer.valueOf(darabokSikertelen[4]);
                ev2013Sikertelen[szamlaloSikertelen] = Integer.valueOf(darabokSikertelen[5]);
                ev2014Sikertelen[szamlaloSikertelen] = Integer.valueOf(darabokSikertelen[6]);
                ev2015Sikertelen[szamlaloSikertelen] = Integer.valueOf(darabokSikertelen[7]);
                ev2016Sikertelen[szamlaloSikertelen] = Integer.valueOf(darabokSikertelen[8]);
                ev2017Sikertelen[szamlaloSikertelen] = Integer.valueOf(darabokSikertelen[9]);
                ev2018Sikertelen[szamlaloSikertelen] = Integer.valueOf(darabokSikertelen[10]);
                szamlaloSikertelen++;
            }
            System.out.println("A " + filename + " állomány beolvasása megtörtént");
            br.close();
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }
}
