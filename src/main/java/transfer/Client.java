package transfer;

public class Client {

    private String name;
    private String cpf;
    private String rg;

    public Client(String name, String cpf, String rg) {
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }
}
