import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        
        CircularLinkedList list = new CircularLinkedList();
        
        int n = in.nextInt();
        int k = in.nextInt();
        
        for (int i = 1; i <= n; i++) {
        	list.add(new Node(i));
        }
        
        for (int i = 0; i < n; i++) {
        	list.remove(k);
        }
        CircularLinkedList.sb.setLength(CircularLinkedList.sb.length()-2);
        
        System.out.println(CircularLinkedList.sb + ">");
    }
}

class Node {
	int data;
	Node link;
	
	Node(int n) {
		data = n;
	}
}

class CircularLinkedList {
	
	Node startNode = null;
	Node endNode = null;
	
	Node pointNode = null;
	
	static StringBuilder sb = new StringBuilder();
	
	public void add(Node node) {
		
		if (startNode == null) {
			startNode = node;
			endNode = node;
			sb.append("<");
		} else {
			endNode.link = node;
			endNode = node;
		}
		
		endNode.link = startNode;
	}
	
	public void remove(int idx) {
		if (startNode == null) {
			throw new ArrayIndexOutOfBoundsException("요소가 없습니다.");
		}
		
		if (pointNode == null) {
			pointNode = startNode;
			idx--;
		}
		
		
		var previousNode = pointNode;
		for (int i = 0; i < idx; i++) {
			previousNode = pointNode;
			pointNode = pointNode.link;
		}
		
		previousNode.link = pointNode.link;
		
		sb.append(pointNode.data).append(", ");
		
		pointNode = previousNode;
	}
	
}
