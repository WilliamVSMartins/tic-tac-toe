public class Main {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro();
        Jogador jogador1 = new Jogador('X');
        Jogador jogador2 = new Jogador('O');

        boolean jogoEmAndamento = true;

        while (jogoEmAndamento) {
            tabuleiro.exibirTabuleiro();
            Jogador jogadorAtual = (tabuleiro.getTurno() % 2 == 0) ? jogador1 : jogador2;
            tabuleiro.lerJogada(jogadorAtual);

            if (tabuleiro.verificarVitoria(jogadorAtual.getSimbolo())) {
                tabuleiro.exibirTabuleiro();
                System.out.println("O jogador " + jogadorAtual.getSimbolo() + " venceu!");
                jogoEmAndamento = false;
            } else if (tabuleiro.tabuleiroCompleto()) {
                tabuleiro.exibirTabuleiro();
                System.out.println("O jogo terminou em empate!");
                jogoEmAndamento = false;
            }
        }
    }
}