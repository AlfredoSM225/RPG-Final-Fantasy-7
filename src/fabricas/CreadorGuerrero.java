package fabricas;

import estrategias.AtaqueEspada;
import personajes.Personaje;
import personajes.PersonajeBase;

public class CreadorGuerrero extends CreadorPersonaje {

    // Crea un personaje estilo Cloud con AtaqueEspada
    @Override
    public Personaje crearPersonaje(String nombre) {
        validarNombre(nombre);
        Personaje p = new PersonajeBase(nombre, 120, 25, 15, 12);
        p.setEstrategia(new AtaqueEspada());
        return p;
    }
}
