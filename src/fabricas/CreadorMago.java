package fabricas;

import estrategias.AtaqueHechizo;
import personajes.Personaje;
import personajes.PersonajeBase;

public class CreadorMago extends CreadorPersonaje {

    // Crea un personaje estilo Aerith con AtaqueHechizo
    @Override
    public Personaje crearPersonaje(String nombre) {
        validarNombre(nombre);
        Personaje p = new PersonajeBase(nombre, 100, 20, 10, 15);
        p.setEstrategia(new AtaqueHechizo());
        return p;
    }
}
