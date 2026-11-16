package estrategias;

import java.util.Random;
import personajes.Personaje;

public class AtaqueFlecha implements EstrategiaAtaque {
    private final Random random = new Random();

    // Disparo a distancia (Barret y Guard Scorpion)
    @Override
    public ResultadoAtaque atacar(Personaje atacante, Personaje objetivo) {
        // Resta la mitad de la defensa del objetivo, mínimo 1
        int dano = Math.max(1, atacante.getAtaque() - objetivo.getDefensa() / 2);
        // 30% de probabilidad de crítico
        boolean critico = random.nextInt(100) < 30;
        if (critico) dano = dano * 3 / 2;
        return new ResultadoAtaque(dano, critico, "disparo");
    }
}
