import java.util.Objects;

public class Paciente {

    private String cartaoSUS;

    private String nome;

    private int idade;

    public Paciente(String cartaoSUS, String nome, int idade) {

        this.cartaoSUS = cartaoSUS;
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paciente paciente = (Paciente) o;

        if (cartaoSUS.equals(paciente.getCartaoSUS())) return false;
        if (nome.equals(paciente.getNome())) return false;
        if (idade != paciente.getIdade()) return false;
        return idade == paciente.idade && Objects.equals(cartaoSUS, paciente.cartaoSUS) && Objects.equals(nome, paciente.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartaoSUS, nome, idade);
    }

    public String getCartaoSUS() {
        return cartaoSUS;
    }

    public void setCartaoSUS(String cartaoSUS) {
        this.cartaoSUS = cartaoSUS;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
