package fabricas;

import estrategias.AtaquePunalada;
import personajes.Personaje;
import personajes.PersonajeBase;

public class CreadorPicaro extends CreadorPersonaje {

    // Crea un personaje estilo Yuffie con AtaquePunalada
    @Override
    public Personaje crearPersonaje(String nombre) {
        validarNombre(nombre);
        Personaje p = new PersonajeBase(nombre, 90, 18, 8, 22);
        p.setEstrategia(new AtaquePunalada());
        return p;
    }
}
