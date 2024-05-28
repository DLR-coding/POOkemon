package Game.Pouvoirs;

import Game.Pokemon;

public class Intimidation implements Pouvoir {
    
    @Override
    public void activatePouvoir(Pokemon p) {
        p.setM_attaque(p.getM_attaque() /2);

    }

    public void RetourALanormal(Pokemon p){
      p.setVie(p.getM_attaque() * 2);
      p.setPouvoir(null);
    }

    @Override
    public String getNomPouvoir() {
        return "Soin_simple";
    }
}
