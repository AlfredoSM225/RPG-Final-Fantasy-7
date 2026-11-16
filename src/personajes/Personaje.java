package personajes;

import estrategias.EstrategiaAtaque;
import estrategias.ResultadoAtaque;

public interface Personaje {
    String getNombre();
    int getAtaque();
    int getDefensa();
    int getVelocidad();
    int getHp();
    void setHp(int hp);
    EstrategiaAtaque getEstrategia();
    void setEstrategia(EstrategiaAtaque estrategia);

    // Ataca al objetivo usando sus atributos actuales
    ResultadoAtaque atacar(Personaje objetivo);

    // Ataca indicando quién es el atacante (el personaje ya equipado)
    ResultadoAtaque atacarComo(Personaje atacante, Personaje objetivo);

    // Texto con el nombre y el equipamiento
    String getDescripcion();
}
