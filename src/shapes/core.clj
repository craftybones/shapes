(ns shapes.core
  (:require [shapes.line :refer :all]
            [shapes.utils :refer :all])
  (:gen-class))

(defn filled-rectangle
  "Creates a list of m lines filled with n repetitions of c"
  [c m n]
  (repeat m (line c n)))

(defn hollow-rectangle
  "Creates a hollow rectangle of mxn dimentions bordered by c"
  [c m n]
  (condp = m
    0 '()
    1 (list (line c n))
    (flatten*
     (line c n)
     (repeat (- m 2) (bordered-line c n))
     (line c n))))

(defn alternating-rectangle
  "Creates an mxn rectangle alternated with the elements of c"
  [c m n]
  (take m (map (partial (flip line) n) (cycle c))))

(defn left-aligned-triangle
  "Creates a left aligned triangle of dimension n with char c"
  [c n]
  (map (partial line c) (range 1 (inc n))))

(defn right-aligned-triangle
  "Creates a right aligned triangle of dimension n with char c"
  [c n]
  (map (partial right-justify n) (left-aligned-triangle c n)))

;; Need to bail out on even numbered values
(defn -diamond
  "Creates a diamond of size n(at its widest) made with the line
  generator specified by l"
  [c n l]
  (let [center-justified-line (comp (partial center-justify n)
                                    (partial l c))]
    (map center-justified-line (there-and-back 1 n 2))))

(defn filled-diamond
  "Creates a filled diamond of size n(at its widest)"
  [c n]
  (-diamond c n line))

(defn hollow-diamond
  "Creates a hollow diamond of size n(at its widest)"
  [c n]
  (-diamond c n bordered-line))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
