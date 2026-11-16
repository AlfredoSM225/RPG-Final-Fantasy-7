package bitacora;

import estrategias.ResultadoAtaque;
import java.util.LinkedHashMap;
import java.util.Map;
import personajes.Personaje;

public class BitacoraEstadisticasDecorator extends BitacoraDecorator {
    // Por cada personaje: [daño total, ataques, críticos]
    private final Map<String, int[]> estadisticas = new LinkedHashMap<>();

    // Agrega las estadísticas finales
    public BitacoraEstadisticasDecorator(Bitacora bitacora) {
        super(bitacora);
    }

    // Acumula el daño, los ataques y los críticos de cada personaje
    @Override
    public void registrarAtaque(Personaje atacante, Personaje defensor, ResultadoAtaque r, int hpAntes) {
        bitacora.registrarAtaque(atacante, defensor, r, hpAntes);
        int[] datos = estadisticas.computeIfAbsent(atacante.getNombre(), k -> new int[3]);
        datos[0] += r.getDano();
        datos[1]++;
        if (r.isCritico()) datos[2]++;
    }

    // Muestra el resumen al terminar el combate
    @Override
    public void registrarFin(Personaje heroe, Personaje enemigo, int turnos) {
        bitacora.registrarFin(heroe, enemigo, turnos);
        System.out.println("\n--- ESTADÍSTICAS FINALES ---");
        System.out.println("Turnos: " + turnos);
        for (Map.Entry<String, int[]> e : estadisticas.entrySet()) {
            int[] d = e.getValue();
            System.out.println(e.getKey() + ": daño total " + d[0]
                + " | ataques " + d[1] + " | críticos " + d[2]);
        }
    }
}
