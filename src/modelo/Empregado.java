/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Dev-2810
 */
public class Empregado {
     private String  nome;
    private int     idade;
    private char    sexo;
    private Date    dataNasc;
    private double  salario;
    private boolean beneficio;
 
    public Empregado() {
        //inicializando variaveis
        this.nome="";
        this.idade=0;
        this.sexo='M';
        this.dataNasc=new Date(new java.util.Date().getTime());
        this.salario=0;
        this.beneficio=true;
    }
 
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }
 
    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
 
    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }
 
    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }
 
    /**
     * @return the sexo
     */
    public char getSexo() {
        return sexo;
    }
 
    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
 
    /**
     * @return the dataNasc
     */
    public Date getDataNasc() {
        return dataNasc;
    }
 
    /**
     * @param dataNasc the dataNasc to set
     */
    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }
 
    /**
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }
 
    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }
 
    /**
     * @return the beneficio
     */
    public boolean isBeneficio() {
        return beneficio;
    }
 
    /**
     * @param beneficio the beneficio to set
     */
    public void setBeneficio(boolean beneficio) {
        this.beneficio = beneficio;
    }
}
