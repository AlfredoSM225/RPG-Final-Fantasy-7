package estrategias;

import java.util.Random;
import personajes.Personaje;

public class AtaquePunalada implements EstrategiaAtaque {
    private final Random random = new Random();

    // Puñalada rápida (Yuffie y Soldado de Shinra)
    @Override
    public ResultadoAtaque atacar(Personaje atacante, Personaje objetivo) {
        // Resta toda la defensa del objetivo, mínimo 1
        int dano = Math.max(1, atacante.getAtaque() - objetivo.getDefensa());
        // 25% de probabilidad de crítico
        boolean critico = random.nextInt(100) < 25;
        if (critico) dano = dano * 2;
        return new ResultadoAtaque(dano, critico, "puñalada");
    }
}
