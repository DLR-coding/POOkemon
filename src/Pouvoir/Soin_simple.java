package Pouvoir;

import Game.Pokemon;

public class Soin_simple implements Pouvoir {

    @Override
    public void Pouvoir(Pokemon p) {
        if(p.getVie() + 30 < p.getM_vieMax()) {
            p.setVie(p.getVie() + 30);
        }
    }
}
