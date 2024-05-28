package Pouvoir;

import Game.Pokemon;

public class Ferveur_guerrière implements Pouvoir {
    @Override
    public void Pouvoir(Pokemon p) {
        p.setM_attaque(p.getM_attaque() + 10);
    }
}
