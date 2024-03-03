package com.unimovimento.app.util.enumeration;

public enum TipoVozCoral {

    TENOR("Tenor"),
    BAIXO("Baixo"),
    CONTRALTO("Contralto"),
    SOPRANO("Soprano"),
    NAO_INFORMADO("Não Informado");

    private final String descricao;

    TipoVozCoral(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
