/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bullscowsgameplaytest;

/**
 *
 * @author wayway
 */
public class AIBullsCows extends BasicBullsCows
{
        int[][] set;
        int[][] set1;
    
       public int [] GenerateInputNumber()
       {
        //access game record****************************************************************
        int RoundNumber = this.GetRoundNumber();
        int [][] Inputs = this.GetInputs();
        int [] Bulls = this.GetBulls();
        int [] Cows = this.GetCows();
        int [] candidateNumber = new int[4];
        
        //print
       /* for(int i = 0; i < RoundNumber; i++)
        {
            System.out.print("Round " + i + ": "
                    + Inputs[i][0] + Inputs[i][1] + Inputs[i][2] + Inputs[i][3]
                    + " " + Bulls[i] + "A" + Cows[i] + "B\n");
        }*/
       
        //**********************************************************************************
  
        //all possible answers
        if(RoundNumber==0)
        {
          set=new int[4536][4];
           int i=0;
           
           for(int n1=0;n1<=9;n1++)
           {
               if(n1==0) continue;
               for(int n2=0;n2<=9;n2++)
               {
                   if(n1==n2) continue;
                   for(int n3=0;n3<=9;n3++)
                   {
                       if(n3==n1||n3==n2) continue;
                       for(int n4=0;n4<=9;n4++)
                       {
                           if(n4==n1||n4==n2||n4==n3) continue;   
                           set[i][0]=n1;
                           set[i][1]=n2;
                           set[i][2]=n3;
                           set[i][3]=n4;
                           i++;      
                       }
                   }
               }
               
           //the first guess
           candidateNumber=set[(int)(Math.random()*4536)];    
           }
        }
      
         //**********************************************************
         

         if(RoundNumber>0)   
        {
                int a=Bulls[RoundNumber-1];
                int b=Cows[RoundNumber-1];
                int Round1=0;
                
                set1=new int[4536][4];

                 for(int j = 0; j < 4536; j++)
                {       
                    int Newbulls = 0;
                    int Newcows= 0;
                    //match 1st
                    for(int k=0;k<=3;k++)
                    {  
                       if(Inputs[RoundNumber-1][0] == set[j][k] )
                      { 
                        if(k == 0)
                            Newbulls++;
                        else
                            Newcows++;
                        break;
                       }
                    }
                    //match 2nd
                    for(int k = 0; k <= 3; k++)
                    {
                       if( Inputs[RoundNumber-1][1] == set[j][k] )
                       {
                          if(k == 1)
                              Newbulls++;
                         else
                             Newcows++;
                         break;
                       }
                    }
                    //match 3th
                     for(int k = 0; k <= 3; k++)
                    {
                       if( Inputs[RoundNumber-1][2] == set[j][k] )
                       {
                          if(k == 2)
                             Newbulls++;
                         else
                             Newcows++;
                         break;
                       }
                    } 
                     //match 4th
                      for(int k = 0; k <= 3; k++)
                    {
                       if( Inputs[RoundNumber-1][3] == set[j][k] )
                       {
                          if(k == 3)
                             Newbulls++;
                         else
                             Newcows++;
                         break;
                       }
                    } 
                                 
                    if(Newbulls==a&&Newcows==b)
                    { 
                       set1[Round1][0]=set[j][0];
                       set1[Round1][1]=set[j][1];
                       set1[Round1][2]=set[j][2];
                       set1[Round1][3]=set[j][3];
                      Round1++;  
                    }                            
                }
              
                    set=new int[Round1][4];
                    set=set1;
                    boolean passCheck = false;
                    while(passCheck == false)
                    {
                    candidateNumber=set1[(int)(Math.random()*(Round1))]; 
                    passCheck = CheckInputNumber(candidateNumber);
                    }

           }
  
        return candidateNumber;
           
        
        //************************************************************************************
 
        //generate input number using random digit

        //int [] candidateNumber = new int[4];

        /*boolean passCheck = false;
        while(passCheck == false)
        {
            candidateNumber[0] = (int)(Math.random()*9);
            candidateNumber[1] = (int)(Math.random()*9);
            candidateNumber[2] = (int)(Math.random()*9);
            candidateNumber[3] = (int)(Math.random()*9);
            
            passCheck = CheckInputNumber(candidateNumber);
        }
        
        return candidateNumber;*/

    }
}
    

