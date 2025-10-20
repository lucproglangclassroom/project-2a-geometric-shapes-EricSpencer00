package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior

import Shape.*

object boundingBox:
  def apply(s: Shape): Location = s match
  case Rectangle(w, h) =>
    Location(0, 0, Rectangle(w, h))

  case Location(x, y, sh) =>
    // compute bounding box of inner shape, then offset it by (x,y)
    val inner = apply(sh) // inner: Location
    Location(x + inner.x, y + inner.y, inner.shape)

  case Ellipse(rx, ry) =>
    // an ellipse's bbox centered at origin goes from -rx..rx and -ry..ry
    Location(-rx, -ry, Rectangle(2 * rx, 2 * ry))

  case Group(shapes @ _*) =>
    val bboxes = shapes.map(apply) // Seq[Location]
    val minX = bboxes.map(_.x).min
    val minY = bboxes.map(_.y).min
    // maxX is the maximum of (bbox.x + bbox.width)
    val maxX = bboxes.map { b =>
      val w = b.shape match
        case Rectangle(w, _) => w
        case _ => 0
      b.x + w
    }.max
    val maxY = bboxes.map { b =>
      val h = b.shape match
        case Rectangle(_, h) => h
        case _ => 0
      b.y + h
    }.max
    Location(minX, minY, Rectangle(maxX - minX, maxY - minY))
    
end boundingBox
