package personajes;

import estrategias.EstrategiaAtaque;
import estrategias.ResultadoAtaque;

public class PersonajeBase implements Personaje {
    private final String nombre;
    private int hp;
    private final int ataque;
    private final int defensa;
    private final int velocidad;
    private EstrategiaAtaque estrategia;

    // Crea el personaje con sus atributos iniciales
    public PersonajeBase(String nombre, int hp, int ataque, int defensa, int velocidad) {
        this.nombre = nombre;
        this.hp = hp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
    }

    // Getters y setters
    @Override public String getNombre() { return nombre; }
    @Override public int getAtaque() { return ataque; }
    @Override public int getDefensa() { return defensa; }
    @Override public int getVelocidad() { return velocidad; }
    @Override public int getHp() { return hp; }
    @Override public void setHp(int hp) { this.hp = Math.max(0, hp); }
    @Override public EstrategiaAtaque getEstrategia() { return estrategia; }
    @Override public void setEstrategia(EstrategiaAtaque e) { this.estrategia = e; }

    // Ataca usándose a sí mismo como atacante
    @Override
    public ResultadoAtaque atacar(Personaje objetivo) {
        return atacarComo(this, objetivo);
    }

    // Delega el cálculo del daño en la estrategia (Strategy)
    @Override
    public ResultadoAtaque atacarComo(Personaje atacante, Personaje objetivo) {
        return estrategia.atacar(atacante, objetivo);
    }

    // Nombre del personaje sin equipo
    @Override
    public String getDescripcion() { return nombre + " (base)"; }
}
