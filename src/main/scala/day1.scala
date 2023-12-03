import scala.io.Source

val calibrate = """1abc2
pqr3stu8vwx
a1b2c3d4e5f
treb7uchet
""".stripMargin

val filename = "day1.txt"



object NumberExtractor extends App {

  // Regular expression pattern to match numbers
  val numberPattern = "\\d".r

  // Function to extract numbers from a line and return them as a List
  def extractNumbers(line: String): List[String] = {
    numberPattern.findAllIn(line).toList
  }

  // Process each line and collect the numbers in a List
  //val numbers = calibrate.linesIterator.map(extractNumbers).toList
  val numbers = Source.fromFile(filename).getLines.map(extractNumbers).toList
  println(numbers)

  println(numbers.map(list => list.head + list.last))
  
  // Print the extracted numbers
  val target = numbers.map(list => list.head + list.last).map(_.toInt).sum
  
  println(target)
}