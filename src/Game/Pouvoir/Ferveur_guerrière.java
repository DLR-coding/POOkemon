package Game.Pouvoir;

import Game.Pokemon;

public class Ferveur_guerrière implements Pouvoir {
    @Override
    public void activatePouvoir(Pokemon p) {
        p.setM_attaque(p.getM_attaque() + 10);
    }

    @Override
    public String getNomPouvoir() {
        return "Ferveur_Guerriere";
    }

}
