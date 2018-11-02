#include<iostream>
#include<stdlib.h>
#include<assert.h>
#define null '\0'
using namespace std;

typedef struct node
{
    int val;
    struct node* next;

} node;

void printList(node *head)
{
    //since we are not returning anything, it is ok to do head->next.
    while(head != NULL)
    {

        cout<<head->val;

        head = head->next;
        if(head != null)
            cout<<"->";
    }

}

node * getNode(int value)
{

    node *p = (node *)malloc(sizeof(node *));
    p->val = value;
    p->next = NULL;
    return p;
}

void insertLast(node *head, int value)
{

    while(head->next != NULL)
    {
        head = head->next;
    }

    head->next = getNode(value);
}

node * insertFirst(node *head, int value)
{
    node * temp = head;

    node *p = getNode(value);

    if(head != NULL)
    {
        p ->next = head;
    }

    return p;
}


node * deleteNode(node *head, int value)
{

    node *temp = head;
    node *prev = NULL;
    if(temp != NULL && temp->val == value)
    {

        head = temp->next;
        free(temp);
        return head;
    }
    while(temp != null && temp->val != value)
    {
        prev = temp;
        temp = temp->next;
    }

    if(temp == NULL)
        return head;

    prev->next = temp->next;
    free(temp);
    return(head);



}

int getLength(node *head)
{

    if(head == null)
    {
        return 0;
    }
    else
        return 1 + getLength(head->next);
}
/*
node * swapNodes(node *head, int val1, int val2)
{

    if(val1 == val2)
        return head;

    short a = 0;
    bool pIsHead = false;
    bool qIsHead = false;

    bool pIsTail = false;
    bool qIsTail = false;

    node *p = null;
    node *q = null;
    node *r = head;

    while(r != null)
    {
        if(r -> val == val1)
        {
            a++;
            p = r;
            if( r == head)
                pIsHead = true;
            if( r->next == null)
                pIsTail = true;
        }

        if(r -> val == val2)
        {
            a++;
            q = r;
            if( r == head)
                qIsHead = true;
            if( r->next == null)
                qIsTail = true;
        }

        r = r -> next;
    }
    if(a != 2)
        return head;

    if((pIsHead && qIsTail) || (pIsTail && qIsHead)){

        node *header = null;
        node *tailer = null;
        node *preTailer = head;

        if(pIsHead){
            header = p;
            tailer = q;
        }
        else{
            header = q;
            tailer = p;
        }

        while(preTailer->next != tailer)
            preTailer = preTailer->next;

        preTailer->next = head;
        tailer->next = header->next;
        header->next = null;

        return tailer; //this is now the head
    }

    if(pIsHead || qIsHead){

        node *header = null;
        node *middler = null;
        node *prevMiddler = head;
        node *headerNext = head->next;

        if(pIsHead){
            header = p;
            middler = q;
        }
        else{
            header = q;
            middler = p;
        }
        while(prevMiddler->next != middler)
            prevMiddler = prevMiddler->next;

        prevMiddler->next = header;
        middler->next = header->next;
        header->next = middler->next;


        return middler; //as this is now the new head
    }

    if(pIsTail || qIsTail){

        node *tailer = null;
        node *middler = null;
        node *prevMiddler = head;
        node *prevTailer = head;

        if(pIsTail){
            tailer = p;
            middler = q;
        }
        else{
            tailer = q;
            middler = p;
        }
        while(prevMiddler->next != middler)
            prevMiddler = prevMiddler->next;

        while(prevTailer->next->next != null)
            prevTailer = prevTailer->next;

        prevMiddler->next = tailer;
        tailer->next = middler->next;

        prevTailer->next = middler;
        middler->next = null;

        return head; //head remains the same

    }

    node *firstMiddler = p;
    node *secondMiddler = q;
    node *preFirstMiddler = head;
    node *postFirstMiddler = p->next;
    node * preSecondMiddler = head;

    while(preFirstMiddler->next != firstMiddler)
        preFirstMiddler = preFirstMiddler->next;

    while(preSecondMiddler->next != secondMiddler)
        preSecondMiddler = preSecondMiddler->next;

    preFirstMiddler->next = secondMiddler;
    firstMiddler->next = secondMiddler->next;
    secondMiddler->next = postFirstMiddler;
    preSecondMiddler->next = firstMiddler;

    return head;
}

*/
/* Function to swap nodes x and y in linked list by
   changing links */
void swapNodes(struct node **head_ref, int x, int y)

{
    // Nothing to do if x and y are same
    if (x == y) return;

    // Search for x (keep track of prevX and CurrX
    struct node *prevX = NULL, *currX = *head_ref;
    while (currX && currX->val != x)
    {
        prevX = currX;
        currX = currX->next;
    }

    // Search for y (keep track of prevY and CurrY
    struct node *prevY = NULL, *currY = *head_ref;
    while (currY && currY->val != y)
    {
        prevY = currY;
        currY = currY->next;
    }

    // If either x or y is not present, nothing to do
    if (currX == NULL || currY == NULL)
        return;

    // If x is not head of linked list
    if (prevX != NULL)
        prevX->next = currY;
    else // Else make y as new head
        *head_ref = currY;

    // If y is not head of linked list
    if (prevY != NULL)
        prevY->next = currX;
    else  // Else make x as new head
        *head_ref = currX;

    // Swap next pointers
    struct node *temp = currY->next;
    currY->next = currX->next;
    currX->next  = temp;
}

//takes a node from the starting of the source node and moves it to the starting of the destination node
void MoveNode(struct node **source, struct node **destination)
{

    node *tempNode = *source;

    assert(tempNode != null);

    *source = tempNode->next;


    (*destination)->next = tempNode;
    tempNode->next = null;


}

node * SortedMerge(node* a, node *b)
{

    node *head = (node *)malloc(sizeof(node *));
    head->val = 0;
    head->next = null;

    node *returnList = head;

    while(1)
    {
        if(a == null){
            returnList->next = b;
            break;
        }

        else if(b == null){
            returnList->next = a;
            break;
        }


        if(a->val <= b->val){
            MoveNode(&a, &(returnList));
        }
        else
            MoveNode(&b, &(returnList));

        returnList = returnList->next;
    }

    return (head->next);
}

node * ReverseList(node *head){

node * next = null;
node * prev = null;
node * current = head;
while(current != null){


    //prev = current;
    next = current -> next;
    current -> next = prev;
    prev = current;
    current = next;

}
return prev;
}



node * ReverseListSet(node *head){

node * next = null;
node * prev = null;
node * current = head;
node *lastSetHead = head;
const int setCount = 3;
int firstTime = 0;
int counter = 0;
node *returnHead = null;


while(current != null){

    next = current -> next;
    current -> next = prev;
    counter ++;

    if(counter == setCount){
        returnHead = current;
        //current->next = null;
    }

    if((counter / setCount >= 2) && (counter % setCount) == 0){

        lastSetHead->next = current;
        //lastSetHead = current->next;

        while(lastSetHead ->next != null){
            lastSetHead = lastSetHead->next;
        }

        //current->next = null;
        //current = next;
        //prev = null;
    }


    prev = current;
    current = next;


    if(current == null && next != null){
        lastSetHead -> next = prev;
        //prev ->next = null;
    }


}
return returnHead;
}


node *ReverseListSetRecur(node *head, int k){

node * next = null;
node * prev = null;
node * current = head;
int counter = 0;

while(current != null && counter < k){


    //prev = current;
    next = current -> next;
    current -> next = prev;
    prev = current;
    current = next;
    counter++;
}

if(next != null){
    head->next = ReverseListSetRecur(next, k);
}
return prev;

}

void ReverseListShu(node **head){
	node *first, *rest;

	if(*head == null ){
		return;
	}

first = *head;
rest = first->next;
if(rest == null)
    return;

ReverseListShu(&rest);

first->next->next = first;
first->next = null;

*head = rest;
}


void ReverseListAny(node *head){

node * next = null;
node * prev = null;
node * current = head;
while(current != null){


    //prev = current;
    next = current -> next;
    current -> next = prev;
    prev = current;
    current = next;

}

}

node *ReverseListMaster(node *head, const int k){

node *start = head;
node *last = head;
int counter = 0;
node *nextStart = null;
int firstTime = 0;
node *prevIterLast = head;
while(1){

    while((counter % (k-1) == 0) && last->next){
    last = last ->next;
    nextStart = last->next;
     counter++;
    }
    if(firstTime == 0){
        head = last;
        firstTime = 1;

    }
    else{
        prevIterLast = last;
    }

    counter = 0;
    ReverseListAny(start, last);

    start = nextStart;

}

}
int main()
{
    node *head1 = getNode(2);
    insertLast(head1, 4);
    insertLast(head1, 6);
    insertLast(head1, 8);
    insertLast(head1, 10);
    insertLast(head1, 12);
    insertLast(head1, 14);
    //insertLast(head1, 16);

//printList(head1);

    node *head2 = getNode(1);
    insertLast(head2,3);
    insertLast(head2,5);

    //printList(head2);

    //node *result = SortedMerge(head1,head2);
    //when nodes are adjacent
    //head = swapNodes(head, 3, 4);
    head1 = ReverseListSet(head1);
    printList(head1);
    //cout<<getLength(head)<<endl;
}
