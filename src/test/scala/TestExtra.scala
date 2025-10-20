package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite

import Shape.*
import Behaviors.*

class TestExtra extends AnyFunSuite:

  test("empty group size and height") {
    val g = Group()
    assert(size(g) == 0)
    // group counts as a node; our height convention: 1 + max(child heights) with empty children -> 1
    assert(height(g) == 1)
  }

  test("scale factor zero") {
    val r = Rectangle(3, 5)
    assert(scale(r, 0) == Rectangle(0, 0))
    val l = Location(2, 3, Rectangle(4, 6))
    assert(scale(l, 0) == Location(0, 0, Rectangle(0, 0)))
  }

  test("negative scale factor") {
    val e = Ellipse(2, 3)
    assert(scale(e, -1) == Ellipse(-2, -3))
  }

  test("nested scaling of group") {
    val g = Group(Location(1,1,Rectangle(2,2)), Ellipse(3,3))
    val scaled = scale(g, 3)
    val expected = Group(Location(3,3,Rectangle(6,6)), Ellipse(9,9))
    assert(scaled == expected)
  }

end TestExtra




