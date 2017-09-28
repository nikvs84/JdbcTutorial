import bl.Util;

import java.sql.Connection;
import java.sql.SQLException;

public class Domain {
    public static void main(String[] args) throws SQLException {
        Util util = new Util();

        Connection connection = util.getConnection();

        connection.close();

    }
}
