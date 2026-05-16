/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class Lista {
    private String nome;
    private ArrayList<Filme> lista;

    public Lista() {
    }
    
    public Lista(String nome, ArrayList<Filme> lista) {
        this.nome = nome;
        this.lista = lista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Filme> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Filme> lista) {
        this.lista = lista;
    }
    
    
}
