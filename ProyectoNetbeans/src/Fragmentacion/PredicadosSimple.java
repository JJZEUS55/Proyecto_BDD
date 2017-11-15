/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fragmentacion;

/**
 *
 * @author usuario
 */
public class PredicadosSimple {
    private String tabla;
    private String atributo;
    private String operador;
    private String valor;


    public PredicadosSimple(String atributo, String operador, String valor, String tabla) {
        this.tabla = tabla; 
       this.atributo = atributo;
        this.operador = operador;
        this.valor = valor;
        
    }

    public String getAtributo() {
        return atributo;
    }

    public String getOperador() {
        return operador;
    }

    public String getValor() {
        return valor;
    }

    public String getTabla() {
        return tabla;
    }

    public String toString(int i) {
        return "P"+i + ": " + atributo + " " + operador + " " + valor;
    }
}
