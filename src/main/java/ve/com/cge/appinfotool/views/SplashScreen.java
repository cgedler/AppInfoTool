
package ve.com.cge.appinfotool.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import ve.com.cge.appinfotool.utils.AppInfo;

/**
 *
 * @author cge
 */
public class SplashScreen extends JWindow {
    
    private JWindow jwindow;
    private long startTime;
    private int minimumMilliseconds;
    private JLabel lblImage;
    private JLabel lblSystem;
    private JLabel lblVersion;
    private JLabel lblDate;
    private JLabel lblCompany;
    
    private AppInfo appInfo;
    
    public SplashScreen(AppInfo appInfo) {
        this.appInfo = appInfo;
        initComponents();
    }
     
    private void initComponents() {  
        jwindow = new JWindow();
        lblImage = new JLabel();
        lblSystem = new JLabel();
        lblVersion = new JLabel();
        lblDate = new JLabel();
        lblCompany = new JLabel();
        JPanel panMain = new JPanel();
        JPanel panLeft = new JPanel();
        JPanel panRight = new JPanel();
        
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        //Icon image = new ImageIcon(this.getClass().getResource("/resources/2.jpg").getFile());
        //Image image=ImageIO.read(this.getClass().getResource("/resources/2.jpg"));

        //label.setSize(600,300);
        //jwindow.getContentPane().add(label);
        
        lblSystem.setFont(new Font("Segoe UI", 0, 36));
        lblSystem.setHorizontalAlignment(SwingConstants.CENTER);
        lblSystem.setText(appInfo.getSYSTEM());

        lblVersion.setFont(new Font("Segoe UI", 3, 14));
        lblVersion.setHorizontalAlignment(SwingConstants.CENTER);
        lblVersion.setText(appInfo.getVERSION());

        lblDate.setHorizontalAlignment(SwingConstants.CENTER);
        lblDate.setText(appInfo.getDATE());

        lblCompany.setText(appInfo.getCOMPANY());
        
        panLeft.add(lblImage);
        panRight.setLayout(new GridLayout(4, 1));
        panRight.add(lblSystem);
        panRight.add(lblVersion);
        panRight.add(lblDate);
        panRight.add(lblCompany);
            
        panMain.setLayout(new GridLayout(1, 2));
        panMain.add(panLeft);
        panMain.add(panRight);
        
        jwindow.setContentPane(panMain);

        jwindow.setBounds(
                ((int)dimension.getWidth()/2),
                ((int)dimension.getHeight()/2),
                (470),
                (260)
        );
    }
    
    public void show(int minimumMilliseconds) {
        this.minimumMilliseconds = minimumMilliseconds;
        jwindow.setVisible(true);
        startTime = System.currentTimeMillis();
    }

    public void hide() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        try {
            Thread.sleep(Math.max(minimumMilliseconds - elapsedTime, 0));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jwindow.setVisible(false);
    }
}
