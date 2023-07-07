package nv.hieu.model;

public enum Card {

    ACE_OF_SPADES(1),
    TWO_OF_SPADE(2),
    THREE_OF_SPADE(3),
    FOUR_OF_SPADE(4),
    FIVE_OF_SPADE(5),
    SIX_OF_SPADE(6),
    SEVEN_OF_SPADE(7),
    EIGHT_OF_SPADE(8),
    NINE_OF_SPADE(9),
    TEN_OF_SPADE(10),
    JACK_OF_SPADE(11),
    QUEEN_OF_SPADE(12),
    KING_OF_SPADE(13),
    ACE_OF_CLUBS(14),
    TWO_OF_CLUBS(15),
    THREE_OF_CLUBS(16),
    FOUR_OF_CLUBS(17),
    FIVE_OF_CLUBS(18),
    SIX_OF_CLUBS(19),
    SEVEN_OF_CLUBS(20),
    EIGHT_OF_CLUBS(21),
    NINE_OF_CLUBS(22),
    TEN_OF_CLUBS(23),
    JACK_OF_CLUBS(24),
    QUEEN_OF_CLUBS(25),
    KING_OF_CLUBS(26),
    ACE_OF_DIAMOND(27),
    TWO_OF_DIAMOND(28),
    THREE_OF_DIAMOND(29),
    FOUR_OF_DIAMOND(30),
    FIVE_OF_DIAMOND(31),
    SIX_OF_DIAMOND(32),
    SEVEN_OF_DIAMOND(33),
    EIGHT_OF_DIAMOND(34),
    NINE_OF_DIAMOND(35),
    TEN_OF_DIAMOND(36),
    JACK_OF_DIAMOND(37),
    QUEEN_OF_DIAMOND(38),
    KING_OF_DIAMOND(39),
    ACE_OF_HEART(40),
    TWO_OF_HEART(41),
    THREE_OF_HEART(42),
    FOUR_OF_HEART(43),
    FIVE_OF_HEART(44),
    SIX_OF_HEART(45),
    SEVEN_OF_HEART(46),
    EIGHT_OF_HEART(47),
    NINE_OF_HEART(48),
    TEN_OF_HEART(49),
    JACK_OF_HEART(50),
    QUEEN_OF_HEART(51),
    KING_OF_HEART(52),

    ;

    private static final int SUIT_SIZE = 13;
    public static final int CARDS_SIZE = 52;
    private final byte cardId;
    private final String name;

    private final int rank;
    private final int suit;

    Card(int id)
    {
        this.cardId = (byte) id;
        this.name = getNameById(id);
        this.rank = (id - 1) % (SUIT_SIZE) + 1;
        this.suit = (id - 1) / SUIT_SIZE;

    }

    public int getCardId() {
        return cardId;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    public static final String SPADES_DISPLAY_NAME = "♠";
    public static final String CLUBS_DISPLAY_NAME = "♣";
    public static final String DIAMOND_DISPLAY_NAME = "♦";
    public static final String HEART_DISPLAY_NAME = "♥";


    private static String getNameById(int id)
    {
        int value = (id - 1) % (SUIT_SIZE) + 1;
        String name = switch (value) {
            case CardConstant.ACE_RANK -> "A";
            case CardConstant.JACK_RANK -> "J";
            case CardConstant.QUEEN_RANK -> "Q";
            case CardConstant.KING_RANK -> "K";
            default -> Integer.toString(value);
        };
        int suitValue = (id - 1) / SUIT_SIZE;
        String suitName = switch (suitValue) {
            case CardConstant.SPADES_SUIT -> SPADES_DISPLAY_NAME;
            case CardConstant.CLUBS_SUIT -> CLUBS_DISPLAY_NAME;
            case CardConstant.DIAMOND_SUIT -> DIAMOND_DISPLAY_NAME;
            case CardConstant.HEART_SUIT -> HEART_DISPLAY_NAME;
            default -> "";
        };
        return name + suitName;

    }



}
