package apartmentsJDBC;

import java.sql.*;
import java.util.PriorityQueue;

public class RequestJDBC {
   private int district;
    private int nRoom;
    private int price;
    private int from;
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/db_appartments";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "sadd72131hg!@";
    private RequestJDBC rj;
    static Connection conn;
    private Statement stmt;
    private String sql;

    public RequestJDBC(int district, int nRoom, int price, int from) {
        this.district = district;
        this.nRoom = nRoom;
        this.price = price;
        this.from = from;
    }

    public RequestJDBC() {
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public int getnRoom() {
        return nRoom;
    }

    public void setnRoom(int nRoom) {
        this.nRoom = nRoom;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public void searcherDB(RequestJDBC rj){
        ToSQL t =  new ToSQL();
        System.out.println();
        System.out.println("district - "+ rj.getDistrict()+ ",   room - "+rj.getnRoom()+ ",   is owner "+rj.getFrom());
        System.out.println();
        sql = t.toSQL(rj);
        System.out.println(sql);
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PreparedStatement ps = null;
        try {
            ps = null;
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            ps = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        ResultSetMetaData md = null;
        try {
            md = rs.getMetaData();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            for (int i = 1; i <= md.getColumnCount(); i++) {
                System.out.print(md.getColumnName(i) + "\t\t");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
        try {
            while (rs.next()) {
                try {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        System.out.print(rs.getString(i) + "\t\t");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
