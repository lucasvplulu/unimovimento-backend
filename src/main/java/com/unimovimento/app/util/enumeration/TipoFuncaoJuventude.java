package com.unimovimento.app.util.enumeration;

public enum TipoFuncaoJuventude {
    LIDER("Líder"),
    VICE_LIDER("Vice-Líder"),
    DIRETORIA("Membro da Diretoria"),
    MIDIA("Equipe de Mídia"),
    BANDA("Banda de Jovens"),
    AJUDANTE("Ajudante em demandas diversas"),
    NENHUM("Nenhum");

    private final String descricao;

    TipoFuncaoJuventude(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
