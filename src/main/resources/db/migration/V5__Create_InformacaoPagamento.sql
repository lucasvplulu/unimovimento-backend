create table informacao_pagamento (
    id CHAR(36) not null,
    pessoa_id CHAR(36),
    formulario_id CHAR(36),
    situacao int DEFAULT NULL,
    tipo_pagamento int DEFAULT NULL,
    qtd_parcela int DEFAULT NULL,
    primary key (id)
);

ALTER TABLE informacao_pagamento
    ADD CONSTRAINT fk_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa (id);

ALTER TABLE informacao_pagamento
    ADD CONSTRAINT fk_formulario FOREIGN KEY (formulario_id) REFERENCES formulario (id);