package fabricas;

import personajes.Personaje;

public abstract class CreadorPersonaje {
    // Cada subclase decide qué personaje crear (Factory Method)
    public abstract Personaje crearPersonaje(String nombre);

    // Valida que el nombre no esté vacío
    protected void validarNombre(String nombre) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("El nombre no puede estar vacío");
    }
}
