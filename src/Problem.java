import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Problem {
	private static String[] FILES = {
			"a_example.txt",
			"b_read_on.txt",
			"c_incunabula.txt",
			"d_tough_choices.txt",
			"e_so_many_books.txt",
			"f_libraries_of_the_world.txt"
	};

	private Scanner mScanner;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner;
		if (args.length == 0) {
			scanner = new Scanner(System.in);
		} else {
			scanner = new Scanner(new File(FILES[args[0].charAt(0) - 'a']));
		}
		new Problem(scanner).run();
	}

	private Problem(Scanner scanner) {
		mScanner = scanner;
		parseInput();
	}

	private int mDays;
	private Map<Integer, Book> mBooks = new HashMap<>();
	private Map<Integer, Library> mLibraries = new HashMap<>();

	protected void parseInput() {
		int b = mScanner.nextInt();
		int l = mScanner.nextInt();
		mDays = mScanner.nextInt();

		for (int i = 0; i < b; i++) mBooks.put(i, new Book(i, mScanner.nextInt()));

		for (int i = 0; i < l; i++) {
			int n = mScanner.nextInt();
			int t = mScanner.nextInt();
			int m = mScanner.nextInt();
			Library library = new Library(i, t, m);
			mLibraries.put(i, library);

			for (int j = 0; j < n; j++) library.books.add(mBooks.get(mScanner.nextInt()));
			library.books.sort(Comparator.comparingInt(Book::getScore));
		}
	}

	private List<Library> mChosenLibraries = new ArrayList<>();
	private int mCurrentDay = 0;
	private List<Set<Book>> mDayBooks = new ArrayList<>();

	private void run() {
		int maxDays = Integer.MAX_VALUE;
		int maxScore = 0;
		for (Library library : mLibraries.values()) {
			library.
		}
	}

	private void



	private static class Book {
		int id;
		int score;

		int getScore() {
			return this.score;
		}

		Book(int id, int score) {
			this.id = id;
			this.score = score;
		}
	}

	private class Library {
		final int id;
		final int days;
		final int speed;
		List<Book> books = new ArrayList<>();

		Library(int id, int days, int speed) {
			this.id = id;
			this.days = days;
			this.speed = speed;
		}

		private int daysCanSendUntilEnd() {
			return Problem.this.mDays - 
		}
	}
}