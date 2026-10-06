import org.example.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deveNotificarUmCliente() {
        Produto produto = new Produto(9836, "Mousepad", "Kabum");
        Cliente cliente = new Cliente("Cliente 1");
        cliente.confirmarEntrega(produto);
        produto.emitirComprovanteEntrega();
        assertEquals("Cliente 1, produto Produto{codigo=9836, produto='Mousepad', loja='Kabum'} entregue", cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes() {
        Produto produto = new Produto(9836,  "Mousepad", "Kabum");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.confirmarEntrega(produto);
        cliente2.confirmarEntrega(produto);
        produto.emitirComprovanteEntrega();
        assertEquals("Cliente 1, produto Produto{codigo=9836, produto='Mousepad', loja='Kabum'} entregue", cliente1.getUltimaNotificacao());
        assertEquals("Cliente 2, produto Produto{codigo=9836, produto='Mousepad', loja='Kabum'} entregue", cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCliente() {
        Produto produto = new Produto(9836,  "Mousepad", "Kabum");
        Cliente cliente = new Cliente("Cliente 1");
        produto.emitirComprovanteEntrega();
        assertEquals(null, cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClienteProdutoA() {
        Produto produtoA = new Produto(9836, "Mousepad", "Kabum");
        Produto produtoB = new Produto(9836, "Mousepad", "B");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.confirmarEntrega(produtoA);
        cliente2.confirmarEntrega(produtoB);
        produtoA.emitirComprovanteEntrega();
        assertEquals("Cliente 1, produto Produto{codigo=9836, produto='Mousepad', loja='Kabum'} entregue", cliente1.getUltimaNotificacao());
        assertEquals(null, cliente2.getUltimaNotificacao());
    }
}