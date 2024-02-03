/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package re.calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;

public class ReCalculator implements ActionListener{

    JFrame frame = new JFrame();
    JPanel outputPanel = new JPanel();
    JPanel numpadPanel = new JPanel();
    JTextField txtField = new JTextField();
    JButton[] calButton = new JButton[10];
    JButton[] signButton = new JButton[10];
    JButton addBtn, minusBtn, multBtn, divBtn;
    JButton pointBtn, clrBtn, backBtn, equBtn;
    JButton darkBtn, nthBtn;
    String operator;
    double firstNum, secNum, total ;
    DecimalFormat numberFormat = new DecimalFormat("#.00");
    
    ReCalculator(){
        //outputPanel.setBackground(Color.yellow);
        //numpadPanel.setBackground(Color.blue);
        
        outputPanel.setPreferredSize(new Dimension(400,60));
        numpadPanel.setPreferredSize(new Dimension(400,310));
        
        outputPanel.add(txtField);
        txtField.setPreferredSize(new Dimension(350, 55));
        txtField.setFont(new Font("Segoe Script", Font.ITALIC, 22));
        txtField.setEditable(false);
        
        numpadPanel.setLayout(new GridLayout(4,5,10,10));
        
        for(int i = 0; i <= 9; i++){
            //adding numbers in button array and adding action listeners
            calButton[i] = new JButton(String.valueOf(i));
            calButton[i].addActionListener(this);
        }
        
        addBtn = new JButton("+");
        minusBtn = new JButton("-");
        multBtn = new JButton("x");
        divBtn = new JButton("/");
        pointBtn = new JButton(".");
        backBtn = new JButton("<-");
        clrBtn = new JButton("C");
        equBtn = new JButton("=");
        darkBtn = new JButton("D");
        nthBtn = new JButton("");
        
        signButton[0] = addBtn;
        signButton[1] = minusBtn;
        signButton[2] = multBtn;
        signButton[3] = divBtn;
        signButton[4] = pointBtn;
        signButton[5] = backBtn;
        signButton[6] = clrBtn;
        signButton[7] = equBtn;
        signButton[8] = darkBtn;
        signButton[9] = nthBtn;
        
        for(int i = 0; i <= 9; i++){
            //adding action buttons
            signButton[i].addActionListener(this);
        }
        
        numpadPanel.add(calButton[1]);
        numpadPanel.add(calButton[2]);
        numpadPanel.add(calButton[3]);
        numpadPanel.add(signButton[0]);
        numpadPanel.add(signButton[1]);
        
        numpadPanel.add(calButton[4]);
        numpadPanel.add(calButton[5]);
        numpadPanel.add(calButton[6]);
        numpadPanel.add(signButton[2]);
        numpadPanel.add(signButton[3]);
        
        numpadPanel.add(calButton[7]);
        numpadPanel.add(calButton[8]);
        numpadPanel.add(calButton[9]);
        numpadPanel.add(signButton[4]);
        numpadPanel.add(signButton[7]);
        
        numpadPanel.add(signButton[8]);
        numpadPanel.add(calButton[0]);
        numpadPanel.add(signButton[9]);
        numpadPanel.add(signButton[5]);
        numpadPanel.add(signButton[6]);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,420);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setVisible(true);
        
        frame.add(outputPanel,BorderLayout.NORTH);
        frame.add(numpadPanel, BorderLayout.SOUTH);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        for(int i =0; i <= 9; i++){
            if(ae.getSource() == calButton[i]){
                //getting number values as output
                txtField.setText(txtField.getText().concat(String.valueOf(i)));
            }
        }
        if(ae.getSource() == signButton[4]){
            //adding point for decimal values
            txtField.setText(txtField.getText().concat(String.valueOf(".")));
        }
        
        for(int i =0; i <= 3; i++){
            if(ae.getSource() == signButton[i]){
                //adding math signs in output
                firstNum = Double.parseDouble(txtField.getText());
                operator = signButton[i].getText();
                txtField.setText(String.valueOf(""));
            }
        }
        
        if(ae.getSource() == signButton[6]){
            //clear button function
            txtField.setText("");
        }
        
        if(ae.getSource() == signButton[7]){
            //equal button function
            secNum = Double.parseDouble(txtField.getText());
            this.calculate();
            
            if (total % 1 == 0){
                int totalNoDecimal = (int) total; //converting double value of total to integer total value
                txtField.setText(totalNoDecimal + "");
            }
            else{
                txtField.setText(numberFormat.format(total)+"");
            }
        }
        
        if(ae.getSource() == signButton[5]){
            //backspace function
            String backSpace = txtField.getText();
            txtField.setText("");
            for(int i = 0; i < backSpace.length() - 1; i++){
                txtField.setText(txtField.getText()+backSpace.charAt(i));
            }
        }
        
        if(ae.getSource() == signButton [8]){
            
        }
    }
    
    double calculate(){
        switch(operator){
            case("+"): total = firstNum + secNum;
            break;
            
            case("-"): total = firstNum - secNum;
            break;
            
            case("x"): total = firstNum * secNum;
            break;
            
            case("/"): total = firstNum / secNum;
            break;
        }
        return total;
    }
}
