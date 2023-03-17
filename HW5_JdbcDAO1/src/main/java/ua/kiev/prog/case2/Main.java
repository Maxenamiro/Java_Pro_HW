package ua.kiev.prog.case2;

import ua.kiev.prog.shared.Client;
import ua.kiev.prog.shared.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = ConnectionFactory.getConnection())
        {
            // remove this
            try {
                try (Statement st = conn.createStatement()) {
                    st.execute("DROP TABLE IF EXISTS Clients");
                    //st.execute("CREATE TABLE Clients (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20) NOT NULL, age INT)");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            ClientDAOImpl2 dao = new ClientDAOImpl2(conn, "Clients");
            dao.createTable(Client.class);

            Client a = new Client("test1", 1);
            Client b = new Client("test2", 2);
            Client c = new Client("test3", 3);
            dao.add(a);
            dao.add(b);
            dao.add(c);
            //DZ#1 -- int id = c.getId();
            int id = b.getId();
            System.out.println(id);
           // List<Client> list = dao.getAll(Client.class, "name", "age");
            List<Client> list = dao.getAll(Client.class,  "age");
            for (Client cli : list)
                System.out.println(cli);

            list.get(0).setAge(55);
            dao.update(list.get(0));

            /*DZ#2

            List<Client> list = dao.getAll(Client.class, "name", "age");
            List<Client> list = dao.getAll(Client.class, "age");
            for (Client cli : list)
                System.out.println(cli);

             */

            dao.delete(list.get(0));
        }
    }
}

