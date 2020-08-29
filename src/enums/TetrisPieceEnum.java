package enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum TetrisPieceEnum {

	J, L, S, Square, Stick, T, Z;

	private static final List<TetrisPieceEnum> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();

	public static TetrisPieceEnum randomPiece() {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}

}
