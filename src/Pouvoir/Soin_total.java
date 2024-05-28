package Pouvoir;

import Game.Pokemon;

public class Soin_total implements Pouvoir {


    @Override
    public void Pouvoir(Pokemon p) { 
         p.setVie(p.getM_vieMax());
    }
}
