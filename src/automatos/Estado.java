/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatos;

import java.util.HashMap;

/**
 *
 * @author pc
 */
public class Estado {
    private Boolean ehFinal;    
    private String saidas;
    private HashMap<String, Estado> proximosEstados;

    public Estado(Boolean ehFinal, String saidas) {
        this.ehFinal = ehFinal;
        this.saidas = saidas;
        this.proximosEstados = new HashMap<>();
    }    
    
    public Boolean getEhFinal() {
        return ehFinal;
    }

    public void setEhFinal(Boolean ehFinal) {
        this.ehFinal = ehFinal;
    }

    public String getSaidas() {
        return saidas;
    }

    public void setSaidas(String saidas) {
        this.saidas = saidas;
    }
    
    public void addProximoEstado(Estado estado, String chave){
        this.proximosEstados.put(chave, estado);
    }
    
    public Estado getProximoEstado(String chave){
        return this.proximosEstados.get(chave);
    }
}
