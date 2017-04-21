#include<stdio.h>

typedef struct BinNode{
    char *data;
    struct BinNode *lChild;
    struct BinNode *rChild;
}BinNode;

typedef BinNode *binTree;



// 前序遍历
void preorder(binTree t){
    if(t){
      printf("%s \n",t->data);
      preorder(t->lChild);
      preorder(t->rChild);
    }
}

int main(){

    printf("hello world \n");


    BinNode lChild;
    lChild.data = "B";

    BinNode rChild;
    rChild.data = "C";

    BinNode parent;
    parent.data = "A";
    parent.lChild = &lChild;
    parent.rChild = &rChild;



    preorder(&parent);



    return 0;
}
