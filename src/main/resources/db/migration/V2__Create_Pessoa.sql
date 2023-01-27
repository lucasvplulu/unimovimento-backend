CREATE TABLE pessoa (
  id char(36) NOT NULL,
  nome varchar(255) NOT NULL,
  data_nascimento date DEFAULT NULL,
  sexo varchar(255) NOT NULL,
  estado_civil varchar(255) DEFAULT NULL,
  nome_conjuge varchar(255) DEFAULT NULL,
  escolaridade varchar(255) DEFAULT NULL,
  profissao varchar(255) DEFAULT NULL,
  foto varchar(255) DEFAULT NULL,
  PRIMARY KEY (id));