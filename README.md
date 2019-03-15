----------------- MINI AUTOCAD -----------------

The project has 14 classes and 3 interfaces, grouped in forms packet, except for
the main class.

Main has three objects of type Singleton Patter: ShapeFactory, DrawFigure and FillFigure
which will be the wanted output. With the help of the scanner, the number of forms will
be read, the canvas properties using auxiliary methods line nextLine() and split().
An image of type BufferedImage will be created, with ARGB color, called image.
An important observation is that in the program x means number of lines and y means 
number of columns. Thus, when setting the RGB of the image, they will be reversed in
order to generate the wanted image. After dealing with the background, the program
will draw the rest of the forms. For each iteration, the type of the form will be checked
and an object of that type will be created with the help of the creator.

The main follows with the visitor pattern, where the drawer is accepted. 
The mechanism for associating forms to images uses a static matrix of the ShapeClass, having 
the dimensions of the canvas, that we are going to alter for each figure.
For drawing, the matrix will be filled with 42, and for filling with 13. Thus, the outline 
is differentiated from the fill.

The Shape Interface is used, that extends Visitable so that each figure can pe called by a visitor.
Draw has visit methods for each figre. Line and Circle uses Bresenham's algo, while the other 
figures use more lines.
	
The algo used to fill is Queue, because of the high complexity that has in the recursive case.
The Point class is an auxiliary class, and uses only a point(x,y) for storing coords.