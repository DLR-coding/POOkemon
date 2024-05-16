package Jeu.elements;

public class Air implements Element {

    @Override
    public String element(){
        return "air";
    }

    @Override
    public String Getforcontre(){
        return "terre";
    }

    @Override
    public String Getfaible(){
        return "feu";
    }

    @Override
    public String toString() {
        return "air";
    }
}
