import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.List;

public class SurvivalFrame extends JFrame {
    private final TraineeDAO dao = new TraineeDAO();
    private JTable tabelKlasemen;
    private DefaultTableModel modelKlasemen;
    private JLabel lblStatus;
    private JLabel lblTerpilih;
    private JComboBox<String> cmbLagu; // buat bikin dropdown
    private JButton btnVote;
    private JButton btnSetLagu;
    private JButton btnEliminasi;
    private JButton btnDaftar;

    private String idTerpilih = null;
    private int rankTerpilih = 0;

    public SurvivalFrame (){
        setTitle("Boys Planet - Live Ranking & Stage Lineup");
        setSize(730,440);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10,10));

        komponenVisual();
        aksiReaksi();
        muatDataAwal();
    }

    public void komponenVisual(){
        JPanel panelHeader = new JPanel(new BorderLayout());
        panelHeader.setBorder(BorderFactory.createEmptyBorder(12,15,5,15));

        JLabel lblJudul = new JLabel("LIVE SURVIVAL RANKING & STAGE LINEUP");
        lblJudul.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblStatus = new JLabel("Ready");
        lblStatus.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblStatus.setForeground(new Color(0, 128, 0));

        panelHeader.add(lblJudul, BorderLayout.WEST);
        panelHeader.add(lblStatus, BorderLayout.EAST);

        String[] kolom = {"Rank", "ID", "Nama Trainee", "Tgl Lahir", "ID Lagu", "Lagu Misi", "Original Artist"};
        modelKlasemen = new DefaultTableModel(kolom, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabelKlasemen = new JTable(modelKlasemen);
        tabelKlasemen.setRowHeight(24);
        JScrollPane scrollTabel = new JScrollPane(tabelKlasemen);
        scrollTabel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 15));

        JPanel panelBawah = new JPanel(new GridLayout(2, 1, 5, 8));
        panelBawah.setBorder(BorderFactory.createEmptyBorder(8, 15, 15, 15));
        JPanel panelInteraksi = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        lblTerpilih = new JLabel("Pilih trainee di tabel:");
        btnVote = new JButton("Vote (+1 Rank)");
        cmbLagu = new JComboBox<>();
        btnSetLagu = new JButton("Set Lagu Misi");
        btnEliminasi = new JButton("Eliminasi");
        setKontrolAktif(false);

        panelInteraksi.add(lblTerpilih);
        panelInteraksi.add(btnVote);
        panelInteraksi.add(cmbLagu);
        panelInteraksi.add(btnSetLagu);
        panelInteraksi.add(btnEliminasi);

        JPanel panelDaftar = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        btnDaftar = new JButton("+ Daftarkan Trainee Baru");
        panelDaftar.add(btnDaftar);

        panelBawah.add(panelInteraksi);
        panelBawah.add(panelDaftar);

        add(panelHeader, BorderLayout.NORTH);
        add(scrollTabel, BorderLayout.CENTER);
        add(panelBawah, BorderLayout.SOUTH);
    }

    private void aksiReaksi(){
       tabelKlasemen.getSelectionModel().addListSelectionListener(e -> {
            int baris = tabelKlasemen.getSelectedRow();
            if (baris != -1) {
                rankTerpilih = Integer.parseInt(modelKlasemen.getValueAt(baris, 0).toString());
                idTerpilih = modelKlasemen.getValueAt(baris, 1).toString();
                String nama = modelKlasemen.getValueAt(baris, 2).toString();
                String idLagu = modelKlasemen.getValueAt(baris, 4).toString();

                lblTerpilih.setText("Terpilih: " + nama + " (#" + rankTerpilih + ")");
                pilihComboLagu(idLagu);
                setKontrolAktif(true);
            }
        }); 

        btnVote.addActionListener(e -> {
            if (idTerpilih != null && rankTerpilih > 1) {
                eksekusiDatabaseThread("Saving...", () -> dao.updateRank(idTerpilih, rankTerpilih - 1));
            } else {
                JOptionPane.showMessageDialog(this, "Trainee ini sudah berada di Peringkat #1!");
            }
        });

        btnSetLagu.addActionListener(e -> {
            if (idTerpilih != null && cmbLagu.getSelectedItem() != null) {
                String idLaguBaru = cmbLagu.getSelectedItem().toString().split(" - ")[0];
                eksekusiDatabaseThread("Saving...", () -> dao.updateLagu(idTerpilih, idLaguBaru));
            }
        });

        btnEliminasi.addActionListener(e -> {
            if (idTerpilih != null) {
                int tanya = JOptionPane.showConfirmDialog(this,
                        "Eliminasi trainee " + idTerpilih + " dari klasemen?",
                        "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (tanya == JOptionPane.YES_OPTION) {
                    eksekusiDatabaseThread("Deleting...", () -> dao.hapusTrainee(idTerpilih));
                }
            }
        });

        btnDaftar.addActionListener(e -> tampilkanDialogDaftar());
    }

    private void muatDataAwal() {
        eksekusiDatabaseThread("Loading...", () -> {
            List<String> laguList = dao.getDaftarLagu();
            SwingUtilities.invokeLater(() -> {
                cmbLagu.removeAllItems();
                for (String item : laguList) cmbLagu.addItem(item);
            });
        });
    }

    private void tampilkanDialogDaftar() {
        JTextField txtId = new JTextField();
        JTextField txtNama = new JTextField();
        JTextField txtRank = new JTextField();
        JTextField txtTgl = new JTextField("2005-01-01");
        JComboBox<String> cmbLaguBaru = new JComboBox<>();
        for (int i = 0; i < cmbLagu.getItemCount(); i++) {
            cmbLaguBaru.addItem(cmbLagu.getItemAt(i));
        }

        JPanel form = new JPanel(new GridLayout(5, 2, 6, 6));
        form.add(new JLabel("ID Trainee (misal TR09):")); form.add(txtId);
        form.add(new JLabel("Nama Lengkap:")); form.add(txtNama);
        form.add(new JLabel("Rank Awal:")); form.add(txtRank);
        form.add(new JLabel("Tgl Lahir (YYYY-MM-DD):")); form.add(txtTgl);
        form.add(new JLabel("Lagu Audisi:")); form.add(cmbLaguBaru);

        int hasil = JOptionPane.showConfirmDialog(this, form, "Daftarkan Trainee Baru", JOptionPane.OK_CANCEL_OPTION);
        if (hasil == JOptionPane.OK_OPTION && !txtId.getText().trim().isEmpty()) {
            String id = txtId.getText().trim();
            String nama = txtNama.getText().trim();
            int rank = Integer.parseInt(txtRank.getText().trim());
            String tgl = txtTgl.getText().trim();
            String idLagu = cmbLaguBaru.getSelectedItem().toString().split(" - ")[0];

            eksekusiDatabaseThread("Saving...", () -> dao.tambahTrainee(id, nama, rank, tgl, idLagu));
        }
    }

    private interface AksiDatabase {
        void jalankan() throws Exception;
    }

    private void eksekusiDatabaseThread(String pesanStatus, AksiDatabase aksi){
        
        btnDaftar.setEnabled(false);
        setKontrolAktif(false);
        lblStatus.setText(pesanStatus);
        lblStatus.setForeground(Color.ORANGE.darker());

        new Thread(()->{
            try{
                Thread.sleep(700);
                aksi.jalankan();

                List<Trainee> daftarTrainee = dao.getSemuaKlasmen();

                SwingUtilities.invokeLater(()->{
                  modelKlasemen.setRowCount(0);
                  for (Trainee t : daftarTrainee){
                    modelKlasemen.addRow(new Object[]{
                        t.getRank(), t.getIdTrainee(), t.getNama(), t.getTglLahir(), t.getIdLagu(), t.getJudulLagu(), t.getOgSinger()
                    });
                  }
                    lblStatus.setText("Saved & Synced!");
                    lblStatus.setForeground(new Color(0, 128, 0));
                    lblTerpilih.setText("Pilih trainee di tabel:");
                    idTerpilih = null;
                    btnDaftar.setEnabled(true);
                });
            }catch(Exception ex){
              SwingUtilities.invokeLater(() -> {
                    lblStatus.setText("Failed!");
                    lblStatus.setForeground(Color.RED);
                    btnDaftar.setEnabled(true);
                    JOptionPane.showMessageDialog(this, "Kesalahan Database: " + ex.getMessage());
                });  
            }
        }).start();
    }

    private void pilihComboLagu(String idLagu) {
        for (int i = 0; i < cmbLagu.getItemCount(); i++) {
            if (cmbLagu.getItemAt(i).startsWith(idLagu + " -")) {
                cmbLagu.setSelectedIndex(i);
                break;
            }
        }
    }

    private void setKontrolAktif(boolean aktif) {
        btnVote.setEnabled(aktif);
        cmbLagu.setEnabled(aktif);
        btnSetLagu.setEnabled(aktif);
        btnEliminasi.setEnabled(aktif);
    }
}
