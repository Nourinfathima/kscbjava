
import java.util.Scanner;
import java.sql.*;
public class Kscb {
    public static void main(String[] args) {
        int choice, consumerCode;
        String consumerName, consumerPhone, consumerEmail, consumerAddress;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("select an option");
            System.out.println("1.add consumer");
            System.out.println("2.search consumer");
            System.out.println("3.delete consumer");
            System.out.println("4.update consumer");
            System.out.println("5.view consumer");
            System.out.println("6.genarate consumerbill");
            System.out.println("7.view consumerbill");
            System.out.println("8.Exit");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("add consumer");
                    System.out.println("Add Consumer");
                    System.out.println("Enter the consumer code: ");
                    consumerCode = input.nextInt();
                    System.out.println("Enter Consumer Name: ");
                    consumerName = input.next();
                    System.out.println("Enter Consumer Phone: ");
                    consumerPhone = input.next();
                    System.out.println("Enter Consumer Email Id: ");
                    consumerEmail = input.next();
                    System.out.println("Enter Consumer Address: ");
                    consumerAddress = input.next();
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb","root","");
                        String sql = "INSERT INTO `consumer`(`consumerCode`, `consumerName`, `consumerPhone`, `consumerEmail`, `consumerAddress`) VALUES (?,?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setInt(1,consumerCode);
                        stmt.setString(2,consumerName);
                        stmt.setString(3,consumerPhone);
                        stmt.setString(4,consumerEmail);
                        stmt.setString(5,consumerAddress);
                        stmt.executeUpdate();
                        System.out.println("Data inserted successfully.");
                    }
                    catch (Exception e ){
                        System.out.println(e);
                    }
                    break;
                case 2:
                    System.out.println("Search Consumer");
                    System.out.println("Enter the Consumer Code/Name/Phone to search: ");
                    String searchOption = input.next();
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb", "root", "");
                        String sql = "SELECT `consumerCode`, `consumerName`, `consumerPhone`, `consumerEmail`, `consumerAddress` FROM `consumer` WHERE `consumerCode` ='"+searchOption+"'  OR `consumerName`='"+searchOption+"' OR `consumerPhone` ='"+searchOption+"' ";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()){
                            String getConsumerCode = rs.getString("consumerCode");
                            String getConsumerName = rs.getString("consumerName");
                            String getConsumerPhone = rs.getString("consumerPhone");
                            String getConsumerEmail = rs.getString("consumerEmail");
                            String getConsumerAddress = rs.getString("consumerAddress");
                            System.out.println("Consumer Code="+getConsumerCode);
                            System.out.println("Consumer Name="+getConsumerName);
                            System.out.println("Consumer Phone="+getConsumerPhone);
                            System.out.println("Consumer Email="+getConsumerEmail);
                            System.out.println("Consumer Address="+getConsumerAddress);
                        }
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }

                    break;
                case 3:
                    System.out.println("Delete Consumer");
                    System.out.println("Enter the consumer code to delete: ");
                    consumerCode = input.nextInt();
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb", "root", "");
                        String sql = "DELETE FROM `consumer` WHERE `consumerCode` = "+consumerCode;
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("Consumer Data deleted successfully.");
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 4:
                    System.out.println("Update Consumer");
                    System.out.println("Enter the consumer code: ");
                    consumerCode = input.nextInt();
                    System.out.println("Enter Consumer Name to update: ");
                    consumerName = input.next();
                    System.out.println("Enter Consumer Phone to update: ");
                    consumerPhone = input.next();
                    System.out.println("Enter Consumer Email Id to update: ");
                    consumerEmail = input.next();
                    System.out.println("Enter Consumer Address to update: ");
                    consumerAddress = input.next();
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb", "root", "");
                        String sql = "UPDATE `consumer` SET `consumerName`='"+consumerName+"',`consumerPhone`='"+consumerPhone+"',`consumerEmail`='"+consumerEmail+"',`consumerAddress`='"+consumerAddress+"' WHERE `consumerCode` = "+consumerCode;
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("Consumer Data updated successfully.");
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 5:
                    System.out.println("View all Consumers");
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb","root","");
                        String sql = "SELECT `consumerCode`, `consumerName`, `consumerPhone`, `consumerEmail`, `consumerAddress` FROM `consumer` ";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()){
                            String getConsumerCode = rs.getString("consumerCode");
                            String getConsumerName = rs.getString("consumerName");
                            String getConsumerPhone = rs.getString("consumerPhone");
                            String getConsumerEmail = rs.getString("consumerEmail");
                            String getConsumerAddress = rs.getString("consumerAddress");

                            System.out.println("Consumer Code="+getConsumerCode);
                            System.out.println("Consumer Name="+getConsumerName);
                            System.out.println("Consumer Phone="+getConsumerPhone);
                            System.out.println("Consumer Email="+getConsumerEmail);
                            System.out.println("Consumer Address="+getConsumerAddress+"\n");

                        }

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }


                    break;
                case 6:
                    System.out.println("genarate consumerbill");
                    break;
                case 7:
                    System.out.println("view consumerbill");
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        }
    }
}
