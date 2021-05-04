//Write a program for error detection and correction for 4 bits ASCII codes using Hamming Codes.


#include <stdio.h>
#include <stdlib.h>

void main() { 

     int data[10],j;
     printf("Enter 4 bits of data one by one\n");
     scanf("%d",&data[3]);
     scanf("%d",&data[5]);
     scanf("%d",&data[6]);
     scanf("%d",&data[7]);
     //Calculation of parity bits
     data[1]=data[3]^data[5]^data[7];
     //P1 = D3 D5 D7
     printf("Parity Bit at P1 %d\n",data[1]);
     data[2]=data[3]^data[6]^data[7];
     //P2 = D3 D6 D7
     printf("Parity Bit at P2 %d\n",data[2]);
     data[4]=data[5]^data[6]^data[7];
     //P4 = D5 D6 D7
     printf("Parity Bit at P4 %d\n",data[4]);
     printf("\nEncoded data is\n"); 
     for(j=7;j>0;j--)
          printf("%d ",data[j]); 
     printf("\n");          
     int dataatrec[10],c,c1,c2,c3,i;
     printf("Enter received data bits one by one :");
     
     for(i=0;i<7;i++)
          scanf("%d",&dataatrec[i]);
     c1=dataatrec[6]^dataatrec[4]^dataatrec[2]^dataatrec[ 0];
     // C1 = P1 D3 D5 D7
     c2=dataatrec[5]^dataatrec[4]^dataatrec[1]^dataatrec[ 0];
     // C2 = P2 D3 D6 D7
     c3=dataatrec[3]^dataatrec[2]^dataatrec[1]^dataatrec[ 0];
     // C4 = P4 D5 D6 D7
     c=c3*4+c2*2+c1 ;
     //calculating decimal value
     if(c==0)
          printf("No error while transmission of data\n");
     else {
          printf("Error on position: %d",c);
          printf("\nData received : ");
          for(i=0;i<7;i++)
               printf("%d",dataatrec[i]);
          printf("\nCorrect message is: ");
          //if errorneous bit is 0 we complement it else vice versa
          if(dataatrec[7-c]==0)
               dataatrec[7-c]=1;
          else dataatrec[7-c]=0;
               for (i=0;i<7;i++)
          printf("%d",dataatrec[i]); 
     } 
}

