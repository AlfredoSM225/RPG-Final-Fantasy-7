package decoradores;

import personajes.Personaje;

public class EspadaDecorator extends PersonajeDecorator {

    // Equipa la Buster Sword
    public EspadaDecorator(Personaje personaje) {
        super(personaje);
    }

    // +10 de ataque
    @Override
    public int getAtaque() { return personaje.getAtaque() + 10; }

    // Agrega el arma a la descripción
    @Override
    public String getDescripcion() { return personaje.getDescripcion() + " + Buster Sword"; }
}
