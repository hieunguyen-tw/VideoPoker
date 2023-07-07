# VideoPoker
Unit test and TDD practice project
## Description
  Video poker is a single player card game based Poker rules
## How to play
  1. First, player will receive 5 cards
  2. Player will be asked to discard their cards (no amount is restrict).
  3. Player will receive cards from the deck with amount equals to discarded cards
  4. Player's last 5 cards will be ranked (ref Hand rankings section)
## Hand rankings
  - Two cards of a same rank Jack, Queen, King or Ace => JACKS_OR_BETTER
  - Two different pairs => TWO_PAIRS 
  - Three cards of a same rank => THREE_OF_A_KIND
  - Five cards in a sequence, but not of the same suit => STRAIGHT
  - Any five cards of a same suit, but not in sequence => FLUSH
  - Three of a kind with a pair => FULL_HOUSE
  - Four cards of a same rank => FOUR_OF_A_KIND
  - Five cards in a sequence, all in the same suit => STRAIGHT_FLUSH
  - A, K, Q, J, 10 in a same suit => ROYAL_FLUSH
  - None of the above => NONE
