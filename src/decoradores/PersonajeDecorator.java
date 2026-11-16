package decoradores;

import estrategias.EstrategiaAtaque;
import estrategias.ResultadoAtaque;
import personajes.Personaje;

public abstract class PersonajeDecorator implements Personaje {

    protected final Personaje personaje;

    // Envuelve al personaje que se va a equipar
    public PersonajeDecorator(Personaje personaje) {
        this.personaje = personaje;
    }

    // Por defecto todo se delega al personaje envuelto
    @Override public String getNombre() { return personaje.getNombre(); }
    @Override public int getAtaque() { return personaje.getAtaque(); }
    @Override public int getDefensa() { return personaje.getDefensa(); }
    @Override public int getVelocidad() { return personaje.getVelocidad(); }
    @Override public int getHp() { return personaje.getHp(); }
    @Override public void setHp(int hp) { personaje.setHp(hp); }
    @Override public EstrategiaAtaque getEstrategia() { return personaje.getEstrategia(); }
    @Override public void setEstrategia(EstrategiaAtaque e) { personaje.setEstrategia(e); }
    @Override public String getDescripcion() { return personaje.getDescripcion(); }

    // El decorador externo se pasa a sí mismo para que el daño use los atributos equipados
    @Override
    public ResultadoAtaque atacar(Personaje objetivo) {
        return atacarComo(this, objetivo);
    }

    // Pasa el ataque hacia el personaje envuelto
    @Override
    public ResultadoAtaque atacarComo(Personaje atacante, Personaje objetivo) {
        return personaje.atacarComo(atacante, objetivo);
    }
}
