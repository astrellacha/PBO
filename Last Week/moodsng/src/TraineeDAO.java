import java.sql.*;
import java.util.ArrayList;
import java.util.List; 

public class TraineeDAO {

    // READ (ResultSet & PreparedStatment): mengambil daftar lagu
    public List<String> getDaftarLagu() throws SQLException{
        List<String> daftar = new ArrayList<>();
        String sql = "SELECT id_lagu, judul_lagu FROM lagu ORDER BY id_lagu ASC";
        
        try (Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    daftar.add(rs.getString("id_lagu")+ " - " + rs.getString("judul_lagu"));
                }
            }
        
        return daftar;
    }

    // READ (ResultSet & PreparedStatment): mengambil papan klasmen
    public List<Trainee> getSemuaKlasmen()throws SQLException{
        List<Trainee> list = new ArrayList<>();
        String sql = "SELECT t.id_trainee, t.nama, t.rank, t.tgl_lahir, t.id_lagu, l.judul_lagu, l.og_singer " +
                     "FROM trainee t JOIN lagu l ON t.id_lagu = l.id_lagu ORDER BY t.rank ASC";

        try(Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                list.add(new Trainee(
                    rs.getString("id_trainee"),
                    rs.getString("nama"),
                    rs.getInt("rank"),
                    rs.getString("tgl_lahir"),
                    rs.getString("id_lagu"),
                    rs.getString("judul_lagu"),
                    rs.getString("og_singer")
                ));
            }
        }
        return list;
    }

    // CREATE
    public void tambahTrainee(String id,String nama, int rank, String tglLahir, String idLagu)throws SQLException{
       String sql = "INSERT INTO trainee (id_trainee, nama, rank, tgl_lahir, id_lagu) VALUES (?, ?, ?, ?, ?)";
       Connection conn = null;
       
       try{
        conn = Koneksi.getConnection();
        conn.setAutoCommit(false);
        try (PreparedStatement ps = conn.prepareStatement(sql)){
           ps.setString(1, id);
                ps.setString(2, nama);
                ps.setInt(3, rank);
                ps.setString(4, tglLahir);
                ps.setString(5, idLagu);
                ps.executeUpdate(); 
        }
        conn.commit();   // untuk menyimpan permanen jika sukses   
       }catch(SQLException e){
        if(conn != null)conn.rollback();// membatalkan perubahan jika gagal
        throw e;
       }finally{
        if(conn != null){
            conn.setAutoCommit(true);
            conn.close();
        }
       }
    }

    //Update
    public void updateRank(String idTrainee, int rankBaru) throws SQLException {
        String sql = "UPDATE trainee SET rank = ? WHERE id_trainee = ?";
        Connection conn = null;
        try {
            conn = Koneksi.getConnection();
            conn.setAutoCommit(false);

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, rankBaru);
                ps.setString(2, idTrainee);
                ps.executeUpdate();
            }

            conn.commit();
        } catch (SQLException e) {
            if (conn != null) conn.rollback();
            throw e;
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }

    // Update
    public void updateLagu(String idTrainee, String idLaguBaru) throws SQLException {
        String sql = "UPDATE trainee SET id_lagu = ? WHERE id_trainee = ?";
        Connection conn = null;
        try {
            conn = Koneksi.getConnection();
            conn.setAutoCommit(false);

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, idLaguBaru);
                ps.setString(2, idTrainee);
                ps.executeUpdate();
            }

            conn.commit();
        } catch (SQLException e) {
            if (conn != null) conn.rollback();
            throw e;
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }

    //delete
    public void hapusTrainee(String idTrainee) throws SQLException {
        String sql = "DELETE FROM trainee WHERE id_trainee = ?";
        Connection conn = null;
        try {
            conn = Koneksi.getConnection();
            conn.setAutoCommit(false);

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, idTrainee);
                ps.executeUpdate();
            }

            conn.commit();
        } catch (SQLException e) {
            if (conn != null) conn.rollback();
            throw e;
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }
}
