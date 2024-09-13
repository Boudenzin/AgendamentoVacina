import java.util.Objects;

public class Vacina {

    private Data data;
    private TipoVacina tipo;

    private int dose;

    public Vacina() {
        this.data = new Data();
        this.tipo = TipoVacina.UNDEFINED;
        this.dose = 0;
    }

    public Vacina(TipoVacina tipo, Data data, int dose) {
        this.data = data;
        this.tipo = tipo;
        this.dose = dose;
    }

    public Vacina(TipoVacina tipo, Data data) {
        this(tipo, data, 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vacina vacina = (Vacina) o;

        if (data != vacina.getData()) return false;
        if (getTipo() != vacina.getTipo()) return false;
        //todo; refatorar colocando o getDose

        return Objects.equals(data, vacina.data) && tipo == vacina.tipo;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + tipo.hashCode();
        //todo: refatorar colocando o dose.hashcode
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
