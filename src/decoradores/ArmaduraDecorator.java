package decoradores;

import personajes.Personaje;

public class ArmaduraDecorator extends PersonajeDecorator {

    // Equipa el Brazalete de Mythril
    public ArmaduraDecorator(Personaje personaje) {
        super(personaje);
    }

    // +8 de defensa
    @Override
    public int getDefensa() { return personaje.getDefensa() + 8; }

    // Agrega la armadura a la descripción
    @Override
    public String getDescripcion() { return personaje.getDescripcion() + " + Brazalete de Mythril"; }
}
