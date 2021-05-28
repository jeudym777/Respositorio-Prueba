/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yeudi MS
 */
public class Tren extends Monitor implements Visitable{
        String idTren,idChofer;
        Estacion destino;
        String estado;// en ruta// detenido// destino
    public Tren() {
       
    }

    public Tren(String idTren, String idChofer, Estacion destino) {
        this.idTren = idTren;
        this.idChofer = idChofer;
        this.destino = destino;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdTren() {
        return idTren;
    }

    public void setIdTren(String idTren) {
        this.idTren = idTren;
    }

    public String getIdChofer() {
        return idChofer;
    }

    public void setIdChofer(String idChofer) {
        this.idChofer = idChofer;
    }

    public Estacion getDestino() {
        return destino;
    }

    public void setDestino(Estacion destino) {
        this.destino = destino;
    }
    
    
    public String getName(){
        return Tren.class.getName();
    }
   
    
    public void accept(Visitor visitor){
        visitor.verTren(this);
    }
}
