
package BlockChain;

public class ProgramaPrincipal {

    public static void main(String[] args) {
    
    //Gera a Blockchain para o Paciente
    //Aqui o Bloco Genesis já é gerado
    BlockChain ProntA = new BlockChain();
    
    //Paciente auxiliar para gerar prontuário
    Paciente auxPac = new Paciente("NULL","NULL","NULL","NULL","NULL",
    "NULL","NULL","NULL");    
    //Prontuario auxiliar
    Prontuario auxPront = new Prontuario(auxPac,"NULL","NULL","NULL","NULL","NULL");
    Prontuario auxPront2 = new Prontuario(auxPac,"NULL","NULL","NULL","NULL","NULL");
    Prontuario auxPront3 = new Prontuario(auxPac,"NULL","NULL","NULL","NULL","NULL");
       
    /*Criados o Paciente e o Prontuario generico, posso incluir novos blocos*/    
    //Adicionando Paciente e Dados

    auxPac.setNomeCompleto("Carlos Augusto");
    auxPac.setDataDeNascimento("05/08/1999");
    auxPac.setSexo("Masculino");
    auxPac.setNaturalidade("Sao Luis");
    auxPac.setEndereco("Rua Antonio Falcao, 488, Monte Castelo");
    auxPac.setEnderecoMunicipio("Sao Luis");
    auxPac.setEnderecoEstado("Maranhao");
    auxPac.setEnderecoCEP("65000");
    auxPac.setCodigo("8756387");
       
    //Adição de Novos Blocos
    Block a = new Block("0x200", new java.util.Date(),auxPront);
    ProntA.adicionarBloco(a); 
    
    /*Atualização de Prontuário - Adicionando novos Dados e Informações
    ao prontuário do paciente em questão*/
      
    /*O segundo prontuário consta de Anamnese do Paciente e Prescrição Médica*/

    auxPront2.setAnamnese("Paciente relatou dores abdominais que ocorreram nos"
            + " ultimos 7 dias");
    auxPront2.setPrescricaoMedica("Butilbrometo de Escopolamina");
    
    Block b = new Block("0x200", new java.util.Date(),auxPront2);
    ProntA.adicionarBloco(b);
    
    /*No caso de adicionar novas informações e subescrever os laudos anteriores,
    não tem problema pois cada prontuário de cada data já está registrado,
    e novos prontuários são únicos e exclusivos do momento em que são gerados,
    o que facilita a identificação de erros*/
    
    auxPront3.setAnamnese("Paciente relatou que as dores amenizaram apos o uso"
            + " dos medicamentos");
    auxPront3.setPrescricaoMedica("Butilbrometo de Escopolamina");
    auxPront3.setEvolucao("O estado do paciente apresentou melhoras significativas"
            + " e uma rapida evolucao na diminuicao dos sintomas"); 
    
    Block c = new Block("0x200", new java.util.Date(),auxPront3);           
    ProntA.adicionarBloco(c);
    
    //Exibe toda a cadeia de blocos atualizada    
    ProntA.exibirChain(); 
      
    /*Aqui alteramos propositalmente um hash para testar se a cadeia eh valida 
    ou nao*/
    //ProntA.retornarUltimoBloco().setHashAnterior("HASHFALSO");    
    //ProntA.ehValido();
        
    }
}