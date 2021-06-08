package tictactoe

import java.util.Scanner
import scala.util.Random


object TicTacToe extends App {
  val board: GameBoard = new GameBoard
  val input: Scanner = new Scanner(System.in)


  def player2Set(player: String): String = {
    if(player.equals("X")) "O"
    else "X"
  }

  //try/catch for input type
  def playerMarkerCheck(): String = {
    try {
      println("Would you like to be X's or O's?")
      val player1marker: String = input.nextLine().toUpperCase()
      if (!(player1marker.equals("X") || player1marker.equals("O"))) {
        throw new Exception
      }
      player1marker
    }
    catch {
      case e: Exception => playerMarkerCheck
    }
  }
  //Player Markers
  val player1marker: String = playerMarkerCheck()
  val player2marker: String = player2Set(player1marker)
  // Make Players
  val player1: Player = new Player("Player 1", player1marker.charAt(0))
  val player2: Player = new Player("Player 2", player2marker.charAt(0))

  def rowColInputCheck(rowOrCol: String, player: Player): Int ={
    try{
      println(s"${player.name} pick a $rowOrCol (between 0 and 2): ")

      val rowCol: Int = input.nextInt()
      input.nextLine()
      if(rowCol >2 || rowCol< 0){
        throw new Exception
      }
      rowCol
    }catch{
      case e: Exception => rowColInputCheck(rowOrCol, player)
    }
  }
  def alreadyFill(row: Int, col: Int, board: GameBoard): Boolean = {
    if(row ==0 && col ==0) {
      if(board.upperLeft != '*') true
      else false
    }
    else if(row ==0 && col ==1) {
        if(board.upperCenter != '*') true
        else false
    }
    else if(row ==0 && col ==2) {
      if(board.upperRight != '*') true
      else false}
    else if(row ==1 && col ==0) {
      if(board.midLeft != '*') true
      else false}
    else if(row ==1 && col ==1) {
      if(board.midCenter != '*') true
      else false}
    else if(row ==1 && col ==2) {
      if(board.midRight != '*') true
      else false}
    else if(row ==2 && col ==0) {
      if(board.bottomLeft != '*') true
      else false}
    else if(row ==2 && col ==1) {
      if(board.bottomCenter != '*') true
      else false}
    else if(row == 2 && col == 2){
      if(board.bottomRight != '*') true
      else false}
    else false
    }





  def gameRound(player1: Player, player2: Player, board: GameBoard, turn: Int): String={


    printf("Turn %d: \n", (turn))
    println()

    //Check if draw
    if(turn == 9){
      println("Max turns reached. Its a draw")
      return "Draw"
    }

  // player 1 turn

    val row1: Int = rowColInputCheck("Row", player1)
    val col1: Int = rowColInputCheck("Column", player1)
    if(alreadyFill(row1, col1, board)){
      println("Space is already filled")
      return gameRound(player1, player2, board, turn)
    }
    val currentBoard =  player1.takeTurn(row1, col1, board)

    currentBoard.displayBoard()
    println()


    // Check if player 1 won:
    if(player1.gameOver(currentBoard)){
      println(s"Player 1 has won on turn: $turn")
      return player1.name
    }

  //player 2 turn
    printf("Turn %d: \n", (turn+1))
    println()


//    val row2: Int = rowColInputCheck("Row", player2)
//    val col2: Int = rowColInputCheck("Column", player2)
    val rowCol = gameLogic(currentBoard)
    val row2 = rowCol(0)
    println(s"row: $row2")
    val col2 = rowCol(1)
    println(s"col: $col2")

    val currentBoardP2 = player2.takeTurn(row2, col2, currentBoard)

    currentBoardP2.displayBoard()
    println()

    // Check if player 2 won:
    if(player2.gameOver(currentBoardP2)){
      println(s"Player 2 has won on turn: ${turn+1}")
      return player2.name
    }
    gameRound(player1, player2, currentBoardP2, turn+2)

  }

  def game(player1: Player, player2: Player, board: GameBoard, turn: Int = 1, player1Wins: Int = 0, player2Wins: Int = 0, draw: Int = 0 ): Unit = {


    val winner: String = gameRound(player1, player2, board, turn)


    System.out.println("Would you like to play again? ")
    val continueAnswer = input.nextLine


    if (continueAnswer.equalsIgnoreCase("yes")) {
      val newBoard: GameBoard = new GameBoard()
      if(winner.equals(player1.name)){
//        println("in if loop")
        game(player1, player2, newBoard, 1, player1Wins+1, player2Wins, draw)

      }
      else if(winner.equals(player2.name)) {
//        println("in else-if loop")
        game(player1, player2, newBoard, 1, player1Wins, (player2Wins+1), draw)

      }else{
//        println("in else loop")
        game(player1, player2, newBoard, 1, player1Wins, player2Wins, draw+1)
      }

    }
    else {
      println("___Final Results___")
      if(winner.equals(player1.name)){
        println(s"Player 1 wins: ${player1Wins+1}")
        println(s"Player 2 wins: $player2Wins")
        println(s"Draws: $draw")
        if((player1Wins+1)>player2Wins){
          println("Player 1 has won!")
        }else if (player2Wins>player1Wins){
          println("Player 2 has won!")
        }
        else{
          println("Its a draw.")
        }
      }else if(winner.equals(player2.name)){
        println(s"Player 1 wins: $player1Wins")
        println(s"Player 2 wins: ${player2Wins+1}")
        println(s"Draws: $draw")
        if(player1Wins>player2Wins){
          println("Player 1 has won!")
        }else if ((player2Wins+1)>player1Wins){
          println("Player 2 has won!")
        }
        else{
          println("Its a draw.")
        }
      }else{
        println(s"Player 1 wins: $player1Wins")
        println(s"Player 2 wins: $player2Wins")
        println(s"Draws: ${draw+1}")
        if(player1Wins>player2Wins){
          println("Player 1 has won!")
        }else if (player2Wins>player1Wins){
          println("Player 2 has won!")
        }
        else{
          println("Its a draw.")
        }
      }




      println("Thanks for playing")
      return ()
    }
  }
  def gameLogic(board: GameBoard): Array[Int]={
    val row: Int = Random.nextInt(3)
    println(s"row: $row")
    val col: Int = Random.nextInt(3)
    println(s"row: $row")
    if(alreadyFill(row, col, board)){
      gameLogic(board)
  }
    else{
      val rowCol = Array(row, col)
      rowCol
    }

  }

  // Start Game
  game(player1, player2, board)


}
