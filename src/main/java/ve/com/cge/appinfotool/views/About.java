
package ve.com.cge.appinfotool.views;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import ve.com.cge.appinfotool.utils.AppInfo;

/**
 * About : This is the screen class about
 * 
 * @author Christopher Gedler <cgedler@gmail.com>
 * @version 1.0
 * @since Nov 19, 2024
 */
public class About extends JFrame {
    
    private JButton jButton;
    private JLabel lblSystem;
    private JLabel lblVersion;
    private JLabel lblDate;
    private JLabel lblImage;
    private JLabel lblCompany;
    private JPanel jPanel;
    private JScrollPane jScrollPane;
    private JTextPane jTextPane;
    public AppInfo appInfo;
    
    public About(AppInfo appInfo) {
        this.appInfo = appInfo;
        initComponents();
    }
    
    private void initComponents() {
        jPanel = new JPanel();
        lblSystem = new JLabel();
        lblVersion = new JLabel();
        lblDate = new JLabel();
        lblImage = new JLabel();
        jScrollPane = new JScrollPane();
        jTextPane = new JTextPane();
        jButton = new JButton();
        lblCompany = new JLabel();

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        lblImage.setText("Image");
        
        jTextPane.setEditable(false);
        
        jTextPane.setText("Description:");

        jScrollPane.setViewportView(jTextPane);
        
        lblSystem.setFont(new Font("Segoe UI", 0, 36));
        lblSystem.setHorizontalAlignment(SwingConstants.CENTER);
        lblSystem.setText(appInfo.getSYSTEM());

        lblVersion.setFont(new Font("Segoe UI", 3, 14));
        lblVersion.setHorizontalAlignment(SwingConstants.CENTER);
        lblVersion.setText(appInfo.getVERSION());

        lblDate.setHorizontalAlignment(SwingConstants.CENTER);
        lblDate.setText(appInfo.getDATE());

        lblCompany.setText(appInfo.getCOMPANY());

        jButton.setText("Acept");

        
        GroupLayout jPanelLayout = new GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane)
                    .addComponent(lblSystem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblVersion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addGap(0, 135, Short.MAX_VALUE)
                        .addComponent(jButton))
                    .addComponent(lblDate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCompany, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(lblSystem)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblVersion)
                        .addGap(18, 18, 18)
                        .addComponent(lblDate)
                        .addGap(18, 18, 18)
                        .addComponent(lblCompany)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton)
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addComponent(lblImage, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setTitle(appInfo.getSYSTEM());
        setVisible(true);
        setBounds(
                ((int)dimension.getWidth()/2),
                ((int)dimension.getHeight()/2),
                (450),
                (380)
         );
    }
    
}
