public class Pokemon
{
    private String m_nom;
    private int m_health;
    private int m_atk;

    public Pokemon(String nom , int ptsvie , int ptsatk)
    {
        m_nom= nom;
        m_health=ptsvie;
        m_atk = ptsatk;
    }

    public void attaque(Pokemon other) {
        if (other != null && other.getHealth() > 0 )
        {
            other.m_health -= this.m_atk;
        }
    }

    public int getHealth() {
        return m_health;
    }
    public String getNom() {
        return m_nom;
    }

    public int getatk()
    {
        return m_atk;
    }

}
