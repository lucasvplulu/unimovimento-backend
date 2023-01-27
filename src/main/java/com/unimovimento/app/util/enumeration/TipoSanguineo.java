package com.unimovimento.app.util.enumeration;

public enum TipoSanguineo {
    A_POSITIVO("A+"),
    B_POSITIVO("B+"),
    AB_POSITIVO("AB+"),
    O_POSITIVO("O+"),
    A_NEGATIVO("A-"),
    B_NEGATIVO("B-"),
    AB_NEGATIVO("AB-"),
    O_NEGATIVO("O-");

    private String descricao;

    TipoSanguineo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
