/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jocprogresie;

/**
 *
 * @author Robert
 */
public class Jucator
{
    private int[] hand;
    private StringBuilder cuvant;
    private StringBuilder win;
    public int ratie;
    
    /**
     * Contructor
     */
    Jucator()
    {
        cuvant=new StringBuilder();
        win=new StringBuilder();
        hand = new int[26];
        for(int i=0;i<26;i++)
            hand[i]=0;
        ratie=0;
    }
    
    /**
     * Adauga litera in mana jucatorului curent
     * @param l litera adaugata in mana jucatorului curent
     */
    public void addLetter(char l)
    {
        hand[l-'A']++;
        cuvant.append(l);
    }
    
    
    /**
     * Initializeaza vectorul dat ca parametru cu 0
     * @param viz vector de intregi neinitializat
     */
    private void initViz(int []viz)
    {
        for(int j=0;j<26;j++)
            viz[j]=0;
    }
    
    
    /**
     * Verifica daca se poate forma o progresie peste cartile din mana
     * @param poz indicele primei litere din progresie, daca exista
     * @param lenCuvant lungimea progresiei
     * @return 
     */
    public boolean Progresie(int poz, int lenCuvant)
    {
        int i;
        int c;
        ratie=1;
        boolean ret=true;
        int []viz=new int[26];
        
        for(ratie=1;ratie<=25;ratie++)
        {
            ret=true;
            win=new StringBuilder();
            win.append((char)(poz+'A'));
            initViz(viz);
            viz[poz]=1;
            
            for(i=(poz+ratie)%26, c=1; c<lenCuvant && i!=poz ; c++,i=(i+ratie)%26)
            {
                    if(hand[i]==0&&viz[i]>=hand[i])
                    {
                        ret=false;
                        break;
                    }
                    else
                    {
                        viz[i]++;
                        win.append((char)(i+'A'));
                    }
            }
            
            if(ret==true && c==lenCuvant)
                return ret;
        }
        return ret;
    }
    
    /**
     * Verifica daca jucatorul curent este castigator
     * @param lenCuvant lungimea progresiei
     * @return 
     */
    public boolean Castigator(int lenCuvant)
    {
        int i;
        for(i=0;i<cuvant.length();i++)
        {
            if(Progresie(cuvant.charAt(i)-'A', lenCuvant)==true)
                return true;
        }
        win.delete(0, win.length());
        return false;
    }
    
    /**
     * 
     * @return cuvantul format pana in momentul apelului
     */
    public StringBuilder getCuvant()
    {
        return cuvant;
    }
    
    /**
     * Apelata numai daca e castigator
     * @return cuvantul cu care a castigat
     */
    public StringBuilder getWin()
    {
        return win;
    }
}
