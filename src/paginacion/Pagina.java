/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paginacion;

/**
 *
 * @author Yulay
 */
public class Pagina {
    private String nombre;
    private int numPagina;
    private ProcesoPaginacion procesoPadre;

    public Pagina(String nombre, int numPagina, ProcesoPaginacion procesoPadre) {
        this.nombre = nombre;
        this.numPagina = numPagina;
        this.procesoPadre = procesoPadre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getNumPagina() {
        return numPagina;
    }

    public ProcesoPaginacion getProcesoPadre() {
        return procesoPadre;
    }
    
    
}

