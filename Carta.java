import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Carta {
    private int forca;
    private int defesa;
    private int inteligencia;
    private int fadiga;

    public Carta(int forca, int defesa, int inteligencia, int fadiga) {
        this.forca = forca;
        this.defesa = defesa;
        this.inteligencia = inteligencia;
        this.fadiga = fadiga;
    }

    public int getForca() {
        return forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getFadiga() {
        return fadiga;
    }

    public void exibirCarta() {
        System.out.println("Força: " + forca + " | Defesa: " + defesa + " | Inteligência: " + inteligencia + " | Fadiga: " + fadiga);
    }

    // Função para gerar cartas aleatórias
    public static ArrayList<Carta> gerarCartas() {
        Random random = new Random();
        ArrayList<Carta> cartas = new ArrayList<>();

        for (int i = 0; i < 11; i++) {
            int forca = random.nextInt(100) + 1;
            int defesa = random.nextInt(100) + 1;
            int inteligencia = random.nextInt(100) + 1;
            int fadiga = random.nextInt(100) + 1;

            cartas.add(new Carta(forca, defesa, inteligencia, fadiga));
        }

        return cartas;
    }

    // Função para comparar o atributo escolhido
    public static int compararAtributo(Carta cartaJogador, Carta cartaComputador, int escolha) {
        int valorJogador = obterValorAtributo(cartaJogador, escolha);
        int valorComputador = obterValorAtributo(cartaComputador, escolha);

        // Regra especial para Fadiga (menor valor ganha)
        if (escolha == 4) {
            return valorJogador < valorComputador ? 1 : (valorJogador > valorComputador ? 2 : 0);
        }

        // Para os demais atributos (maior valor ganha)
        return valorJogador > valorComputador ? 1 : (valorJogador < valorComputador ? 2 : 0);
    }

    // Função para obter valor do atributo selecionado
    public static int obterValorAtributo(Carta carta, int escolha) {
        switch (escolha) {
            case 1:
                return carta.getForca();
            case 2:
                return carta.getDefesa();
            case 3:
                return carta.getInteligencia();
            case 4:
                return carta.getFadiga();
            default:
                return 0;
        }
    }

    // Função para obter o nome do atributo
    public static String obterNomeAtributo(int escolha) {
        switch (escolha) {
            case 1:
                return "Força";
            case 2:
                return "Defesa";
            case 3:
                return "Inteligência";
            case 4:
                return "Fadiga";
            default:
                return "Atributo desconhecido";
        }
    }
}

