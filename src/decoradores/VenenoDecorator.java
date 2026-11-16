package decoradores;

import estrategias.ResultadoAtaque;
import personajes.Personaje;

public class VenenoDecorator extends PersonajeDecorator {

    // Equipa la Materia Veneno
    public VenenoDecorator(Personaje personaje) {
        super(personaje);
    }

    // +5 de ataque
    @Override
    public int getAtaque() { return personaje.getAtaque() + 5; }

    // Agrega 3 de daño de veneno a cada ataque
    @Override
    public ResultadoAtaque atacarComo(Personaje atacante, Personaje objetivo) {
        ResultadoAtaque r = personaje.atacarComo(atacante, objetivo);
        // Se crea un nuevo resultado con el daño extra y el efecto agregado
        return new ResultadoAtaque(r.getDano() + 3, r.isCritico(), r.getEfecto() + " + veneno");
    }

    // Agrega la materia a la descripción
    @Override
    public String getDescripcion() { return personaje.getDescripcion() + " + Materia Veneno"; }
}
