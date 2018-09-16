package sample.database;

import sample.model.Listing;

import java.sql.*;

public class DatabaseHandler extends Config{
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPassword);
        return dbConnection;
    }

    //Create new listing
    public void createListing(Listing listing) throws SQLException, ClassNotFoundException{
        String insert = "INSERT INTO " + Const.LISTINGS_TABLE + "(" + Const.LISTINGS_COMPANY + "," + Const.LISTINGS_POSITION + "," + Const.LISTINGS_LOCATION + "," + Const.LISTINGS_LINK + ")" + "VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
        preparedStatement.setString(1, listing.getCompany());
        preparedStatement.setString(2, listing.getPosition());
        preparedStatement.setString(3, listing.getLocation());
        preparedStatement.setString(4, listing.getLink());
        preparedStatement.executeUpdate();
    }
}
