/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.ArrayList;


public class Motorista {
    private int id;
    private String nome,telefone,CNH;
    private Carro carro;
    private ArrayList<Chamado> chamados = new ArrayList();

    public Motorista(int id, String nome, String telefone, String CNH, Carro carro) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.CNH = CNH;
        this.carro = carro;
    }

    

    public ArrayList<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(Chamado chamados) {
        this.chamados.add(chamados);
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
    
    public Carro getCarros() {
        return this.carro;
    }
    public void addMotorista(Carro carro){
        this.carro = carro;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCNH() {
        return CNH;
    }

    public void setCNH(String CNH) {
        this.CNH = CNH;
    }
    //Fim da classe motorista
}
    

