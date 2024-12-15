import java.sql.*;


public class Main {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/ovchip";
        String user = "postgres";
        String password = "";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Verbinding succesvol!");


            stmt = conn.createStatement();
            String sql = "SELECT * FROM reiziger";
            rs = stmt.executeQuery(sql);


            while (rs.next()) {
                int id = rs.getInt("reiziger_id");
                String voorletters = rs.getString("voorletters");
                String tussenvoegsel = rs.getString("tussenvoegsel");
                String achternaam = rs.getString("achternaam");
                String geboortedatum = rs.getString("geboortedatum");

                System.out.println("ID: " + id + ", Naam: " + voorletters + " " +
                        (tussenvoegsel != null ? tussenvoegsel + " " : "") + achternaam + ", Geboortedatum: " + geboortedatum);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}