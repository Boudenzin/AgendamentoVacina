import java.util.Objects;

public class Vacina {

    private Data data;
    private TipoVacina tipo;

    public Vacina() {
        this.data = new Data();
        this.tipo = TipoVacina.UNDEFINED;
    }

    public Vacina(Data data, TipoVacina tipo) {
        this.data = data;
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vacina vacina = (Vacina) o;

        if (data != vacina.getData()) return false;
        if (getTipo() != vacina.getTipo()) return false;

        return Objects.equals(data, vacina.data) && tipo == vacina.tipo;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + tipo.hashCode();
        return result;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public TipoVacina getTipo() {
        return tipo;
    }

    public void setTipo(TipoVacina tipo) {
        this.tipo = tipo;
    }
}
