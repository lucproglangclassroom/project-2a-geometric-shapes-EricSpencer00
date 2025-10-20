package edu.luc.cs.laufer.cs371.shapes

object Behaviors:
  import Shape.*

  // count concrete leaf shapes (Rectangle and Ellipse)
  def size(s: Shape): Int = s match
    case Rectangle(_, _) => 1
    case Ellipse(_, _)   => 1
    case Location(_, _, sh) => size(sh)
    case Group(shapes @ _*) =>
      shapes.foldLeft(0)((acc, sh) => acc + size(sh))

  // height of shape tree: leaf = 1, Location/Group add 1
  def height(s: Shape): Int = s match
    case Rectangle(_, _) => 1
    case Ellipse(_, _)   => 1
    case Location(_, _, sh) => 1 + height(sh)
    case Group(shapes @ _*) =>
      val childHeights = shapes.map(height)
      1 + (if childHeights.isEmpty then 0 else childHeights.max)

  // scale shape by integer factor
  def scale(s: Shape, factor: Int): Shape = s match
    case Rectangle(w, h) => Rectangle(w * factor, h * factor)
    case Ellipse(rx, ry)  => Ellipse(rx * factor, ry * factor)
    case Location(x, y, sh) => Location(x * factor, y * factor, scale(sh, factor))
    case Group(shapes @ _*) =>
      val scaled = shapes.map(s => scale(s, factor))
      Group(scaled*)

end Behaviors
 

