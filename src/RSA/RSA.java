/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RSA;

import javax.swing.JOptionPane;

/**
 *
 * @author Romildo e Jaime
 */
public class RSA {
    public static void main(String[] args) {
        RSAO teste = new RSAO();
        int op=1;
        String x = "a";
       
       
        while(op!=0){
            op = Integer.parseInt(JOptionPane.showInputDialog("1 - valor de n \n2 - valor de phi \n3 - valor de e \n4 - Escrever menssagem "
                    + "\n 5 - Criptografar \n6 - Decriptografar \n7 - Mostrar menssagem\n0 - Sair"));
            switch(op){
                case 1:
                    JOptionPane.showMessageDialog(null, "Valor de n é "+teste.getN());
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Valor de phi é "+teste.getN());
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Valor de e é "+teste.getE()+" "+teste.getD());
                    break;
                case 4:
                    teste.setMsg(JOptionPane.showInputDialog("Digite a menssagem: "));
                    break;
                case 5:
                    teste.Criptografar();
                    break;
                case 6:
                    teste.Decriptografar();
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, teste.getMsg());
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null,"Programa finalizado");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opção inválida");
            }
            
        }
    }
}
