package transfer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Client xuxa;
    Client silvioSantos;
    Account contaXuxa;
    Account contaSilvio;

    @BeforeEach
    void setUp() {
        xuxa = new Client("Xuxa", "9350938921", "4947090");
        silvioSantos = new Client("Silvio Santos", "1234567890", "2345678");

        contaXuxa = new Account("0030", "356", 3000.00, xuxa);
        contaSilvio = new Account("0040", "789", 6000.00, silvioSantos);
    }

    @Test
    public void deveRealizarTransacao() {
        contaXuxa.deveRealizarTransferencia(1000.00, contaSilvio);
        assertEquals(2000.00, contaXuxa.getBalance());
        assertEquals(7000.00, contaSilvio.getBalance());
    }
    @Test
    public void naoDeveRealizarTransacaoComSaldoInvalido() {
        boolean resultado = contaXuxa.deveRealizarTransferencia(10000.00, contaSilvio);
        assertFalse(resultado);
    }

}