package personajes;

public class Enemigo extends PersonajeBase {

    // Crea un enemigo con sus atributos iniciales
    public Enemigo(String nombre, int hp, int ataque, int defensa, int velocidad) {
        super(nombre, hp, ataque, defensa, velocidad);
    }

    // Los enemigos se muestran solo con su nombre
    @Override
    public String getDescripcion() { return getNombre(); }
}
