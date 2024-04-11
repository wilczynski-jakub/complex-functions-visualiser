# Complex Functions Visualiser
A program written in Java to visualise complex functions, using custom graphic images. 

## The idea behind
Let $z$ be a complex number, such that:
$$z = x + iy$$
and let $f$ be any complex function:
$$f: \mathbb{C} \rightarrow \mathbb{C}$$
Then, let $f(z)$ be denoted by $z'$, whereas:
$$z' = x' + iy'$$
<br>
We may think of the function $f$ as a transformation in a complex plane, which moves any given point $(x,y)$ to $(x',y')$.
![Points' transformation](img/Transformation.png)
In this program, each pixel of a given input image will be treated as a point of coordinates $(x,y)$, and all transformed pixels will form the output image.

## Interface
Just click on the function you want to apply to the image.
<br>
![Interface](img/Interface.png)
<br>
Of course, you can always change the [input image](src/Input.png).
<br>
<i>(The one chosen is relatively small: 50x50, in order for the program to work quickly.)</i>

## Transformed images
| Function | Output |
|------------|------------|
| $f(z) = 10 z$  | ![Output1](img/Output1.png)  |
| $f(z) = z^2$  | ![Output2](img/Output2.png)  |
| $f(z) = \frac{1}{10} z^3$  | ![Output3](img/Output3.png)  |
| $f(z) = sin(z)$  | ![Output4](img/Output4.png)  |
| $f(z) = cos(z)$  | ![Output5](img/Output5.png)  |
| $f(z) = 200 z^{-1}$  | ![Output6](img/Output6.png)  |
