import java.util.Scanner;

public class Tabuleiro {
    private char[][] tabuleiro;
    private int turno;
    private Scanner scanner;

    public Tabuleiro() {
        tabuleiro = new char[3][3];
        inicializarTabuleiro();
        turno = 0;
        scanner = new Scanner(System.in);
    }

    public void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    public void exibirTabuleiro() {
        System.out.println("   0   1    2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j]);
                if (j < 2) {
                    System.out.print("  | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  ---+----+---");
            }
        }
    }

    public boolean validarJogada(int linha, int coluna) {
        return (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == ' ');
    }

    public void realizarJogada(int linha, int coluna, char jogador) {
        tabuleiro[linha][coluna] = jogador;
        turno++;
    }

    public boolean verificarVitoria(char jogador) {
        for (int i = 0; i < 3; i++) {
            if ((tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) ||
                    (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador)) {
                return true;
            }
        }
        if ((tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) ||
                (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador)) {
            return true;
        }
        return false;
    }

    public boolean tabuleiroCompleto() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public int getTurno() {
        return turno;
    }

    public void lerJogada(Jogador jogador) {
        System.out.println("É a vez do jogador " + jogador.getSimbolo());
        int linha = lerEntrada("Digite a linha (0, 1 ou 2): ");
        int coluna = lerEntrada("Digite a coluna (0, 1 ou 2): ");

        if (validarJogada(linha, coluna)) {
            realizarJogada(linha, coluna, jogador.getSimbolo());
        } else {
            System.out.println("Essa posição já está ocupada. Tente novamente.");
            lerJogada(jogador); // Chama recursivamente até obter uma jogada válida
        }

    }


    private int lerEntrada(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }
}
