#include <stdio.h>
#include <stdlib.h>
#include <stack>

using namespace std;
/* A binary tree node has data, pointer to left child
   and a pointer to right child */
struct node
{
    int data;
    struct node* left, *right;
};

/* Function protoypes */
void printGivenLevel(struct node* root, int level);

void printGivenLevelSpiral(struct node* root, int level, bool ltor);
int height(struct node* node);
struct node* newNode(int data);

/* Function to print level order traversal a tree*/
void printLevelOrder(struct node* root)
{
    int h = height(root);
    int i;
    for (i=1; i<=h; i++)
        printGivenLevel(root, i);
}

/* Print nodes at a given level */
void printGivenLevel(struct node* root, int level)
{
    if (root == NULL)
        return;
    if (level == 1)
        printf("%d ", root->data);
    else if (level > 1)
    {
        printGivenLevel(root->left, level-1);
        printGivenLevel(root->right, level-1);
    }
}

void printLevelOrderSpiral(struct node* root)
{
    int h = height(root);
    bool ltor = true;
    int i;
    for (i=1; i<=h; i++){
        printGivenLevelSpiral(root, i, ltor);
        ltor = !ltor;
    }

}

int diameterOfTree(node *head){

static int maxHeight = 0;

if(head != NULL){
    int h = height(head->left) + height(head->right);
    if(h > maxHeight)
        maxHeight = h;
}
else
    return 0;

    diameterOfTree(head->left);

    diameterOfTree(head->right);

    return maxHeight;


}

void printGivenLevelSpiral(struct node* root, int level, bool ltor)
{

    if (root == NULL){
        return;
    }
    if(level == 1){
        printf("%d ", root->data);
    }
    else if(level > 1){
            if(ltor){
                printGivenLevelSpiral(root->left, level -1, true);
                printGivenLevelSpiral(root->right, level -1, true);
            }
        else{
            printGivenLevelSpiral(root->right, level -1, false);
            printGivenLevelSpiral(root->left, level -1, false);
        }
    }
}
/* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
int height(struct node* node)
{
    if (node==NULL)
        return 0;
    else
    {
        /* compute the height of each subtree */
        int lheight = height(node->left);
        int rheight = height(node->right);

        /* use the larger one */
        if (lheight > rheight)
            return(lheight+1);
        else return(rheight+1);
    }
}



/* Helper function that allocates a new node with the
   given data and NULL left and right pointers. */
struct node* newNode(int data)
{
    struct node* node = (struct node*)
                        malloc(sizeof(struct node));
    node->data = data;
    node->left = NULL;
    node->right = NULL;

    return(node);
}

/* Driver program to test above functions*/
int main()
{
    struct node *root = newNode(1);
    root->left        = newNode(2);
    //root->right       = newNode(3);
    root->left->left  = newNode(4);
    root->left->left->left  = newNode(6);
    root->left->right = newNode(5);
    root->left->right->right = newNode(7);
    root->left->right->right->right = newNode(8);

    printf("Level Order traversal of binary tree is \n");
    //printLevelOrderSpiral(root);
    printf("%d",diameterOfTree(root));
    return 0;
}
