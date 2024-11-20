package ve.com.cge.appinfotool.controllers;

import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.AbstractAction;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ve.com.cge.appinfotool.models.User;
import ve.com.cge.appinfotool.services.UserService;
import ve.com.cge.appinfotool.views.MDIApp;

/**
 * JasperAction : This is the action class that shows a report with JasperViewer.
 * 
 * @author Christopher Gedler <cgedler@gmail.com>
 * @version 1.0
 * @since Nov 19, 2024
 */
public class JasperAction extends AbstractAction {

    private static final Logger logger = LogManager.getLogger(JasperAction.class);

    private MDIApp mdiApp;

    public JasperAction(MDIApp mdiApp) {
        this.mdiApp = mdiApp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            FileInputStream logoStream = new FileInputStream(this.getClass().getClassLoader().getResource("templates/invoice_logo.png").getFile());
            List<User> users = new ArrayList<User>();
            users = UserService.getUsers();
            params.put("listData", new JRBeanCollectionDataSource(users));
            params.put("title", "Users List");
            params.put("logo", logoStream);
            JasperPrint report = JasperFillManager.fillReport(JasperCompileManager.compileReport(
                    this.getClass().getClassLoader().getResource("templates/Base.jrxml").getFile()), params, new JREmptyDataSource());
            JasperViewer.viewReport(report, true);
        } catch (JRException ex) {
            logger.error("Failed to get Jasper Report", ex);
        } catch (FileNotFoundException ex) {
            logger.error("Failed file not found", ex);
        }
    }

}
