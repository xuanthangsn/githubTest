import java.util.*;
import java.lang.Math;
import java.util.Scanner;
class Link {
    public int data;
    public Link next;
    public Link(int data) {
        this.data = data;
        next = null;
    }
    public void displayLink () {
        System.out.println(" " + data + " ");
    }
}
class LinkedList {
    private Link head;
    public LinkedList () {
        head = null;
    }
    public boolean isEmpty () {
        return head == null;
    }
    public void addFirst (int data) {
        Link addedLink = new Link(data);
        addedLink.next = head;
        head = addedLink;
    }
    public void display () {
        Link current = head;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }
    public Link deleteFirst () {
        if (head != null) {
            Link temp = head;
            head = head.next;
            return temp;
        } else {
            return null;
        }
    }
}
public class Main {
    /** main */
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        ArrayList<String> b = new ArrayList<>();
        b.add("thang");
        b.add("quan");
        a.add("name");
        a.add("address");
        a = b;
        System.out.println(a.size());
        a.add("thuyet");
        System.out.println(b.get(2));
    }
}
