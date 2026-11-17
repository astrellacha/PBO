import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 1. Class khusus tampilan GUI (mewarisi JFrame)
class FormTrainee extends JFrame {
    
    private JTextField txtNama, txtId, txtSpeciality;
    private JButton btnTampil, btnHapus;
    private JTextArea areaHasil;


    public FormTrainee() {
        super("Form Biodata Trainee"); // Mengatur judul JFrame
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
       
        // Memanggil method penyusun komponen & event
        komponenVisual();
        aksiReaksi();

        setLocationRelativeTo(null);
    }

    // Method untuk menyusun Intermediate & Atomic Components
    private void komponenVisual() {
        // Intermediate Container 1
        JPanel panelInput = new JPanel(new GridLayout(3, 2, 5, 5));
        panelInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));

        // Atomic Components
        txtNama = new JTextField();
        txtId = new JTextField();
        txtSpeciality = new JTextField();

        panelInput.add(new JLabel("Nama Lengkap: "));
        panelInput.add(txtNama);
        panelInput.add(new JLabel("ID: "));
        panelInput.add(txtId);
        panelInput.add(new JLabel("Speciality: "));
        panelInput.add(txtSpeciality);

        // Intermediate Container 2
        JPanel panelTombol = new JPanel();
        btnTampil = new JButton("Tampilkan Data");
        btnHapus = new JButton("Bersihkan");
        panelTombol.add(btnTampil);
        panelTombol.add(btnHapus);

        // Intermediate Container 3 & Atomic Component hasil
        areaHasil = new JTextArea(5, 30);
        areaHasil.setEditable(false);
        JScrollPane scrollHasil = new JScrollPane(areaHasil);

        // Menambahkan semua panel ke JFrame ini
        add(panelInput, BorderLayout.NORTH);
        add(panelTombol, BorderLayout.CENTER);
        add(scrollHasil, BorderLayout.SOUTH);
    }

    // Method untuk menangani Event Handling
    private void aksiReaksi() {
        btnTampil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = txtNama.getText();
                String id = txtId.getText();
                String speciality = txtSpeciality.getText();

                areaHasil.setText("=== DATA Trainee ===\n"
                                + "Nama       : " + nama + "\n"
                                + "ID         : " + id + "\n"
                                + "Speciality : " + speciality);
            }
        });

        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNama.setText("");
                txtId.setText("");
                txtSpeciality.setText("");
                areaHasil.setText("");
            }
        });
    }
}
public class Example1 {
    public static void main(String[] args) {
        new FormTrainee().setVisible(true);
    }
}