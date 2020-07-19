/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoMV.model;

import java.sql.Date;

/**
 *
 * @author sergi
 */
public class Conta {
    
    private int id;
    private String valor;
    private Date dataAbertCont;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * @return the dataAbertCont
     */
    public Date getDataAbertCont() {
        return dataAbertCont;
    }

    /**
     * @param dataAbertCont the dataAbertCont to set
     */
    public void setDataAbertCont(Date dataAbertCont) {
        this.dataAbertCont = dataAbertCont;
    }
    
    
    
}
