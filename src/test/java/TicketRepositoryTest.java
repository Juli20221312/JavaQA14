import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

public class TicketRepositoryTest {

    Ticket ticket1 = new Ticket(1, "OMS", "DME", 1000, 160);
    Ticket ticket2 = new Ticket(2, "OMS", "DME", 1100, 170);
    Ticket ticket3 = new Ticket(3, "ARH", "VKO", 800, 80);
    Ticket ticket4 = new Ticket(4, "OMS", "DME", 990, 165);
    Ticket ticket5 = new Ticket(5, "HMA", "AER", 1300, 190);
    Ticket ticket6 = new Ticket(6, "KGD", "LED", 700, 70);

    @Test
    public void shouldAdd() {
        TicketRepository repo = new TicketRepository();
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemove() {
        TicketRepository repo = new TicketRepository();
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.removeById(5);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket6};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


}
