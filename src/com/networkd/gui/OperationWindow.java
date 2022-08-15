package com.networkd.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperationWindow extends JFrame implements ActionListener {

  private JPanel displayPanel = new JPanel();
  private JLabel mainDisplay = new JLabel();
  private JLabel miniDisplay = new JLabel();


  private JPanel midPanel = new JPanel();
  private JPanel inputPanel = new JPanel();
  private JLabel lblValue1 = new JLabel("Value One:");
  private JTextField txtValue1 = new JTextField();

  private JLabel lblValue2 = new JLabel("Value Two");
  private JTextField txtValue2 = new JTextField();


  private JPanel operatorsPanel = new JPanel();
  private ButtonGroup operators = new ButtonGroup();
  private JToggleButton tgBtnAdd = new JToggleButton("+");
  private JToggleButton tgBtnSubtract = new JToggleButton("-");
  private JToggleButton tgBtnMultiply = new JToggleButton("x");
  private JToggleButton tgBtnDivide = new JToggleButton("/");

  private JPanel buttonsPanel = new JPanel();
  private JButton btnListOps = new JButton("List of Operations");
  private JButton btnCreate = new JButton("Solve");
  private JButton btnReset = new JButton("Reset");



  public OperationWindow() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(300, 300);
    setTitle("Simple Operation Calculator");
    setDisplayPanel();
    add(displayPanel);
  }

  private void setDisplayPanel() {
    displayPanel.setBounds(0, 0, 300, 50);
    mainDisplay.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    mainDisplay.setBounds(2, 2, 298, 38);

    miniDisplay.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    miniDisplay.setBounds(2, 40, 298, 8);

    displayPanel.add(mainDisplay);
    displayPanel.add(miniDisplay);
  }







  @Override
  public void actionPerformed(ActionEvent e) {

  }
}
