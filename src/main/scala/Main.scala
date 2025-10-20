package edu.luc.cs.laufer.cs371.shapes

object Main:
  def main(args: Array[String]): Unit =
    import Shape.*

    val r = Rectangle(2, 3)
    println(s"shape: $r")
    println(s"boundingBox: ${boundingBox(r)}")

end Main

