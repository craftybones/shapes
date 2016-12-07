(ns shapes.core
  (:require [shapes.utils :refer :all])
  (:gen-class))

(def repeat-string (comp (partial apply str) repeat))

(def line (flip repeat-string))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
