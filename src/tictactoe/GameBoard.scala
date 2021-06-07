package tictactoe

class GameBoard(val upperLeft: Char = '*', val upperCenter: Char = '*', val upperRight: Char = '*',
                val midRight:Char = '*', val midCenter: Char = '*', val midLeft: Char = '*',
                val bottomLeft: Char = '*', val bottomCenter: Char = '*', val bottomRight: Char = '*') {




  def displayBoard(): Unit = {
    print(upperLeft + " | " + upperCenter + " | " + upperRight + "\n")
    println("----------")
    print(midLeft + " | " + midCenter + " | " + midRight + "\n")
    println("----------")
    print(bottomLeft + " | " + bottomCenter + " | " + bottomRight + "\n")
  }

  def clearBoard(board: GameBoard): GameBoard = {
    new GameBoard

  }
}
