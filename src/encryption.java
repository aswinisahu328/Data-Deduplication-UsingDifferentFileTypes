import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
public class encryption extends javax.swing.JFrame {
    public encryption() {
        initComponents();
        super.setBounds(100, 100, 800, 600);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnbrowse = new javax.swing.JButton();
        txtFolder = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        listFilenames = new java.awt.List();
        txtRealContent = new java.awt.TextArea();
        txtEncrytedCode = new java.awt.TextArea();
        btnbrowse1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Multiple File Encrytion");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 730, 40);

        btnbrowse.setFont(jLabel3.getFont());
        btnbrowse.setText("Browse");
        btnbrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbrowseActionPerformed(evt);
            }
        });
        getContentPane().add(btnbrowse);
        btnbrowse.setBounds(530, 80, 100, 30);

        txtFolder.setFont(jLabel3.getFont());
        getContentPane().add(txtFolder);
        txtFolder.setBounds(190, 80, 330, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Selected Folder");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(80, 80, 110, 20);

        listFilenames.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listFilenamesItemStateChanged(evt);
            }
        });
        listFilenames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listFilenamesActionPerformed(evt);
            }
        });
        getContentPane().add(listFilenames);
        listFilenames.setBounds(40, 120, 340, 330);
        getContentPane().add(txtRealContent);
        txtRealContent.setBounds(390, 120, 330, 160);
        getContentPane().add(txtEncrytedCode);
        txtEncrytedCode.setBounds(390, 290, 330, 160);

        btnbrowse1.setFont(jLabel3.getFont());
        btnbrowse1.setText("Encrypt");
        btnbrowse1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbrowse1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnbrowse1);
        btnbrowse1.setBounds(300, 460, 100, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbrowseActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Select folder for encryption");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            txtFolder.setText(chooser.getSelectedFile() + "");

            for (File n : chooser.getSelectedFile().listFiles()) {
                if (n.getName().endsWith("txt")) {
                    listFilenames.add(n + "");
                }
            }
        } else {
            System.out.println("No Selection ");
        }
    }//GEN-LAST:event_btnbrowseActionPerformed

    private void listFilenamesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listFilenamesItemStateChanged
        f = new File(listFilenames.getSelectedItem());
        txtRealContent.setText(getRealContent());
        txtEncrytedCode.setText(getEncryptedCode());

    }//GEN-LAST:event_listFilenamesItemStateChanged

    private void listFilenamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listFilenamesActionPerformed

    }//GEN-LAST:event_listFilenamesActionPerformed

    private void btnbrowse1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbrowse1ActionPerformed
        for (String fname : listFilenames.getItems()) {
            try {
                f = new File(fname);
                new File(f.getParent() + "//encrypted").mkdir();
                FileWriter fw = new FileWriter(f.getParent() + "//encrypted//" + f.getName());
                fw.write(getEncryptedCode());
                fw.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        JOptionPane.showMessageDialog(null, listFilenames.getItems().length + " files are encrpted successfully");
    }//GEN-LAST:event_btnbrowse1ActionPerformed

    public String getEncryptedCode() {
        String str = getSimpleText();
        List<content> lst = getList(str);
        Collections.sort(lst);
        content c = null;
        realcontent = realcontent.replaceAll("\r\n", " \r\n ");
        realcontent = " " + realcontent.trim() + " ";
        StringBuffer result = new StringBuffer(realcontent);
        //System.out.println(result);
        for (int i = 0; i < lst.size(); i++) {
            c = (content) lst.get(i);
            c.setBitValue(i);
            boolean first = true;
            for (int j = 0; j <= result.length() - c.getValue().length(); j++) {
                String res = result.substring(j, j + c.getValue().length());
                if (res.equals(c.getValue())) {
                    if (first)
                        result.replace(j, j + c.getValue().length(), " " + c.getValue().trim() + ":" + c.getBitValue());
                    else
                        result.replace(j, j + c.getValue().length(), " " + c.getBitValue());
                    first = false;
                }
            }
        }
        realcontent = result + "";
        return realcontent.trim().replaceAll(" \r\n ", "\r\n");
    }

    public static List<content> getList(String str) {
        List<content> n = new LinkedList();
        String[] x = str.split(" ");
        Arrays.sort(x);
        String pvalue = x[0];
        int count = 1;
        for (int i = 1; i < x.length; i++) {
            if (!pvalue.equals(x[i])) {
                n.add(new content(pvalue, count));
                pvalue = x[i];
                count = 1;
            } else
                count++;
        }
        n.add(new content(pvalue, count));
        return n;
    }

    private String getRealContent() {
        try {
            char[] c = new char[(int) f.length()];
            FileReader fr = new FileReader(f);
            fr.read(c);
            fr.close();
            realcontent = new String(c);
            realcontent = realcontent.replaceAll("\t", "             ").replaceAll(":", "");

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return realcontent;
    }

    private String getSimpleText() {
        String str = "";
        str = getRealContent().replaceAll("\r\n", " ");
        int plength;
        do {
            plength = str.length();
            str = str.replaceAll("  ", " ");
        } while (plength != str.length());
        return str.trim();
    }

    private File f;
    private String realcontent;

    public static void main(String args[]) {
        new encryption().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbrowse;
    private javax.swing.JButton btnbrowse1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private java.awt.List listFilenames;
    private java.awt.TextArea txtEncrytedCode;
    private javax.swing.JTextField txtFolder;
    private java.awt.TextArea txtRealContent;
    // End of variables declaration//GEN-END:variables
}