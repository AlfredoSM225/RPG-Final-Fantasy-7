package estrategias;

import java.util.Random;
import personajes.Personaje;

public class AtaquePuno implements EstrategiaAtaque {
    private final Random random = new Random();

    // Combo de dos puñetazos (Tifa)
    @Override
    public ResultadoAtaque atacar(Personaje atacante, Personaje objetivo) {
        // Dos golpes, cada uno con la mitad del ataque
        int golpe = Math.max(1, atacante.getAtaque() / 2 - objetivo.getDefensa() / 4);
        int dano = golpe * 2;
        // 15% de probabilidad de crítico
        boolean critico = random.nextInt(100) < 15;
        if (critico) dano = dano * 2;
        return new ResultadoAtaque(dano, critico, "combo de puños");
    }
}
