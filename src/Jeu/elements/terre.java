package Jeu.elements;

public class terre implements Element {

    @Override
    public String element(){
        return "terre";
    }

    @Override
    public String Getforcontre(){
        return "eau";
    }

    @Override
    public String Getfaible(){
        return "air";
    }

    @Override
    public String toString() {
        return "terre";
    }
}
