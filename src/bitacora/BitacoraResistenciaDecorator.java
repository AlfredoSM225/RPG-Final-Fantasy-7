package bitacora;

import estrategias.ResultadoAtaque;
import personajes.Personaje;

public class BitacoraResistenciaDecorator extends BitacoraDecorator {

    // Agrega el detalle de resistencia
    public BitacoraResistenciaDecorator(Bitacora bitacora) {
        super(bitacora);
    }

    // Muestra la defensa del que recibe el ataque
    @Override
    public void registrarAtaque(Personaje atacante, Personaje defensor, ResultadoAtaque r, int hpAntes) {
        bitacora.registrarAtaque(atacante, defensor, r, hpAntes);
        System.out.println("    Resistencia: " + defensor.getNombre() + " tiene DEF " + defensor.getDefensa());
    }
}
