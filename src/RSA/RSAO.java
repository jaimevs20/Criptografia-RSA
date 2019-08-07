
package RSA;

import java.math.BigInteger;
import javax.swing.JOptionPane;


public class RSAO {
    private int p,q,phi,e,n,d;
    private BigInteger a;
    private String msg;
    
    public RSAO(String msg){
        
    }
    
    public RSAO(){
        this.geraPrimos();
        this.n = p*q;
        this.phi = (p-1)*(q-1);
        this.e = this.calculaE();
        this.d = this.calculaD(e, this.phi);
    }
    
    public int getE(){
        return this.e;
    }
    
    public int getD(){
        return this.d;
    }
    
    public int getN(){
        return this.n;
    }
    
    public String getMsg(){
        return this.msg;
    }
    
    public void setMsg(String arquivoLinha){
        this.msg = arquivoLinha;
    }
    
    private int MDC(int x,int y){
        if(x<=1 || y<=1)
            return 1;
        else if(x==y)
            return x;
        else if(x>y)
            return MDC(x-y,y);
        else
            return MDC(y-x,x);
       }
    
    public void Criptografar(){
        if(this.msg!=null){
            int tam = this.msg.length();
            String aux = new String();
            BigInteger a,b,c;
            b = new BigInteger(Integer.toString(this.e));
            c = new BigInteger(Integer.toString(this.n));
            for(int i=0; i<tam; i++){
                int auxA = (int)this.msg.charAt(i);
                a = new BigInteger(Integer.toString(auxA));
                a = a.modPow(b, c);
                aux+= a.toString();
                if(i<tam-1)
                    aux+= " ";
            }

            this.msg = aux;
        }
        else
            JOptionPane.showMessageDialog(null, "Escreva uma menssagem antes!");
    }
    
    public void Decriptografar(){
        if(this.msg!=null){
            int tam = this.msg.length();
            String aux1 = new String();
            String aux2 = new String();
            BigInteger a,b,c;
            b = new BigInteger(Integer.toString(this.d));
            c = new BigInteger(Integer.toString(this.n));
            for(int i=0; i<tam; i++){
                if(this.msg.charAt(i)!=' ')
                    aux2+=this.msg.charAt(i);
                else{
                    int auxA = Integer.parseInt(aux2);
                    a = new BigInteger(Integer.toString(auxA));
                    a = a.modPow(b, c);
                    aux1 += (char)a.intValue();
                    aux2 = new String();
                }
            }
            int auxA = Integer.parseInt(aux2);
            a = new BigInteger(Integer.toString(auxA));
            a = a.modPow(b, c);
            aux1 += (char)a.intValue();
            this.msg = aux1;
        }
        else
            JOptionPane.showMessageDialog(null, "Escreva uma menssagem antes!");
    }
    
    public int calculaD(int x,int y){
        BigInteger b = new BigInteger(Integer.toString(x));
        BigInteger c = new BigInteger(Integer.toString(y));
        BigInteger g = b.modInverse(c);
        
        return g.intValue();
    }
    
    private int calculaE(){
        BigInteger E = new BigInteger("11");
        int aux;
        do{
            aux = E.intValue();
            E = E.nextProbablePrime();
        }while(E.intValue()<(this.phi/2));
        return aux;
    }
    
    private void geraPrimos(){
        int tam = 24, pos;
        double rand = Math.random();
        int v[] = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        pos = (int)(rand*24);
        this.p = v[pos];
        do{
           rand = Math.random();
           pos = (int)(rand*24);
           this.q = v[pos];
        }while(this.q*this.p<255);
        //System.out.println(p+" "+q);
    }
}
