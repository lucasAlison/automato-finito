/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatos;

import java.util.ArrayList;
import java.util.HashMap;

public class Automato {
    private ArrayList<String> simbolos;
    private ArrayList<String> operadores;
    private ArrayList<Estado> estados;
    private Estado estadoInicial;
    private Estado estadoAtual;
    private Boolean ehInicio;
    private String resultado;
    private Long status;
    private String palavra;
    private HashMap<Long,String> mapStatus;

    public Automato(ArrayList<String> simbolos, ArrayList<String> operadores, ArrayList<Estado> estados, Estado estadoInicial) {
        this.simbolos = simbolos;
        this.operadores = operadores;
        this.estados = estados;
        this.estadoInicial = estadoInicial;
        this.estadoAtual = this.estadoInicial;
        this.ehInicio = true;
        this.mapStatus = new HashMap<>();
        this.mapStatus.put(1l,"Operador aritmético: ");
        this.mapStatus.put(2l,"ERRO: símbolo(s) inválido(s): ");
        this.mapStatus.put(3l,"ERRO: sentença inválida: ");
        this.mapStatus.put(4l,"sentença válida: ");
        this.palavra = "";
        this.status = null;
        this.resultado = "";
    }

    public ArrayList<Estado> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<Estado> estados) {
        this.estados = estados;
    }

    public Estado getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(Estado estadoInicial) {
        this.estadoInicial = estadoInicial;
    }
    
    public ArrayList<String> getSimbolos() {
        return simbolos;
    }

    public void setSimbolos(ArrayList<String> simbolos) {
        this.simbolos = simbolos;
    }

    public ArrayList<String> getOperadores() {
        return operadores;
    }

    public void setOperadores(ArrayList<String> operadores) {
        this.operadores = operadores;
    }
    
    private void resetar(){
        this.estadoAtual = this.estadoInicial;
        this.ehInicio = true;
        this.palavra = "";
        this.status = null;
    }
    
    public void Andar(String valor){        
        if (!simboloValido(valor)){
            if (this.palavra != null && !this.palavra.isEmpty()){
                resultado += mapStatus.get(this.status)+this.palavra+"\n";
            }
            resetar();
        }else{
            if (operadores.contains(valor)){     
                if (this.palavra != null && !this.palavra.isEmpty()){
                    resultado += mapStatus.get(this.status)+this.palavra+"\n";
                }
                resultado += mapStatus.get(1l)+valor+"\n";    
                resetar();
            }else{
                if (ehInicio){
                    if (!simbolos.contains(valor)){
                        this.ehInicio = false;
                        this.palavra += valor;
                        if (this.status == null  || this.status == 4l || this.status == 3l ){
                            this.status = 2l;
                        }
                    }else{
                        if (this.estadoAtual.getSaidas().contains(valor)){
                            this.estadoAtual = this.estadoAtual.getProximoEstado(valor);
                            this.palavra += valor;
                            if (this.status != null && this.status != 3l && this.status != 2l){
                                this.status = 4l;
                            }else if (this.status == null){
                                this.status = 4l;
                            }            
                        }else{
                            this.ehInicio = false;
                            this.palavra += valor;
                            this.status = 3l;
                        }
                    }
                }else{
                    if (!simbolos.contains(valor)){
                        this.ehInicio = false;
                        this.palavra += valor;
                        if (this.status == null || this.status == 4l || this.status == 3l ){
                            this.status = 2l;
                        }
                    }else{
                        if (this.estadoAtual.getSaidas().contains(valor)){
                            this.estadoAtual = this.estadoAtual.getProximoEstado(valor);
                            this.palavra += valor;
                            if (this.status != null && this.status != 3l && this.status != 2l){
                                this.status = 4l;
                            }else if (this.status == null){
                                this.status = 4l;
                            } 
                        }else{
                            this.ehInicio = false;
                            this.palavra += valor;
                            if (this.status == null || (this.status != null && this.status != 2l)){
                                this.status = 3l;
                            }                            
                        }
                    }
                }   
            }         
        }                
    }
    

    public String getResultado(){
        if (this.palavra != null && !this.palavra.isEmpty()){
            resultado += mapStatus.get(this.status)+this.palavra+"\n";
        }
        resetar();
        return this.resultado;
    }
    
    private Boolean simboloValido(String valor){
        if (valor.equals(" "))
            return false;
        if (valor.equals("\n"))
            return false;
        if (valor.equals("\t"))
            return false;
        return true;
    }
    
}
