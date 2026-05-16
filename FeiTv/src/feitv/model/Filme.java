/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lucas
 */
public class Filme extends Video{
    private String descricao, titulo, genero;
    private int horas, minutos, segundos, nAvaliacoes;
    private double avaliacoes;   

    public Filme(String titulo,String descricao, String genero, int horas, int minutos, int segundos, double avaliacoes, int nAvaliacoes) {
        this.descricao = descricao;
        this.titulo = titulo;
        this.genero = genero;
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
        this.avaliacoes = avaliacoes;
        this.nAvaliacoes = nAvaliacoes;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public double getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(double avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public int getnAvaliacoes() {
        return nAvaliacoes;
    }

    public void setnAvaliacoes(int nAvaliacoes) {
        this.nAvaliacoes = nAvaliacoes;
    }
    
    @Override
    public String toString() {
        return "Filme{" + "titulo=" + titulo + ", descricao=" + descricao +  ", genero=" + genero + ", horas=" + horas + ", minutos=" + minutos + ", segundos=" + segundos + ", avaliacoes=" + avaliacoes + ", nAvaliacoes=" + nAvaliacoes + '}';
    }
}
