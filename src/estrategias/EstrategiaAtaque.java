package estrategias;

import personajes.Personaje;

public interface EstrategiaAtaque {
    // Calcula el resultado de un ataque del atacante sobre el objetivo
    ResultadoAtaque atacar(Personaje atacante, Personaje objetivo);
}
