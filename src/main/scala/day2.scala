import scala.util.matching.Regex

val gameInfo = """Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"""



object NumberExtractor extends App {
	val roundsPattern: Regex = "[:;] (.*?)[;$]".r
	val gamePattern: Regex = "Game (\\d*):".r

	
	def getNumber(colorString: String, color: String): Int = {
		val pattern = s"(\\d*)\\s*$color".r
    
		pattern.findFirstMatchIn(colorString) match
			case Some(m) if m.group(1).nonEmpty => m.group(1).toInt
			case _ => 0
	}

	def getColors(colorString: String): List[Int] = {
    val gameColors = List("red", "green", "blue")
    
    gameColors.map(getNumber(colorString, _))
  }

	val games = gameInfo.linesIterator.map(roundsPattern.findAllMatchIn(_).map(_.group(1)).toList).toList
	games.foreach(println)
	//val pgames = games.map(getColors)
	//pgames.foreach(println)

	val gamez = gameInfo.linesIterator.map(gamePattern.findFirstMatchIn(_)map(_.group(1).toInt))
	gamez.foreach(println)


}