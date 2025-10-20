[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=21176684)


Learning objectives
Transition from Java to Scala
An understanding of
object-oriented programming in Scala
algebraic data types and their representation as case classes
pattern matching
recursive functions
relationship with composite, decorator, and visitor patterns
test-driven development (TDD) in Scala and Intellij IDEA
Scala collections library and methods
Functional requirements
Accept this GitHub classroom invitation to copy the shapes-oo-scala example, then copy your resulting private repository URL and clone the repository.
Study the code.
Try to run the Main application and the unit tests. The code should compile, though most of the tests will fail.
sbt test:run
sbt test
Perform the steps marked TODO in the comments within the sources provided (View > Tool Windows > TODO). When you are done, all six bounding box tests should succeed.
Following boundingBox, create a size behavior that counts the number of concrete leaf shapes (such as ellipses and rectangles) in a general shape.
Following size, create a height behavior that computes the height of a shape tree (taking all kinds of shape nodes into consideration). [This used to be called depth in previous versions]
In addition, create a scale behavior that (recursively) scales the dimensions of a shape by a given factor. (This affects shapes that have dimensions, including locations.)
See also this related Java/Android-based project from COMP 313/413: description code skeleton This corresponding image shows several types of shapes (including some features not required here, such as colors and polygons); the black rectangle surrounding all the other shapes is the bounding box for the entire group of those other shapes.



In addition, here is a related practice midterm exam, which should help conceptually and algorithmically if you did not work on the related Java/Android project: practice exam The solution for this exam is attached below.

Nonfunctional requirements
Retain the original project structure.
Keep your code as functional/immutable as possible.
Use map, foldLeft, sum, and/or min/max in the completion of the boundingBox behavior.
Using the existing test fixtures and following TestBoundingBox, create TestSize, TestHeight, and TestScale classes with at least the same number of tests but for your size, height, and scale behaviors, respectively.
Use a suitable logging library to print debugging information (see also project 1b and the lecture notes).
Extra credit
Graphical rendering of the shapes using Doodle or some other suitable graphics library. You should implement this capability as a new behavior draw.
Automated unit testing of the draw behavior using offline drawing to instances of BufferedImage (see also this example).
Be sure to indicate in your project README if you attempted one or both of these extra credit tasks.

Submission
Your GitHub Classroom repository will be shared automatically with the instructor and TA. As you work on this project, keep your repo current by committing and pushing frequently. Once your project is ready to grade, submit a brief inline note to Sakai with the complete repo URL.

Grading criteria
Total 6 points:

0.5 add missing case classes
1 completion of boundingBox function
0.5 shape constructor validity checking with suitable tests
0.5 size function
0.5 height function
0.5 scale function
0.5 use of map, foldLeft, sum, min/max
0.5 TestSize
0.5 TestHeight
0.5 TestScale
0.5 configurable debug output using logging library
