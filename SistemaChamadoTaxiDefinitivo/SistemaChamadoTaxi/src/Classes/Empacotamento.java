/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Classes;

import java.io.Serializable;
import java.util.ArrayList;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author vitor
 */
public abstract class Empacotamento {
     // 6. Serialização: gravando os objetos no arquivo binário com o nome especificado
    public static void gravarArquivoBinario(ArrayList<Object> lista, String nomeArq) {
        File arq = new File(nomeArq);
        try {
            arq.delete();
            arq.createNewFile();

            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
            objOutput.writeObject(lista);
            objOutput.close();

        } catch(IOException erro) {
            System.out.printf("Erro: %s", erro.getMessage());
        }
    }

    // ...

    // 20. Desserialização: recuperando os objetos gravados no arquivo binário com o nome especificado
    public static ArrayList<Object> lerArquivoBinario(String nomeArq) {
        ArrayList<Object> lista = new ArrayList();
        try {
            File arq = new File(nomeArq);
            if (arq.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
                lista = (ArrayList<Object>) objInput.readObject();
                objInput.close();
            }
        } catch(IOException erro1) {
            System.out.printf("Erro: %s", erro1.getMessage());
        } catch(ClassNotFoundException erro2) {
            System.out.printf("Erro: %s", erro2.getMessage());
        }

        return lista;
    }
    
}
