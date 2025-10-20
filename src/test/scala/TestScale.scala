package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite

import TestFixtures.*
import Behaviors.*
import Shape.*

class TestScale extends AnyFunSuite:

  def testScale(description: String, s: Shape, factor: Int, expected: Shape): Unit =
    test(description) {
      assert(expected == scale(s, factor))
    }

  testScale("simple ellipse", simpleEllipse, 2, Ellipse(100, 60))
  testScale("simple rectangle", simpleRectangle, 2, Rectangle(160, 240))
  testScale("simple location", simpleLocation, 2, Location(140, 60, Rectangle(160, 240)))

end TestScale




