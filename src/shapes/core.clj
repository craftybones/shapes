(ns shapes.core
  (:require [shapes.line :refer :all])
  (:gen-class))

(defn filled-rectangle
  "Creates a list of m lines filled with n repetitions of c"
  [c m n]
  (repeat m (line c n)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
