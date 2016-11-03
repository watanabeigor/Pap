package com.example.marianaleal.pap;

public class Evento {

    private int id;
    private String descricao;
    private int faixaEtaria;
    private String estiloMusical;
    private String horario;
    private int foto;
    private String nome;
    private double valorEntrada;


    public Evento(int id, String descricao, int faixaEtaria, String estiloMusical, String horario, int foto, String nome, double valorEntrada) {
        this.id = id;
        this.descricao = descricao;
        this.faixaEtaria = faixaEtaria;
        this.estiloMusical = estiloMusical;
        this.horario = horario;
        this.foto = foto;
        this.nome = nome;
        this.valorEntrada = valorEntrada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(int faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public String getEstiloMusical() {
        return estiloMusical;
    }

    public void setEstiloMusical(String estiloMusical) {
        this.estiloMusical = estiloMusical;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(double valorEntrada) {
        this.valorEntrada = valorEntrada;
    }
}
