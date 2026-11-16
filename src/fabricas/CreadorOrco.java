package fabricas;

import estrategias.AtaqueFlecha;
import personajes.Enemigo;
import personajes.Personaje;

public class CreadorOrco extends CreadorEnemigo {

    // Crea a Guard Scorpion con AtaqueFlecha
    @Override
    public Personaje crearEnemigo() {
        Personaje e = new Enemigo("Guard Scorpion", 150, 22, 18, 6);
        e.setEstrategia(new AtaqueFlecha());
        return e;
    }
}
