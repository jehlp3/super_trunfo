import java.util.ArrayList;

class Jogador {
    private ArrayList<Carta> cartas;
    private int pontos;

    public Jogador(ArrayList<Carta> cartas) {
        this.cartas = cartas;
        this.pontos = 0;
    }

    public Carta getCarta(int index) {
        return cartas.get(index);
    }

    public void ganharPonto() {
        pontos++;
    }

    public int getPontos() {
        return pontos;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }
}