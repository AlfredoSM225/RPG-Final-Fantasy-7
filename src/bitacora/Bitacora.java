package bitacora;

import estrategias.ResultadoAtaque;
import personajes.Personaje;

public interface Bitacora {
    // Registra el inicio del combate
    void registrarInicio();

    // Registra el número de turno
    void registrarTurno(int turno);

    // Registra un ataque y el HP del defensor
    void registrarAtaque(Personaje atacante, Personaje defensor, ResultadoAtaque r, int hpAntes);

    // Registra el final del combate
    void registrarFin(Personaje heroe, Personaje enemigo, int turnos);
}
