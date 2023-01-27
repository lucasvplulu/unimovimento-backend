package com.unimovimento.app.config;

import com.unimovimento.app.evento.Evento;
import com.unimovimento.app.evento.EventoRepository;
import com.unimovimento.app.pessoa.Pessoa;
import com.unimovimento.app.pessoa.PessoaRepository;
import com.unimovimento.app.pessoa.conhecimento.PessoaConhecimento;
import com.unimovimento.app.pessoa.conhecimento.PessoaConhecimentoRepository;
import com.unimovimento.app.pessoa.contato.PessoaContato;
import com.unimovimento.app.pessoa.contato.PessoaContatoRepository;
import com.unimovimento.app.pessoa.curiosidade.PessoaCuriosidade;
import com.unimovimento.app.pessoa.curiosidade.PessoaCuriosidadeRepository;
import com.unimovimento.app.pessoa.documento.PessoaDocumento;
import com.unimovimento.app.pessoa.documento.PessoaDocumentoRepository;
import com.unimovimento.app.pessoa.emergencia.PessoaEmergencia;
import com.unimovimento.app.pessoa.emergencia.PessoaEmergenciaRepository;
import com.unimovimento.app.pessoa.emergencia.contato.PessoaContatoEmergencia;
import com.unimovimento.app.pessoa.emergencia.contato.PessoaContatoEmergenciaRepository;
import com.unimovimento.app.pessoa.endereco.PessoaEndereco;
import com.unimovimento.app.pessoa.endereco.PessoaEnderecoRepository;
import com.unimovimento.app.pessoa.interesse.PessoaInteresse;
import com.unimovimento.app.pessoa.interesse.PessoaInteresseRepository;
import com.unimovimento.app.pessoa.ministerio.PessoaMinisterio;
import com.unimovimento.app.pessoa.ministerio.PessoaMinisterioRepository;
import com.unimovimento.app.util.GenericEntity;
import com.unimovimento.app.util.enumeration.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private PessoaConhecimentoRepository pessoaConhecimentoRepository;
    @Autowired
    private PessoaContatoRepository pessoaContatoRepository;
    @Autowired
    private PessoaCuriosidadeRepository pessoaCuriosidadeRepository;
    @Autowired
    private PessoaDocumentoRepository pessoaDocumentoRepository;
    @Autowired
    private PessoaConhecimentoRepository pessoaConhecimento;
    @Autowired
    private PessoaContatoEmergenciaRepository pessoaContatoEmergenciaRepository;
    @Autowired
    private PessoaEmergenciaRepository pessoaEmergenciaRepository;
    @Autowired
    private PessoaEnderecoRepository pessoaEnderecoRepository;
    @Autowired
    private PessoaInteresseRepository pessoaInteresseRepository;
    @Autowired
    private PessoaMinisterioRepository pessoaMinisterioRepository;

    /**
     * Método responsável por realizar o Database Seeding no profile DEV apenas para testes em ambiente local.
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        cleanRepositories();
        eventoDatabaseSeeding();
        pessoaDatabaseSeeding();
    }

    private void eventoDatabaseSeeding() {
        var evento1 = new Evento("Doe Suas Férias - 2024",
                "Semana em que os jovens de Blumenau doam para pregar Cristo em outra cidade",
                LocalDate.parse("2024-01-06"),
                LocalDate.parse("2024-01-13"),
                LocalDate.parse("2023-12-31"),
                LocalDate.parse("2023-12-31"));

        var evento2 = new Evento("Retiro UNI - 2023",
                "Final de Semana em que os jovens de Blumenau passam retirados para descansar no Senhor",
                LocalDate.parse("2023-11-11"),
                LocalDate.parse("2023-11-12"),
                LocalDate.parse("2023-11-08"),
                LocalDate.parse("2023-11-08"));

        List<Evento> eventos = Stream.of(evento1, evento2)
                .map(x -> (Evento) createAuditoryLog(x))
                .collect(Collectors.toList());

        eventoRepository.saveAllAndFlush(eventos);
    }

    private void cleanRepositories() {
        //Repositórios de Pessoas
        pessoaConhecimentoRepository.deleteAll();
        pessoaCuriosidadeRepository.deleteAll();
        pessoaEmergenciaRepository.deleteAll();
        pessoaEnderecoRepository.deleteAll();
        pessoaInteresseRepository.deleteAll();
        pessoaMinisterioRepository.deleteAll();
        pessoaRepository.deleteAll();

        //Repositório de Eventos
        eventoRepository.deleteAll();
    }

    private void pessoaDatabaseSeeding() {
        // pessoa
        var pessoa1 = new Pessoa("Leônidas Guilherme Moritz Pereira Rosa",
                LocalDate.parse("1995-02-17"),
                TipoSexo.MASCULINO,
                TipoEstadoCivil.CASADO,
                "Bruna de Oliveira Rosa",
                "https://unimovimento.com.br/anexos/fotos/leonidas.png",
                TipoGrauInstrucao.SUPERIOR_INCOMPLETO,
                "Desenvolvedor",
                TamanhoCamisa.GG,
                TipoCamisa.NORMAL,
                TipoVozCoral.BAIXO);

        var pessoa2 = new Pessoa("Jessé Eduardo Branco",
                LocalDate.parse("1991-03-17"),
                TipoSexo.MASCULINO,
                TipoEstadoCivil.CASADO,
                "Sheila Maria Pereira Branco",
                "https://unimovimento.com.br/anexos/fotos/leonidas.png",
                TipoGrauInstrucao.SUPERIOR_COMPLETO,
                "Pastor de Jovens",
                TamanhoCamisa.P,
                TipoCamisa.NORMAL,
                TipoVozCoral.TENOR);

        //Documentos da Pessoa
        var documento1 = new PessoaDocumento(null,
                "09874553979",
                "5.169.851",
                "SSP",
                pessoa1);

        var documento2 = new PessoaDocumento(null,
                "07460926957",
                "5.299.638",
                "SSP",
                pessoa2);

        pessoa1.setDocumento((PessoaDocumento) createAuditoryLog(documento1));
        pessoa2.setDocumento((PessoaDocumento) createAuditoryLog(documento2));

        //Contatos da Pessoa
        var contato1 = new PessoaContato(null,
                "leogui.moritz@gmail.com",
                "554799252-4310",
                pessoa1);

        var contato2 = new PessoaContato(null,
                "jbkiss@hotmail.com",
                "554799239-4581",
                pessoa2);

        pessoa1.setContato((PessoaContato) createAuditoryLog(contato1));
        pessoa2.setContato((PessoaContato) createAuditoryLog(contato2));

        //Log de Auditoria

        List<Pessoa> pessoas = Stream.of(pessoa1,
                        pessoa2)
                .map(x -> (Pessoa) createAuditoryLog(x))
                .collect(Collectors.toList());

        //Salvando pré-dados da Pessoa
        pessoaRepository.saveAllAndFlush(pessoas);

        //Conhecimentos da pessoa
        var conhecimento1 = new PessoaConhecimento(null,
                "Liderança",
                pessoa1);
        var conhecimento2 = new PessoaConhecimento(null,
                "Desenvolvimento de Sistemas",
                pessoa1);

        var conhecimento3 = new PessoaConhecimento(null,
                "Pregação",
                pessoa1);

        var conhecimento4 = new PessoaConhecimento(null,
                "Liderança",
                pessoa2);

        List<PessoaConhecimento> pessoaConhecimentos = Stream.of(conhecimento1,
                        conhecimento2,
                        conhecimento3,
                        conhecimento4)
                .map(x -> (PessoaConhecimento) createAuditoryLog(x))
                .collect(Collectors.toList());

        pessoaConhecimentoRepository.saveAllAndFlush(pessoaConhecimentos);
        pessoa1.getConhecimentos().addAll(Arrays.asList(conhecimento1, conhecimento2, conhecimento3));
        pessoa2.getConhecimentos().add(conhecimento4);

        //Curiosidades da Pessoa
        var curiosidade1 = new PessoaCuriosidade(null,
                LivroBiblia.JOAO,
                "Até Que Nada Mais Importe - Luciano Subirá",
                null,
                "Lasanha",
                "Viajar, jogar bola, assistir filmes, ler livros, estudar, pescar, programar",
                pessoa1);

        curiosidade1 = (PessoaCuriosidade) createAuditoryLog(curiosidade1);
        pessoaCuriosidadeRepository.saveAndFlush(curiosidade1);
        pessoa1.setCuriosidade(curiosidade1);

        //Dados de Emergência da Pessoa
        var emergencia1 = new PessoaEmergencia(false,
                null,
                true,
                "Alergia a abelhas e mosquitos",
                true,
                "Plano de Saúde Unimed",
                TipoSanguineo.AB_POSITIVO,
                null);

        var contatoEmergencia1 = new PessoaContatoEmergencia(null,
                "Bruna de Oliveira Rosa",
                "554799184-2365",
                emergencia1);

        var contatoEmergencia2 = new PessoaContatoEmergencia(null,
                "Tuliana Bohr Moritz",
                "55478819-3350",
                emergencia1);

        List<PessoaContatoEmergencia> pessoaContatosEmergencia = Stream.of(contatoEmergencia1,
                        contatoEmergencia2)
                .map(x -> (PessoaContatoEmergencia) createAuditoryLog(x))
                .collect(Collectors.toList());

        emergencia1.getContatoEmergencia().addAll(pessoaContatosEmergencia);
        emergencia1 = (PessoaEmergencia) createAuditoryLog(emergencia1);
        emergencia1.setPessoa(pessoa1);
        pessoaEmergenciaRepository.saveAndFlush(emergencia1);
        pessoa1.setDadoEmergencial(emergencia1);

        //Endereço da Pessoa
        var endereco1 = new PessoaEndereco(null,
                "89069292",
                "Brasil",
                "Santa Catarina",
                "Blumenau",
                "Itoupava Central",
                "Rua Frieda Jensen",
                "92",
                "AP 2041",
                pessoa1);

        var endereco2 = new PessoaEndereco(null,
                "89012001",
                "Brasil",
                "Santa Catarina",
                "Blumenau",
                "Victor Konder",
                "Rua São Paulo",
                "940",
                "AP 802",
                pessoa2);

        List<PessoaEndereco> pessoaEnderecos = Stream.of(endereco1,
                        endereco2)
                .map(x -> (PessoaEndereco) createAuditoryLog(x))
                .collect(Collectors.toList());

        pessoaEnderecoRepository.saveAllAndFlush(pessoaEnderecos);
        pessoa1.setEndereco(endereco1);
        pessoa2.setEndereco(endereco2);

        //Interesses da Pessoa
        var interesse1 = new PessoaInteresse(null,
                TipoInteresse.PREGACAO,
                null,
                pessoa1);

        var interesse2 = new PessoaInteresse(null,
                TipoInteresse.ENSINO,
                null,
                pessoa1);

        var interesse3 = new PessoaInteresse(null,
                TipoInteresse.TECNOLOGIA_INFORMATICA,
                null,
                pessoa1);

        var interesse4 = new PessoaInteresse(null,
                TipoInteresse.LIDERANCA,
                null,
                pessoa2);

        List<PessoaInteresse> pessoaInteresses = Stream.of(interesse1,
                        interesse2,
                        interesse3,
                        interesse4)
                .map(x -> (PessoaInteresse) createAuditoryLog(x))
                .collect(Collectors.toList());

        pessoaInteresseRepository.saveAllAndFlush(pessoaInteresses);
        pessoa1.getInteresses().addAll(Arrays.asList(interesse1, interesse2, interesse3));
        pessoa2.getInteresses().add(interesse4);

        //Dados Ministeriais da Pessoa
        var ministerio1 = new PessoaMinisterio(null,
                "Pregação e Ensino das Escrituras",
                "Esdras 7.10",
                "Betesda - Setor 10",
                true,
                LocalDate.parse("2015-09-26"),
                TipoFuncaoJuventude.DIRETORIA,
                TipoFuncaoEclesiastica.DIACONO,
                true,
                "Igreja Católica Apostólica Romana",
                true,
                true,
                "Médio em Teologia e Especialização em Novo Testamento",
                "Ministro da Palavra, Líder Regional Leste do UniMovimento, Membro da Diretoria do UniMovimento",
                pessoa1);

        var ministerio2 = new PessoaMinisterio(null,
                "Pastoreio",
                "Pastor de Jovens",
                "Sede - Setor 01",
                true,
                null,
                TipoFuncaoJuventude.LIDER,
                TipoFuncaoEclesiastica.PASTOR,
                false,
                null,
                true,
                true,
                null,
                "Pastor de Jovens do UniMovimento em Blumenau",
                pessoa2);

        List<PessoaMinisterio> pessoaMinisterios = Stream.of(ministerio1,
                        ministerio2)
                .map(x -> (PessoaMinisterio) createAuditoryLog(x))
                .collect(Collectors.toList());

        pessoaMinisterioRepository.saveAllAndFlush(pessoaMinisterios);
        pessoa1.setDadoMinisterial(ministerio1);
        pessoa2.setDadoMinisterial(ministerio2);

        //Salvando Dados das Pessoas
        pessoaRepository.saveAllAndFlush(Arrays.asList(pessoa1, pessoa2));
    }

    private GenericEntity createAuditoryLog(GenericEntity entity) {
        entity.setAutorCriacao("profile-dev");
        entity.setAutorModificacao("profile-dev");
        entity.setDataCriacao(LocalDateTime.now());
        entity.setDataModificacao(LocalDateTime.now());
        return entity;
    }
}
