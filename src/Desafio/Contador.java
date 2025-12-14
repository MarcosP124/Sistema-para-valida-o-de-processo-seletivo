package Desafio;
import java.util.Scanner;
public class Contador {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try{
        System.out.println("Digite um numero de partida: ");
        int partida = input.nextInt();
        System.out.println("Digite um numero de chegada: ");
        int chegada = input.nextInt();
        int contagem = chegada - partida;
        if (partida >= chegada){
            throw new ParametrosInvalidosException("Primeiro parametro deve ser menor que o segundo");
        }
        for (int i = 1; i <= contagem; i++){
            System.out.println("Numero: " + i);
        }}
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("Programa finalizado.");
        }

    
    }
}
