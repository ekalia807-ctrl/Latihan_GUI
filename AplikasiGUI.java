import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AplikasiGUI {
    public static void main(String[] args) {
        // 1. Top Level Container (Menggunakan JFrame)
        JFrame frame = new JFrame("Aplikasi Pendataan Sederhana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 200);

        // 2. Intermediate Container (Menggunakan JPanel)
        JPanel panel = new JPanel();
        
        // 3. Layout Manager 
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        panel.setLayout(layout);

        // 4. Atomic Component (JLabel, JTextField, JButton)
        JLabel labelNama = new JLabel("Masukkan Nama:");
        JTextField textNama = new JTextField(20);
        JButton btnSimpan = new JButton("Simpan");
        JButton btnReset = new JButton("Reset");
        JLabel labelHasil = new JLabel("Status: Belum ada data.");

        // 5. Event Handling - Interface 1: ActionListener (Untuk klik tombol)
        btnSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textNama.getText();
                if(nama.isEmpty()){
                    labelHasil.setText("Status: Nama tidak boleh kosong!");
                } else {
                    labelHasil.setText("Status: Data '" + nama + "' berhasil disimpan.");
                }
            }
        });

        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textNama.setText("");
                labelHasil.setText("Status: Form direset.");
            }
        });

        // 5. Event Handling: KeyListener Untuk deteksi ketikan di text field
        textNama.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {}
            public void keyPressed(KeyEvent e) {}
            public void keyReleased(KeyEvent e) {
                // Teks akan update otomatis setiap kali user mengetik
                labelHasil.setText("Mengetik... " + textNama.getText());
            }
        });

        // Menambahkan komponen ke dalam panel
        panel.add(labelNama);
        panel.add(textNama);
        panel.add(btnSimpan);
        panel.add(btnReset);
        panel.add(labelHasil);

        // Menambahkan panel ke frame
        frame.getContentPane().add(panel);
        
        // Menampilkan frame
        frame.setVisible(true);
    }
}