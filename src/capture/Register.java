/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capture;

import java.awt.Frame;
import util.ConectaBanco;
import util.TrainLBPH;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import org.bytedeco.javacpp.BytePointer;
import static org.bytedeco.opencv.global.opencv_core.flip;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imencode;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;
import org.bytedeco.opencv.global.opencv_imgproc;
import static org.bytedeco.opencv.global.opencv_imgproc.COLOR_BGRA2GRAY;
import static org.bytedeco.opencv.global.opencv_imgproc.cvtColor;
import static org.bytedeco.opencv.global.opencv_imgproc.rectangle;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Rect;
import org.bytedeco.opencv.opencv_core.RectVector;
import org.bytedeco.opencv.opencv_core.Scalar;
import org.bytedeco.opencv.opencv_core.Size;
import org.bytedeco.opencv.opencv_objdetect.CascadeClassifier;
import org.bytedeco.opencv.opencv_videoio.VideoCapture;
/**
 *
 * @author ACER
 */
public class Register extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
    private Register.DaemonThread myThread = null;

    //JavaCV
    VideoCapture webSource = null;
    Mat cameraImage = new Mat();
    CascadeClassifier cascade = new CascadeClassifier("G:\\TUGAS AKHIR WWOOOYYOOOOO\\Java\\FacEmot_v1\\lib\\haarcascade_frontalface_alt2.xml");

    BytePointer mem = new BytePointer();
    RectVector detectedFaces = new RectVector();

    int numSamples = 50, sample = 1, idPerson;

    //Connection
    ConectaBanco conecta = new ConectaBanco();

    /**
     * @param parent It's the JFrame that's calling it
     * @param modal is a window that blocks access to other windows while it is
     * not clicked.
     */
    
    public Register() {
//        super(parent, modal);
        initComponents();
        getIdUser();
        startCamera();

    }

//    private Register() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        saveButton = new keeptoo.KButton();
        kGradientPanel5 = new keeptoo.KGradientPanel();
        keterangan_field = new javax.swing.JTextField();
        label_photo = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txt_id_label = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        nama_lengkap_field = new javax.swing.JTextField();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        kamera_field = new javax.swing.JTextField();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jarak_kamera_field = new javax.swing.JTextField();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        ekspresi_field = new javax.swing.JTextField();
        counterLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        saveButton.setText("Finish");
        saveButton.setkAllowTab(false);
        saveButton.setkEndColor(new java.awt.Color(118, 195, 118));
        saveButton.setkHoverEndColor(new java.awt.Color(22, 92, 22));
        saveButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        saveButton.setkHoverStartColor(new java.awt.Color(80, 142, 80));
        saveButton.setkPressedColor(new java.awt.Color(28, 72, 28));
        saveButton.setkStartColor(new java.awt.Color(87, 167, 87));
        saveButton.setOpaque(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        kGradientPanel5.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel5.setkEndColor(new java.awt.Color(57, 114, 227));
        kGradientPanel5.setkFillBackground(false);
        kGradientPanel5.setkStartColor(new java.awt.Color(122, 227, 192));
        kGradientPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        keterangan_field.setBorder(null);
        keterangan_field.setOpaque(false);
        kGradientPanel5.add(keterangan_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 440, 150));

        label_photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(100, 100, 100));
        jLabel12.setText("Register Face");

        jPanel1.setBackground(new java.awt.Color(90, 68, 193));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(90, 68, 193));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("ID Face");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 40));

        txt_id_label.setBackground(new java.awt.Color(90, 68, 193));
        txt_id_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_id_label.setForeground(new java.awt.Color(255, 255, 255));
        txt_id_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_id_label.setText("1");
        jPanel1.add(txt_id_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 40, 40));

        kGradientPanel1.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkEndColor(new java.awt.Color(57, 114, 227));
        kGradientPanel1.setkFillBackground(false);
        kGradientPanel1.setkStartColor(new java.awt.Color(122, 227, 192));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nama_lengkap_field.setBorder(null);
        nama_lengkap_field.setOpaque(false);
        kGradientPanel1.add(nama_lengkap_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 200, 30));

        kGradientPanel2.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkEndColor(new java.awt.Color(57, 114, 227));
        kGradientPanel2.setkFillBackground(false);
        kGradientPanel2.setkStartColor(new java.awt.Color(122, 227, 192));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kamera_field.setBorder(null);
        kamera_field.setOpaque(false);
        kGradientPanel2.add(kamera_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 30));

        kGradientPanel3.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel3.setkEndColor(new java.awt.Color(57, 114, 227));
        kGradientPanel3.setkFillBackground(false);
        kGradientPanel3.setkStartColor(new java.awt.Color(122, 227, 192));
        kGradientPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jarak_kamera_field.setBorder(null);
        jarak_kamera_field.setOpaque(false);
        kGradientPanel3.add(jarak_kamera_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 200, 30));

        kGradientPanel4.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel4.setkEndColor(new java.awt.Color(57, 114, 227));
        kGradientPanel4.setkFillBackground(false);
        kGradientPanel4.setkStartColor(new java.awt.Color(122, 227, 192));
        kGradientPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ekspresi_field.setBorder(null);
        ekspresi_field.setOpaque(false);
        kGradientPanel4.add(ekspresi_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 30));

        counterLabel.setBackground(new java.awt.Color(255, 255, 255));
        counterLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        counterLabel.setForeground(new java.awt.Color(32, 78, 199));
        counterLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        counterLabel.setText("00/50");
        counterLabel.setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("After registration, capture 50 photos.");

        jLabel2.setText("Nama Lengkap");

        jLabel3.setText("Kamera");

        jLabel4.setText("Jarak Kamera (cm)");

        jLabel5.setText("Ekspresi");

        jLabel6.setText("Keterangan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(kGradientPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(kGradientPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(51, 51, 51))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(counterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(90, 90, 90))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kGradientPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addGap(35, 35, 35)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kGradientPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(counterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        saveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

    }//GEN-LAST:event_saveButtonActionPerformed

    private int getIdUser() {
        int id = 0;
        conecta.conexao();
        conecta.executaSQL("SELECT * FROM dataset_register ORDER BY id_regis DESC LIMIT 1");
        try {
            conecta.rs.first();
            txt_id_label.setText(String.valueOf(conecta.rs.getInt("id_regis")));
            id = Integer.parseInt(txt_id_label.getText());
            id++;
            txt_id_label.setText(String.valueOf(id));
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
    
    class DaemonThread implements Runnable {

        protected volatile boolean runnable = false;

        @Override
        public void run() {
            synchronized (this) {
                while (runnable) {
                    try {
                        if (webSource.grab()) {
                            webSource.retrieve(cameraImage);
                            Graphics g = label_photo.getGraphics(); //mostra a imagem no jlabel

                            Mat imageColor = new Mat(); //imagem colorida
                            imageColor = cameraImage;

                            Mat imageGray = new Mat(); //imagem pb
                            cvtColor(imageColor, imageGray, COLOR_BGRA2GRAY);
//                            flip(cameraImage, cameraImage, +1);

                            RectVector detectedFaces = new RectVector(); //face detectada
                            cascade.detectMultiScale(imageColor, detectedFaces, 1.1, 1, 1, new Size(150, 150), new Size(500, 500));

                            for (int i = 0; i < detectedFaces.size(); i++) { //repetição pra encontrar as faces
                                Rect dadosFace = detectedFaces.get(0);

                                rectangle(imageColor, dadosFace, new Scalar(255, 255, 0, 2), 3, 0, 0);

                                Mat face = new Mat(imageGray, dadosFace);
                                opencv_imgproc.resize(face, face, new Size(160, 160));

                                if (saveButton.getModel().isPressed()) { //quando apertar o botão saveButton
                                    if (nama_lengkap_field.getText().equals("") || nama_lengkap_field.getText().equals(" ")) {
                                        JOptionPane.showMessageDialog(null, "Mohon Kolom diisi!");
                                    } else if (nama_lengkap_field.getText().equals("") || nama_lengkap_field.getText().equals(" ")) {
                                        JOptionPane.showMessageDialog(null, "Mohon Kolom diisi!");
                                    } else if (kamera_field.getText().equals("") || kamera_field.getText().equals(" ")) {
                                        JOptionPane.showMessageDialog(null, "Mohon Kolom diisi!");
                                    } 
//                                    else if (txt_office.getText().equals("") || txt_office.getText().equals(" ")) {
//                                        JOptionPane.showMessageDialog(null, "Campo vazio");
//                                    } 
                                    else {
                                        if (sample <= numSamples) {
//                                        salva a imagem cortada [160,160]
//                                        nome do arquivo: idpessoa + a contagem de fotos. ex: person.10(id).6(sexta foto).jpg
                                            String cropped = "G:\\TUGAS AKHIR WWOOOYYOOOOO\\Java\\FacEmot_v1\\src\\photos\\person." + txt_id_label.getText() + "." + sample + ".jpg";
                                            imwrite(cropped, face);

                                            //System.out.println("Foto " + amostra + " capturada\n");
                                            counterLabel.setText(String.valueOf(sample) + "/50");
                                            sample++;
                                        }
                                        if (sample > 50) {
                                            new TrainLBPH().trainPhotos();//se a contagem for maior que 25, termina de tirar a foto, gera o arquivo
                                            insertDatabase(); //insere os dados no banco

                                            System.out.println("File Generated");
                                            stopCamera(); // e fecha a camera
                                        }

                                    }
                                }
                            }

                            imencode(".bmp", cameraImage, mem);
                            Image im = ImageIO.read(new ByteArrayInputStream(mem.getStringBytes()));
                            BufferedImage buff = (BufferedImage) im;
                            try {
                                if (g.drawImage(buff, 0, 0, 500, 500, 0, 0, buff.getWidth(), buff.getHeight(), null)) {
                                    if (runnable == false) {
                                        System.out.println("Salve a Foto");
                                        this.wait();
                                    }
                                }
                            } catch (Exception e) {
                            }
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * This method inserts the information into the database.
     */
    public void insertDatabase() {
        ControlPerson cod = new ControlPerson();
        ModelPerson mod = new ModelPerson();

        mod.setId_regis(Integer.parseInt(txt_id_label.getText()));
        mod.setNama_lengkap(nama_lengkap_field.getText());
        mod.setKamera(kamera_field.getText());
        mod.setJarak_layar(Integer.parseInt(jarak_kamera_field.getText()));
        mod.setEkspresi(ekspresi_field.getText());
        mod.setKeterangan(keterangan_field.getText());
//        mod.setInstagram(txt_instagram.getText());
//        mod.setLinkedin(txt_linkedin.getText());
//        mod.setGithub(txt_github.getText());
        cod.insert(mod);
    }

    public void stopCamera() {
        myThread.runnable = false;
        webSource.release();
        dispose();
    }

    /**
     * This method connects the software to the web cam.
     * <br><br>
     * VideoCapture(0); is the default camera on your computer.
     */
    public void startCamera() {
        new Thread() {
            @Override
            public void run() {
                webSource = new VideoCapture(0);

                myThread = new Register.DaemonThread();
                Thread t = new Thread(myThread);
                t.setDaemon(true);
                myThread.runnable = true;
                t.start();
            }
        }.start();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel counterLabel;
    private javax.swing.JTextField ekspresi_field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jarak_kamera_field;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel4;
    private keeptoo.KGradientPanel kGradientPanel5;
    private javax.swing.JTextField kamera_field;
    private javax.swing.JTextField keterangan_field;
    private javax.swing.JLabel label_photo;
    private javax.swing.JTextField nama_lengkap_field;
    private keeptoo.KButton saveButton;
    private javax.swing.JLabel txt_id_label;
    // End of variables declaration//GEN-END:variables
}
