/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.Serializable;
import java.util.Date;

public class Chamado implements Serializable{
    
    //Atributos
    private int id;
    private String tipo,origem,destino;
    private double kmInicial,kmFinal, valorTotalChamado;
    private Cliente cliente;
    private Motorista motorista;
    private Carro carro;
    private Date data;

    public Chamado(int id, String tipo, String origem, String destino, double kmInicial, double kmFinal, double valorTotalChamado, Cliente cliente,Carro carro, Date data) {
        this.id = id;
        this.tipo = tipo;
        this.origem = origem;
        this.destino = destino;
        this.kmInicial = kmInicial;
        this.kmFinal = kmFinal;
        this.valorTotalChamado = valorTotalChamado;
        this.cliente = cliente;
        this.carro = carro;
        this.data = data;
    }

    

    public Cliente getCliente() {
        return cliente;
    }

    public int getId() {
        return id;
    }

   
    public String getTipo() {
        return tipo;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

   
    public double getKmInicial() {
        return kmInicial;
    }

    public void setKmInicial(double kmInicial) {
        this.kmInicial = kmInicial;
    }

    public double getKmFinal() {
        return kmFinal;
    }

    public void setKmFinal(double kmFinal) {
        this.kmFinal = kmFinal;
    }

    public double getValorTotalChamado() {
        return valorTotalChamado;
    }

    public void setValorTotalChamado(double valorTotalChamado) {
        this.valorTotalChamado = valorTotalChamado;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
    

