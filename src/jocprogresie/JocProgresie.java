/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jocprogresie;

import java.util.Scanner;

/**
 *
 * @author Robert
 */
public class JocProgresie
{
    private int n;
    private int p;
    
    /**
     * Constructor
     */
    JocProgresie()
    {
        n=0;
        p=0;        
    }
    
    /**
     * Functia calculeza random un indice folosit in reprezantarea unei carti atribuite unui jucator
     * @return numar random de la 0->25
     */
    public char getRand()
    {
        char carte;
        double randomNumber;
        
        randomNumber=Math.random();
        carte=(char) (65+(char)(randomNumber*26));
        
        return carte;
    }
    
    /**
     * Functie folosita in atribuirea numarului de jucatori si a lungimii progresiei
     * @param s sir care poate reprezenta un numar
     * @return false sau true in functie de sirul trimis ca parametru
     */
    public boolean isInt(String s)
    {        
        try
        {
            Integer.parseInt(s);
        } catch (NumberFormatException e)  
        {
           return false;
         }
        return true;
    }
    
    /**
     * Atribuie jocului numarul de jucatori
     * @param s sirul atribuit ca valoare
     */
    private void setN(String s)
    {
        StringBuilder arg = new StringBuilder(s);
        
        try
        {
            n=Integer.parseInt(arg.toString());
        }catch (NumberFormatException e)
                {
                    System.out.println("Valoarea introdusa nu este un numar natural!");
                }
        
        while(!isInt(arg.toString()))
        {
            arg.delete(0, arg.length());
            
            System.out.println("Va rugam introduceti un numar natural(n):");
            Scanner scan=new Scanner(System.in);
            arg.insert(0,scan.nextLine());
        }
        
        n=Integer.parseInt(arg.toString());
    }
    
    /**
     * Atribuie jocului lungimea progresiei
     * @param s sirul atribuit ca valoare
     */
    private void setP(String s)
    {
        StringBuilder arg = new StringBuilder(s);
        
        try
        {
            p=Integer.parseInt(arg.toString());
        }catch (NumberFormatException e)
                {
                    System.out.println("Valoarea introdusa nu este un numar natural!");
                }
        
        while(!isInt(arg.toString()))
        {
            arg.delete(0, arg.length());
            
            System.out.println("Va rugam introduceti un numar natural(p):");
            Scanner scan=new Scanner(System.in);
            arg.insert(0,scan.nextLine());
        }
        
        p=Integer.parseInt(arg.toString());        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JocProgresie joc=new JocProgresie();
        
        if(args.length==0)
        {
            System.err.println("Nu sunt destule argumente!");
            joc.setN("asd");
            joc.setP("asd");
        }
        
        if(args.length==1)
        {
            System.err.println("Nu sunt destule argumente!");
            joc.setN(args[0]);
            joc.setP("asd");
        }
        
        if(args.length==2)
        {
            joc.setN(args[0]);
            joc.setP(args[1]);
        }
        
        if(args.length>2)
        {
            System.err.println("Sunt prea multe argumente! Se vor considera primele doua!");
            joc.setN(args[0]);
            joc.setP(args[1]);
        }
        
        
        Jucator pl[]=new Jucator[joc.n];
        for(int i=0;i<joc.n;i++)
                pl[i]=new Jucator();
        int runda=1;
        boolean gameover=false;
        
        while(true)
        {
            System.out.println("Runda "+runda);
            for(int i=0;i<joc.n;i++)
            {
                char c=joc.getRand();
                pl[i].addLetter(c);
                System.out.println("Jucatorul "+(i+1)+" a primit cartea: "+c+": "+pl[i].getCuvant());
            }
            
            for(int i=0;i<joc.n;i++)
            {
                if(pl[i].Castigator(joc.p))
                {
                    System.out.println("Jucatorul "+(i+1)+" a castigat: "+pl[i].getWin());
                    System.out.println("Ratia: " + pl[i].ratie);
                    gameover=true;
                    break;
                }
            }
            if(gameover)
                break;
            runda++;
        }
    }
}
