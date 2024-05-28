package Pouvoir;

import Game.Pokemon;

public class Intimidation implements Pouvoir {
    @Override
    public void Activation(Pokemon p) {
        p.setM_attaque(p.getM_attaque() /2);

    }

    public void RetourALanormal(Pokemon p){
      p.setVie(p.getM_attaque() * 2);
      p.setM_pouvoir(null);
    }
}
