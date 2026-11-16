package bitacora;

import estrategias.ResultadoAtaque;
import personajes.Personaje;

public abstract class BitacoraDecorator implements Bitacora {

    protected final Bitacora bitacora;

    // Envuelve la bitácora que se va a enriquecer
    public BitacoraDecorator(Bitacora bitacora) {
        this.bitacora = bitacora;
    }

    // Por defecto todo se delega a la bitácora envuelta
    @Override public void registrarInicio() { bitacora.registrarInicio(); }
    @Override public void registrarTurno(int turno) { bitacora.registrarTurno(turno); }

    @Override
    public void registrarAtaque(Personaje atacante, Personaje defensor, ResultadoAtaque r, int hpAntes) {
        bitacora.registrarAtaque(atacante, defensor, r, hpAntes);
    }

    @Override
    public void registrarFin(Personaje heroe, Personaje enemigo, int turnos) {
        bitacora.registrarFin(heroe, enemigo, turnos);
    }
}
