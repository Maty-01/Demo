//Abdul Mateen
//FA23-BCS-014
#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <unistd.h>
#include <errno.h>

int main(){
    pid_t pid[6];
    for(int i = 0 ; i < 5 ; i++){
        if((pid[i] = fork()) == -1){
            perror("Fork Issue\n");
            exit(1);
        }
    }
    pid_t childpid = getpid();
    for(int i = 0 ; i < 5 ; i++){
    if (getpid() == getppid()){
        printf("Im parent my ID is %d and waiting for child to terminate %d\n",getpid(),getppid());
        }
     printf("%d process id: %d parent ID: %d\n",i,getpid(),getppid());
    }
}

