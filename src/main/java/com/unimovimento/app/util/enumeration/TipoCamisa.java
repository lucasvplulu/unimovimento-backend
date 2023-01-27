package com.unimovimento.app.util.enumeration;

public enum TipoCamisa {

    NORMAL("Normal"),
    BABY_LOOK("Baby Look"),
    NENHUM("Nenhum");
    private final String descricao;

    TipoCamisa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
