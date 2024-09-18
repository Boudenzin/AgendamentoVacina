import java.util.Objects;

public class Vacina {

    private Data data;

    private Hora hora;
    private TipoVacina tipo;

    private int dose;

    public Vacina() {
        this(TipoVacina.UNDEFINED, 0, new Data(), new Hora());
    }

    public Vacina(TipoVacina tipo, int dose, Data data, Hora hora) {
        this.data = data;
        this.hora = hora;
        this.tipo = tipo;
        this.dose = dose;
    }

    public Vacina(TipoVacina tipo, Data data, Hora hora) {
        this(tipo, 1, data, hora);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vacina vacina = (Vacina) o;

        if (data != vacina.getData()) return false;
        if (getTipo() != vacina.getTipo()) return false;
        if (getDose() != vacina.getDose()) return false;

        return Objects.equals(data, vacina.data) && tipo == vacina.tipo && dose == vacina.dose && hora == vacina.hora;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + tipo.hashCode();
        result = 31 * result + hora.hashCode();
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

    public int getDose() {return dose;}

    public void setDose(int dose) {this.dose = dose;}

    public Hora getHora() {return this.hora;}

    public void setHora(int hora, int minutos) {this.hora = new Hora(hora, minutos);}
}
