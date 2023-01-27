package com.unimovimento.app.util.enumeration;

public enum TipoInteresse {
    PREGACAO("Pregação"),
    MUSICA("Música"),
    MIDIA("Mídia"),
    REDES_SOCIAIS("Redes Sociais"),
    DESIGN_DIGITAL("Design Digital"),
    PRODUCAO_CONTEUDO_DIGITAL("Produção Conteúdo Digital"),
    TECNICA("Técnica"),
    PRODUCAO_EVENTOS("Produção de Eventos"),
    TEATRO("Teatro"),
    LIDERANCA("Liderança"),
    INTERCESSAO("Intercessão"),
    ENSINO("Ensino"),
    LOGISTICA("Logística"),
    ADMINISTRACAO("Administração"),
    VENDAS("Vendas"),
    DECORACAO("Decoração"),
    CONSTRUCAO_CIVIL("Construção Civil"),
    FINANCAS_ECONOMIA("Finanças e/ou Economia"),
    UX("Experiência do Usuário"),
    TECNOLOGIA_INFORMATICA("Tecnologia e Informática"),
    MODA_VESTUARIO("Moda e/ou Vestuário"),
    TESOURARIA("Tesouraria"),
    ARTES("Artes"),
    ESPORTES("Esportes"),
    OUTROS("Outros"),
    NENHUM("Nenhum");

    private String descricao;

    TipoInteresse(String descricao) {
    }

    public String getDescricao() {
        return descricao;
    }
}
