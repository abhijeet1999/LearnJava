package java_assignment;

public class CouponCollectorProbelm {

	public static void main(String[] args) {

		final var NUMBER_OF_CARDS = 52;
		String[] suits = { "Spades", "Hearts", "Diamonds", "Clubs" };
		String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };

		var found = new boolean[4];

		var numberOfPicks = 0;
		var count = 0;

		while (count < 4) {
			numberOfPicks++;
			var index = (int) (Math.random() * NUMBER_OF_CARDS);
			if (!found[index / 13]) {
				found[index / 13] = true;
				count++;

				var suit = suits[index / 13];
				var rank = ranks[index % 13];
				System.out.println(rank + " of " + suit);

			}

		}

		System.out.println("Number of picks it took: " + numberOfPicks);

	}

}
