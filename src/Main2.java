public class Main {
    public static void main(String[] args) {

        pokemon d = new pokemon("rd",new feu(),40,10);
        pokemon c = new pokemon("salamaeche",new eau(),40,10);
        pokemon a = new pokemon("roche",new terre(),40,10);
        pokemon b = new pokemon("vent",new air(),40,10);

        c.Attaquer(d);
        d.Attaquer(c);
        a.Attaquer(b);
        b.Attaquer(a);

        System.out.println(d.getVie());
        System.out.println(c.getVie());
    }
}
