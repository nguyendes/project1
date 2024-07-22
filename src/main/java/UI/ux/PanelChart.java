package UI.ux;

import UI.chart.ModelChart;
import UI.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class PanelChart extends javax.swing.JPanel {

    public PanelChart() {
        initComponents();
        setOpaque(false);
        init();
        
    }

    public void init() {
        updateChart();
    }
    
    private void updateChart() {
        chart.resetChart();
        if (rdoDays.isSelected()) {
            chart.addLegend("Ngày", Color.BLUE);
            for (int i = 1; i <= 31; i++) {
                chart.addData(new ModelChart(String.valueOf(i), new double[]{i}));
            }
        } else if (rdoWeeks.isSelected()) {
            chart.addLegend("Tuần", Color.GREEN);
            for (int i = 1; i <= 4; i++) {
                chart.addData(new ModelChart(String.valueOf(i), new double[]{i}));
            }
        }
        chart.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setText("DOANH THU THUẦN THÁNG TRƯỚC");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setText("2,334,000");
        jLabel2.setIconTextGap(6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(622, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(453, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rdoDaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDaysActionPerformed
        updateChart();
    }//GEN-LAST:event_rdoDaysActionPerformed

    private void rdoWeeksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoWeeksActionPerformed
        updateChart();
    }//GEN-LAST:event_rdoWeeksActionPerformed

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(grphcs);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
