package edu.luc.cs.laufer.cs371.shapes

/** data Shape = Rectangle(w, h) | Location(x, y, Shape) */
enum Shape derives CanEqual:
  case Rectangle(width: Int, height: Int)
  case Location(x: Int, y: Int, shape: Shape)
  case Ellipse(rx: Int, ry: Int)
  case Group(shapes: Shape*)

end Shape

def height(s: Shape): Int = s match
  case Shape.Rectangle(_, h) => h
  case Shape.Location(_, _, sh) => height(sh)
  case Shape.Ellipse(_, ry) => 2 * ry
  case Shape.Group(shapes @ _*) =>
    if shapes.isEmpty then 0
    else shapes.map(height).max

def size(s: Shape): Int = s match
  case Shape.Rectangle(w, h) => w * h
  case Shape.Location(_, _, sh) => size(sh)
  case Shape.Ellipse(rx, ry) => Math.PI.toInt * rx * ry
  case Shape.Group(shapes @ _*) =>
    shapes.map(size).sum

def scale(s: Shape, factor: Double): Shape = s match
  case Shape.Rectangle(w, h) =>
    Shape.Rectangle((w * factor).toInt, (h * factor).toInt)
  case Shape.Location(x, y, sh) =>
    Shape.Location((x * factor).toInt, (y * factor).toInt, scale(sh, factor))
  case Shape.Ellipse(rx, ry) =>
    Shape.Ellipse((rx * factor).toInt, (ry * factor).toInt)
  case Shape.Group(shapes @ _*) =>
    Shape.Group(shapes.map(sh => scale(sh, factor))*)
  