package com.unimovimento.app.util.enumeration;

public enum TipoEstadoCivil {
    CASADO("Casado"),
    SOLTEIRO("Solteiro"),
    DIVORCIADO("Divorciado");

    private String descricao;

    private TipoEstadoCivil(String name) {
        this.descricao = name;
    }

    public String getDescricao() {
        return descricao;
    }
}
