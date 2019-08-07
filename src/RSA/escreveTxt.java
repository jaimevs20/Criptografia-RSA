/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RSA;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class escreveTxt {
    public static void main(String[] args) {
        
    try //esta sintaxe faz parte do tratamento de exceções
    {  
      
       FileWriter a = new FileWriter ("L:/teste");
       BufferedWriter escreve= new BufferedWriter(a);
       
       RSAO teste = new RSAO();
       String msg = teste.getMsg();
       escreve.write(msg);
       escreve.newLine();
       escreve.flush();
       escreve.close();
    }catch(IOException e)
        {
        }
    }
}