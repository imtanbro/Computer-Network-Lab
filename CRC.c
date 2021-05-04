#include <stdio.h>
#include <string.h>
int main() {
    int i,j,checklen,msglen,flag=0;
    char msg[100], check[30],temp[30],quot[100],rem[30],check1[30];
    printf("Enter Data: ");
    scanf("%s",msg);
    printf("Enter Key: ");
    scanf("%s",check);
    checklen=strlen(check);
    msglen=strlen(msg);
    strcpy(check1,check);
    for (i=0;i<checklen-1;i++) {
        msg[msglen+i]='0';}
    for (i=0;i<checklen;i++)
        temp[i]=msg[i];
    for (i=0;i<msglen;i++) {
        quot[i]=temp[0];
        if(quot[i]=='0')
            for (j=0;j<checklen;j++)
                check[j]='0';
        else
            for (j=0;j<checklen;j++)
                check[j]=check1[j];
        for (j=checklen-1;j>0;j--) {
            if(temp[j]==check[j])
            rem[j-1]='0';
            else
            rem[j-1]='1';
        }
        rem[checklen-1]=msg[i+checklen];
        strcpy(temp,rem);
    }
    strcpy(rem,temp);
    printf("\nQuotient is ");
    for (i=0;i<msglen;i++)
        printf("%c",quot[i]);
    printf("\nRemainder is ");
    for (i=0;i<checklen-1;i++)
        printf("%c",rem[i]);
    printf("\nFinal data is: ");
    for (i=0;i<msglen;i++)
        printf("%c",msg[i]);
    for (i=0;i<checklen-1;i++)
        printf("%c",rem[i]);
    printf("\n");
    char rec[20];
    printf("Enter recieved data: ");
    scanf("%s",rec);
    for (i=0;i<checklen;i++)
        temp[i]=rec[i];
    for (i=0;i<msglen;i++) {
        quot[i]=temp[0];
        if(quot[i]=='0')
        for (j=0;j<checklen;j++)
        check[j]='0';
        else
        for (j=0;j<checklen;j++)
        check[j]=check1[j];
        for (j=checklen-1;j>0;j--) {
        if(temp[j]==check[j])
        rem[j-1]='0';
        else
        rem[j-1]='1';
        }
        rem[checklen-1]=rec[i+checklen];
        strcpy(temp,rem);
    }
    strcpy(rem,temp);
    printf("\nQuotient is ");
    for (i=0;i<msglen;i++)
        printf("%c",quot[i]);
    printf("\nRemainder is ");
    for (i=0;i<checklen-1;i++)
        printf("%c",rem[i]);
    flag=0;
    for (i=0;i<checklen-1;i++){
        if(rem[i]=='1'){
        flag=1;
        break;}
        else
        flag=0;
    }
    if(flag==0)
        printf("\nNo Error");
    else
        printf("\nError is detected");
    return 0;

}