/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paginacion;

import java.util.ArrayList;

/**
 *
 * @author Yulay
 */
public class ProcesoPaginacion {
    
    private Pagina[] paginas;
    private String nombre;
    private int id;
    private int miss; 
    private int hits;

    /** Construtor **/
    public ProcesoPaginacion(int numPaginas, int numeroProceso) {
        this.paginas = new Pagina[numPaginas];
        this.miss = 0;
        this.hits = 0;
        this.nombre = "Proceso " + numeroProceso;
        this.id = numeroProceso;
        
        llenarPaginas(numPaginas);
    }
    
    /** Crea las paginas que va a tener el proceso **/
    private void llenarPaginas(int numPaginas){
        for (int i = 0; i<numPaginas; i++){
            Pagina nuevaPagina = new Pagina(this.nombre+"-"+Character.toString((char) (65+i)), i, this);
            
            this.paginas[i]= nuevaPagina;
            
        }
    }
    
    
    /** Retorna el resultado de subir las paginas a RAM **/
    public String imprimir(int paginasSubidasRam, int tiempoRam, int tiempoHDD){
        
        return "Nombre: "+ nombre + 
        "\nMiss: " + miss + 
        "\nHits: " + hits +
        "\nCantidad de pag subidas a Ram: "+ paginasSubidasRam+
        "\nCantidad de pag en Ram: " + (paginas.length-paginasSubidasRam)+
        "\nTiempo estimado para subir pag a Ram: " +tiempoHDD + "mls"+
        "\nTiempo estimado de busquedad de pag en Ram: " +tiempoRam + "mls"+
        "\nTiempo total para tener proceso completo en Ram: " 
        +(paginasSubidasRam*tiempoHDD + tiempoRam /** (paginas.length-paginasSubidasRam)*/) + "mls";
    }
    
    /** Metodo llamado para que actualice los MITS Y HITS **/
    public String actualizarProceso(int paginasSubidasRam, int tiempoRam, int tiempoHDD){
        
        if(paginasSubidasRam == 0)
        {
            hits++;
            return imprimir(paginasSubidasRam, tiempoRam, tiempoHDD);
        }
        else if(paginasSubidasRam == paginas.length)
        {
            miss++;
            return imprimir(paginasSubidasRam, tiempoRam, tiempoHDD);
        }
        else{
            hits++;
            miss++;
            return imprimir(paginasSubidasRam, tiempoRam, tiempoHDD);
        }
        
    }
    
    
    /** METODOS POR DEFECTO QUE RETORNAN LOS VALORES DE LOS ATRIBUTOS**/
    
    
    public void addHist(){
        this.hits++;
    }
    
    public void addMiss(){
        this.miss++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMiss() {
        return miss;
    }

    public int getHits() {
        return hits;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Pagina> getPaginas() {
        ArrayList<Pagina> paginasExportar = new ArrayList<Pagina>();

        for (int i = 0; i< paginas.length; i++){
            paginasExportar.add(paginas[i]);
        }
        return paginasExportar;
    }
    
      
}
