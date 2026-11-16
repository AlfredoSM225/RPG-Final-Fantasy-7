package estrategias;

public class ResultadoAtaque {
    private final int dano;
    private final boolean critico;
    private final String efecto;

    // Guarda el daño, si fue crítico y el efecto del ataque
    public ResultadoAtaque(int dano, boolean critico, String efecto) {
        this.dano = dano;
        this.critico = critico;
        this.efecto = efecto;
    }

    // Getters
    public int getDano() { return dano; }
    public boolean isCritico() { return critico; }
    public String getEfecto() { return efecto; }
}
