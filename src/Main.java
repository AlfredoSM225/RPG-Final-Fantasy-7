import bitacora.*;
import combate.MotorCombate;
import decoradores.*;
import fabricas.*;
import personajes.Personaje;

import java.util.Scanner;

public class Main {
    // Menú del juego: crea al héroe, lo equipa y lo pone a combatir
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String otra;

        // Se repite mientras el jugador quiera otra batalla
        do {
            System.out.println("=== FINAL FANTASY VII: BATALLA EN MIDGAR ===");

            System.out.println("Personajes: 1. Cloud (Guerrero)  2. Aerith (Mago)  3. Barret (Arquero)  4. Yuffie (Pícaro)  5. Tifa (Peleador)");
            System.out.print("Personaje: ");
            int clase = Integer.parseInt(sc.nextLine().trim());

            System.out.println("Equipamiento: 1. Buster Sword  2. Brazalete de Mythril  3. Materia Veneno  4. Materia Regen  5. Corriente Vital");
            System.out.print("Equipamiento (ej. 1,3,5 o vacío): ");
            String equipo = sc.nextLine();

            System.out.println("Enemigos: 1. Soldado de Shinra  2. Guard Scorpion  3. Bahamut");
            System.out.print("Enemigo: ");
            int opcionEnemigo = Integer.parseInt(sc.nextLine().trim());

            System.out.println();

            // Factory Method
            CreadorPersonaje creador;
            String nombre;
            switch (clase) {
                case 1: creador = new CreadorGuerrero(); nombre = "Cloud"; break;
                case 2: creador = new CreadorMago(); nombre = "Aerith"; break;
                case 3: creador = new CreadorArquero(); nombre = "Barret"; break;
                case 4: creador = new CreadorPicaro(); nombre = "Yuffie"; break;
                default: creador = new CreadorPeleador(); nombre = "Tifa"; break;
            }
            Personaje heroe = creador.crearPersonaje(nombre);

            // Decorator: cada objeto envuelve al personaje anterior
            for (String op : equipo.split(",")) {
                switch (op.trim()) {
                    case "1": heroe = new EspadaDecorator(heroe); break;
                    case "2": heroe = new ArmaduraDecorator(heroe); break;
                    case "3": heroe = new VenenoDecorator(heroe); break;
                    case "4": heroe = new AmuletoRegeneracionDecorator(heroe); break;
                    case "5": heroe = new BendicionDecorator(heroe); break;
                }
            }

            System.out.println("Héroe: " + heroe.getDescripcion());
            System.out.println("ATK: " + heroe.getAtaque()
                    + " | DEF: " + heroe.getDefensa()
                    + " | VEL: " + heroe.getVelocidad()
                    + " | HP: " + heroe.getHp());

            CreadorEnemigo creadorEnemigo;
            switch (opcionEnemigo) {
                case 2: creadorEnemigo = new CreadorOrco(); break;
                case 3: creadorEnemigo = new CreadorDragon(); break;
                default: creadorEnemigo = new CreadorGoblin(); break;
            }
            Personaje enemigo = creadorEnemigo.crearEnemigo();
            System.out.println("Enemigo: " + enemigo.getNombre()
                    + " | HP: " + enemigo.getHp());
            System.out.println();

            // Bitácora enriquecida con Decorator (todos los detalles activos)
            Bitacora bitacora = new BitacoraBase();
            bitacora = new BitacoraCriticoDecorator(bitacora);
            bitacora = new BitacoraResistenciaDecorator(bitacora);
            bitacora = new BitacoraEstadisticasDecorator(bitacora);
            bitacora = new BitacoraVictoriaDecorator(bitacora);

            // Strategy + combate
            new MotorCombate(bitacora).iniciarCombate(heroe, enemigo);

            System.out.print("\n¿Otra batalla? (s/n): ");
            otra = sc.nextLine().trim();
            System.out.println();
        } while (otra.equalsIgnoreCase("s"));
    }
}