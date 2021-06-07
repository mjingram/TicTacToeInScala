package tictactoe

class Player (val name: String, marker: Char){



  def takeTurn(row: Int, col: Int, board: GameBoard): GameBoard={
    if(row ==0 && col ==0) {
      new GameBoard(upperLeft = marker, upperCenter = board.upperCenter, upperRight = board.upperRight,
        midLeft = board.midLeft, midCenter = board.midCenter, midRight = board.midRight,
        bottomLeft = board.bottomLeft, bottomCenter = board.bottomCenter, bottomRight = board.bottomRight)
    }
    else if(row ==0 && col ==1){
      new GameBoard(upperLeft = board.upperLeft, upperCenter = marker, upperRight = board.upperRight,
        midLeft = board.midLeft, midCenter = board.midCenter, midRight = board.midRight,
        bottomLeft = board.bottomLeft, bottomCenter = board.bottomCenter, bottomRight = board.bottomRight)
    }
    else if(row ==0 && col ==2){
      new GameBoard(upperLeft = board.upperLeft, upperCenter = board.upperCenter, upperRight = marker,
        midLeft = board.midLeft, midCenter = board.midCenter, midRight = board.midRight,
        bottomLeft = board.bottomLeft, bottomCenter = board.bottomCenter, bottomRight = board.bottomRight)
    }
    else if(row ==1 && col ==0) {
      new GameBoard(upperLeft = board.upperLeft, upperCenter = board.upperCenter, upperRight = board.upperRight,
        midLeft = marker, midCenter = board.midCenter, midRight = board.midRight,
        bottomLeft = board.bottomLeft, bottomCenter = board.bottomCenter, bottomRight = board.bottomRight)
    }
    else if(row ==1 && col ==1) {
      new GameBoard(upperLeft = board.upperLeft, upperCenter = board.upperCenter, upperRight = board.upperRight,
        midLeft = board.midLeft, midCenter = marker, midRight = board.midRight,
        bottomLeft = board.bottomLeft, bottomCenter = board.bottomCenter, bottomRight = board.bottomRight)
    }
    else if(row ==1 && col ==2) {
      new GameBoard(upperLeft = board.upperLeft, upperCenter = board.upperCenter, upperRight = board.upperRight,
        midLeft = board.midLeft, midCenter = board.midCenter, midRight = marker,
        bottomLeft = board.bottomLeft, bottomCenter = board.bottomCenter, bottomRight = board.bottomRight)
    }
    else if(row ==2 && col ==0) {
      new GameBoard(upperLeft = board.upperLeft, upperCenter = board.upperCenter, upperRight = board.upperRight,
        midLeft = board.midLeft, midCenter = board.midCenter, midRight = board.midRight,
        bottomLeft = marker, bottomCenter = board.bottomCenter, bottomRight = board.bottomRight)
    }
    else if(row ==2 && col ==1){
      new GameBoard(upperLeft = board.upperLeft, upperCenter = board.upperCenter, upperRight = board.upperRight,
        midLeft = board.midLeft, midCenter = board.midCenter, midRight = board.midRight,
        bottomLeft = board.bottomLeft, bottomCenter = marker, bottomRight = board.bottomRight)
    }
    else { //cell (2, 2)
      new GameBoard(upperLeft = board.upperLeft, upperCenter = board.upperCenter, upperRight = board.upperRight,
        midLeft = board.midLeft, midCenter = board.midCenter, midRight = board.midRight,
        bottomLeft = board.bottomLeft, bottomCenter = board.bottomCenter, bottomRight = marker)
    }
  }

  def gameOver(board: GameBoard): Boolean ={
    if(board.upperLeft == marker && board.upperCenter == marker && board.upperRight == marker) true
    else if(board.midLeft == marker && board.midCenter == marker && board.midRight == marker) true
    else if(board.bottomLeft == marker && board.bottomCenter == marker && board.bottomRight == marker) true
    else if(board.upperLeft == marker && board.midLeft == marker && board.bottomLeft == marker) true
    else if(board.upperLeft == marker && board.midLeft == marker && board.bottomLeft == marker) true
    else if(board.upperCenter == marker && board.midCenter == marker && board.bottomCenter == marker) true
    else if(board.upperRight == marker && board.midRight == marker && board.bottomRight == marker) true
    else if(board.upperLeft == marker && board.midCenter == marker && board.bottomRight == marker) true
    else if(board.upperRight == marker && board.midCenter == marker && board.bottomLeft == marker) true
    else false

  }


}
