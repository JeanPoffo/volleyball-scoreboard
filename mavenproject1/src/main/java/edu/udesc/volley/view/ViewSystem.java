package edu.udesc.volley.view;

import edu.udesc.volley.controller.ControllerSystem;
import edu.udesc.volley.model.Team;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * View class of System
 * @author Jean Poffo
 */
public class ViewSystem extends JFrame implements Observer{
    
    private JButton buttonAddPointTeamOne;
    private JButton buttonAddPointTeamTwo;
    private JButton buttonNewGame;
    private JLabel labelNameTeamOne;
    private JLabel labelNameTeamTwo;
    private JLabel labelSetTeamOne;
    private JLabel labelSetTeamTwo;
    private JLabel labelPointTeamOne;
    private JLabel labelPointTeamTwo;
    private JPanel panelNewGame;
    private JPanel panelPoints;
    private JPanel panelTeamOne;
    private JPanel panelTeamTwo;

    private ControllerSystem controller;
    
    public ViewSystem(ControllerSystem controller)  {
        this.controller = controller;
        
        this.initComponents();
        this.addListeners();
        
        super.setSize(new Dimension(350, 250));
        super.setTitle("Placar");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
        
        this.controller.addObserver(this);
        
        this.callNewGame();
    }
    
    private void initComponents() {
        panelPoints = new JPanel();
        panelTeamOne = new JPanel();
        panelTeamTwo = new JPanel();
        panelNewGame = new JPanel();
        labelNameTeamOne = new JLabel();
        labelNameTeamTwo = new JLabel();
        labelSetTeamOne = new JLabel();
        labelSetTeamTwo = new JLabel();
        labelPointTeamOne = new JLabel();
        labelPointTeamTwo = new JLabel();
        buttonAddPointTeamOne = new JButton();
        buttonAddPointTeamTwo = new JButton();
        buttonNewGame = new JButton();

        panelPoints.setBackground(new Color(242, 245, 234));
        panelPoints.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 15));

        // Team One
        panelTeamOne.setLayout(new BoxLayout(panelTeamOne, BoxLayout.Y_AXIS));
        panelTeamOne.setBackground(new Color(242, 245, 234));
        panelTeamOne.setSize(new Dimension(150, 80));
        
        labelNameTeamOne.setBackground(new Color(242, 245, 234));
        labelNameTeamOne.setFont(new Font("Ubuntu", 0, 25));
        labelNameTeamOne.setHorizontalAlignment(SwingConstants.CENTER);
        labelNameTeamOne.setText("B");
        labelNameTeamOne.setOpaque(true);
        labelNameTeamOne.setAlignmentX(CENTER_ALIGNMENT);
        panelTeamOne.add(labelNameTeamOne);
        
        labelSetTeamOne.setBackground(new Color(242, 245, 234));
        labelSetTeamOne.setFont(new Font("Ubuntu", 0, 15));
        labelSetTeamOne.setHorizontalAlignment(SwingConstants.CENTER);
        labelSetTeamOne.setText("Sets: 0");
        labelSetTeamOne.setOpaque(true);
        labelSetTeamOne.setAlignmentX(CENTER_ALIGNMENT);
        panelTeamOne.add(labelSetTeamOne);
        
        labelPointTeamOne.setBackground(new Color(242, 245, 234));
        labelPointTeamOne.setFont(new Font("Ubuntu", 0, 48));
        labelPointTeamOne.setHorizontalAlignment(SwingConstants.CENTER);
        labelPointTeamOne.setText("0");
        labelPointTeamOne.setOpaque(true);
        labelPointTeamOne.setAlignmentX(CENTER_ALIGNMENT);
        panelTeamOne.add(labelPointTeamOne);

        buttonAddPointTeamOne.setFont(new Font("Ubuntu", 1, 15));
        buttonAddPointTeamOne.setForeground(new Color(44, 54, 63));
        buttonAddPointTeamOne.setText("Pontuar");
        buttonAddPointTeamOne.setMargin(new Insets(2, 2, 2, 2));
        buttonAddPointTeamOne.setAlignmentX(CENTER_ALIGNMENT);
        panelTeamOne.add(buttonAddPointTeamOne);

        panelPoints.add(panelTeamOne);
        
        //Team Two
        panelTeamTwo.setLayout(new BoxLayout(panelTeamTwo, BoxLayout.Y_AXIS));
        panelTeamTwo.setBackground(new Color(242, 245, 234));
        panelTeamTwo.setSize(new Dimension(150, 80));
        
        labelNameTeamTwo.setBackground(new Color(242, 245, 234));
        labelNameTeamTwo.setFont(new Font("Ubuntu", 0, 25));
        labelNameTeamTwo.setHorizontalAlignment(SwingConstants.CENTER);
        labelNameTeamTwo.setText("A");
        labelNameTeamTwo.setOpaque(true);
        labelNameTeamTwo.setAlignmentX(CENTER_ALIGNMENT);
        panelTeamTwo.add(labelNameTeamTwo);
        
        labelSetTeamTwo.setBackground(new Color(242, 245, 234));
        labelSetTeamTwo.setFont(new Font("Ubuntu", 0, 15));
        labelSetTeamTwo.setHorizontalAlignment(SwingConstants.CENTER);
        labelSetTeamTwo.setText("Sets: 0");
        labelSetTeamTwo.setOpaque(true);
        labelSetTeamTwo.setAlignmentX(CENTER_ALIGNMENT);
        panelTeamTwo.add(labelSetTeamTwo);
        
        labelPointTeamTwo.setBackground(new Color(242, 245, 234));
        labelPointTeamTwo.setFont(new Font("Ubuntu", 0, 48));
        labelPointTeamTwo.setHorizontalAlignment(SwingConstants.CENTER);
        labelPointTeamTwo.setText("0");
        labelPointTeamTwo.setOpaque(true);
        labelPointTeamTwo.setAlignmentX(CENTER_ALIGNMENT);
        panelTeamTwo.add(labelPointTeamTwo);

        buttonAddPointTeamTwo.setFont(new Font("Ubuntu", 1, 15));
        buttonAddPointTeamTwo.setForeground(new Color(44, 54, 63));
        buttonAddPointTeamTwo.setText("Pontuar");
        buttonAddPointTeamTwo.setMargin(new Insets(2, 2, 2, 2));
        buttonAddPointTeamTwo.setAlignmentX(CENTER_ALIGNMENT);
        panelTeamTwo.add(buttonAddPointTeamTwo);

        panelPoints.add(panelTeamTwo);

        getContentPane().add(panelPoints, BorderLayout.CENTER);

        panelNewGame.setBackground(new Color(214, 219, 210));

        buttonNewGame.setFont(new Font("Ubuntu", 1, 15));
        buttonNewGame.setForeground(new Color(44, 54, 63));
        buttonNewGame.setText("Novo Jogo");
        buttonNewGame.setMargin(new Insets(2, 2, 2, 2));
        panelNewGame.add(buttonNewGame);

        getContentPane().add(panelNewGame, BorderLayout.PAGE_END);

        pack();
    }
    
    private void addListeners() {
        this.buttonNewGame.addActionListener((e) -> {
            this.callNewGame();
        });
        
        this.buttonAddPointTeamOne.addActionListener((e) -> {
            this.controller.callAddPointTeamOne();
        });
        
        this.buttonAddPointTeamTwo.addActionListener((e) -> {
            this.controller.callAddPointTeamTwo();
        });
    }
    
    private void callNewGame() {
        String nameTeamOne = JOptionPane.showInputDialog(this, "Digite o nome do primeiro time:");
        String nameTeamTwo = JOptionPane.showInputDialog(this, "Digite o nome do segundo time:");

        this.controller.callNewGame(nameTeamOne, nameTeamTwo);   
        
        this.buttonAddPointTeamOne.setEnabled(true);
        this.buttonAddPointTeamTwo.setEnabled(true);
    }

    @Override
    public void updateNameTeamOne(String name) {
        this.labelNameTeamOne.setText(name);
    }

    @Override
    public void updateNameTeamTwo(String name) {
        this.labelNameTeamTwo.setText(name);
    }

    @Override
    public void updateSetTeamOne(int set) {
        this.labelSetTeamOne.setText("Sets: " + String.valueOf(set));
    }

    @Override
    public void updateSetTeamTwo(int set) {
        this.labelSetTeamTwo.setText("Sets: " + String.valueOf(set));
    }
    
    @Override
    public void updatePointTeamOne(int point) {
        this.labelPointTeamOne.setText(String.valueOf(point));
    }

    @Override
    public void updatePointTeamTwo(int point) {
        this.labelPointTeamTwo.setText(String.valueOf(point));
    }

    @Override
    public void updateGameWinner(Team team) {
        if(team != null) {
            JOptionPane.showMessageDialog(this, "O Time " + team.getName() + " foi o vencedor!");
            
            this.buttonAddPointTeamOne.setEnabled(false);
            this.buttonAddPointTeamTwo.setEnabled(false);
        }
    }
    
}
