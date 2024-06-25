package java_assignment;

public class DeckOfCards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		var deck = new int[52];

		String[] suits = { "Spades", "Hearts", "Diamonds", "Clubs" };
		String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };

		for (var i = 0; i < deck.length; i++) {
			deck[i] = i;
		}

		for (var i = 0; i < deck.length; i++) {
			var index = (int) (Math.random() * deck.length);

			var temp = deck[i];
			deck[i] = deck[index];
			deck[index] = temp;
		}
		for (var i = 0; i < 4; i++) {
			var suit = suits[deck[i] / 13];
			var rank = ranks[deck[i] % 13];

			System.out.println("Card number " + deck[i] + " : " + suits[i] + "  of " + ranks[i]);
		}

	}

}
