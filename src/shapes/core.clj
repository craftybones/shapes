(ns shapes.core
  (:require [shapes.line :refer :all]
            [shapes.utils :refer :all])
  (:gen-class))

(defn filled-rectangle
  "Creates a list of m lines filled with n repetitions of c"
  [c m n]
  (repeat m (line c n)))

(def top-and-middle-lines
  "juxtaposes two line generators"
  (juxt line bordered-line))

(defn hollow-rectangle
  "Creates a hollow rectangle of mxn dimentions bordered by c"
  [c m n]
  (let [[fl ml] (top-and-middle-lines c n)
        rep (partial repeat (- m 2))]
    (take m (flatten* fl (rep ml) fl))))

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

(defn -diamond
  "Creates a diamond of size n(at its widest) made with the line
  generator specified by l made up with c"
  [c n l]
  (if (even? n)
    '()
    (let [justified (justified-line-of center-justify n l c)]
      (map justified (there-and-back 1 n 2)))))

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
