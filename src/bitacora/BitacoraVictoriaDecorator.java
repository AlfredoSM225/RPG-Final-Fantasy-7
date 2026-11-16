package bitacora;

import personajes.Personaje;

public class BitacoraVictoriaDecorator extends BitacoraDecorator {

    // Agrega la marca de victoria o derrota
    public BitacoraVictoriaDecorator(Bitacora bitacora) {
        super(bitacora);
    }

    // Muestra VICTORIA o GAME OVER según quién ganó
    @Override
    public void registrarFin(Personaje heroe, Personaje enemigo, int turnos) {
        bitacora.registrarFin(heroe, enemigo, turnos);
        if (heroe.getHp() > 0)
            System.out.println("\n*** ¡VICTORIA! " + heroe.getNombre() + " derrotó a " + enemigo.getNombre() + " ***");
        else
            System.out.println("\n*** GAME OVER: " + heroe.getNombre() + " cayó en combate ***");
    }
}
