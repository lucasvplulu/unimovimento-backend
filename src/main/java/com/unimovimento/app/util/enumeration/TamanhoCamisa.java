package com.unimovimento.app.util.enumeration;

public enum TamanhoCamisa {
    CATORZE("14"),
    PP("PP"),
    P("P"),
    M("M"),
    G("G"),
    GG("GG"),
    XG("XG"),
    XXG("XXG"),
    OUTRO("Outro"),
    NAO_INFORMADO("Não Informado");

    private final String descricao;

    TamanhoCamisa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
