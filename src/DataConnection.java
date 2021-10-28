import java.sql.*;

public class DataConnection {
    public static final String url = "jdbc:mysql://localhost:3306/mydictionary";
    public static final String user_name = "root";
    public static final String password = "#Xuanthang123";

    private Connection connection;
    private PreparedStatement preparedStatement;

    /** constructor. */
    public DataConnection() {
        try{
            connection = DriverManager.getConnection(url, user_name, password);
            preparedStatement = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String search(String word) {
        String result = null;
        try {
            String order = "select * from tbl_edict where word like '" + word +"'";
            preparedStatement = connection.prepareStatement(order);
            ResultSet resultSet = preparedStatement.executeQuery(order);
            if (resultSet.next()) {
                result = resultSet.getString("detail");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("somthing went wrong when try to access to database");
        } finally {
            closeConnection();
            return result;
        }
    }

    /** insert data into the database. */
    public boolean insertData(String word, String definition) {
        boolean result = false;
        try{
            String order = "insert into second_dict value('" + word +"','"+definition+"')";
            preparedStatement = connection.prepareStatement(order);
            preparedStatement.execute();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("something went wrong when try to insert data into database");
        } finally {
            closeConnection();
            return  result;
        }
    }

}
