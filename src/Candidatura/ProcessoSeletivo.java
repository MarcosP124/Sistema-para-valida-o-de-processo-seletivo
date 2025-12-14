package Candidatura;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
public class ProcessoSeletivo {
    public static void main(String[] args) {
        System.out.println("\033[1;35m   ========= Processo seletivo =========   \033[m");
         String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO"};
         for (String candidato : candidatos){
            entrandoEmContato(candidato);
         }
        
        
    }

    static void selecaoCandidato(){
        String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO","MONICA","FABRICIO","MIRELA","DANIELA","JORGE"};
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000;
        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = gerarSalarioPretendido();
            System.out.println("Candidato "+ candidato + " tem a pretensão salarial de R$" + salarioPretendido);
            System.out.print("Status do candidato: ");
            analisarCandidato(salarioPretendido);
            if (salarioPretendido <= salarioBase){
                candidatosSelecionados++;
                System.out.println("Candidato " + candidato + " selecionado. Total de selecionados: " + candidatosSelecionados);
                System.out.println("________________________________________________");
            }
            candidatoAtual++;
        }
    }

    static double gerarSalarioPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000;
        if(salarioBase > salarioPretendido){
            System.out.println("\033[1;32mLIGAR PARA O CANDIDATO\033[m");
        }
        else if (salarioBase == salarioPretendido){
            System.out.println("\033[1;33mLIGAR PARA O CANDIDATO COM CONTRA PROPOSTA\033[m");
        }
        else{
            System.out.println("\033[1;31mAGUARDANDO OUTRO CANDIDATO\033[m");
        }
    }

    static void imprimirSelecionados(){
        String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO"};
        for (String candidato : candidatos){
            System.out.println("Candidato selecionado: "+ candidato);
        }
        
    }

    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do{
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("Contato realizado com sucesso!");
        }while(continuarTentando && tentativasRealizadas < 3);
        if (atendeu)
            System.out.println("Conseguimos contato com o(a) " + candidato + " na " + tentativasRealizadas + "ª tentativa.");
        else
            System.out.println("Não conseguimos contato com " + candidato + ", tentativas realizadas: " + tentativasRealizadas);
    }

    static boolean atender(){
        return new Random().nextInt(3) ==1;
    }
}

