package Jeu.elements;

public class Eau implements Element {

    @Override
    public String element(){
        return "eau";
    }

    @Override
    public String Getforcontre(){
        return "feu";
    }

    @Override
    public String Getfaible(){
        return "terre";
    }

    @Override
    public String toString() {
        return "eau";
    }
    }



