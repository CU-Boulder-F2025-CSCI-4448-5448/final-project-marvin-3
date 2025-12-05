# Stratego in your terminal!
Overview: We have coded a basic version of the classic two-player game stratego! Both players play on the same computer, simply passing the computer back and forth at the prompt. Your computer will also keep track of total wins from game to game for long-lasting battles!<br>

Functionality: Run through main. Red and blue will be first prompted to enter initials. Then each player, beginning with red, will set up his or her board one at a time, in order of pieces 1 to flag. Once both players have completed set-up, game play will pass between players, beginning with red, until one player wins.

# Rules of the game

Objective<br>
- Capture the opponent’s Flag or eliminate all of their movable pieces.

Board & Setup
- The game is played on a 10×10 board by two players, "red" and "blue".
- Each player controls 40 pieces of varying ranks.
- Two 2×2 impassable lake areas are located in the center.
- Players secretly place their pieces on their first four rows.
- After setup, pieces cannot be moved until the game begins.

Piece Types and Ranks<br>
- 1	Marshal =	Highest rank<br>
- 2	General<br>
- 3	Colonel	<br>
- 4	Major	<br>
- 5	Captain	<br>
- 6	Lieutenant	<br>
- 7	Sergeant	<br>
- 8	Miner = Can defuse bombs<br>
- 9	Scout	<br>
- S	Spy =	Can defeat the marshal if it attacks first<br>
- B	Bomb = Immovable; kills attackers except miners<br>
- F	Flag = Immovable; capturing it wins the game<br>

Movement Rules<br>
- Most pieces move one square orthogonally (up, down, left, right).
- No diagonal movement.
- Bombs and the flag cannot move.
- Pieces cannot move into or through lakes.
- A piece may move onto an opponent's piece to attack ("strike") it.

When a piece moves onto a square occupied by an opponent’s piece:
- The higher-ranked piece wins.
- The losing piece is removed from the board.
- If the attacking piece wins, it moves into the space previously occupied by the losing piece.
- If both pieces have the same rank, both are removed.

The attacker wins ties only for the spy vs. marshal scenario:
- Spy attacking marshal → spy wins
- Marshal attackingsSpy → marshal wins

Special Combat Cases
- Bombs destroy any attacker except Miners.
- Miners defuse bombs (miner wins).
- Any moveable piece captures the flag during a strike.

When a Player Cannot Move
A player loses if:
- Their Flag is captured, or
- They have no movable pieces left, or
- All their movable pieces are surrounded by pieces of their own color and cannot legally move.

Turn Structure
- Current player chooses one of their movable pieces and a legal destination.
- If entering a square occupied by the opponent, a "strike" occurs.
- Turn ends; play passes to the opponent.

You win the game if you:
- Capture the opponent’s Flag, or
- Opponent has no legal moves remaining.
