import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;
import ru.netology.domain.TicketManager;


public class TicketManagerTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);
    Ticket ticket1 = new Ticket(1, "OMS", "DME", 1000, 160);
    Ticket ticket2 = new Ticket(2, "OMS", "DME", 1100, 170);
    Ticket ticket3 = new Ticket(3, "ARH", "VKO", 800, 80);
    Ticket ticket4 = new Ticket(4, "OMS", "DME", 990, 165);
    Ticket ticket5 = new Ticket(5, "HMA", "AER", 1300, 190);
    Ticket ticket6 = new Ticket(6, "KGD", "LED", 700, 70);

    @BeforeEach
    public void setup() {
        manager.save(ticket1);
        manager.save(ticket2);
        manager.save(ticket3);
        manager.save(ticket4);
        manager.save(ticket5);
        manager.save(ticket6);

    }

    @Test
    public void shouldSearchOMS() {
        Ticket[] expected = {ticket4, ticket1, ticket2};
        Ticket[] actual = manager.findAll("OMS", "DME");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchHMA() {
        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.findAll("HMA", "AER");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNull() {
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("MSK", "AMG");

        Assertions.assertArrayEquals(expected, actual);
    }


}
