package com.magnani.aula.museuunivali.modelo;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by marcelo on 6/22/17.
 */

public class Animal {

    private int id;
    private String nome;
    private String nomeCientifico;
    private String peso;
    private String fotografia;
    private String filo;
    private String classe;
    private String tempoDeVida;
    private String tempoDeExistencia;
    private String gestacao;
    private String alimentacao;
    private String habitat;
    private String ordem;
    private String familia;
    private String comprimento;
    private String curiosidades;
    private String genero;
    private String reino;
    private String especie;
    private boolean importante;
    public static int contador = 0;
    public Animal(JSONObject origem) {
        try {
            JSONObject classificacao = origem.getJSONObject("Classificação científica");
            this.reino = classificacao.getString("reino");
            this.filo = classificacao.getString("filo");
            this.classe = classificacao.getString("classe");
            this.ordem = classificacao.getString("ordem");
            this.familia = classificacao.getString("família");
            this.genero = classificacao.getString("gênero");
            this.especie = classificacao.getString("espécie");
            contador++;
            this.id = 1;
            this.gestacao = origem.getString("gestação");
            this.alimentacao = origem.getString("alimentação");
            this.habitat = origem.getString("habitat");
            this.nome = origem.getString("nome popular");
            this.tempoDeVida = origem.getString("tempo de vida");
            this.tempoDeExistencia = origem.getString("tempo de existência");
            this.setGestacao(origem.getString("gestação"));
            this.nomeCientifico = origem.getString("nome científico");
            this.peso = origem.getString("peso");
            this.fotografia = origem.getString("fotografia");
            this.curiosidades = origem.getString("curiosidades");
            this.comprimento = origem.getString("comprimento");
            this.importante = origem.getBoolean("importante");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }


    public boolean isImportante() {
        return importante;
    }

    public void setImportante(boolean importante) {
        this.importante = importante;
    }

    public String getReino() {
        return reino;
    }

    public void setReino(String reino) {
        this.reino = reino;
    }

    public String getFilo() {
        return filo;
    }

    public void setFilo(String filo) {
        this.filo = filo;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getOrdem() {
        return ordem;
    }

    public void setOrdem(String ordem) {
        this.ordem = ordem;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    public String getTempoDeVida() {
        return tempoDeVida;
    }

    public void setTempoDeVida(String tempoDeVida) {
        this.tempoDeVida = tempoDeVida;
    }

    public String getTempoDeExistencia() {
        return tempoDeExistencia;
    }

    public void setTempoDeExistencia(String tempoDeExistencia) {
        this.tempoDeExistencia = tempoDeExistencia;
    }

    public String getGestacao() {
        return gestacao;
    }

    public void setGestacao(String gestacao) {
        this.gestacao = gestacao;
    }

    public String getAlimentacao() {
        return alimentacao;
    }

    public void setAlimentacao(String alimentacao) {
        this.alimentacao = alimentacao;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getComprimento() {
        return comprimento;
    }

    public void setComprimento(String comprimento) {
        this.comprimento = comprimento;
    }

    public String getCuriosidades() {
        return curiosidades;
    }

    public void setCuriosidades(String curiosidades) {
        this.curiosidades = curiosidades;
    }
}
