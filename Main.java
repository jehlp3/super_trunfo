import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("""
  ____                       _____                  __
 / ___| _   _ _ __   ___ _ _|_   _| __ _   _ _ __  / _| ___
 \\___ \\| | | | '_ \\ / _ \\ '__|| || '__| | | | '_ \\| |_ / _ \\
  ___) | |_| | |_) |  __/ |   | || |  | |_| | | | |  _| (_) |
 |____/ \\__,_| .__/ \\___|_|   |_||_|   \\__,_|_| |_|_|  \\___/
             |_|
""");
        Delay.delay(2000);

        ArrayList<Carta> cartasJogador = Carta.gerarCartas();
        ArrayList<Carta> cartasComputador = Carta.gerarCartas();

        Jogador jogador = new Jogador(cartasJogador);
        Jogador computador = new Jogador(cartasComputador);

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        for (int rodada = 0; rodada < 10; rodada++) {
            System.out.println("_________________________________________________________");
            System.out.println("\nRodada " + (rodada + 1) + ":\n");

            // Jogador escolhe carta
            System.out.println("Sua carta:");
            Carta cartaJogador = jogador.getCarta(rodada);
            cartaJogador.exibirCarta();

            int escolha = 0;

            if (rodada % 2 == 0) {
                // Rodada do jogador escolher o atributo
                System.out.println("\nEscolha um atributo para competir:");
                System.out.println("1. Força");
                System.out.println("2. Defesa");
                System.out.println("3. Inteligência");
                System.out.println("4. Fadiga");
                escolha = scanner.nextInt();
            } else {
                // Rodada do computador escolher o atributo
                escolha = random.nextInt(4) + 1;  // Computador escolhe um atributo aleatório
                System.out.println("\nO computador escolheu o atributo: " + Carta.obterNomeAtributo(escolha));
            }

            // Mostrar a carta do computador no final da rodada
            Carta cartaComputador = computador.getCarta(rodada);
            System.out.println("\nCarta do Computador:");
            cartaComputador.exibirCarta();

            // Comparar o atributo escolhido
            int vencedor = Carta.compararAtributo(cartaJogador, cartaComputador, escolha);

            if (vencedor == 1) {
                jogador.ganharPonto();
                System.out.println("\nVocê venceu esta rodada!");
            } else if (vencedor == 2) {
                computador.ganharPonto();
                System.out.println("\nO computador venceu esta rodada!");
            } else {
                System.out.println("\nEsta rodada foi empate!");
            }

            // Exibir placar
            System.out.println("\nPlacar:");
            System.out.println("Jogador: " + jogador.getPontos() + " | Computador: " + computador.getPontos());
            Delay.delay(3000);
        }

        // Exibir vencedor final
        System.out.println("\n----------------- Fim do Jogo -----------------");
        if (jogador.getPontos() > computador.getPontos()) {
            System.out.println("Você é o vencedor!");
        } else if (jogador.getPontos() < computador.getPontos()) {
            System.out.println("O computador venceu!");
        } else {
            System.out.println("O jogo terminou empatado!");
        }

        scanner.close();
    }
}