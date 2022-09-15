package com.unimovimento.app.util.enumeration;

public enum TipoSexo {
    MASCULINO ("Masculino"),
    FEMININO ("Feminino");

    private String descricao;

    private TipoSexo(String name) {
        this.descricao = name;
    }

    public String getDescricao() {
        return descricao;
    }
}
