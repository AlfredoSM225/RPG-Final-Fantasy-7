package combate;

import bitacora.Bitacora;
import bitacora.BitacoraBase;
import estrategias.ResultadoAtaque;
import personajes.Personaje;

public class MotorCombate {
    private final Bitacora bitacora;

    // Usa la bitácora básica
    public MotorCombate() {
        this(new BitacoraBase());
    }

    // Usa la bitácora indicada (puede venir decorada)
    public MotorCombate(Bitacora bitacora) {
        this.bitacora = bitacora;
    }

    // Alterna turnos hasta que alguien se quede sin HP
    public void iniciarCombate(Personaje heroe, Personaje enemigo) {
        bitacora.registrarInicio();
        int turno = 1;
        while (heroe.getHp() > 0 && enemigo.getHp() > 0) {
            bitacora.registrarTurno(turno);
            ejecutarTurno(heroe, enemigo);
            if (enemigo.getHp() <= 0) break;
            ejecutarTurno(enemigo, heroe);
            if (heroe.getHp() <= 0) break;
            turno++;
        }
        bitacora.registrarFin(heroe, enemigo, turno);
    }

    // Un personaje ataca y el otro recibe el daño
    private void ejecutarTurno(Personaje atacante, Personaje defensor) {
        ResultadoAtaque r = atacante.atacar(defensor);
        // Se guarda el HP antes del golpe para mostrarlo en la bitácora
        int hpAntes = defensor.getHp();
        defensor.setHp(hpAntes - r.getDano());
        bitacora.registrarAtaque(atacante, defensor, r, hpAntes);
    }
}
