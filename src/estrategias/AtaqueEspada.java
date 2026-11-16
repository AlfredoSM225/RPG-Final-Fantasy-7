package estrategias;

import java.util.Random;
import personajes.Personaje;

public class AtaqueEspada implements EstrategiaAtaque {
    private final Random random = new Random();

    // Corte de espada (Cloud)
    @Override
    public ResultadoAtaque atacar(Personaje atacante, Personaje objetivo) {
        // Resta la mitad de la defensa del objetivo, mínimo 1
        int dano = Math.max(1, atacante.getAtaque() - objetivo.getDefensa() / 2);
        // 20% de probabilidad de crítico
        boolean critico = random.nextInt(100) < 20;
        if (critico) dano = dano * 2;
        return new ResultadoAtaque(dano, critico, "corte de espada");
    }
}
