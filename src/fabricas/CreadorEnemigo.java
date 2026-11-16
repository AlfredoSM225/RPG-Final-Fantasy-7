package fabricas;

import personajes.Personaje;

public abstract class CreadorEnemigo {
    // Cada subclase decide qué enemigo crear (Factory Method)
    public abstract Personaje crearEnemigo();
}
