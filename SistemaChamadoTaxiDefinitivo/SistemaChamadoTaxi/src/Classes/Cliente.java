/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Cliente implements Serializable{
    //Atributos
    private int id;
    private String nome,CPF,telefone,email;
    private Date dataRegistro;
  
    //Metodo consturtor 
    public Cliente(String nome, String telefone,String CPF,String email) {
        this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "id=" + id + ", nome=" + nome + ", CPF=" + CPF + ", telefone=" + telefone + ", email=" + email + ", dataRegistro=" + dataRegistro.toString();
    }
    
    //Metodos basicos

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getId() {
        return id;
    }
    
    public String getNome(){
        return this.nome;
    }

    public String getCPF() {
        return CPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
    

