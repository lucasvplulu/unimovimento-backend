package com.unimovimento.app.util.enumeration;

public enum TipoFuncaoEclesiastica {

    PASTOR("Pastor"),
    EVANGELISTA("Evangelista"),
    PRESBITERO("Presbítero"),
    DIACONO("Diácono"),
    AUXILIAR("Auxiliar"),
    NENHUM("Nenhum");

    private final String descricao;

    TipoFuncaoEclesiastica(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
