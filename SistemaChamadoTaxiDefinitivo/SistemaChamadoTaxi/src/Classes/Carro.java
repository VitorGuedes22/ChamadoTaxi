/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.Serializable;
import java.util.Date;


public class Carro implements Serializable{
    private String ano;
    private String placa,marca,modelo,cor;
    private Date dataRegistro;

    public Carro(String placa, String marca, String modelo, String cor,String ano) {
        this.ano = ano;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    
    
    public String getAno() {
        return ano;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
//Fim da classe carro
}
    

