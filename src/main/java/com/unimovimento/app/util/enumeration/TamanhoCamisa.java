package com.unimovimento.app.util.enumeration;

public enum TamanhoCamisa {
    PP("PP"),
    P("P"),
    M("M"),
    G("G"),
    GG("GG"),
    XG("XG"),
    XXG("XXG"),
    NENHUM("Nenhum");

    private final String descricao;

    TamanhoCamisa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
