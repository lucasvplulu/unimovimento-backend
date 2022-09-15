package com.unimovimento.app.util.enumeration;

public enum TipoGrauInstrucao {
    ANALFABETO("Analfabeto");

    private String descricao;

    private TipoGrauInstrucao(String name) {
        this.descricao = name;
    }

    public String getDescricao() {
        return descricao;
    }
}
