package list.linkedlist;

public class LinkedList {

	class Node {
		int value;
		Node next = null;

		Node(int value) {
			this.value = value;
		}
	}

	protected Node head = null;
	protected Node tail = null;

	public void addToFront(int value) {
		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;

		if (newNode.next == null) {
			tail = newNode;
		}

		/*
		 * 원래 헤드에 있던 노드를 새로운 노드의 뒤로 밀어버리고 새로운 노드를 헤드로 지정해줌 
		 * 텅텅빈 연결리스트에 새로운 노드가 들어왔을 경우 
		 * 얘는 head인 동시에 tail이 된다.
		 */
	}

	public void addToBack(int value) {
		Node newNode = new Node(value);
		if (tail == null) {
			// 연결리스트가 비어있을 때
			head = newNode;
		} else {
			tail.next = newNode;
		}
		tail = newNode;
	}

	public void addAtIndex(int index, int value) {
		if (index < 0) {
			// 인덱스가 음수라면 예외처리
			throw new IndexOutOfBoundsException();
		} else if (index == 0) {
			// 인덱스가 0이라면 맨앞에 추가하는 방식 적용
			addToFront(value);
		} else {
			Node newNode = new Node(value);
			Node current = head; // current는 헤드를 가리키며 시작
			for (int i = 0; i < index - 1; i++) {
				// 해당 인덱스 앞에서 새로운 노드를 링크시킬거.
				// 인덱스 -1 에서 커런트는 업데이트는 멈춘다.

				if (current == null) {
					throw new IndexOutOfBoundsException();
					/*
					 * 연결리스트에 있는 요소 갯수의 범위를 벗어났다면 예외처리 사이즈 4인데 인덱스 1000이 들어오면, 커런트는 인덱스따라서 순차적으로 가는데
					 * 인덱스 4에서 1000까지 가려면 current가 null값이 되는 상황이 온다. index[5]는 null이니까 갈곳이 멀어. 그래서
					 * 이럴땐 예외처리
					 */
				}
				current = current.next;
				// current를 다음 링크로 업데이트.
				// 인덱스로 2를 받았을 경우 여기서 커런트값은 1(좌우대입)
			}
			if (current.next == null) { // 다음 연결이 없을 땐 adding to tail
				tail = newNode;
			} else {
				// 새로운노드를 커런트의 다음노드와 링크
				newNode.next = current.next;
				// 커런트를 새로운 노드와 링크
				current.next = newNode;
			}
		}
	}

	public boolean contains(int value) {
		Node current = head;
		while (current != null) {
			if (current.value == value) {
				return true;
			}
			current = current.next;
		}
		return false;
		/*
		 * current는 끝까지 탐색할 경우 tail을 지나 최종적으로 null값을 가리킬 수 있다. tail은 null에 링크되어 있으니까
		 */
	}

	public int getByIndex(int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		} else {
			Node current = head;
			for (int i = 0; i < index; i++) {
				if (current == null || current.next == null) {
					// 연결리스트 사이즈는 작은데 부른값이 너무 클 때, 금방 최종 null에 도달해버리니까 예외처리
					throw new IndexOutOfBoundsException();
				}
				current = current.next;
			}
			return current.value;
		}
	}
	
	public void removeFromFront() {
		if (head != null) {
			head = head.next;
		}
		if (head == null) {
			tail = null;
		}
	}
	
	public void removeFromBack() {
		if (head == null) { // empty list
			return;
		} else if (head.equals(tail)) { // single element list
			head = null;
			tail = null;
		} else {
			Node current = head;
			while (current.next != tail) {
				current = current.next;
			}
			tail = current;
			current.next = null;
		}
	}
	
	public void removeAtIndex(int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		} else if (index == 0) {
			removeFromFront();
		} else {
			Node current = head;
			for (int i = 0; i < index - 1; i++) {
				if (current == null) {
					throw new IndexOutOfBoundsException();
				}
				current = current.next;
			}
			current.next = current.next.next;
			// 인덱스 2를 제거할 경우 커런트 1의 다음노드는 커런트의 다다음인 3으로 링크하겠다
			if (current.next == null) {
				tail = current;
			}
		}
	}
}
