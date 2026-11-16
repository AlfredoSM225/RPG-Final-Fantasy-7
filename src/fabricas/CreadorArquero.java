package fabricas;

import estrategias.AtaqueFlecha;
import personajes.Personaje;
import personajes.PersonajeBase;

public class CreadorArquero extends CreadorPersonaje {

    // Crea un personaje estilo Barret con AtaqueFlecha
    @Override
    public Personaje crearPersonaje(String nombre) {
        validarNombre(nombre);
        Personaje p = new PersonajeBase(nombre, 130, 22, 12, 10);
        p.setEstrategia(new AtaqueFlecha());
        return p;
    }
}
