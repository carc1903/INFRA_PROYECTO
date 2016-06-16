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
public class Memoria {
    
    private ArrayList<Pagina> campos= new ArrayList<Pagina>();
    private int tiempoVerificacion;
    private int tope;

    public Memoria(int tiempoVerificacion, int tope) {
        this.tiempoVerificacion = tiempoVerificacion;
        this.tope = tope;
    }

    public String[] getNombres(){
        int cantPaginas = this.campos.size();
        String[] nombres = new String[cantPaginas];
        
        for (int i = 0; i < cantPaginas; i++){
            nombres[i]= this.campos.get(i).getNombre();
        }
        
        return nombres;
    }
    
    public ArrayList<Pagina> sacarDeMemoria(ProcesoPaginacion procesoPadre){
        ArrayList<Pagina> paginasProceso = new ArrayList<Pagina>();
        for (int i = 0; i<this.campos.size(); i++){
            if (this.campos.get(i).getProcesoPadre().getId() == procesoPadre.getId()){
                paginasProceso.add(this.campos.get(i));
                campos.remove(campos.get(i));
                i--;
            }         
        }
        return paginasProceso;
    }
    
    public ArrayList<Pagina> meterEnMemoria(ArrayList<Pagina> nuevasPaginas){
        ArrayList<Pagina> paginasSacadas = new ArrayList<Pagina>();
        return meterEnMemoria_aux(nuevasPaginas,paginasSacadas); 
    }
    
    private ArrayList<Pagina> meterEnMemoria_aux(ArrayList<Pagina> nuevasPaginas, ArrayList<Pagina> paginasSacadas){
        
        if (nuevasPaginas.size() != 0)
        {   
            if (nuevasPaginas.size() <= camposVacios() )
            {
               // ArrayList<Pagina> camposSimilares = sacarDeMemoria(nuevasPaginas.get(0).getProcesoPadre());
                //nuevasPaginas.addAll(camposSimilares);
                nuevasPaginas.addAll(campos);  
                this.campos = nuevasPaginas;
            }
            else{
                
                int camposLimpiar = nuevasPaginas.size() - camposVacios();
                for (int i = 0; i<camposLimpiar; i++){
                    Pagina pag = campos.get(campos.size()-1);
                    /*if (pag.getProcesoPadre().getId() == nuevasPaginas.get(0).getProcesoPadre().getId()){
                        campos.remove(pag);
                        ArrayList<Pagina> nuevosCampos = new ArrayList<Pagina>();
                        nuevosCampos.add(pag);
                        nuevosCampos.addAll(campos);  
                        campos = nuevosCampos;
                        i--;
                    }
                    else {*/
                        paginasSacadas.add(pag);
                        campos.remove(pag);
                    //}
                }
                meterEnMemoria_aux(nuevasPaginas,paginasSacadas);
            }
        }
        return paginasSacadas;
    }
    
    private int camposVacios(){
        return this.tope - this.campos.size();
    }

    public int getTiempoVerificacion() {
        return tiempoVerificacion;
    }

    public int getTope() {
        return tope;
    }
    
    
    
    
    
}
