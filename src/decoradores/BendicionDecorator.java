package decoradores;

import personajes.Personaje;

public class BendicionDecorator extends PersonajeDecorator {

    // Aplica la bendición de la Corriente Vital
    public BendicionDecorator(Personaje personaje) {
        super(personaje);
    }

    // +15% de ataque, redondeado
    @Override
    public int getAtaque() { return (int) Math.round(personaje.getAtaque() * 1.15); }

    // +15% de defensa, redondeado
    @Override
    public int getDefensa() { return (int) Math.round(personaje.getDefensa() * 1.15); }

    // +15% de velocidad, redondeado
    @Override
    public int getVelocidad() { return (int) Math.round(personaje.getVelocidad() * 1.15); }

    // Agrega la bendición a la descripción
    @Override
    public String getDescripcion() { return personaje.getDescripcion() + " + Corriente Vital"; }
}
