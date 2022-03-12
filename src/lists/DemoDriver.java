package lists;

import customexceptions.ListException;

public class DemoDriver {

	public static void main(String[] args) throws ListException {
		singlyLinkedListTests();
		doublyLinkedListTests();
		circularLinkedListTests();
	}

	private static void singlyLinkedListTests() throws ListException {
		List<Integer> list = new SinglyLinkedList<>();
		list.add(2);
		System.out.println(list);
		
		
		list.add(3);
		System.out.println(list);
		
		list.add(7);
		System.out.println(list);
		
		list.add(10,list.getSize());
		System.out.println(list);
		
		list.removeObject(3);
		System.out.println(list);
		
		list.removeAt(0);
		list.removeAt(0);
		list.removeAt(0);
		System.out.println(list);
		
		list.add(3);
		list.add(7);
		list.add(11);
		list.add(6);
		list.add(2);
		list.add(11);
		list.add(34);
		System.out.println(list);
		
		list.removeObject(34);
		list.removeObject(3);
		list.removeObject(11);
		System.out.println(list);
		
		list.removeAt(3);
		list.removeAt(0);
		System.out.println(list);
		
		list.add(45);
		list.add(2);
		list.add(2);
		list.add(25);
		list.add(2);
		list.add(34);
		list.add(56);
		list.add(2);
		System.out.println(list);
		
		list.removeObject(6);
		System.out.println(list);
		
		list.add(2);
		list.add(2,0);
		System.out.println(list);
		
		list.removeAllObjects(2);
		System.out.println(list);
		
		list.add(0);
		System.out.println(list);
		
		System.out.println(list.getPositionOf(34));
		System.out.println(list.getPositionOf(88));
		
	}

	private static void doublyLinkedListTests() throws ListException {
		List<Character> doublyList = new DoublyLinkedList<>();
		doublyList.add('a');
		doublyList.add('b');
		doublyList.add('c');
		doublyList.add('d');
		doublyList.add('e');
		System.out.println(doublyList);
		
		doublyList.add('a',2);
		System.out.println(doublyList);
		doublyList.add('A',0);
		System.out.println(doublyList);
		doublyList.add('Z',7);
		System.out.println(doublyList);
		
		System.out.println();
		
		doublyList.removeObject('c');
		System.out.println(doublyList);
		doublyList.removeObject('A');
		System.out.println(doublyList);
		doublyList.removeObject('Z');
		System.out.println(doublyList);
		doublyList.removeObject('b');
		System.out.println(doublyList);
		doublyList.removeObject('a');
		System.out.println(doublyList);
		System.out.println();
		
		doublyList.add('g');
		doublyList.add('h');
		System.out.println(doublyList);
		doublyList.removeAt(doublyList.getSize()-1);
		System.out.println(doublyList);
		doublyList.removeAt(2);
		System.out.println(doublyList);
		doublyList.removeAt(0);
		System.out.println(doublyList);
		
		doublyList.add('a',0);
		doublyList.add('a',0);
		doublyList.add('a',3);
		doublyList.add('a',3);
		doublyList.add('f');
		doublyList.add('a');
		doublyList.add('a');
		System.out.println(doublyList);
		
		doublyList.removeAllObjects('a');
		System.out.println(doublyList);
		
		System.out.println(doublyList.getPositionOf('g'));
		System.out.println(doublyList.getPositionOf('f'));
		System.out.println(doublyList.getPositionOf('d'));
		System.out.println(doublyList.getPositionOf('a'));
		
		DoublyLinkedList<Character> doublyList2 = new DoublyLinkedList<>();
		doublyList2.add('a');
		doublyList2.add('b');
		doublyList2.add('c');
		doublyList2.add('d');
		doublyList2.add('e');
		System.out.println(doublyList2.reverse());
		
		doublyList2.add('a',2);
		System.out.println(doublyList2.reverse());
		doublyList2.add('A',0);
		System.out.println(doublyList2.reverse());
		doublyList2.add('Z',7);
		System.out.println(doublyList2.reverse());
		System.out.println();
		
		doublyList2.removeObject('c');
		System.out.println(doublyList2.reverse());
		doublyList2.removeObject('A');
		System.out.println(doublyList2.reverse());
		doublyList2.removeObject('Z');
		System.out.println(doublyList2.reverse());
		doublyList2.removeObject('b');
		System.out.println(doublyList2.reverse());
		doublyList2.removeObject('a');
		System.out.println(doublyList2.reverse());
		System.out.println();
		
		doublyList2.add('g');
		doublyList2.add('h');
		System.out.println(doublyList2.reverse());
		doublyList2.removeAt(doublyList2.getSize()-1);
		System.out.println(doublyList2.reverse());
		doublyList2.removeAt(2);
		System.out.println(doublyList2.reverse());
		doublyList2.removeAt(0);
		System.out.println(doublyList2.reverse());
		
		doublyList2.add('a',0);
		doublyList2.add('a',0);
		doublyList2.add('a',3);
		doublyList2.add('a',3);
		doublyList2.add('f');
		doublyList2.add('a');
		doublyList2.add('a');
		System.out.println(doublyList2.reverse());
		
		doublyList2.removeAllObjects('a');
		System.out.println(doublyList2.reverse());
	}

	private static void circularLinkedListTests() throws ListException {
		CircularLinkedList<Double> list = new CircularLinkedList<>();
		list.add(2.0);
		System.out.println(list);
		
		list.add(3.6);
		list.add(7.9);
		System.out.println(list);
		list.add(4.5, list.getSize());
		System.out.println(list);
		list.add(3.9);
		list.add(7.9);
		list.add(7.9);
		list.add(4.0);
		System.out.println(list);
		list.add(4.0, 0);
		System.out.println(list);
		list.add(7.9, 5);
		System.out.println(list);
		
		System.out.println("Position of 3.9 = "+list.getPositionOf(3.9));
		
		System.out.println();
		
		list.removeObject(4.0);
		System.out.println(list);
		list.removeObject(4.5);
		System.out.println(list);
		list.removeObject(7.9);
		System.out.println(list);
		list.removeObject(4.0);
		System.out.println(list);
		
		System.out.println(list.displayRepeatedly(2*list.getSize()));
		
		list.removeAt(1);
		list.add(4.23);
		System.out.println(list);
		list.removeAt(list.getSize() - 1);
		System.out.println(list);
		
		list.removeAt(0);
		System.out.println(list);
		
		list.add(7.9,0);
		System.out.println(list);
		
		list.removeAllObjects(7.9);
		System.out.println(list);
		
		for(int i=0;i<list.getSize();i++)
			System.out.println(list.get(i));
		
		System.out.println(list.getPositionOf(7.9));
		
	}
}
