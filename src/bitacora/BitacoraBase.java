package bitacora;

import estrategias.ResultadoAtaque;
import personajes.Personaje;

public class BitacoraBase implements Bitacora {

    // Muestra el encabezado del combate
    @Override
    public void registrarInicio() {
        System.out.println("=== COMBATE INICIADO ===");
    }

    // Muestra el número de turno
    @Override
    public void registrarTurno(int turno) {
        System.out.println("\n--- TURNO " + turno + " ---");
    }

    // Muestra quién ataca, el daño, el efecto y el HP del defensor
    @Override
    public void registrarAtaque(Personaje atacante, Personaje defensor, ResultadoAtaque r, int hpAntes) {
        System.out.println(atacante.getDescripcion() + " usa "
            + atacante.getEstrategia().getClass().getSimpleName()
            + " sobre " + defensor.getNombre());
        System.out.println("    Daño: " + r.getDano() + " | Efecto: " + r.getEfecto());
        System.out.println("    " + defensor.getNombre() + " HP: " + hpAntes + " -> " + defensor.getHp());
    }

    // Muestra al ganador y su HP restante
    @Override
    public void registrarFin(Personaje heroe, Personaje enemigo, int turnos) {
        System.out.println("\n=== COMBATE FINALIZADO ===");
        if (heroe.getHp() > 0)
            System.out.println("Ganador: " + heroe.getDescripcion()
                + " (HP restante: " + heroe.getHp() + ")");
        else
            System.out.println("Ganador: " + enemigo.getNombre()
                + " (HP restante: " + enemigo.getHp() + ")");
    }
}
