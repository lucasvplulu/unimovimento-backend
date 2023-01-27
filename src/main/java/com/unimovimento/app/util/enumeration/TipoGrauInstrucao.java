package com.unimovimento.app.util.enumeration;

public enum TipoGrauInstrucao {
    ANALFABETO("Analfabeto"),
    ATE_QUINTO_ANO_INCOMPLETO("Até 5º Ano Incompleto"),
    QUINTO_ANO_COMPLETO("5º Ano Completo"),
    SEXTO_AO_NONO_ANO_FUNDAMENTAL("6º ao 9º Ano do Fundamental"),
    FUNDAMENTAL_COMPLETO("Fundamental Completo"),
    MEDIO_INCOMPLETO("Médio Incompleto"),
    MEDIO_COMPLETO("Médio Completo"),
    SUPERIOR_INCOMPLETO("Superior Incompleto"),
    SUPERIOR_COMPLETO("Superior Completo"),
    MESTRADO("Mestrado"),
    DOUTORADO("Doutorado"),
    IGNORADO("Ignorado");

    private String descricao;

    private TipoGrauInstrucao(String name) {
        this.descricao = name;
    }

    public String getDescricao() {
        return descricao;
    }
}
