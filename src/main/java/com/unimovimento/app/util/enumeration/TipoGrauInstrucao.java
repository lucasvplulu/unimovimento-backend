package com.unimovimento.app.util.enumeration;

public enum TipoGrauInstrucao {
    ANALFABETO("Analfabeto"),
    FUNDAMENTAL_INCOMPLETO("Fundamental Incompleto"),
    FUNDAMENTAL_COMPLETO("Fundamental Completo"),
    MEDIO_INCOMPLETO("Médio Incompleto"),
    MEDIO_COMPLETO("Médio Completo"),
    SUPERIOR_INCOMPLETO("Superior Incompleto"),
    SUPERIOR_COMPLETO("Superior Completo"),
    MESTRADO("Mestrado"),
    DOUTORADO("Doutorado"),
    NAO_INFORMADO("Não Informado");

    private String descricao;

    private TipoGrauInstrucao(String name) {
        this.descricao = name;
    }

    public String getDescricao() {
        return descricao;
    }
}
