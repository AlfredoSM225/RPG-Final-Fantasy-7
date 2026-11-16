package fabricas;

import estrategias.AtaquePunalada;
import personajes.Enemigo;
import personajes.Personaje;

public class CreadorGoblin extends CreadorEnemigo {

    // Crea a Soldado de Shinra con AtaquePunalada
    @Override
    public Personaje crearEnemigo() {
        Personaje e = new Enemigo("Soldado de Shinra", 60, 10, 12, 8);
        e.setEstrategia(new AtaquePunalada());
        return e;
    }
}
