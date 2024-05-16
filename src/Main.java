import Jeu.Pokemon;
import Jeu.elements.Air;
import Jeu.elements.Eau;
import Jeu.elements.Feu;
import Jeu.elements.terre;

public class Main {
    public static void main(String[] args) {

        Pokemon d = new Pokemon("rd",new Feu(),40,10);
        Pokemon c = new Pokemon("salamaeche",new Eau(),40,10);
        Pokemon a = new Pokemon("roche",new terre(),40,10);
        Pokemon b = new Pokemon("vent",new Air(),40,10);

        c.Attaquer(d);
        d.Attaquer(c);
        a.Attaquer(b);
        b.Attaquer(a);

        System.out.println(d.getVie());
        System.out.println(c.getVie());
    }
}