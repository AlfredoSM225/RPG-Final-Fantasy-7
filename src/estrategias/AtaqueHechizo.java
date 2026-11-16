package estrategias;

import java.util.Random;
import personajes.Personaje;

public class AtaqueHechizo implements EstrategiaAtaque {
    private final Random random = new Random();

    // Hechizo de magia (Aerith y Bahamut)
    @Override
    public ResultadoAtaque atacar(Personaje atacante, Personaje objetivo) {
        // La magia ignora la defensa del objetivo
        int dano = atacante.getAtaque();
        // 10% de probabilidad de crítico
        boolean critico = random.nextInt(100) < 10;
        if (critico) dano = dano * 3 / 2;
        return new ResultadoAtaque(dano, critico, "hechizo");
    }
}
