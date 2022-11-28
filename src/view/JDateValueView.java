package view;

import controller.Features;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JDateValueView extends JPanel implements PanelView {

  private JButton homeButton;
  private JLabel titleLabel;
  private JTextField dateField;
  private JButton actionButton;
  private JLabel messageLabel;

  public JDateValueView(String title) {
    this.setPreferredSize(new Dimension(500, 500));
    this.setLayout(new BorderLayout(8, 16));

    // North panel -> Title
    this.titleLabel = new JLabel(title);

    JPanel northPanel = new JPanel();
    northPanel.add(this.titleLabel);
    this.add(northPanel, BorderLayout.NORTH);

    // Center panel -> Enter date and submit
    this.dateField = new JTextField(6);
    this.actionButton = new JButton("Get Value");
    this.homeButton = new JButton("HOME");

    JPanel centerPanel = new JPanel();
    centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 4, 0));
    centerPanel.add(new JLabel("Enter date:"));
    centerPanel.add(this.dateField);
    centerPanel.add(new JLabel("    "));
    centerPanel.add(this.actionButton);
    centerPanel.add(this.homeButton);
    this.add(centerPanel, BorderLayout.CENTER);

    // South panel -> Show result
    this.messageLabel = new JLabel("Show result");
    JPanel southPanel = new JPanel();
    southPanel.add(this.messageLabel);
    this.add(southPanel, BorderLayout.SOUTH);
    setVisible(true);
  }

  @Override
  public void addActionListener(Features features) {
    this.actionButton.addActionListener(event -> {
      double response = features.getValue(dateField.getText());
      this.messageLabel.setText(String.valueOf(response));
    });
  }

  @Override
  public void clearInput() {
    this.dateField.setText("");
    this.messageLabel.setText("");
  }
}