#include <stdio.h>
#include <string.h>

void imprimeVec(char* vec[202]){
    for(int i = 0; i < strlen(vec); i++){
        printf("%d", vec[i]);
    }
    printf("\n");
}

int main (void){
    // declaracao de variaves
    char* str1[101];
    char* str2[101];
    char* resp[202];
    
    int n;
    scanf("%d", &n);

    while(scanf("%s", str1) != EOF){
        // entrada
        scanf("%s", str2);;

        // contadores
        int i, j, k;
        i = j = k = 0;

        int maior;

        if(strlen(str1)>strlen(str2)){
            maior = strlen(str1);
        }
        else{
            maior = strlen(str2);
        }

        for(int i = 0; i < maior; i++){
            if(str1[i] != '\0'){
                resp[k] = str1[i];
                i++;
                k++;
            }
            else if(str2[j] != '\0'){
                resp[k] = str2[j];
                j++;
                k++;
            }
        }

        // finaliza string
        resp[k] = '\0';

        imprimeVec(resp);
    }
    return 0;
}