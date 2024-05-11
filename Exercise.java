package xuanthanh;

import java.util.Random;
import java.util.Scanner;

public class Exercise {
	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	Node head;

	public Exercise() {
		this.head = null;
	}

	public void insert(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node crr = head;
			while (crr.next != null) {
				crr = crr.next;
			}
			crr.next = newNode;
		}
	}
	// Display

	public void display() {
		Node crr = head;
		while (crr != null) {
			System.out.print(crr.data + "-> ");
			crr = crr.next;

		}
		System.out.println("null");
	}

	// Fìnd LastElement
	public void inLastElement() {
		if (head == null) {
			System.out.println("Danh sach rong");
		} else {
			Node crr = head;
			while (crr.next != null) {
				crr = crr.next;
			}
			System.out.println("Phan tu cuoi cung trong ds la: " + crr.data);
		}
	}

	// Swap first with second
	public void swapFirstWithSecond() {
		if (head == null || head.next == null) {
			System.out.println("Ds Rong or chi co mot nut");
			return;
		} else {
			Node first = head;
			Node Second = head.next;
			first.next = Second.next;
			Second.next = first;
			head = Second;

		}
	}

	// Chen
	public void chenx(int x, int k) {
		if (k < 1) {
			System.out.println("\nKhông chèn được.");
			return;
		}
		if (k == 1) {
			head = new Node(x);
			return;
		}

		Node prev = head;
		int count = 1;
		while (prev != null && count < k - 1) {
			prev = prev.next;
			count++;
		}

		if (prev == null) {
			System.out.println("\nVị trí không hợp lệ.");
			return;
		}

		Node newNode = new Node(x);
		newNode.next = prev.next;
		prev.next = newNode;
	}

	// Delete
	public void deleteElement(int k) {
		if (head == null || k < 1) {
			System.out.println("Không thể xóa.");
			return;
		}

		if (k == 1) {
			head = head.next;
			return;
		}

		Node prev = null;
		Node current = head;
		int count = 1;

		while (current != null && count < k) {
			prev = current;
			current = current.next;
			count++;
		}

		if (current == null) {
			System.out.println("Vị trí không hợp lệ.");
			return;
		}

		prev.next = current.next;
	}

	// Calculate Sum
	public int sum() {
		int total = 0;
		Node crr = head;
		while (crr != null) {
			total += crr.data;
			crr = crr.next;
		}
		return total;
	}

	// Count OldElement
	public int CountOldElement() {
		int count = 0;
		Node crr = head;
		while (crr != null) {
			if (crr.data % 2 != 0) {
				count++;
			}
			crr = crr.next;
		}
		return count;

	}

	// Main
	public static void main(String[] args) {
		Exercise E = new Exercise();
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		System.out.println("Nhap so phan tu cua danh sach: ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int randomNumber = rd.nextInt(99) + 1;
			E.insert(randomNumber);
		}

		System.out.println("Danh sách ban đầu:");
		E.display();

		System.out.println("Tổng các phần tử trong danh sách: " + E.sum());
		System.out.println("Tổng số phần tử lẻ trong danh sách: " + E.CountOldElement());
		E.inLastElement();

		int x = 100;
		int k = 4;

		// Chèn giá trị x vào vị trí k
		E.chenx(x, k);
		System.out.println("Danh sách sau khi chèn giá trị " + x + " vào vị trí " + k + ":");
		E.display();

		// Xóa phần tử thứ k=3
		int kToDelete = 3;
		System.out.println("Xóa phần tử thứ " + kToDelete + " trong danh sách:");
		E.deleteElement(kToDelete);
		E.display();

		// Hoán đổi nút đầu tiên với nút thứ hai
		System.out.println("Hoán đổi nút đầu tiên với nút thứ hai:");
		E.swapFirstWithSecond();
		E.display();
	}

}
