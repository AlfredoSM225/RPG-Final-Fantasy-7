package fabricas;

import estrategias.AtaquePuno;
import personajes.Personaje;
import personajes.PersonajeBase;

public class CreadorPeleador extends CreadorPersonaje {

    // Crea un personaje estilo Tifa con AtaquePuno
    @Override
    public Personaje crearPersonaje(String nombre) {
        validarNombre(nombre);
        Personaje p = new PersonajeBase(nombre, 110, 24, 11, 18);
        p.setEstrategia(new AtaquePuno());
        return p;
    }
}
