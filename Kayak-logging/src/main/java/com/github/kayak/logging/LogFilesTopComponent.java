/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.kayak.logging;

import com.github.kayak.core.LogFile;
import java.io.File;
import java.util.logging.Logger;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import org.openide.util.ImageUtilities;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.ExplorerUtils;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//com.github.kayak.ui.logfiles//LogFiles//EN",
autostore = false)
public final class LogFilesTopComponent extends TopComponent implements ExplorerManager.Provider {

    private static LogFilesTopComponent instance;
    /** path to the icon used by the component and its open action */
    static final String ICON_PATH = "com/github/kayak/ui/logfiles/accessories-text-editor.png";
    private static final String PREFERRED_ID = "LogFilesTopComponent";
    private ExplorerManager manager = new ExplorerManager();

    public LogFilesTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(LogFilesTopComponent.class, "CTL_LogFilesTopComponent"));
        setToolTipText(NbBundle.getMessage(LogFilesTopComponent.class, "HINT_LogFilesTopComponent"));
        setIcon(ImageUtilities.loadImage(ICON_PATH, true));

        AbstractNode rootNode = new AbstractNode(Children.create(new LogFilesNodeFactory(), true));
        manager.setRootContext(rootNode);
        associateLookup(ExplorerUtils.createLookup(manager, getActionMap()));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        beanTreeView1 = new org.openide.explorer.view.BeanTreeView();

        beanTreeView1.setRootVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(beanTreeView1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(beanTreeView1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openide.explorer.view.BeanTreeView beanTreeView1;
    // End of variables declaration//GEN-END:variables
    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link #findInstance}.
     */
    public static synchronized LogFilesTopComponent getDefault() {
        if (instance == null) {
            instance = new LogFilesTopComponent();
        }
        return instance;
    }

    /**
     * Obtain the LogFilesTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized LogFilesTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            Logger.getLogger(LogFilesTopComponent.class.getName()).warning(
                    "Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
            return getDefault();
        }
        if (win instanceof LogFilesTopComponent) {
            return (LogFilesTopComponent) win;
        }
        Logger.getLogger(LogFilesTopComponent.class.getName()).warning(
                "There seem to be multiple components with the '" + PREFERRED_ID
                + "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }

    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_ALWAYS;
    }

    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    Object readProperties(java.util.Properties p) {
        if (instance == null) {
            instance = this;
        }
        instance.readPropertiesImpl(p);
        return instance;
    }

    private void readPropertiesImpl(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    @Override
    protected String preferredID() {
        return PREFERRED_ID;
    }

    @Override
    public ExplorerManager getExplorerManager() {
        return manager;
    }
}
