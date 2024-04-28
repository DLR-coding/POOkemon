public class Main
{
  public static void main(String args[])
  {
    System.out.println("Lancement du jeu ...");
    // Création des Pokémon
    Pokemon pikachu = new Pokemon("Pikachu", 100, 20);
    Pokemon bulbizarre = new Pokemon("Bulbizarre", 120, 15);

    // Affichage de la santé initiale des Pokémon
    System.out.println(pikachu.getNom() + " a une santé de : " + pikachu.getHealth());
    System.out.println(bulbizarre.getNom() + " a une santé de : " + bulbizarre.getHealth());

    // Pikachu attaque Bulbizarre
    pikachu.attaque(bulbizarre);

    // Affichage de la santé après l'attaque
    System.out.println(pikachu.getNom() + " a attaqué " + bulbizarre.getNom() + ". Santé de " + bulbizarre.getNom().toString() + " -"+ pikachu.getatk());
    System.out.println(bulbizarre.getNom() + " a maintenant une santé de : " + bulbizarre.getHealth());
  }
}
