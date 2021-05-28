
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

interface Visitable {

    void accept(Visitor visitor);
}

interface Visitor {

    void verTren(Tren trenx);

    void verTramoIncidencia(Tramo tramox);

    void verEstacionIncidencia(Estacion estacionx);
}

class Controlador implements Visitor {

    public void verTren(Tren tren) {

        System.out.println("\n------------ " + tren.getName() + " ------------");
        System.out.println(" Tren ID: " + tren.getIdTren());
        System.out.println("Conductor ID " + tren.idChofer);
        if (tren.estado == null) {
            System.out.println("Estado actual " + tren.destino.nombre);

        } else {
            System.out.println("Estado actual  " + tren.estado);

        }

        System.out.println("------------------------------\n");

    }

    public void verTramoIncidencia(Tramo tramo) {
        Date date = new Date();
        //Obtener hora:
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("\n------- Incidencia de TRAMO ----------");
        System.out.println("Hora Incidencia: " + hourFormat.format(date) + "--");
        System.out.println("Distancia " + tramo.km + " KM");
        System.out.println("Velocidad " + tramo.kmph );
        System.out.println("Linea color " + tramo.color + "");

        if (tramo.contadorIncidencias == 1) {
            System.out.println("Incidencia LEVE");
            tramo.contadorIncidencias++;

        } else if (tramo.contadorIncidencias == 2) {
            System.out.println("Incidencia MODERADA");
            tramo.contadorIncidencias++;

        } else if (tramo.contadorIncidencias >= 3) {
            System.out.println("Incidencia ALTA");
            tramo.contadorIncidencias++;

        }
    }

    public void verEstacionIncidencia(Estacion estacion) {
        Date date = new Date();
        //Obtener hora:
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("\n------- Incidencia de ESTACION ----------");
        System.out.println("Nombre Estacion: " + estacion.nombre);
        System.out.println("Hora Incidencia: " + hourFormat.format(date) + "--");
        if (estacion.contadorIncidencias == 1 || estacion.contadorIncidencias == 2) {
            System.out.println("Incidencia LEVE");
            estacion.contadorIncidencias++;

        } else if (estacion.contadorIncidencias > 2 && estacion.contadorIncidencias < 5) {
            System.out.println("Incidencia MODERADA");
            estacion.contadorIncidencias++;

        } else if (estacion.contadorIncidencias >= 5) {
            System.out.println("Incidencia ALTA");
            estacion.contadorIncidencias++;

        }

    }
}

abstract class Monitor {

    // Add game related attributes and methods here
    public Monitor() {

    }

    // Donde se Relacionan las clases
    public void Incidencia1() {
        System.out.println("  Incidencia tipo 1");

        this.getName();
    }

    ;
    public void makeNextMove() {
    }

    public abstract String getName();
}

class Tramo extends Monitor implements Visitable {

    String kmph, km, color;
    int contadorIncidencias;

    public Tramo() {
    }

    public Tramo(String kmph, String km, String color) {
        this.kmph = kmph;
        this.km = km;
        this.color = color;
        contadorIncidencias = 1;

    }

    public int getContadorIncidencias() {
        return contadorIncidencias;
    }

    public void setContadorIncidencias(int contadorIncidencias) {
        this.contadorIncidencias = contadorIncidencias;
    }

    public String getKmph() {
        return kmph;
    }

    public void setKmph(String kmph) {
        this.kmph = kmph;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return Tramo.class.getName();
    }

    public void accept(Visitor visitor) {
        visitor.verTramoIncidencia(this);
    }
}

class Estacion extends Monitor implements Visitable {

    String nombre, incidencia;
    int contadorIncidencias;

    public Estacion() {
    }

    public Estacion(String nombre) {
        this.nombre = nombre;
        this.incidencia = "";
        contadorIncidencias = 1;

    }

    public int getContadorIncidencias() {
        return contadorIncidencias;
    }

    public void setContadorIncidencias(int contadorIncidencias) {
        this.contadorIncidencias = contadorIncidencias;
    }

    public String getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(String incidencia) {
        this.incidencia = incidencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getName() {
        return Estacion.class.getName();
    }

    public void accept(Visitor visitor) {
        visitor.verEstacionIncidencia(this);
    }
}


/**********************************************************************************************
*
* *
* *  Se utiliza la lista rutasViajes donde estan tanto estaciones como tramos
* *
* *  Se escoge un tren mediante un random en la lista de trenes
*   y se recorre rutasViajes hasta encontrar la estacion
*    de destino del tren, mediante el patron visitor se tiene al tanto el tren que acaba de salir
* *  como para incrementar las incidencias de estacion y de tramos de via 
* *  y poder clasificar la tasa de incidencias del sistema, la lista se recorre
*   hasta que ya no hayan trenes disponibles por lo que al principio las 
*  incidencias de algunas estaciones pueden ser mas bajas que otras dependiendo del tren, los
* resultados siempre van a ser diferentes 
* *   
* *
* *





/*/


public class VisitorPattern {

    public static void main(String args[]) {
        Visitor visitor = new Controlador();

        //--------------------------------------
        //       Estaciones
        //**************************************
        //(Capital, Belén, Heredia y Cartago)
        Estacion e1 = new Estacion("E-01");
        Tren tr1 = new Tren("codt:123", "ID1110078123", e1);
        Estacion e2 = new Estacion("E-02");
        Estacion e3 = new Estacion("E-03");
        Estacion e4 = new Estacion("E-04");
        Estacion e5 = new Estacion("E-05");
        Estacion e6 = new Estacion("E-06");
        Estacion e7 = new Estacion("E-07");
        Estacion e8 = new Estacion("E-08");
        Estacion e9 = new Estacion("E-09");
        Estacion e10 = new Estacion("E-10");
        Estacion e11 = new Estacion("Capital");
        Estacion e12 = new Estacion("Belen");
        Estacion e13 = new Estacion("Heredia");
        Estacion e14 = new Estacion("Cartago");
        //--------------------------------------
        //       Trenes
        //**************************************

        Tren tr2 = new Tren("codt:222", "ID220123421", e2);
        Tren tr3 = new Tren("codt:333", "ID33333", e3);
        Tren tr4 = new Tren("codt:444", "ID44450078123", e11);
        Tren tr5 = new Tren("codt:555", "ID50078123", e12);
        Tren tr6 = new Tren("codt:666", "ID6678123", e13);
        Tren tr7 = new Tren("codt:777", "ID777078123", e14);
        Tren tr8 = new Tren("codt:888", "ID888123", e6);
        Tren tr9 = new Tren("codt:999", "ID990078123", e10);
        //(Capital, Belén, Heredia y Cartago)

        //--------------------------------------
        //       Rutas
        //**************************************
        Tramo tramo1 = new Tramo("125kmph", "20km", "Rojo");
        Tramo tramo2 = new Tramo("105kmph", "120km", "Verde");
        Tramo tramo3 = new Tramo("75kmph", "216km", "Azul");
        Tramo tramo4 = new Tramo("25kmph", "28km", "Cafe");
        Tramo tramo5 = new Tramo("15kmph", "17km", "Amarillo");
        Tramo tramo6 = new Tramo("55kmph", "26km", "Plateado");
        Tramo tramo7 = new Tramo("80kmph", "80km", "Dorado");
        Tramo tramo8 = new Tramo("40kmph", "200km", "Gris");

        Visitable[] trenes = {tr1, tr2, tr3, tr4, tr5, tr6, tr7, tr8, tr9};

        int randomN = (int) (Math.random() * trenes.length);

        Visitable[] rutasViaje = {e13, tramo2, e1, e4, tramo1, e4, tramo3, tramo4, tramo5, e11, tramo7, tramo8, e12,
            e2, tramo1, e3, tramo6, e4, tramo6, e5, tramo2, e11};

        Tren tt = (Tren) trenes[randomN]; 
        int i = 0;
        while (i < trenes.length) {
                  //( Heredia, Capital, Belén y Cartago
            tt.estado = "En ruta";
            System.out.println("Tren " + tt.idTren + " Chofer " + tt.idChofer + " Estado " + tt.estado);
            for (Visitable v : rutasViaje) {
                if (tt.destino.equals(v.getClass())) {
                    tt.estado = tt.destino.nombre;
                    System.out.println("Tren " + tt.idTren + " Chofer " + tt.idChofer + " Estado " + tt.estado);

                }
                v.accept(visitor);
            }
            //( Heredia, Capital, Belén y Cartago

            i++;
        }

        // Ver estado actual de los trenes
        for (Visitable v : trenes) {

            v.accept(visitor);
        }
    }

}
