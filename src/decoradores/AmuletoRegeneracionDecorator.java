package decoradores;

import estrategias.ResultadoAtaque;
import personajes.Personaje;

public class AmuletoRegeneracionDecorator extends PersonajeDecorator {
    private final int hpMaximo;

    // Equipa la Materia Regen y guarda el HP máximo
    public AmuletoRegeneracionDecorator(Personaje personaje) {
        super(personaje);
        this.hpMaximo = personaje.getHp();
    }

    // +3 de defensa
    @Override
    public int getDefensa() { return personaje.getDefensa() + 3; }

    // Recupera 2 HP en cada turno antes de atacar
    @Override
    public ResultadoAtaque atacarComo(Personaje atacante, Personaje objetivo) {
        // No se puede pasar del HP máximo
        setHp(Math.min(hpMaximo, getHp() + 2));
        ResultadoAtaque r = personaje.atacarComo(atacante, objetivo);
        return new ResultadoAtaque(r.getDano(), r.isCritico(), r.getEfecto() + " + regen");
    }

    // Agrega la materia a la descripción
    @Override
    public String getDescripcion() { return personaje.getDescripcion() + " + Materia Regen"; }
}
