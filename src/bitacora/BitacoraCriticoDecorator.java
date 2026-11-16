package bitacora;

import estrategias.ResultadoAtaque;
import personajes.Personaje;

public class BitacoraCriticoDecorator extends BitacoraDecorator {

    // Agrega el detalle de golpes críticos
    public BitacoraCriticoDecorator(Bitacora bitacora) {
        super(bitacora);
    }

    // Avisa cuando un ataque fue crítico
    @Override
    public void registrarAtaque(Personaje atacante, Personaje defensor, ResultadoAtaque r, int hpAntes) {
        bitacora.registrarAtaque(atacante, defensor, r, hpAntes);
        if (r.isCritico())
            System.out.println("    ¡CRÍTICO! " + atacante.getNombre() + " encontró un punto débil");
    }
}
