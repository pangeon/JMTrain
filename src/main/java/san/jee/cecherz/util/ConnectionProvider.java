package san.jee.cecherz.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionProvider {
    private static DataSource ds;

    public static Connection connect() throws SQLException {
        return getDSInstance().getConnection();
    }

    public static DataSource getDSInstance() {
        if (ds == null) {
            try {
                Context ic = new InitialContext();
                Context ec = (Context) ic.lookup("java:comp/env");
                ds = (DataSource) ec.lookup("jdbc/JMTrainDB");
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return ds;
    }
}