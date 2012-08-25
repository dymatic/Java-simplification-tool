(defun add-all (x) (+ (car x) (if (cdr x) (add-all (cdr x)) 0)));Add a list together

(defun square (x) (* x x));Square a number

(defun rsquare (x) (if (null x) nil (cons (* (car x) (car x)) (rsquare (cdr x)))));Square a list

(defun mean (x)(+ 0.0 (/ (add-all x) (length x))));Find the mean of a list

(defun stmm (x y) (if (null x) nil  (cons (- y (car x)) (stmm (cdr x) y))));Subtract the mean from every element in a list

(defun stdDev (x);Find the standard deviation of a list
(if (< (length x) 2) (car x))

(sqrt (/ (add-all (rSquare (stmm x (mean x)))) (- (length x) 1))))


(defun rarea (x) (* (car x) (cadr x)));Find rectangular area given a list
(defun rvol (x) (* (car x) (if (cdr x) (rvol (cdr x)) 1)));Multiply a list to itself. Used for rectangular volume
(defun triAr (bh) (* .5 (car bh) (cadr bh)));Find trianguylar area
(defun triPyrVol (bh) (+ 0.0 (* (/ 1 3) (car bh) (cadr bh))));Find the volume of a triangular pyramid
(defun ptgSide (hp s) (sqrt (- (square hp) (square s))));Pythag for a side
(defun ptgHp (s1 s2) (sqrt (+ (square s1) (square s2))));Pythag for hypot
(defun circA (rad) (* (square rad) pi));Area for circle
(defun pow(num times) (* num (if (< 1 times) num (pow num (- times 1)))));Power of a number
(defun spV (rad) (* (/ 4 3) pi (pow rad 3)));Get spherical volume 
(defun cylV (rad height) (+ (* 2 pi rad height) (* 2 (circA rad))));Cylindrical volume
(defun conA (rad slant) (+ (* pi slant rad) (circA rad)));Conic area
(defun conV (rad height) (* (/ 1 3) (circA rad) height));Conic volume
(defun dense (mass vol) (/ mass vol));Density

(defun cvCtF (celc) (+ (* celc (/ 9 5)) 32));Convert Celc to Fahr
(defun cvFtC (fahr) (- (* fahr (/ 5 9)) 32));Convert Fahr to Celc
(defun cvFtK (fahr) (- (cvFtC fahr) 273.15));Convert Fahr to Kelv

(defun cvCtK (celc) (- celc 273.15));Convert Celc to Kelv
(defun cvKtC (kelv) (+ kelv 273.15));Convert kelv to Celc

(defun cvKtF (kelv) (cvCtF (cvKtC kelv)));Convert kelv to Fahr

(defun mcsToSec (mcs) (/ (/ mcs 1000) 1000));Convert micro to seconds
(defun secToMcs (sec) (* sec 1000 1000));Convert seconds to micro