package Game.Pouvoirs;

import Game.Pokemon;

public class Ferveur_guerrière implements Pouvoir  {

    @Override
    public void activatePouvoir(Pokemon p) {
        p.setM_attaque(p.getM_attaque() + 10);
        System.out.println(p.getM_attaque());
        p.setPouvoir(null);
    }

    @Override
    public String getNomPouvoir() {
        return "Ferveur_Guerriere";
    }

}
