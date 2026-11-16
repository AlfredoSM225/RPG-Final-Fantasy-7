package fabricas;

import estrategias.AtaqueHechizo;
import personajes.Enemigo;
import personajes.Personaje;

public class CreadorDragon extends CreadorEnemigo {

    // Crea a Bahamut con AtaqueHechizo
    @Override
    public Personaje crearEnemigo() {
        Personaje e = new Enemigo("Bahamut", 180, 18, 20, 14);
        e.setEstrategia(new AtaqueHechizo());
        return e;
    }
}
