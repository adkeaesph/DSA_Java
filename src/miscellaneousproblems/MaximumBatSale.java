package miscellaneousproblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MaximumBatSale {

	public static void main(String[] args) throws IOException {
		class Bat {
			int weight;
			int price;

			Bat(int weight, int price) {
				this.weight = weight;
				this.price = price;
			}

			void display() {
				System.out.print("[" + weight + ", " + price + "]");
			}

		}
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String[] strs;
		strs = br.readLine().trim().split("\\s+");
		int noAvbl = Integer.parseInt(strs[0]);
		int noReq = Integer.parseInt(strs[1]);
		Bat[] avblBats = new Bat[noAvbl];
		Bat[] reqBats = new Bat[noReq];

		for (int i = 0; i < noAvbl; i++) {
			strs = br.readLine().trim().split("\\s+");
			avblBats[i] = new Bat(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]));
		}

		for (int i = 0; i < noReq; i++) {
			strs = br.readLine().trim().split("\\s+");
			reqBats[i] = new Bat(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]));
		}

		br.close();
		isr.close();

		Set<Bat>[] options = new HashSet[noReq];
		for (int i = 0; i < noReq; i++) {
			options[i] = new HashSet<Bat>();
			for (int j = 0; j < noAvbl; j++) {
				if (reqBats[i].weight <= avblBats[j].weight && reqBats[i].price >= avblBats[j].price) {
					options[i].add(avblBats[j]);
				}
			}
		}

		Set<Bat> key;
		int j;
		for (int i = 1; i < noReq; i++) {
			key = options[i];
			for (j = i - 1; j >= 0; j--) {
				if (key.size() >= options[j].size())
					break;
				else
					options[j + 1] = options[j];
			}
			options[j + 1] = key;
		}

		Iterator<Bat> it;
		Set<Bat> temp;
		for (int i = 0; i < noReq; i++) {
			temp = options[i];
			it = temp.iterator();
			while (it.hasNext()) {
				((Bat) it.next()).display();
				System.out.print(" ");
			}
			System.out.println();
		}

		Bat toBeRemoved;
		int count = 0;
		for (int i = 0; i < noReq; i++) {
			temp = options[i];
			if (!temp.isEmpty()) {
				it = temp.iterator();
				toBeRemoved = it.next();
				for (int k = 0; k < noReq; k++) {
					options[k].remove(toBeRemoved);
				}
				count++;
			}
		}
		System.out.println(count + "\n");
		for (int i = 0; i < noReq; i++) {
			temp = options[i];
			it = temp.iterator();
			while (it.hasNext()) {
				((Bat) it.next()).display();
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
