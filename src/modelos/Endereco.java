package modelos;

public class Endereco {

    private String cep;
    private String logradouro;
    private String bairro;
    private String estado;

    @Override
    public String toString() {
        return "{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
