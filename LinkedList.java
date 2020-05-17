// ..,. .,.
public class LinkedList{
    Node head;
    public void inEnd(int databaru){
        Node nodebaru = new Node(databaru);
        if (head==null){
            head = new Node(databaru);
            return;
        }

        nodebaru.next=null;
        Node last=head;
        while(last.next != null){
            last = last.next;
        }

        last.next=nodebaru;
        return;
    }
    public void inMid(int databaru, int pos){
        if(pos == 0){
            inFirst(databaru);
            return;
        }
        Node current = head;

        for(int i=0;i < pos-1;i++){
            current = current.next;
            if(current == null){
                inEnd(databaru);
                return;
            }
        }
        Node nodebaru = new Node(databaru);
        nodebaru.next = current.next;
        current.next = nodebaru;
    }
    public void inFirst(int databaru){
        Node nodebaru = new Node(databaru);
        if (head==null){
            head = new Node(databaru);
            return;
        }
        nodebaru.next = head;
        head = nodebaru;
    }

    public void show(){
        Node printNode = head;
        while (printNode != null){
            System.out.print(printNode.data+" ");
            printNode=printNode.next;
        }
        System.out.println();
    }

    public void searchNode(int searched_data){
        Node current = head;
        int pos=1;

        while (current.data != searched_data){
            pos++;
            current=current.next;
            if(current == null){
                System.out.println("tidak ditemukan");
                return;
            }

        }

        System.out.println("data ditemukan di node "+pos);
    }

    public void delNode(int pos){
        Node current = head;
        Node t = current.next;

        if(pos == 1){
            head=head.next;
            return;
        }

        for(int i=0; i<pos-2; i++){
            current = current.next;
            t = t.next;
        }

        current.next = t.next;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.inEnd(9);
        list.inFirst(0);
        list.inMid(8,1);
        list.inMid(9,2);
        list.inFirst(1);
        list.inMid(5,1);
        list.show();// 1 5 0 8 9 9
        list.inFirst();
        list.show();// 100 1 5 0 8 9 9
        list.searchNode(9);
        list.delNode(1);
        list.show();

    }

}
